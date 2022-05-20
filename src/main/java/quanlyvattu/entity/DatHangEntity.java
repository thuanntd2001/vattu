package quanlyvattu.entity;


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
@Table(name="DatHang")

public class DatHangEntity {
	@Id

	@Column(name="MASODDH")
	private String maSoDDH;
	@Column(name="NGAY")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date ngay;
	@Column(name="NHACC")
	private String nhaCC;

	@ManyToOne
	@JoinColumn(name="KHO")
	private KhoEntity kho;
	
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVienEntity nhanVien;
	
//	@OneToMany(mappedBy = "datHang", fetch = FetchType.EAGER)
//	List<PhieuNhapEntity> phieuNhaps = new ArrayList<PhieuNhapEntity>();
	
	@OneToMany(mappedBy = "datHang", fetch = FetchType.EAGER)
	List<CTDDHEntity> phieuNhaps = new ArrayList<CTDDHEntity>();
	
	public String getMaSoDDH() {
		return maSoDDH;
	}

	public NhanVienEntity getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVienEntity nhanVien) {
		this.nhanVien = nhanVien;
	}
	public void setMaSoDDH(String maSoDDH) {
		this.maSoDDH = maSoDDH;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date date) {
		this.ngay = date;
	}
	public String getNhaCC() {
		return nhaCC;
	}
	public void setNhaCC(String nhaCC) {
		this.nhaCC = nhaCC;
	}

	public KhoEntity getKho() {
		return kho;
	}

	public void setKho(KhoEntity kho) {
		this.kho = kho;
	}


	
	
}
