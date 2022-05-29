package quanlyvattu.controller.CN2;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.dao.impl.AbstractDAO;
import quanlyvattu.mapper.CTSLHHXNMapper;
import quanlyvattu.model.CTSLHHXNModel;
import quanlyvattu.repositoryCN2.DatHangRepositoryCN2;
import quanlyvattu.repositoryCN2.KhoRepositoryCN2;
import quanlyvattu.repositoryCN2.NhanVienRepositoryCN2;
import quanlyvattu.statics.InfoConnection;

@Controller
@RequestMapping(value = "chitietsoluongtrigiahanghoanhapxuat/cn2")
public class CTSoLuongTriGiaHangHoaNhapXuatControllerCN2 {
	@Autowired
	DatHangRepositoryCN2 dhrepo;

	@Autowired
	KhoRepositoryCN2 krepo;

	@Autowired
	NhanVienRepositoryCN2 nvrepo;

	@Autowired
	ServletContext session;

	AbstractDAO dao = new AbstractDAO();

//===============================CHINHANH=============================//
	@RequestMapping(value = { "chinhanh/nhap"}, method = RequestMethod.GET)
	public String getNVCN1(ModelMap model, HttpServletRequest request) {

		return "chinhanh2/form/choosepn-pn";

//		String sql = "EXEC [dbo].[sp_ChiTietSoLuongTriGiaHangHoaNhapXuat] ?,?,?,?";
//		List<CTSLHHXNModel> ctxn=dao.queryPM(InfoConnection.getUserNamePM(), InfoConnection.getPassWordPM(), sql, new CTSLHHXNMapper(),"CHINHANH" "NHAP", );
//		System.out.println(ctxn.get(0).getThangNam());
//		model.addAttribute("ctxn", ctxn);
//		model.addAttribute("nvs", nvrepo.findAllNV());
//		return "chinhanh/ctsoluongtrigiahanghoanhapxuat";

//		Timestamp tungay= Timestamp.valueOf(request.getParameter("tungay").replace("T", " ") + ":00");
//		Timestamp denngay= Timestamp.valueOf(request.getParameter("denngay").replace("T", " ") + ":00");

//		String sql = "EXEC [dbo].[sp_ChiTietSoLuongTriGiaHangHoaNhapXuat] ?,?,?,?";
//		@SuppressWarnings("deprecation")
//		List<CTSLHHXNModel> ctxn=dao.queryPM(InfoConnection.getUserNamePM(), InfoConnection.getPassWordPM(), sql, new CTSLHHXNMapper(),"CHINHANH" ,"NHAP",request.getParameter("tungay"),request.getParameter("denngay"));
//		model.addAttribute("ctpns", ctxn;
//		model.addAttribute("nvs", nvrepo.findAllNV());
//		System.out.println(ctxn.get(0).getTenVT());
//		return "chinhanh/ctsoluongtrigiahanghoanhapxuat";
	}

	@RequestMapping(value = { "chinhanh/nhap"}, method = RequestMethod.POST)
	public String getPNCN1(ModelMap model, HttpServletRequest request) {
		Timestamp tungay = Timestamp.valueOf(request.getParameter("tungay").replace("T", " ") + ":00");
		Timestamp denngay = Timestamp.valueOf(request.getParameter("denngay").replace("T", " ") + ":00");

		String sql = "EXEC	[dbo].[sp_ChiTietSoLuongTriGiaHangHoaNhapXuat]\r\n" + "		@ROLE =?,\r\n"
				+ "		@TYPE = ?,\r\n" + "		@DATEFROM = ?,\r\n" + "		@DATETO = ?";
		List<CTSLHHXNModel> ctpn = dao.queryPM(InfoConnection.getUserNamePM(), InfoConnection.getPassWordPM(), sql,
				new CTSLHHXNMapper(), "CHINHANH", "NHAP", tungay, denngay);
//		System.out.println(ctxn.get(0).getThangNam());
		System.out.println(tungay + " " + denngay);
		System.out.println(ctpn.get(0).getTenVT());
		model.addAttribute("ctpns", ctpn);
		model.addAttribute("nvs", nvrepo.findAllNV());
//		System.out.println(ctxn.get(0).getTenVT());
		return "chinhanh2/CThanghoanhap";

	}

	@RequestMapping(value = { "chinhanh/xuat"}, method = RequestMethod.GET)
	public String getPXCN1(ModelMap model, HttpServletRequest request) {

		return "chinhanh2/form/choosepn-px";

	}

	@RequestMapping(value = { "chinhanh/xuat"}, method = RequestMethod.POST)
	public String getPXCN12(ModelMap model, HttpServletRequest request) {
		Timestamp tungay = Timestamp.valueOf(request.getParameter("tungay").replace("T", " ") + ":00");
		Timestamp denngay = Timestamp.valueOf(request.getParameter("denngay").replace("T", " ") + ":00");

		String sql = "EXEC	[dbo].[sp_ChiTietSoLuongTriGiaHangHoaNhapXuat]\r\n" + "		@ROLE =?,\r\n"
				+ "		@TYPE = ?,\r\n" + "		@DATEFROM = ?,\r\n" + "		@DATETO = ?";
		List<CTSLHHXNModel> ctpx = dao.queryPM(InfoConnection.getUserNamePM(), InfoConnection.getPassWordPM(), sql,
				new CTSLHHXNMapper(), "CHINHANH", "XUAT", tungay, denngay);
		model.addAttribute("ctpns", ctpx);
		model.addAttribute("nvs", nvrepo.findAllNV());
		return "chinhanh2/CThanghoaxuat";

	}

