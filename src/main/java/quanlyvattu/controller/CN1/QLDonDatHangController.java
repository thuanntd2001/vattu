package quanlyvattu.controller.CN1;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.DatHangEntity;
import quanlyvattu.entity.KhoEntity;
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


/*	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(ModelMap model){	
		Sort sort = new Sort(Sort.Direction.ASC, "maKho");;
		model.addAttribute("dh",dhrepo.findAll(sort));
		return "chinhanh/qldh";
	}*/
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model){	
		model.addAttribute("dh", new DatHangEntity());
		
	
		return "chinhanh/form/add-donhang";
	}
	
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.POST)
	public String addDHCN1(ModelMap model, @ModelAttribute("dh") DatHangEntity dh, HttpServletRequest request) {
		
	
		if (dhrepo.findOne(dh.getMaSoDDH())==null) {
			DatHangEntity nvsave = null;

			try {
				nvsave = dhrepo.save(dh);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "thêm đơn hàng thất bại");
				System.out.print("thêm đơn hàng thất bại");
			}
			if (nvsave != null) {
				model.addAttribute("message", "thêm đơn hàng thành công");
				System.out.print("thêm đơn hàng thành công");
			}
		}
		else {
			model.addAttribute("message", "thêm đơn hàng thất bại, mã đơn hàng đã tồn tại");
			System.out.print("thêm đơn hàng thất bại");
		}
		

		return "redirect:/quanlydonhang/cn1/chinhanh/add.htm";
	}
}


