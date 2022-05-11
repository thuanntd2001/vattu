package quanlyvattu.controller.chinhanh;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class QLNhanVienHomeChiNhanh {


	@RequestMapping(value = "chinhanh-home", method = RequestMethod.GET)
	public String index(){	

		return "chinhanh/chinhanhhome";
	}
	
}