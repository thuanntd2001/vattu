package quanlyvattu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlyvattu")
public class QLVatTuController {
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getVTCN(){	

		return "chinhanh/qlvattu";
	}
	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getVTCT(){	

		return "congty/qlvattu";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getVTU(){	

		return "user/qlvattu";
	}
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(){	

		return "chinhanh/form/add-vattu";
	}
	@RequestMapping(value = "congty/add", method = RequestMethod.GET)
	public String addDDHCT(){	

		return "congty/form/add-vattu";
	}
	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addDDHU(){	

		return "congty/form/add-vattu";
	}
}
