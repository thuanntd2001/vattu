package quanlyvattu.controller.CN1;

import java.sql.Timestamp;
import java.util.Date;
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
import quanlyvattu.model.DDHnoPNModel;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN1.ChiNhanhRepositoryCN1;
import quanlyvattu.repositoryCN1.DatHangRepositoryCN1;
import quanlyvattu.repositoryCN1.KhoRepositoryCN1;
import quanlyvattu.repositoryCN1.NhanVienRepositoryCN1;

@Controller
@RequestMapping(value = "baocaodondathangkhongcophieunhap/cn1")
public class BCDonDatHangNoPhieuNhap {
	@Autowired
	DatHangRepositoryCN1 dhrepo;

	@Autowired
	KhoRepositoryCN1 krepo;

	@Autowired
	NhanVienRepositoryCN1 nvrepo;

	@Autowired
	ServletContext session;


	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getNVCN1(ModelMap model) {
		Sort sort = new Sort(Sort.Direction.DESC, "maSoDDH");
		List<DDHnoPNModel> dhs = (List<DDHnoPNModel>) dhrepo.findByDDHnoPNModel();
		model.addAttribute("ddhs", dhs);
		model.addAttribute("nvs", nvrepo.findAllNV());
		return "chinhanh/bcdondathangkhongcophieunhap";
	}
			


}
