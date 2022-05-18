package quanlyvattu.controller.CN1;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.entity.NhanVienEntity;
import quanlyvattu.entity.VatTuEntity;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN1.VatTuRepositoryCN1;



@Controller
@RequestMapping(value = "quanlyvattu/cn1")
public class QLVatTuController {
	@Autowired
	VatTuRepositoryCN1 vtrepo;

	@Autowired
	ServletContext session;
	

	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getVTCN(ModelMap model){	
/*		Sort sort = new Sort(Sort.Direction.ASC, "maVT");;
*/		model.addAttribute("vts",vtrepo.findAll());
		return "chinhanh/qlvattu";
	}
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addVTCN(ModelMap model){	
		VatTuEntity vt=new VatTuEntity();
		vt.setDonViTinh("kg");
		model.addAttribute("vt", vt);
		
	
		return "chinhanh/form/add-vattu";
	}
	
	@RequestMapping(value = "chinhanh/add", method = RequestMethod.POST)
	public String addVTCN1(ModelMap model, @ModelAttribute("vt") VatTuEntity vt, HttpServletRequest request) {
		
		UserModel user = (UserModel) session.getAttribute("USERMODEL");
		
		System.out.print(vt.getMaVT());
		
		System.out.print(vt.getDonViTinh());
		System.out.print(vt.getSoLuongTon());
		System.out.print(vt.getTenVT());
		if (vtrepo.findOne(vt.getMaVT())==null) {
			VatTuEntity nvsave = null;

			try {
				nvsave = vtrepo.save(vt);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "thêm vật tư thất bại");
				System.out.print("thêm vật tư thất bại");
			}
			if (nvsave != null) {
				model.addAttribute("message", "thêm vật tư thành công");
				System.out.print("thêm vật tư thành công");
			}
		}
		else {
			model.addAttribute("message", "thêm vật tư thất bại, mã vật tư đã tồn tại");
			System.out.print("thêm vật tư thất bại");
		}
		

		return "redirect:/quanlyvattu/cn1/chinhanh/add.htm";
	}
	
	
	
	

}
