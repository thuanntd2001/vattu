package quanlyvattu.controller.chinhanh;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class QLDonHangController {
	@RequestMapping(value = "chinhanh-qldh", method = RequestMethod.GET)
	public String index(){	

		return "chinhanh/chinhanhqldh";
	}
}
