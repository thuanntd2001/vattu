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

import quanlyvattu.entity.PhieuNhapEntity;
import quanlyvattu.entity.PhieuXuatEntity;
import quanlyvattu.repositoryCN1.PhieuNhapRepositoryCN1;
import quanlyvattu.repositoryCN1.PhieuXuatRepositoryCN1;



@Controller
@RequestMapping(value = "quanlyphieunhap/cn1")
public class QLPhieuNhapController {
	@Autowired
	PhieuNhapRepositoryCN1 pnrepo;

	@Autowired
	ServletContext session;
	


	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getPXCN(ModelMap model, HttpServletRequest request){	
		String idDDH= (String) request.getParameter("idDDH");
		if(idDDH != "" && idDDH != null ) {
			Sort sort = new Sort(Sort.Direction.DESC, "maPN");
			List<PhieuNhapEntity> pxs=(List<PhieuNhapEntity>) pnrepo.findByDDH(idDDH);
			model.addAttribute("ddhs",pxs);
			/*for (PhieuXuatEntity dh:pxs) System.out.print(dh.pxrepo());*/
			return "chinhanh/qlphieunhap";
		}else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maPN");
			model.addAttribute("ddhs",pnrepo.findAll(sort));
			return "chinhanh/qlphieunhap";
		}
		
	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(){	

		return "chinhanh/form/add-phieunhap";
	}
	@RequestMapping(value = "congty/add", method = RequestMethod.GET)
	public String addDDHCT(){	

		return "congty/form/add-phieunhap";
	}
	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addDDHU(){	

		return "congty/form/add-phieunhap";
	}
}
