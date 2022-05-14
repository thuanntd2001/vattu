package quanlyvattu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.KhoEntity;
import quanlyvattu.repository.KhoRepository;



@Controller
@RequestMapping(value = "quanlykho")
public class QLKhoController {
	@Autowired
	KhoRepository krepo;

	
	

	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getKCN(ModelMap model){	
		Sort sort = new Sort(Sort.Direction.ASC, "maKho");;
		model.addAttribute("ks",krepo.findAll(sort));
		return "chinhanh/qlkho";
	}
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model){	
		model.addAttribute("k", new KhoEntity());
		
	
		return "chinhanh/form/add-kho";
	}
	
	
	
	

	}


