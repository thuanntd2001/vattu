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
import quanlyvattu.repositoryCN1.ChiNhanhRepositoryCN1;
import quanlyvattu.repositoryCN1.DatHangRepositoryCN1;
import quanlyvattu.repositoryCN1.NhanVienRepositoryCN1;



@Controller
@RequestMapping(value = "quanlydondathang/cn1")
public class QLDonDatHangController {
	@Autowired
	DatHangRepositoryCN1 dhrepo;

	@Autowired
	ServletContext session;
	
	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request){	
		String idKho= (String) request.getParameter("idkho");
		if(idKho != "" && idKho != null ) {
			Sort sort = new Sort(Sort.Direction.DESC, "maSoDDH");
			List<DatHangEntity> dhs=(List<DatHangEntity>) dhrepo.findByKho(idKho);
			model.addAttribute("ddhs",dhs);
			for (DatHangEntity dh:dhs) System.out.print(dh.getKho());
			return "chinhanh/qldondathang";
		}else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maSoDDH");
			model.addAttribute("ddhs",dhrepo.findAll(sort));
			return "chinhanh/qldondathang";
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


