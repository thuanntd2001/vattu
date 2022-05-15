package quanlyvattu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.model.LoginModel;



@Controller
@RequestMapping(value = "taologin")
public class TaoLoginController {

	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request){	
		

			model.addAttribute("newLogin",new LoginModel());
			return "chinhanh/taologin";
		}
		
	


}


