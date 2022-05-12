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
import quanlyvattu.dao.impl.NhanVienDAO;
import quanlyvattu.model.DSPMModel;
import quanlyvattu.model.NhanVienLoginModel;
import quanlyvattu.model.UserModel;
import quanlyvattu.service.ICheckService;
import quanlyvattu.service.impl.CheckService;
import quanlyvattu.statics.InfoConnection;
import quanlyvattu.utils.FormUtil;
import quanlyvattu.utils.SessionUtil;

@Controller
public class LoginController {
	@Autowired
	ServletContext session;
	@Autowired
	ServletContext application;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	DSPMDAO dspmDAO = new DSPMDAO();
	NhanVienDAO nvdao = new NhanVienDAO();
	private ICheckService ck = new CheckService();

	@RequestMapping(value = "dang-nhap", method = RequestMethod.GET)
	private String doGet(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		// tao dspm set ra view
		if (application.getAttribute("DSPM") == null) {
			List<DSPMModel> DSPMs = dspmDAO.findAll();
			if (DSPMs != null) {
				for (DSPMModel md : DSPMs) {
					System.out.print(md.getTenCN() + md.getTenServer() + "\n");

				}
				application.setAttribute("DSPMs", DSPMs);
			}
		}

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
				// kt nv co tk trong sqlserver ko
				boolean flag = false;
				//set server ma nv chon de thu ket noi
				InfoConnection.setUrl(model.getChiNhanh());
				flag = ck.ckUserPassword(model.getUserName(), model.getPasswd());
				// neu ket noi dc setup thuoc tinh cho nhan vien sap dang nhap
				if (flag) {
					InfoConnection.setUrl(model.getChiNhanh());
					System.out.print("thanh cong ket noi " + InfoConnection.getUrl());
					InfoConnection.setPassWord(model.getPasswd());
					InfoConnection.setUserName(model.getUserName());

					NhanVienLoginModel login = nvdao.login(model.getUserName());

					model.setMaNV(login.getMaNV());
					model.setHoTen(login.getHoTen());
					model.setRoleID(login.getTenNhom());

					SessionUtil.getInstance().putValue(request, "USERMODEL", model);
					session.setAttribute("USERMODEL", model);

					// tra ra view
					if (model.getRoleID().equals("CONGTY"))

						return "redirect:quanlynhanvien/congty.htm";
					if (model.getRoleID().equals("CHINHANH"))

						return "redirect:quanlynhanvien/chinhanh.htm";
					if (model.getRoleID().equals("USER"))

						return "redirect:quanlynhanvien/user.htm";
				}

			}
			System.out.print("ket noi that bai " + "user " + model.getUserName() + "pass " + model.getPasswd());

		}

		return "redirect:dang-nhap.htm?action=login&message=username_password_invalid&alert=danger";

	}
}
