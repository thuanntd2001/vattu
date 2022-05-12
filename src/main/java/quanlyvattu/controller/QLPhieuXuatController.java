package quanlyvattu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlyphieuxuat")
public class QLPhieuXuatController {
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getPXCN(){	

		return "chinhanh/qlphieuxuat";
	}
	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getPXCT(){	

		return "congty/qlphieuxuat";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getPXU(){	

		return "user/qlphieuxuat";
	}
}
