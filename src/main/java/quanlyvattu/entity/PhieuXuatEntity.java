package quanlyvattu.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="PhieuXuat")

public class PhieuXuatEntity {
	@Id

	@Column(name="MAPX")
	private String maPX;
	@Column(name="NGAY")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date ngay;
	@Column(name="HOTENKH")
	private String hoTenKH;

	
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVienEntity nhanVien;
	
	@ManyToOne
	@JoinColumn(name="MAKHO")
	private KhoEntity kho;
	
	public String getMaPX() {
		return maPX;
	}
	public void setMaPX(String maPX) {
		this.maPX = maPX;
	}	
	public NhanVienEntity getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVienEntity nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhoEntity getKho() {
		return kho;
	}
	public void setKho(KhoEntity kho) {
		this.kho = kho;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}


}
