package quanlyvattu.controller.CN2;

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

import quanlyvattu.entity.PhieuNhapEntity;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN2.DatHangRepositoryCN2;
import quanlyvattu.repositoryCN2.KhoRepositoryCN2;
import quanlyvattu.repositoryCN2.NhanVienRepositoryCN2;
import quanlyvattu.repositoryCN2.PhieuNhapRepositoryCN2;

@Controller
@RequestMapping(value = "quanlyphieunhap/cn2")
public class QLPhieuNhapControllerCN2 {
	@Autowired
	PhieuNhapRepositoryCN2 pnrepo;

	@Autowired
	NhanVienRepositoryCN2 nvrepo;

	@Autowired
	KhoRepositoryCN2 krepo;

	@Autowired
	DatHangRepositoryCN2 dhrepo;

	@Autowired
	ServletContext session;
	private String idDDH = "N/A";
	private String idKho = "N/A";
//=================================CHINHANH=====================================//

	@RequestMapping(value = { "chinhanh"}, method = RequestMethod.GET)
	public String getPXCN(ModelMap model, HttpServletRequest request) {
		idDDH = (String) request.getParameter("idDDH");
		idKho = (String) request.getParameter("idkho");
		if (idDDH != "" && idDDH != null) {
			Sort sort = new Sort(Sort.Direction.DESC, "maPN");
			List<PhieuNhapEntity> pxs = (List<PhieuNhapEntity>) pnrepo.findByDDH(idDDH);
			model.addAttribute("ddhs", pxs);
			/* for (PhieuXuatEntity dh:pxs) System.out.print(dh.pxrepo()); */
			return "chinhanh2/qlphieunhap";
		} else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maPN");
			model.addAttribute("ddhs", pnrepo.findAll(sort));
			return "chinhanh2/qlphieunhap";
		}

	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model) {

		model.addAttribute("px", new PhieuNhapEntity());
		model.addAttribute("idddh", idDDH);
		model.addAttribute("idkho", idKho);
		return "chinhanh2/form/add-phieunhap";
	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.POST)
	public String addDHCN1(ModelMap model, @ModelAttribute("px") PhieuNhapEntity dh, HttpServletRequest request) {

		if (pnrepo.findOne(dh.getMaPN()) == null) {
			PhieuNhapEntity nvsave = null;
			UserModel user = (UserModel) session.getAttribute("USERMODEL");

			try {
				dh.setDatHang(dhrepo.findOne(idDDH));
				dh.setNgay(new Date());
				dh.setNhanVien(nvrepo.findOne(user.getMaNV()));
				dh.setKho(krepo.findOne(idKho));
				nvsave = pnrepo.save(dh);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "th??m PHI???U Nh???p th???t b???i, c?? 2 phieu nh???p trong 1 ????n h??ng");
				System.out.print("th??m PHI???U Nh???p th???t b???i");
			}
			if (nvsave != null) {
				model.addAttribute("message", "th??m PHI???U Nh???p th??nh c??ng");
				System.out.print("th??m PHI???U Nh???p th??nh c??ng");
			}
		} else {
			model.addAttribute("message", "th??m PHI???U Nh???p th???t b???i, m?? PHI???U Nh???p ???? t???n t???i");
			System.out.print("th??m ????n h??ng th???t b???i");
		}

		return "redirect:/quanlyphieunhap/cn2/chinhanh.htm?idDDH=" + idDDH + "&&idkho=" + idKho;
	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.GET)
	public String xoaNVCN1(ModelMap model, HttpServletRequest request) {

		model.addAttribute("id", request.getParameter("id"));

		return "chinhanh2/form/xoa-phieunhap";

	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.POST)
	public String xoaKCN1P(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");
		System.out.print(request.getParameter("xacNhan") + request.getParameter("id"));
		try {
			if (request.getParameter("xacNhan").equals("YES")) {
//				VatTuEntity nvsave = vtrepo.findOne(id);
				pnrepo.delete(id);

				model.addAttribute("message", "xo?? phi???u nh???p th??nh c??ng");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "xo?? phi???u nh???p th???t b???i, ch??? c?? th??? xo?? phi???u nh???p tr???ng");
		}
		return "redirect:/quanlyphieunhap/cn2/chinhanh.htm?idDDH=" + idDDH + "&&idkho=" + idKho;

	}

	// =================================CONGTY=====================================//

	@RequestMapping(value = { "congty"}, method = RequestMethod.GET)
	public String getPXCTY(ModelMap model, HttpServletRequest request) {
		idDDH = (String) request.getParameter("idDDH");
		idKho = (String) request.getParameter("idkho");
		if (idDDH != "" && idDDH != null) {
			Sort sort = new Sort(Sort.Direction.DESC, "maPN");
			List<PhieuNhapEntity> pxs = (List<PhieuNhapEntity>) pnrepo.findByDDH(idDDH);
			model.addAttribute("ddhs", pxs);
			/* for (PhieuXuatEntity dh:pxs) System.out.print(dh.pxrepo()); */
			return "congty2/qlphieunhap";
		} else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maPN");
			model.addAttribute("ddhs", pnrepo.findAll(sort));
			return "congty2/qlphieunhap";
		}

	}

	
	// =================================USER=====================================//

	@RequestMapping(value = {"user" }, method = RequestMethod.GET)
	public String getPXU(ModelMap model, HttpServletRequest request) {
		idDDH = (String) request.getParameter("idDDH");
		idKho = (String) request.getParameter("idkho");
		if (idDDH != "" && idDDH != null) {
			Sort sort = new Sort(Sort.Direction.DESC, "maPN");
			List<PhieuNhapEntity> pxs = (List<PhieuNhapEntity>) pnrepo.findByDDH(idDDH);
			model.addAttribute("ddhs", pxs);
			/* for (PhieuXuatEntity dh:pxs) System.out.print(dh.pxrepo()); */
			return "user2/qlphieunhap";
		} else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maPN");
			model.addAttribute("ddhs", pnrepo.findAll(sort));
			return "user2/qlphieunhap";
		}

	}

	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addDDHU(ModelMap model) {

		model.addAttribute("px", new PhieuNhapEntity());
		model.addAttribute("idddh", idDDH);
		model.addAttribute("idkho", idKho);
		return "user2/form/add-phieunhap";
	}

	@RequestMapping(value = "user/add", method = RequestMethod.POST)
	public String addDHU(ModelMap model, @ModelAttribute("px") PhieuNhapEntity dh, HttpServletRequest request) {

		if (pnrepo.findOne(dh.getMaPN()) == null) {
			PhieuNhapEntity nvsave = null;
			UserModel user = (UserModel) session.getAttribute("USERMODEL");

			try {
				dh.setDatHang(dhrepo.findOne(idDDH));
				dh.setNgay(new Date());
				dh.setNhanVien(nvrepo.findOne(user.getMaNV()));
				dh.setKho(krepo.findOne(idKho));
				nvsave = pnrepo.save(dh);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "th??m PHI???U Nh???p th???t b???i, c?? 2 phieu nh???p trong 1 ????n h??ng");
				System.out.print("th??m PHI???U Nh???p th???t b???i");
			}
			if (nvsave != null) {
				model.addAttribute("message", "th??m PHI???U Nh???p th??nh c??ng");
				System.out.print("th??m PHI???U Nh???p th??nh c??ng");
			}
		} else {
			model.addAttribute("message", "th??m PHI???U Nh???p th???t b???i, m?? PHI???U Nh???p ???? t???n t???i");
			System.out.print("th??m ????n h??ng th???t b???i");
		}

		return "redirect:/quanlyphieunhap/cn2/user.htm?idDDH=" + idDDH + "&&idkho=" + idKho;
	}

	@RequestMapping(value = "user/xoa", method = RequestMethod.GET)
	public String xoaNVU(ModelMap model, HttpServletRequest request) {

		model.addAttribute("id", request.getParameter("id"));

		return "user2/form/xoa-phieunhap";

	}

	@RequestMapping(value = "user/xoa", method = RequestMethod.POST)
	public String xoaKU(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");
		System.out.print(request.getParameter("xacNhan") + request.getParameter("id"));
		try {
			if (request.getParameter("xacNhan").equals("YES")) {
//					VatTuEntity nvsave = vtrepo.findOne(id);
				pnrepo.delete(id);

				model.addAttribute("message", "xo?? phi???u nh???p th??nh c??ng");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "xo?? phi???u nh???p th???t b???i, ch??? c?? th??? xo?? phi???u nh???p tr???ng");
		}
		return "redirect:/quanlyphieunhap/cn2/user.htm?idDDH=" + idDDH + "&&idkho=" + idKho;

	}
}
