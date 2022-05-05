package quanlyvattu.controller.chung;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.model.NhanVienModel;
import quanlyvattu.model.UserModel;
import quanlyvattu.service.INhanVienService;
import quanlyvattu.service.IUserService;
import quanlyvattu.service.impl.NhanVienService;
import quanlyvattu.service.impl.UserService;
import quanlyvattu.utils.FormUtil;
import quanlyvattu.utils.SessionUtil;


@Controller
public class LoginController {
	private static final long serialVersionUID = 1L;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	private INhanVienService nhanVienService = new NhanVienService();
	private IUserService userService = new UserService();
	
	
	@RequestMapping(value = "dang-nhap", method = RequestMethod.GET)
	protected String doGet (HttpServletRequest request, HttpServletResponse response)  {
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

	/*@RequestMapping(value = "dang-nhap", method = RequestMethod.POST)
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		if (action != null && action.equals("login")) {
			
				UserModel model = FormUtil.toModel(UserModel.class, request);
				model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPasswd(), 1);

				if (model != null) {
					SessionUtil.getInstance().putValue(request, "USERMODEL", model);
					NhanVienModel nv = nhanVienService.findOne(model.getID());
					SessionUtil.getInstance().putValue(request, "NHANVIEN", nv);
					if (model.getRoleID() == 1) {
						response.sendRedirect(request.getContextPath() + "/admin-home/index.htm");
					} else if (model.getRoleID() != null) {
						response.sendRedirect(request.getContextPath() + "/trang-chu.htm");
					}
				} else {
					response.sendRedirect(request.getContextPath()
							+ "/dang-nhap.htm?action=login&message=username_password_invalid&alert=danger");
				}
			
		}
	}*/
}
