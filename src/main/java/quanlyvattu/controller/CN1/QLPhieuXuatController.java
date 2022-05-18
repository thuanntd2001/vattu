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

import quanlyvattu.entity.DatHangEntity;
import quanlyvattu.entity.PhieuXuatEntity;
import quanlyvattu.repositoryCN1.DatHangRepositoryCN1;
import quanlyvattu.repositoryCN1.PhieuXuatRepositoryCN1;



@Controller
@RequestMapping(value = "quanlyphieuxuat/cn1")
public class QLPhieuXuatController {

	@Autowired
	PhieuXuatRepositoryCN1 pxrepo;

	@Autowired
	ServletContext session;
	
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getPXCN(ModelMap model, HttpServletRequest request){	
		String idKho= (String) request.getParameter("idkho");
		if(idKho != "" && idKho != null ) {
			Sort sort = new Sort(Sort.Direction.DESC, "maPX");
			List<PhieuXuatEntity> pxs=(List<PhieuXuatEntity>) pxrepo.findByKho(idKho);
			model.addAttribute("ddhs",pxs);
			/*for (PhieuXuatEntity dh:pxs) System.out.print(dh.pxrepo());*/
			return "chinhanh/qlphieuxuat";
		}else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maPX");
			model.addAttribute("ddhs",pxrepo.findAll(sort));
			return "chinhanh/qlphieuxuat";
		}
		
	}

	
	
	
	
	
	
	
	@RequestMapping(value = "congty", method = RequestMethod.GET)
	public String getPXCT(){	

		return "congty/qlphieuxuat";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getPXU(){	

		return "user/qlphieuxuat";
	}
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(){	

		return "chinhanh/form/add-phieuxuat";
	}
	@RequestMapping(value = "congty/add", method = RequestMethod.GET)
	public String addDDHCT(){	

		return "congty/form/add-phieuxuat";
	}
	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addDDHU(){	

		return "congty/form/add-phieuxuat";
	}
}
