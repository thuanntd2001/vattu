package quanlyvattu.controller.chung;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.dao.impl.DSPMDAO;
import quanlyvattu.model.DSPMModel;
import quanlyvattu.model.UserModel;
import quanlyvattu.service.ICheckService;
import quanlyvattu.service.INhanVienService;
import quanlyvattu.service.impl.CheckService;
import quanlyvattu.service.impl.NhanVienService;
import quanlyvattu.utils.FormUtil;
import quanlyvattu.utils.SessionUtil;

@Controller
public class LoginController {
	@Autowired
	ServletContext session;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	DSPMDAO dspmDAO=new DSPMDAO();

	private ICheckService ck = new CheckService();

	@RequestMapping(value = "dang-nhap", method = RequestMethod.GET)
	private String doGet(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		List<DSPMModel> DSPMs=dspmDAO.findAll();
		for (DSPMModel md : DSPMs) {
			System.out.print(md.getTenCN()+md.getTenServer()+"\n");
			
		}
		model.addAttribute("DSPMs", DSPMs);
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String alert = request.getParameter("alert");
			String message = request.getParameter("message");
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}

			return "chung/login";
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			return "redirect:dang-nhap.htm?action=login";
		} else {
			return "redirect:dang-nhap.htm?action=login";
		}
	}

	@RequestMapping(value = "dang-nhap", method = RequestMethod.POST)
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");

		if (action != null && action.equals("login")) {

			UserModel model = FormUtil.toModel(UserModel.class, request);

			if (model != null) {
				boolean flag = false;

				flag = ck.ckUserPassword(model.getUserName(), model.getPasswd());

				if (flag) {
					System.out.print("thanh cong ket noi");
					session.setAttribute("USERMODEL", model);
					return "redirect:dang-nhap.htm?action=login";
				}

			}
			System.out.print("ket noi that bai " + "user " + model.getUserName() + "pass " + model.getPasswd());

		}

		return "redirect:dang-nhap.htm?action=login&message=username_password_invalid&alert=danger";
		

	}
}
