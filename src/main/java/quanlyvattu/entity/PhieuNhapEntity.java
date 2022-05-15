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
@Table(name="PhieuNhap")

public class PhieuNhapEntity {
	@Id

	@Column(name="MAPN")
	private String maPN;
	@Column(name="NGAY")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Timestamp ngay;

	
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
	@JoinColumn(name="KHO")
	private KhoEntity kho;
	
	
	public String getMaPN() {
		return maPN;
	}
	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}	
	public Timestamp getNgay() {
		return ngay;
	}
	public void setNgay(Timestamp ngay) {
		this.ngay = ngay;
	}



}
