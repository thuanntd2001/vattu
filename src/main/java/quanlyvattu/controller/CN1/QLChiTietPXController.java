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
import quanlyvattu.entity.CTPXEntity;
import quanlyvattu.model.UserModel;
import quanlyvattu.repositoryCN1.ChiTietPXRepositoryCN1;
import quanlyvattu.repositoryCN1.PhieuXuatRepositoryCN1;
import quanlyvattu.repositoryCN1.VatTuRepositoryCN1;
import quanlyvattu.statics.InfoConnection;

@Controller
@RequestMapping(value = "quanlychitietphieuxuat/cn1")
public class QLChiTietPXController {
	@Autowired
	ChiTietPXRepositoryCN1 ctpxrepo;

	@Autowired
	ServletContext session;

	AbstractDAO dao = new AbstractDAO();

	String idddh = "n/a";

	@Autowired
	VatTuRepositoryCN1 vtrepo;

	PhieuXuatRepositoryCN1 pxrepo;

	@RequestMapping(value = {"chinhanh","congty","user"}, method = RequestMethod.GET)
	public String getDDHCN(ModelMap model, HttpServletRequest request) {
		idddh = (String) request.getParameter("idpx");
		if (idddh != "" && idddh != null) {

			List<CTPXEntity> dhs = (List<CTPXEntity>) ctpxrepo.findByMaSoPX(idddh);
			model.addAttribute("ddhs", dhs);

			return "chinhanh/qlCTPX";
		} else {
			System.out.print("khong co ma kho");

			model.addAttribute("ddhs", ctpxrepo.findAll());
			return "chinhanh/qlCTPX";
		}

	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.GET)
	public String addDDHCN(ModelMap model) {
		model.addAttribute("ct", new CTPXEntity());
		model.addAttribute("vattus", vtrepo.findAll());
		return "chinhanh/form/add-CTPX";
	}

	@RequestMapping(value = "chinhanh/add", method = RequestMethod.POST)
	public String addchitietDDHCN(ModelMap model, @ModelAttribute("ct") CTPXEntity ct, HttpServletRequest request) {

		CTPXEntity nvsave = null;
		UserModel user = (UserModel) session.getAttribute("USERMODEL");

		try {
			System.out.println(idddh);

			String vt = request.getParameter("maVT");

			System.out.println(InfoConnection.getUrlPM());
//			nvsave = ctdhrepo.save(ct);

			String sql = "INSERT INTO [dbo].[CTPX]\n" + "           ([MaPX]\n" + "           ,[MAVT]\n"
					+ "           ,[SOLUONG]\n" + "           ,[DONGIA]\n)" +

					"     VALUES (?,?,?,?)";
			System.out.println(sql);

			System.out.println(ct.getSoLuong());
			System.out.println(ct.getDonGia());
			dao.insertPM(sql, idddh, vt, ct.getSoLuong(), ct.getDonGia());
			model.addAttribute("message", "thêm chi tiết thành công");
			System.out.print("thêm chi tiết thành công");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "thêm chi tiết thất bại, loại vật tư đã tồn tại");
			System.out.print("thêm chi tiết thất bại");

		}

		return "redirect:/quanlychitietphieuxuat/cn1/chinhanh.htm?idpx=" + idddh;
	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.GET)
	public String xoaNVCN1(ModelMap model, HttpServletRequest request) {

		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("vt", request.getParameter("vt"));
		System.out.println(request.getParameter("vt"));
		return "chinhanh/form/xoa-CTPX";

	}

	@RequestMapping(value = "chinhanh/xoa", method = RequestMethod.POST)
	public String xoaKCN1P(ModelMap model, HttpServletRequest request) {

		String id = request.getParameter("id");
		String vt = request.getParameter("vt");
		System.out.print(request.getParameter("xacNhan") + request.getParameter("id"));
		try {
			if (request.getParameter("xacNhan").equals("YES")) {
//				VatTuEntity nvsave = vtrepo.findOne(id);

				String sql = "DELETE FROM [dbo].[CTPX]\n" + "      WHERE MaPX=? and MAVT=?\n";
				System.out.println(id);
				System.out.println(id);
				System.out.println(vt);
				System.out.println(InfoConnection.getUrlPM());
				dao.updatePM(sql, id, vt);
				model.addAttribute("message", "xoá chi tiết PX thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "xoá ct phiếu xuất thất bại");
		}
		return "redirect:/quanlychitietphieuxuat/cn1/chinhanh.htm?idpx="+id;

	}
}
