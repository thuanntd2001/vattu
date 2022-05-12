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
@Table(name="PhieuXuat")

public class PhieuXuatEntity {
	@Id

	@Column(name="MAPX")
	private String maPX;
	@Column(name="NGAY")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Timestamp ngay;
	@Column(name="HOTENKH")
	private String hoTenKH;
	@Column(name="MANV")
	private String maNV;
	@Column(name="MAKHO")
	private String maKho;
	
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVienEntity nhanVien;
	
	@ManyToOne
	@JoinColumn(name="MAKHO")
	private KhoEntity Kho;
	
	public String getMaPX() {
		return maPX;
	}
	public void setMaPX(String maPX) {
		this.maPX = maPX;
	}	
	public Timestamp getNgay() {
		return ngay;
	}
	public void setNgay(Timestamp ngay) {
		this.ngay = ngay;
	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaKho() {
		return maKho;
	}
	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}

}
