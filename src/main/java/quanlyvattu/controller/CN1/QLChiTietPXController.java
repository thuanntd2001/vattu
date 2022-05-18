package quanlyvattu.controller.CN1;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.CTPXEntity;
import quanlyvattu.repositoryCN1.ChiTietPXRepositoryCN1;



@Controller
@RequestMapping(value = "quanlychitietphieuxuat/cn1")
public class QLChiTietPXController {
	@Autowired
	ChiTietPXRepositoryCN1 ctpxrepo;

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


