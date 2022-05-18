package quanlyvattu.controller.CN1;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.KhoEntity;
import quanlyvattu.entity.VatTuEntity;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN1.ChiNhanhRepositoryCN1;
import quanlyvattu.repositoryCN1.KhoRepositoryCN1;



@Controller
@RequestMapping(value = "quanlykho/cn1")
public class QLKhoController {
	@Autowired
	KhoRepositoryCN1 krepo;

	
	@Autowired
	ChiNhanhRepositoryCN1 cnrepo;
	@Autowired
	ServletContext session;	

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
	
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.POST)
	public String addKCN1(ModelMap model, @ModelAttribute("k") KhoEntity k, HttpServletRequest request) {
		
		
		if (krepo.findOne(k.getMaKho())==null) {
			KhoEntity nvsave = null;
			UserModel user=(UserModel) session.getAttribute("USERMODEL");
			System.out.print(user.getChiNhanh());
			k.setChiNhanh(cnrepo.findOne(user.getChiNhanh()));
			try {
				nvsave = krepo.save(k);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "thêm kho thất bại");
				System.out.print("thêm kho thất bại");
			}
			if (nvsave != null) {
				model.addAttribute("message", "thêm kho thành công");
				System.out.print("thêm kho thành công");
			}
		}
		else {
			model.addAttribute("message", "thêm kho thất bại, mã kho đã tồn tại");
			System.out.print("thêm kho thất bại");
		}
		

		return "redirect:/quanlykho/cn1/chinhanh/add.htm";
	}
	
	
	

	}


