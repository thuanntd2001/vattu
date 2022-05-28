package quanlyvattu.controller.CN1;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.NhanVienEntity;
import quanlyvattu.entity.VatTuEntity;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN1.NhanVienRepositoryCN1;
import quanlyvattu.repositoryCN1.VatTuRepositoryCN1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.model.LoginModel;



@Controller
@RequestMapping(value = "taologin/cn1")
public class TaoLoginController {
	
	@Autowired
	NhanVienRepositoryCN1 nvrepo;

	@RequestMapping(value = {"chinhanh","congty","user"}, method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request){	
		

			model.addAttribute("newLogin",new LoginModel());
			return "chinhanh/taologin";
		}
	@RequestMapping(value = {"chinhanh","congty","user"}, method = RequestMethod.POST)
	public String taoLogin(ModelMap model, @ModelAttribute("newLogin") LoginModel lg){	
		int f=1;
		System.out.println(lg.getLgName());
		System.out.println(lg.getMaNV());
		System.out.println(lg.getPass());
		System.out.println(lg.getQuyen());
			
				 f=nvrepo.taoLogin(lg.getLgName(), lg.getPass(), lg.getMaNV(), lg.getQuyen());
				 System.out.println("thành công");
			
				
		
			if (f==0) {
				model.addAttribute("message","thêm login thanh cong");

			}else {
				System.out.println("thêm login thất bại");
			}
			return "chinhanh/taologin";
		}
		
	


}
