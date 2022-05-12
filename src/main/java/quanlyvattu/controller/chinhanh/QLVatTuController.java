package quanlyvattu.controller.chinhanh;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlyvattu")
public class QLVatTuController {
	@RequestMapping(value = "xem/chinhanh", method = RequestMethod.GET)
	public String getVTCN(){	

		return "chinhanh/chinhanhqlvt";
	}
	@RequestMapping(value = "xem/congty", method = RequestMethod.GET)
	public String getVTCT(){	

		return "chinhanh/congtyqlvt";
	}
	
	@RequestMapping(value = "xem/user", method = RequestMethod.GET)
	public String getVTU(){	

		return "chinhanh/userqlvt";
	}
}
