package quanlyvattu.controller.chinhanh;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlyphieuxuat")
public class QLPhieuXuatController {
	@RequestMapping(value = "xem/chinhanh", method = RequestMethod.GET)
	public String getPXCN(){	

		return "chinhanh/chinhanhqlpx";
	}
	@RequestMapping(value = "xem/congty", method = RequestMethod.GET)
	public String getPXCT(){	

		return "chinhanh/congtyqlpx";
	}
	
	@RequestMapping(value = "xem/user", method = RequestMethod.GET)
	public String getPXU(){	

		return "chinhanh/userqlpx";
	}
}
