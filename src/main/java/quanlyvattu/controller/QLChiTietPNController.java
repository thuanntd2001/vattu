package quanlyvattu.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.CTPNEntity;
import quanlyvattu.repository.ChiTietPNRepository;



@Controller
@RequestMapping(value = "quanlychitietphieunhap")
public class QLChiTietPNController {
	@Autowired
	ChiTietPNRepository ctpnrepo;

	@Autowired
	ServletContext session;
	
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request){	
		String idpn= (String) request.getParameter("idpn");
		if(idpn != "" && idpn != null ) {

			List<CTPNEntity> dhs=(List<CTPNEntity>) ctpnrepo.findByMaSoPN(idpn);
			model.addAttribute("ddhs",dhs);
			
			return "chinhanh/qlCTPN";
		}else {
			System.out.print("khong co ma kho");

			model.addAttribute("ddhs",ctpnrepo.findAll());
			return "chinhanh/qlCTPN";
		}
		
	}


	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(){	

		return "chinhanh/form/add-dondathang";
	}
	@RequestMapping(value = "congty/add", method = RequestMethod.GET)
	public String addDDHCT(){	

		return "congty/form/add-dondathang";
	}
	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addDDHU(){	

		return "user/form/add-dondathang";
	}
}