	// ===============================CONGTY=============================//
	@RequestMapping(value = { "congty/nhap"}, method = RequestMethod.GET)
	public String getNVCTY(ModelMap model, HttpServletRequest request) {

		return "congty2/form/choosepn-pn";

//			String sql = "EXEC [dbo].[sp_ChiTietSoLuongTriGiaHangHoaNhapXuat] ?,?,?,?";
//			List<CTSLHHXNModel> ctxn=dao.queryPM(InfoConnection.getUserNamePM(), InfoConnection.getPassWordPM(), sql, new CTSLHHXNMapper(),"CHINHANH" "NHAP", );
//			System.out.println(ctxn.get(0).getThangNam());
//			model.addAttribute("ctxn", ctxn);
//			model.addAttribute("nvs", nvrepo.findAllNV());
//			return "chinhanh/ctsoluongtrigiahanghoanhapxuat";

//			Timestamp tungay= Timestamp.valueOf(request.getParameter("tungay").replace("T", " ") + ":00");
//			Timestamp denngay= Timestamp.valueOf(request.getParameter("denngay").replace("T", " ") + ":00");

//			String sql = "EXEC [dbo].[sp_ChiTietSoLuongTriGiaHangHoaNhapXuat] ?,?,?,?";
//			@SuppressWarnings("deprecation")
//			List<CTSLHHXNModel> ctxn=dao.queryPM(InfoConnection.getUserNamePM(), InfoConnection.getPassWordPM(), sql, new CTSLHHXNMapper(),"CHINHANH" ,"NHAP",request.getParameter("tungay"),request.getParameter("denngay"));
//			model.addAttribute("ctpns", ctxn;
//			model.addAttribute("nvs", nvrepo.findAllNV());
//			System.out.println(ctxn.get(0).getTenVT());
//			return "chinhanh/ctsoluongtrigiahanghoanhapxuat";
	}

	@RequestMapping(value = {"congty/nhap"}, method = RequestMethod.POST)
	public String getPNCTY(ModelMap model, HttpServletRequest request) {
		Timestamp tungay = Timestamp.valueOf(request.getParameter("tungay").replace("T", " ") + ":00");
		Timestamp denngay = Timestamp.valueOf(request.getParameter("denngay").replace("T", " ") + ":00");

		String sql = "EXEC	[dbo].[sp_ChiTietSoLuongTriGiaHangHoaNhapXuat]\r\n" + "		@ROLE =?,\r\n"
				+ "		@TYPE = ?,\r\n" + "		@DATEFROM = ?,\r\n" + "		@DATETO = ?";
		List<CTSLHHXNModel> ctpn = dao.queryPM(InfoConnection.getUserNamePM(), InfoConnection.getPassWordPM(), sql,
				new CTSLHHXNMapper(), "CHINHANH", "NHAP", tungay, denngay);
//			System.out.println(ctxn.get(0).getThangNam());
		System.out.println(tungay + " " + denngay);
		System.out.println(ctpn.get(0).getTenVT());
		model.addAttribute("ctpns", ctpn);
		model.addAttribute("nvs", nvrepo.findAllNV());
//			System.out.println(ctxn.get(0).getTenVT());
		return "congty2/CThanghoanhap";

	}

	@RequestMapping(value = {"congty/xuat"}, method = RequestMethod.GET)
	public String getPXCTY(ModelMap model, HttpServletRequest request) {

		return "congty2/form/choosepn-px";

	}

	@RequestMapping(value = { "congty/xuat"}, method = RequestMethod.POST)
	public String getPXCTYs(ModelMap model, HttpServletRequest request) {
		Timestamp tungay = Timestamp.valueOf(request.getParameter("tungay").replace("T", " ") + ":00");
		Timestamp denngay = Timestamp.valueOf(request.getParameter("denngay").replace("T", " ") + ":00");

		String sql = "EXEC	[dbo].[sp_ChiTietSoLuongTriGiaHangHoaNhapXuat]\r\n" + "		@ROLE =?,\r\n"
				+ "		@TYPE = ?,\r\n" + "		@DATEFROM = ?,\r\n" + "		@DATETO = ?";
		List<CTSLHHXNModel> ctpx = dao.queryPM(InfoConnection.getUserNamePM(), InfoConnection.getPassWordPM(), sql,
				new CTSLHHXNMapper(), "CHINHANH", "XUAT", tungay, denngay);
		model.addAttribute("ctpns", ctpx);
		model.addAttribute("nvs", nvrepo.findAllNV());
		return "congty2/CThanghoaxuat";

	}

	
}
