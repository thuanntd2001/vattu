package quanlyvattu.controller.chinhanh;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlyphieunhap")
public class QLPhieuNhapController {
	@RequestMapping(value = "xem/chinhanh", method = RequestMethod.GET)
	public String getPNCN(){	

		return "chinhanh/chinhanhqlpn";
	}
	@RequestMapping(value = "xem/congty", method = RequestMethod.GET)
	public String getPNCT(){	

		return "chinhanh/congtyqlpn";
	}
	
	@RequestMapping(value = "xem/user", method = RequestMethod.GET)
	public String getPNU(){	

		return "chinhanh/userqlpn";
	}
}
