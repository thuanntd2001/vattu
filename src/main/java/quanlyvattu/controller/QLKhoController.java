package quanlyvattu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlykho")
public class QLKhoController {
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getKhoCN(){	

		return "chinhanh/qlkho";
	}
	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getKhoCT(){	

		return "congty/qlkho";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getKhoU(){	

		return "user/qlkho";
	}
}
