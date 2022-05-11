package quanlyvattu.controller.chinhanh;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlyvattu.dao.impl.NhanVienDAO;
import quanlyvattu.entity.NhanVienEntity;


@Transactional
@Controller
public class QLNhanVienHomeChiNhanh {

NhanVienDAO nvdao=new NhanVienDAO();
	// CONTROLLER
	@RequestMapping(value = "chinhanh-home", method = RequestMethod.GET)
	public <E> String index(HttpServletRequest request,ModelMap model){	
/*		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) nvdao.findAll());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);
	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);*/
		return "chinhanh/chinhanhhome";
	}
	
/*	//hiển thị form
	@RequestMapping(value="form", method = RequestMethod.GET) 
    public String index_form(ModelMap model) {
		model.addAttribute("nv",new NhanVienEntity());
          return "admin/form/inputNV";
    }*/
	
/*	public List<NhanVienEntity> getNhanVien(){
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVienEntity where daNghi = false";
		Query query = session.createQuery(hql);
		List<NhanVienEntity> list = query.list();
		return list;
	}*/
}	
	/*//thêm nhân viên
	@RequestMapping(value = "form",params = "Insert", method = RequestMethod.POST )
	public <E> String addUser(HttpServletRequest request, ModelMap model,@ModelAttribute("nv") NhanVienEntity nv) {
		
		String dateInString = request.getParameter("ngaysinh");
		Date ngaysinh;
		try {
			ngaysinh = DateUtils.parseDate(dateInString, 
			  new String[] { "yyyy-MM-dd", "dd/MM-yyyy" });
			nv.setNgaySinh(ngaysinh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dateInString1 = request.getParameter("ngayvaolam");
		Date ngayvaolam;
		try {
			ngayvaolam = DateUtils.parseDate(dateInString1, 
			  new String[] { "yyyy-MM-dd", "dd/MM-yyyy" });
			nv.setNgayVaoLam(ngayvaolam);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		nv.setDaNghi(false);
		Integer temp = this.insertUser(nv);
		if(temp != 0) {
		    model.addAttribute("message","Thêm Thành Công");
			nv.setHoTen(null);
			nv.setGioiTinh(null);
			nv.setLuong(null);
			nv.setSdt(null);
			nv.setCmnd(null);
			nv.setDiaChi(null);
		
		}else {
			model.addAttribute("message","Thêm Thất Bại");
		}
		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) this.getNhanVien());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/QLNV";
	}
	
	public Integer insertUser(NhanVienEntity nv) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(nv);
			t.commit();
		}catch(Exception e) {
			t.rollback();
			return 0;
		}finally {
			session.close();
		}
		return 1;
	} 
	
	// phần chỉnh sửa 
	
	@RequestMapping(value = "form", params = "linkEdit" )
	public String editNV_showform (HttpServletRequest request, ModelMap model) {
		String id1 =request.getParameter("id");
		long maNV = Long.parseLong(id1);
		List<NhanVienEntity> nhanvien = this.getNhanVien();
		model.addAttribute("pagedListHolder", nhanvien);
		
		NhanVienEntity NV =  this.getNV(maNV);
		
		Date ngaysinh = NV.getNgaySinh();
		Date ngayvaolam = NV.getNgayVaoLam();
		String ngaysinh1 = ngaysinh.toString();
		String ngayvaolam1 = ngayvaolam.toString();
		
		model.addAttribute("ngaysinh",ngaysinh);
		model.addAttribute("ngayvaolam",ngayvaolam);
		
		model.addAttribute("nv",NV);
		model.addAttribute("btnupdate","true");
		return "admin/form/inputNV";
	}

	@RequestMapping(value = "form", params = "btnupdate" , method = RequestMethod.POST )
	public <E> String editNV(HttpServletRequest requets, ModelMap model, 
			@ModelAttribute("nv") NhanVienEntity nv) {
		String dateInString = requets.getParameter("ngaysinh");
		Date ngaysinh;
		try {
			ngaysinh = DateUtils.parseDate(dateInString, 
			  new String[] { "yyyy-MM-dd", "dd/MM-yyyy" });
			nv.setNgaySinh(ngaysinh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dateInString1 = requets.getParameter("ngayvaolam");
		Date ngayvaolam;
		try {
			ngayvaolam = DateUtils.parseDate(dateInString1, 
			  new String[] { "yyyy-MM-dd", "dd/MM-yyyy" });
			nv.setNgayVaoLam(ngayvaolam);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer temp = this.updateNV(nv);
		if( temp != 0) {
			model.addAttribute("message", "Cập nhật thành công");	
		}
		else {
			model.addAttribute("message", "Cập nhật không thành công nhân vien số "+nv.getMaNV());

		}
		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) this.getNhanVien());
		int page = ServletRequestUtils.getIntParameter(requets, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);
	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/QLNV";
	}
	
	
	public Integer updateNV(NhanVienEntity nv) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(nv);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			return 0;
		}
		finally {
			session.close();
		}
		return 1;
	}
	// end phần chỉnh sửa 
	
	public List<UserTBEntity> getTaiKhoans() {
		Session session = factory.getCurrentSession();
		String hql = "FROM UserTBEntity where status =:status";
		Query query = session.createQuery(hql);
		query.setParameter("status", 1);
		List<UserTBEntity> list = query.list();
		return list;
	}
	
	public UserTBEntity getTaiKhoan (long Manv) {
		Session session = factory.getCurrentSession();
		String hql = "FROM UserTBEntity where usernv.maNV =:Manv and status=:status";
		
		Query query = session.createQuery(hql);
		query.setParameter("Manv", Manv);
		query.setParameter("status", 1);
		UserTBEntity list = (UserTBEntity) query.list().get(0);
		return list;
	}
	
	public Integer updateTK(UserTBEntity tk) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(tk);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			return 0;
		}
		finally {
			session.close();
		}
		return 1;
	}

	
	public void deleteTaiKhoan(long MaNV) {
		List<UserTBEntity> list = (List<UserTBEntity>)getTaiKhoans();
		int n = list.size();
		System.out.println(n);
		for(int i=0;i<n;i++)
		{
			if(list.get(i).getUsernv().getMaNV() == MaNV) {
				UserTBEntity tmp = this.getTaiKhoan(MaNV);
				tmp.setStatus(0);
				updateTK(tmp);
				System.out.println("daxoaoooooooooo");
			}
		}
	}
	
//	phần xóa
	@RequestMapping(value = "index", params = "linkDelete",method = RequestMethod.GET)
	public <E> String deleteNV (HttpServletRequest request, ModelMap model) {
		String id1 =request.getParameter("id");
		long maNV = Long.parseLong(id1);
		NhanVienEntity tmp = this.getNV(maNV);
		tmp.setDaNghi(true);
		this.deleteTaiKhoan(maNV);
		
		Integer temp = this.updateNV(tmp);
		if(temp != 0) {
			model.addAttribute("message","Delete k thành công");
		}
		else {
			model.addAttribute("message", "Delete thành công");
		}
		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) this.getNhanVien());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);
	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/QLNV";

}
	@RequestMapping(value = "index", params = "linkDelete",method = RequestMethod.GET)

	@RequestMapping(value = "{id}.htm", params = "linkDelete",method = RequestMethod.GET)
	public <E> String deleteNV (HttpServletRequest request, ModelMap model,
			@PathVariable("id") Long id) {
		this.getNV(id).setDaNghi(true);
		Integer temp = this.updateNV(this.getNV(id));
		if(temp != 0) {
			model.addAttribute("message","Delete k thành công");
		}
		else {
			model.addAttribute("message", "Delete thành công");
		}
		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) this.getNhanVien());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);
	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		//model.addAttribute("bans", list);
		return "admin/QLNV";
	}
//	kết thúc xóa
	
//	phần tìm kiếm
	@SuppressWarnings("unchecked")
	@RequestMapping(value="index", params = "btnsearch", method=RequestMethod.POST)
	public <E> String searchNhanVien(HttpServletRequest request, ModelMap model) {
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>)this.searchNhanVien(request.getParameter("searchInput")));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setMaxLinkedPages(10);
		
		pagedListHolder.setPageSize(5);
		
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return "admin/QLNV";
	}
	public List<NhanVienEntity> searchNhanVien(String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVienEntity where maNV = :id OR hoTen like :name and daNghi = false";
		Query query = session.createQuery(hql);
		Long id = null;
	
		try {
			id = Long.parseLong(name);
		}
		catch (Exception e) {
		}
		
		query.setParameter("id", id);			
		query.setParameter("name", "%" +  name + "%");
		List<NhanVienEntity> list = query.list();
		return list;
	}
//	kết thúc tìm kiếm
	
	public NhanVienEntity getNV (long id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVienEntity where maNV =:id and daNghi = false ";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		NhanVienEntity list = (NhanVienEntity) query.list().get(0);
		return list;
	}
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        sdf.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    }
}
*/