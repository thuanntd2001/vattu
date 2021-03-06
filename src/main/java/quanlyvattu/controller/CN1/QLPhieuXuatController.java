package quanlyvattu.controller.CN1;

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
import quanlyvattu.entity.PhieuXuatEntity;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN1.DatHangRepositoryCN1;
import quanlyvattu.repositoryCN1.KhoRepositoryCN1;
import quanlyvattu.repositoryCN1.NhanVienRepositoryCN1;
import quanlyvattu.repositoryCN1.PhieuXuatRepositoryCN1;

@Controller
@RequestMapping(value = "quanlyphieuxuat/cn1")
public class QLPhieuXuatController {

	@Autowired
	PhieuXuatRepositoryCN1 pxrepo;
	@Autowired
	NhanVienRepositoryCN1 nvrepo;

	@Autowired
	KhoRepositoryCN1 krepo;

	@Autowired
	ServletContext session;
	private String idKho = "N/A";
//======================================CHINHANH=====================================//

	@RequestMapping(value = { "chinhanh" }, method = RequestMethod.GET)
	public String getPXCN(ModelMap model, HttpServletRequest request) {
		idKho = (String) request.getParameter("idkho");
		if (idKho != "" && idKho != null) {
			Sort sort = new Sort(Sort.Direction.DESC, "maPX");
			List<PhieuXuatEntity> pxs = (List<PhieuXuatEntity>) pxrepo.findByKho(idKho);
			model.addAttribute("ddhs", pxs);
			/* for (PhieuXuatEntity dh:pxs) System.out.print(dh.pxrepo()); */
			return "chinhanh/qlphieuxuat";
		} else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maPX");
			model.addAttribute("ddhs", pxrepo.findAll(sort));
			return "chinhanh/qlphieuxuat";
		}

	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model) {

		model.addAttribute("px", new PhieuXuatEntity());
		model.addAttribute("idkho", idKho);

		return "chinhanh/form/add-phieuxuat";
	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.POST)
	public String addDHCN1(ModelMap model, @ModelAttribute("px") PhieuXuatEntity dh, HttpServletRequest request) {

		boolean ckpx = false;
		try {
			ckpx = (pxrepo.ckPX(dh.getMaPX()) == 0);
		} catch (Exception e) {
			e.printStackTrace();

		}
		if (ckpx) {
			PhieuXuatEntity nvsave = null;
			UserModel user = (UserModel) session.getAttribute("USERMODEL");

			try {
				dh.setKho(krepo.findOne(idKho));
				dh.setNgay(new Date());
				dh.setNhanVien(nvrepo.findOne(user.getMaNV()));

				nvsave = pxrepo.save(dh);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "th??m PHI???U XU???T th???t b???i");
				System.out.print("th??m ????n h??ng th???t b???i");
			}
			if (nvsave != null) {
				model.addAttribute("message", "th??m PHI???U XU???T th??nh c??ng");
				System.out.print("th??m ????n h??ng th??nh c??ng");
			}
		} else {
			model.addAttribute("message", "th??m PHI???U XU???T th???t b???i, m?? PHI???U XU???T ???? t???n t???i");
			System.out.print("th??m ????n h??ng th???t b???i");
			System.out.println("Ma px da ton tai");
		}

		return "redirect:/quanlyphieuxuat/cn1/chinhanh/add.htm";
	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.GET)
	public String xoaNVCN1(ModelMap model, HttpServletRequest request) {

		model.addAttribute("id", request.getParameter("id"));

		return "chinhanh/form/xoa-phieuxuat";

	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.POST)
	public String xoaKCN1P(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");
		System.out.print(request.getParameter("xacNhan") + request.getParameter("id"));
		try {
			if (request.getParameter("xacNhan").equals("YES")) {
//				VatTuEntity nvsave = vtrepo.findOne(id);
				pxrepo.delete(id);

				model.addAttribute("message", "xo?? phi???u xu???t th??nh c??ng");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "xo?? phi???u xu???t th???t b???i, ch??? c?? th??? xo?? phi???u xu???t tr???ng");
		}
		return "redirect:/quanlyphieuxuat/cn1/chinhanh.htm";

	}

	@RequestMapping(value = "chinhanh/edit", method = RequestMethod.GET)
	public String editVTCN1(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");

		PhieuXuatEntity k = pxrepo.findOne(id);
		if (k != null) {
			model.addAttribute("dh", k);
			model.addAttribute("idkho", idKho);
			System.out.print("t???n t???i px");
		}

		else {
			System.out.print("kh??ng t???n t???i px");
			return "redirect:quanlyphieuxuat/cn1/chinhanh.htm";
		}

		return "chinhanh/form/edit-phieuxuat";
	}

	@RequestMapping(value = "chinhanh/edit", method = RequestMethod.POST)
	public String editVTCN1(ModelMap model, @ModelAttribute("k") PhieuXuatEntity k, HttpServletRequest request) {

		UserModel user = (UserModel) session.getAttribute("USERMODEL");
		PhieuXuatEntity ksave2 = null;
		try {
			k.setNgay(new Date());
			k.setKho(krepo.findAll().get(0));

			k.setNhanVien(nvrepo.findOne(user.getMaNV()));
			ksave2 = pxrepo.save(k);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ksave2 != null) {

			model.addAttribute("message", "s???a PHIEU XUAT th??nh c??ng");
			System.out.print("s???a PHIEU XUAT th??nh c??ng");
		}

		return "redirect:/quanlyphieuxuat/cn1/chinhanh.htm";

	}

	// ======================================USER=====================================//

	@RequestMapping(value = { "user" }, method = RequestMethod.GET)
	public String getPXU(ModelMap model, HttpServletRequest request) {
		idKho = (String) request.getParameter("idkho");
		if (idKho != "" && idKho != null) {
			Sort sort = new Sort(Sort.Direction.DESC, "maPX");
			List<PhieuXuatEntity> pxs = (List<PhieuXuatEntity>) pxrepo.findByKho(idKho);
			model.addAttribute("ddhs", pxs);
			/* for (PhieuXuatEntity dh:pxs) System.out.print(dh.pxrepo()); */
			return "user/qlphieuxuat";
		} else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maPX");
			model.addAttribute("ddhs", pxrepo.findAll(sort));
			return "user/qlphieuxuat";
		}

	}

	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addDDHU(ModelMap model) {

		model.addAttribute("px", new PhieuXuatEntity());
		model.addAttribute("idkho", idKho);

		return "user/form/add-phieuxuat";
	}

	@RequestMapping(value = "user/add", method = RequestMethod.POST)
	public String addDHU(ModelMap model, @ModelAttribute("px") PhieuXuatEntity dh, HttpServletRequest request) {

		boolean ckpx = false;
		try {
			ckpx = (pxrepo.ckPX(dh.getMaPX()) == 0);
		} catch (Exception e) {
			e.printStackTrace();

		}
		if (ckpx) {
			PhieuXuatEntity nvsave = null;
			UserModel user = (UserModel) session.getAttribute("USERMODEL");

			try {
				dh.setKho(krepo.findOne(idKho));
				dh.setNgay(new Date());
				dh.setNhanVien(nvrepo.findOne(user.getMaNV()));

				nvsave = pxrepo.save(dh);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "th??m PHI???U XU???T th???t b???i");
				System.out.print("th??m ????n h??ng th???t b???i");
			}
			if (nvsave != null) {
				model.addAttribute("message", "th??m PHI???U XU???T th??nh c??ng");
				System.out.print("th??m ????n h??ng th??nh c??ng");
			}
		} else {
			model.addAttribute("message", "th??m PHI???U XU???T th???t b???i, m?? PHI???U XU???T ???? t???n t???i");
			System.out.print("th??m ????n h??ng th???t b???i");
			System.out.println("Ma px da ton tai");
		}

		return "redirect:/quanlyphieuxuat/cn1/user/add.htm";
	}

	@RequestMapping(value = "user/xoa", method = RequestMethod.GET)
	public String xoaNVU(ModelMap model, HttpServletRequest request) {

		model.addAttribute("id", request.getParameter("id"));

		return "user/form/xoa-phieuxuat";

	}

	@RequestMapping(value = "user/xoa", method = RequestMethod.POST)
	public String xoaKU(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");
		System.out.print(request.getParameter("xacNhan") + request.getParameter("id"));
		try {
			if (request.getParameter("xacNhan").equals("YES")) {
//					VatTuEntity nvsave = vtrepo.findOne(id);
				pxrepo.delete(id);

				model.addAttribute("message", "xo?? phi???u xu???t th??nh c??ng");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "xo?? phi???u xu???t th???t b???i, ch??? c?? th??? xo?? phi???u xu???t tr???ng");
		}
		return "redirect:/quanlyphieuxuat/cn1/user.htm";

	}

	@RequestMapping(value = "user/edit", method = RequestMethod.GET)
	public String editVTU(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");

		PhieuXuatEntity k = pxrepo.findOne(id);
		if (k != null) {
			model.addAttribute("dh", k);
			model.addAttribute("idkho", idKho);
			System.out.print("t???n t???i px");
		}

		else {
			System.out.print("kh??ng t???n t???i px");
			return "redirect:quanlyphieuxuat/cn1/user.htm";
		}

		return "user/form/edit-phieuxuat";
	}

	@RequestMapping(value = "user/edit", method = RequestMethod.POST)
	public String editVTU(ModelMap model, @ModelAttribute("k") PhieuXuatEntity k, HttpServletRequest request) {

		UserModel user = (UserModel) session.getAttribute("USERMODEL");
		PhieuXuatEntity ksave2 = null;
		try {
			k.setNgay(new Date());
			k.setKho(krepo.findAll().get(0));

			k.setNhanVien(nvrepo.findOne(user.getMaNV()));
			ksave2 = pxrepo.save(k);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ksave2 != null) {

			model.addAttribute("message", "s???a PHIEU XUAT th??nh c??ng");
			System.out.print("s???a PHIEU XUAT th??nh c??ng");
		}

		return "redirect:/quanlyphieuxuat/cn1/user.htm";

	}

	// ======================================CONGTY=====================================//

	@RequestMapping(value = { "congty" }, method = RequestMethod.GET)
	public String getPXCTY(ModelMap model, HttpServletRequest request) {
		idKho = (String) request.getParameter("idkho");
		if (idKho != "" && idKho != null) {
			Sort sort = new Sort(Sort.Direction.DESC, "maPX");
			List<PhieuXuatEntity> pxs = (List<PhieuXuatEntity>) pxrepo.findByKho(idKho);
			model.addAttribute("ddhs", pxs);
			/* for (PhieuXuatEntity dh:pxs) System.out.print(dh.pxrepo()); */
			return "congty/qlphieuxuat";
		} else {
			System.out.print("khong co ma kho");
			Sort sort = new Sort(Sort.Direction.DESC, "maPX");
			model.addAttribute("ddhs", pxrepo.findAll(sort));
			return "congty/qlphieuxuat";
		}

	}

}