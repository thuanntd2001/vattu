package quanlyvattu.controller.CN1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.VatTuEntity;
import quanlyvattu.repositoryCN1.VatTuRepositoryCN1;



@Controller
@RequestMapping(value = "quanlyvattu/cn1")
public class QLVatTuController {
	@Autowired
	VatTuRepositoryCN1 vtrepo;

	
	

	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getVTCN(ModelMap model){	
/*		Sort sort = new Sort(Sort.Direction.ASC, "maVT");;
*/		model.addAttribute("vts",vtrepo.findAll());
		return "chinhanh/qlvattu";
	}
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model){	
		model.addAttribute("vt", new VatTuEntity());
		
	
		return "chinhanh/form/add-vattu";
	}
	
	
	
	
	
	
	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getVTCT(){	

		return "congty/qlvattu";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getVTU(){	

		return "user/qlvattu";
	}

	@RequestMapping(value = "congty/add", method = RequestMethod.GET)
	public String addDDHCT(){	

		return "congty/form/add-vattu";
	}
	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addDDHU(){	

		return "congty/form/add-vattu";
	}
}
