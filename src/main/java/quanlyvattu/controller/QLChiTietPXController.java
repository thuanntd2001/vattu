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
import quanlyvattu.entity.CTPXEntity;
import quanlyvattu.repository.ChiTietDDHRepository;
import quanlyvattu.repository.ChiTietPXRepository;



@Controller
@RequestMapping(value = "quanlychitietphieuxuat")
public class QLChiTietPXController {
	@Autowired
	ChiTietPXRepository ctpxrepo;

	@Autowired
	ServletContext session;
	
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request){	
		String idpx= (String) request.getParameter("idpx");
		if(idpx != "" && idpx != null ) {

			List<CTPXEntity> dhs=(List<CTPXEntity>) ctpxrepo.findByMaSoPX(idpx);
			model.addAttribute("ddhs",dhs);
			
			return "chinhanh/qlCTPX";
		}else {
			System.out.print("khong co ma kho");

			model.addAttribute("ddhs",ctpxrepo.findAll());
			return "chinhanh/qlCTPX";
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


