package quanlyvattu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlydondathang")
public class QLDonDatHangController {
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(){	

		return "chinhanh/qldondathang";
	}
	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getDDHCT(){	

		return "congty/qldondathang";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getDDHU(){	

		return "user/qldondathang";
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


