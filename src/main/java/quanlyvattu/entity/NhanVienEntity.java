package quanlyvattu.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="NhanVien")
public class NhanVienEntity {
	@Id
	@Column(name="MANV")
	private int maNV;
	@Column(name="HO")
	private String ho;
	@Column(name="TEN")
	private String ten;
	@Column(name="DIACHI")
	private String diaChi;
	@Column(name="NGAYSINH")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Timestamp ngaySinh;
	@Column(name="LUONG")
	private float luong;
	
	@ManyToOne
	@JoinColumn(name="MACN")
	private ChiNhanhEntity chiNhanh;
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	List<DatHangEntity> DatHangs = new ArrayList<DatHangEntity>();
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	List<PhieuNhapEntity> PhieuNhaps = new ArrayList<PhieuNhapEntity>();
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	List<PhieuXuatEntity> PhieuXuats = new ArrayList<PhieuXuatEntity>();
	
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Timestamp getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Timestamp ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	public ChiNhanhEntity getChiNhanh() {
		return chiNhanh;
	}
	public void setChiNhanh(ChiNhanhEntity chiNhanh) {
		this.chiNhanh = chiNhanh;
	}
	public int getTrangThaiXoa() {
		return TrangThaiXoa;
	}
	public void setTrangThaiXoa(int trangThaiXoa) {
		TrangThaiXoa = trangThaiXoa;
	}
	@Column(name="TRANGTHAIXOA")
	private int TrangThaiXoa;

}


