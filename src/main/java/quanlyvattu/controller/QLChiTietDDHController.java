package quanlyvattu.controller;

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

import quanlyvattu.repository.ChiTietDDHRepository;



@Controller
@RequestMapping(value = "quanlychitietdondathang")
public class QLChiTietDDHController {
	@Autowired
	ChiTietDDHRepository ctdhrepo;

	@Autowired
	ServletContext session;
	
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request){	
		String idddh= (String) request.getParameter("idddh");
		if(idddh != "" && idddh != null ) {

			List<CTDDHEntity> dhs=(List<CTDDHEntity>) ctdhrepo.findByMaSoDDH(idddh);
			model.addAttribute("ddhs",dhs);
			
			return "chinhanh/qlCTDDH";
		}else {
			System.out.print("khong co ma kho");

			model.addAttribute("ddhs",ctdhrepo.findAll());
			return "chinhanh/qlCTDDH";
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

