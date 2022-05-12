package quanlyvattu.controller.chinhanh;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping(value = "quanlydondathang")
public class QLDonDatHangController {
	@RequestMapping(value = "xem/chinhanh", method = RequestMethod.GET)
	public String getNVCN(){	

		return "chinhanh/chinhanhqldh";
	}
	@RequestMapping(value = "xem/congty", method = RequestMethod.GET)
	public String getNVCT(){	

		return "chinhanh/congtyqldh";
	}
	
	@RequestMapping(value = "xem/user", method = RequestMethod.GET)
	public String getNVU(){	

		return "chinhanh/userqldh";
	}
}


