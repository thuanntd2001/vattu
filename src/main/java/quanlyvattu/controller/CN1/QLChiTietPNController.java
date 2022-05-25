package quanlyvattu.controller.CN1;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.dao.impl.AbstractDAO;
import quanlyvattu.entity.CTDDHEntity;
import quanlyvattu.entity.CTPNEntity;
import quanlyvattu.entity.CTPXEntity;
import quanlyvattu.entity.PhieuNhapEntity;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN1.ChiTietDDHRepositoryCN1;
import quanlyvattu.repositoryCN1.ChiTietPNRepositoryCN1;
import quanlyvattu.repositoryCN1.ChiTietPXRepositoryCN1;
import quanlyvattu.repositoryCN1.DatHangRepositoryCN1;
import quanlyvattu.repositoryCN1.PhieuNhapRepositoryCN1;
import quanlyvattu.repositoryCN1.PhieuXuatRepositoryCN1;
import quanlyvattu.repositoryCN1.VatTuRepositoryCN1;
import quanlyvattu.statics.InfoConnection;

@Controller
@RequestMapping(value = "quanlychitietphieunhap/cn1")
public class QLChiTietPNController {
	@Autowired
	ChiTietPNRepositoryCN1 ctpnrepo;

	@Autowired
	PhieuNhapRepositoryCN1 pnrepo;
	@Autowired
	ChiTietDDHRepositoryCN1 ctdhrepo;

	@Autowired
	ServletContext session;

	AbstractDAO dao = new AbstractDAO();

	String idpn = "n/a";

	String idddh = "n/a";

	@Autowired
	VatTuRepositoryCN1 vtrepo;

	@Autowired
	DatHangRepositoryCN1 dhrepo;

	@RequestMapping(value = "chinhanh", method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request) {
		idpn = (String) request.getParameter("idpn");
		if (idpn != "" && idpn != null) {

			List<CTPNEntity> dhs = (List<CTPNEntity>) ctpnrepo.findByMaSoPN(idpn);
			model.addAttribute("ddhs", dhs);

			return "chinhanh/qlCTPN";
		} else {
			System.out.print("khong co ma kho");

			model.addAttribute("ddhs", ctpnrepo.findAll());
			return "chinhanh/qlCTPN";
		}

	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model) {
		model.addAttribute("ct", new CTPXEntity());
		model.addAttribute("vattus", vtrepo.findAll());
		PhieuNhapEntity pn = pnrepo.findOne(idpn);
		model.addAttribute("pn", pn);
		idddh = pn.getDatHang().getMaSoDDH();
		if (idddh != "" && idddh != null && idddh != "n/a") {
			System.out.println(idddh = pn.getDatHang().getMaSoDDH());
			List<CTDDHEntity> dhs = (List<CTDDHEntity>) ctdhrepo.findByMaSoDDH(idddh);
			model.addAttribute("ddhs", dhs);

		} else {
			System.out.print("khong co ma DDH");

			model.addAttribute("ddhs", ctdhrepo.findAll());

		}

		return "chinhanh/form/add-CTPN";
	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.POST)
	public String addchitietDDHCN(ModelMap model, @ModelAttribute("ct") CTPNEntity ct, HttpServletRequest request) {

		CTPXEntity nvsave = null;
		UserModel user = (UserModel) session.getAttribute("USERMODEL");

		try {
			System.out.println(idpn);

			String vt = request.getParameter("maVT");

			System.out.println(InfoConnection.getUrlPM());

			String sql = "INSERT INTO [dbo].[CTPN]\n" + "           ([MaPN]\n" + "           ,[MAVT]\n"
					+ "           ,[SOLUONG]\n" + "           ,[DONGIA]\n)" +

					"     VALUES (?,?,?,?)";
			System.out.println(sql);

			System.out.println(ct.getSoLuong());
			System.out.println(ct.getDonGia());
			dao.insertPM(sql, idpn, vt, ct.getSoLuong(), ct.getDonGia());
			model.addAttribute("message", "thêm chi tiết thành công");
			System.out.print("thêm chi tiết thành công");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "thêm chi tiết thất bại, loại vật tư đã tồn tại");
			System.out.print("thêm chi tiết thất bại");

		}

		return "redirect:/quanlychitietphieunhap/cn1/chinhanh.htm?idpn=" + idpn;
	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.GET)
	public String xoaNVCN1(ModelMap model, HttpServletRequest request) {

		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("vt", request.getParameter("vt"));
		System.out.println(request.getParameter("vt"));
		return "chinhanh/form/xoa-CTPN";

	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.POST)
	public String xoaKCN1P(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");
		String vt = request.getParameter("vt");
		System.out.print(request.getParameter("xacNhan") + request.getParameter("id"));
		try {
			if (request.getParameter("xacNhan").equals("YES")) {
//				VatTuEntity nvsave = vtrepo.findOne(id);

				String sql = "DELETE FROM [dbo].[CTPN]\n" + "      WHERE MaPN=? and MAVT=?\n";
				System.out.println(id);
				System.out.println(id);
				System.out.println(vt);
				System.out.println(InfoConnection.getUrlPM());
				dao.updatePM(sql, id, vt);
				model.addAttribute("message", "xoá chi tiết PN thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "xoá ct phiếu Nhập thất bại");
		}
		return "redirect:/quanlychitietphieunhap/cn1/chinhanh.htm?idpx=" + id;

	}
}
