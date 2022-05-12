package quanlyvattu.controller.chinhanh;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlykho")
public class QLKhoController {
	@RequestMapping(value = "xem/chinhanh", method = RequestMethod.GET)
	public String getKhoCN(){	

		return "chinhanh/chinhanhqlkho";
	}
	@RequestMapping(value = "xem/congty", method = RequestMethod.GET)
	public String getKhoCT(){	

		return "chinhanh/congtyqlkho";
	}
	
	@RequestMapping(value = "xem/user", method = RequestMethod.GET)
	public String getKhoU(){	

		return "chinhanh/userqlkho";
	}
}
