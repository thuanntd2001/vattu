package quanlyvattu.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.repository.ChiNhanhRepository;
import quanlyvattu.repository.DatHangRepository;
import quanlyvattu.repository.NhanVienRepository;



@Controller
@RequestMapping(value = "quanlydondathang")
public class QLDonDatHangController {
	@Autowired
	DatHangRepository dhrepo;

	@Autowired
	ServletContext session;
	
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(ModelMap model){	
		Sort sort = new Sort(Sort.Direction.DESC, "maSoDDH");;
		model.addAttribute("ddhs",dhrepo.findAll(sort));
		return "chinhanh/qldondathang";
	}


	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(){	

		return "chinhanh/form/add-dondathang";
	}
	@RequestMapping(value = "congty/add", method = RequestMethod.GET)
	public String addDDHCT(){	

		return "congty/form/add-dondathang";
	}
	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addDDHU(){	

		return "user/form/add-dondathang";
	}
}


