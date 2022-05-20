package quanlyvattu.controller.CN1;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.CTDDHEntity;

import quanlyvattu.repositoryCN1.ChiTietDDHRepositoryCN1;
import quanlyvattu.repositoryCN2.ChiTietDDHRepositoryCN2;



@Controller
@RequestMapping(value = "quanlychitietdondathang/cn1")
public class QLChiTietDDHController {
	@Autowired
	ChiTietDDHRepositoryCN1 ctdhrepo;

	@Autowired
	ServletContext session;
	
	String idddh="n/a";
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request){	
		System.out.print("khong co ma kho");
		idddh= (String) request.getParameter("idddh");
		if(idddh != "" && idddh != null ) {

			List<CTDDHEntity> dhs=(List<CTDDHEntity>) ctdhrepo.findByMaSoDDH(idddh);
			model.addAttribute("ddhs",dhs);
			
			return "chinhanh/qlCTDDH";
		}else {
			System.out.print("khong co ma DDH");

			model.addAttribute("ddhs",ctdhrepo.findAll());
			return "chinhanh/qlCTDDH";
		}
		
	}


	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(){	

		return "chinhanh/form/add-dondathang";
	}

	
	
}


