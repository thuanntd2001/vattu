package quanlyvattu.controller;

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
import quanlyvattu.repository.ChiNhanhRepository;
import quanlyvattu.repository.NhanVienRepository;

@Controller
@RequestMapping(value = "quanlynhanvien")
public class QLNhanVienHome {
	@Autowired
	NhanVienRepository nvrepo;
	@Autowired
	ChiNhanhRepository cnrepo;
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
		int idMoi=-1;
		 idMoi=nvrepo.TimMaNV();
		System.out.print(idMoi);
		nv.setMaNV(idMoi);
		if (idMoi!=-1) {
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
		} else {
			model.addAttribute("message", "không có nv");
			System.out.print("ko có nv");
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
