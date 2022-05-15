package quanlyvattu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

class ChiTietPNVT implements Serializable {
	private PhieuNhapEntity phieuNhap;
	private VatTuEntity vatTu;

	public ChiTietPNVT(PhieuNhapEntity phieuNhap, VatTuEntity vatTu) {
		super();
		this.phieuNhap = phieuNhap;
		this.vatTu = vatTu;
	}

	public ChiTietPNVT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhieuNhapEntity getPhieuNhap() {
		return phieuNhap;
	}

	public void setPhieuNhap(PhieuNhapEntity phieuXuat) {
		this.phieuNhap = phieuXuat;
	}

	public VatTuEntity getVatTu() {
		return vatTu;
	}

	public void setVatTu(VatTuEntity vatTu) {
		this.vatTu = vatTu;
	}
}

@Entity
@IdClass(ChiTietPNVT.class)
@Table(name = "CTPN")

public class CTPNEntity {
	@Id

	@ManyToOne
	@JoinColumn(name = "MAPN")
	private PhieuNhapEntity phieuNhap;

	@Id
	@ManyToOne
	@JoinColumn(name = "MAVT")
	private VatTuEntity vatTu;

	@Column(name = "SOLUONG")
	private int soLuong;
	@Column(name = "DONGIA")
	private float donGia;

	public int getSoLuong() {
		return soLuong;
	}

	public PhieuNhapEntity getPhieuNhap() {
		return phieuNhap;
	}

	public void setPhieuNhap(PhieuNhapEntity phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

	public VatTuEntity getVatTu() {
		return vatTu;
	}

	public void setVatTu(VatTuEntity vatTu) {
		this.vatTu = vatTu;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

}
