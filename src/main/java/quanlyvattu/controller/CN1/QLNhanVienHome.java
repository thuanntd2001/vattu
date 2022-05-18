package quanlyvattu.controller.CN1;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.NhanVienEntity;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN1.ChiNhanhRepositoryCN1;
import quanlyvattu.repositoryCN1.NhanVienRepositoryCN1;
import quanlyvattu.repositoryCN2.NhanVienRepositoryCN2;

@Controller
@RequestMapping(value = "quanlynhanvien/cn1")
public class QLNhanVienHome {
	@Autowired
	NhanVienRepositoryCN2 nvrepo;
	@Autowired
	ChiNhanhRepositoryCN1 cnrepo;
	@Autowired
	ServletContext session;

	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getNVCN(ModelMap model) {
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		;
		model.addAttribute("nvs", nvrepo.findAll());
		return "chinhanh/qlnhanvien";
	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model) {
		model.addAttribute("nv", new NhanVienEntity());

		UserModel user = (UserModel) session.getAttribute("USERMODEL");
		model.addAttribute("chiNhanhHT", cnrepo.findOne(user.getChiNhanh()));
		return "chinhanh/form/add-nhanvien";
	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.POST)
	public String addDDHCN2(ModelMap model, @ModelAttribute("nv") NhanVienEntity nv) {
		model.addAttribute("nv", new NhanVienEntity());
		UserModel user=(UserModel) session.getAttribute("USERMODEL");
		Integer idMoi= null;
		 idMoi=nvrepo.TimMaNV();
		System.out.print(idMoi);
		nv.setMaNV(idMoi);
		nv.setChiNhanh(cnrepo.findOne(user.getChiNhanh()));
			NhanVienEntity nvsave = null;
		
			try {
				nvsave = nvrepo.save(nv);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "thêm nhân viên thất bại");
				System.out.print("thêm nhân viên thất bại");
			}
			if (nvsave != null) {
				model.addAttribute("message", "thêm nhân viên thành công");
				System.out.print("thêm nhân viên thành công");
			}


		return "chinhanh/form/add-nhanvien";
	}

	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getNVCT() {

		return "congty/qlnhanvien";
	}

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getNVU() {

		return "user/qlnhanvien";
	}

}
