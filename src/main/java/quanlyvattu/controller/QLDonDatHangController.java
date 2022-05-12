package quanlyvattu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}


