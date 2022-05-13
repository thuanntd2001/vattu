package quanlyvattu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.NhanVienEntity;
import quanlyvattu.repository.ChiNhanhRepository;
import quanlyvattu.repository.NhanVienRepository;



@Controller
@RequestMapping(value = "quanlynhanvien")
public class QLNhanVienHomeChiNhanh {
	@Autowired
	NhanVienRepository nvrepo;
	@Autowired
	ChiNhanhRepository cnrepo;
	
	
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getNVCN(ModelMap model){	
		Sort sort = new Sort(Sort.Direction.ASC, "id");;
		model.addAttribute("nvs",nvrepo.findAll());
		return "chinhanh/qlnhanvien";
	}
	
	
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model){	
		model.addAttribute("nv", new NhanVienEntity());
		Sort sort = new Sort(Sort.Direction.ASC, "id");;
		model.addAttribute("chiNhanhs", cnrepo.findAll(sort));
		return "chinhanh/form/add-nhanvien";
	}
	
	
	
	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getNVCT(){	

		return "congty/qlnhanvien";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getNVU(){	

		return "user/qlnhanvien";
	}
	

}
