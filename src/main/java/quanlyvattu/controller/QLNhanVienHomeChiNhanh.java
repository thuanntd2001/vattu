package quanlyvattu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "quanlynhanvien")
public class QLNhanVienHomeChiNhanh {
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getNVCN(){	

		return "chinhanh/qlnhanvien";
	}
	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getNVCT(){	

		return "congty/qlnhanvien";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getNVU(){	

		return "user/qlnhanvien";
	}
}
