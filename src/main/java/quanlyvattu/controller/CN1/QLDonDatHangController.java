package quanlyvattu.controller.CN1;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.DatHangEntity;
import quanlyvattu.entity.KhoEntity;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN1.ChiNhanhRepositoryCN1;
import quanlyvattu.repositoryCN1.DatHangRepositoryCN1;
import quanlyvattu.repositoryCN1.KhoRepositoryCN1;
import quanlyvattu.repositoryCN1.NhanVienRepositoryCN1;

@Controller
@RequestMapping(value = "quanlydondathang/cn1")
public class QLDonDatHangController {
	@Autowired
	DatHangRepositoryCN1 dhrepo;

	@Autowired
	KhoRepositoryCN1 krepo;

	@Autowired
	NhanVienRepositoryCN1 nvrepo;

	@Autowired
	ServletContext session;

	private String idKho = "N/A";

	@RequestMapping(value = {"chinhanh","congty","user"}, method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request) {
		idKho = (String) request.getParameter("idkho");
		if (idKho != "" && idKho != null) {
			Sort sort = new Sort(Sort.Direction.DESC, "maSoDDH");
			List<DatHangEntity> dhs = (List<DatHangEntity>) dhrepo.findByKho(idKho);
			model.addAttribute("ddhs", dhs);
			
				
			return "chinhanh/qldondathang";
		} else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maSoDDH");
			model.addAttribute("ddhs", dhrepo.findAll(sort));
			return "chinhanh/qldondathang";
		}

	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model) {

		model.addAttribute("dh", new DatHangEntity());
		model.addAttribute("idkho", idKho);

		return "chinhanh/form/add-donhang";
	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.POST)
	public String addDHCN1(ModelMap model, @ModelAttribute("dh") DatHangEntity dh, HttpServletRequest request) {
		boolean ckddh=false;
		try {
			ckddh=(dhrepo.ckDDH(dh.getMaSoDDH())==0);
		}catch(Exception e) {
			e.printStackTrace(); 
			
		}
		if (ckddh) {

			DatHangEntity nvsave = null;
			UserModel user = (UserModel) session.getAttribute("USERMODEL");

			try {
				dh.setKho(krepo.findOne(idKho));
				dh.setNgay(new Date());
				dh.setNhanVien(nvrepo.findOne(user.getMaNV()));

				nvsave = dhrepo.save(dh);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "thêm đơn hàng thất bại");
				System.out.print("thêm đơn hàng thất bại");
			}
			if (nvsave != null) {
				model.addAttribute("message", "thêm đơn hàng thành công");
				System.out.print("thêm đơn hàng thành công");
			}
		} else {
			model.addAttribute("message", "thêm đơn hàng thất bại, mã đơn hàng đã tồn tại");
			System.out.print("thêm đơn hàng thất bại");
		}

		return "redirect:/quanlydondathang/cn1/chinhanh/add.htm";
	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.GET)
	public String xoaNVCN1(ModelMap model, HttpServletRequest request) {

		model.addAttribute("id", request.getParameter("id"));

		return "chinhanh/form/xoa-dondathang";

	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.POST)
	public String xoaKCN1P(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");
		System.out.print(request.getParameter("xacNhan") + request.getParameter("id"));
		try {
			if (request.getParameter("xacNhan").equals("YES")) {
//				VatTuEntity nvsave = vtrepo.findOne(id);
				dhrepo.delete(id);

				model.addAttribute("message", "xoá đơn hàng thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "xoá đơn hàng thất bại, chỉ có thể xoá đơn hàng trống");
		}
		return "redirect:/quanlykho/cn1/chinhanh.htm";

	}

	@RequestMapping(value = "chinhanh/edit", method = RequestMethod.GET)
	public String editVTCN1(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");

		DatHangEntity k = dhrepo.findOne(id);
		if (k != null) {
			model.addAttribute("dh", k);
			model.addAttribute("idkho", idKho);
			System.out.print("tồn tại dh");
		}

		else {
			System.out.print("không tồn tại dh");
			return "redirect:quanlykho/cn1/chinhanh.htm";
		}

		return "chinhanh/form/edit-dondathang";
	}

	@RequestMapping(value = "chinhanh/edit", method = RequestMethod.POST)
	public String editVTCN1(ModelMap model, @ModelAttribute("k") DatHangEntity k, HttpServletRequest request) {

		
		UserModel user = (UserModel) session.getAttribute("USERMODEL");
		DatHangEntity ksave2=null;
		try {
			k.setNgay(new Date());
			k.setKho(krepo.findAll().get(0));

			k.setNhanVien(nvrepo.findOne(user.getMaNV()));
			 ksave2=dhrepo.save(k);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ksave2 != null) {

			model.addAttribute("message", "sửa DDH thành công");
			System.out.print("sửa DDH thành công");
		}

		return "redirect:/quanlydondathang/cn1/chinhanh.htm";

	}

}
