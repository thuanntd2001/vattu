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
@Table(name="PhieuNhap")

public class PhieuNhapEntity {
	@Id

	@Column(name="MAPN")
	private String maPN;

	@Column(name="NGAY")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date ngay;
	
	@ManyToOne
	@JoinColumn(name="MASODDH")
	private DatHangEntity datHang;
	
	public DatHangEntity getDatHang() {
		return datHang;
	}
	public void setDatHang(DatHangEntity datHang) {
		this.datHang = datHang;
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
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVienEntity nhanVien;
	
	@ManyToOne
	@JoinColumn(name="MAKHO")
	private KhoEntity kho;
	
	
	public String getMaPN() {
		return maPN;
	}
	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}	
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}



}
