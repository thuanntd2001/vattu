package quanlyvattu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlyphieunhap")
public class QLPhieuNhapController {
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getPNCN(){	

		return "chinhanh/qlphieunhap";
	}
	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getPNCT(){	

		return "congty/qlphieunhap";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getPNU(){	

		return "user/qlphieunhap";
	}
}