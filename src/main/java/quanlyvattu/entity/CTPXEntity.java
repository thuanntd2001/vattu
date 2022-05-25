package quanlyvattu.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

class ChiTietPXVT implements Serializable {
	private PhieuXuatEntity phieuXuat;
	private VatTuEntity vatTu;

	public ChiTietPXVT(PhieuXuatEntity phieuXuat, VatTuEntity vatTu) {
		super();
		this.phieuXuat = phieuXuat;
		this.vatTu = vatTu;
	}

	public ChiTietPXVT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhieuXuatEntity getPhieuXuat() {
		return phieuXuat;
	}

	public void setPhieuXuat(PhieuXuatEntity phieuXuat) {
		this.phieuXuat = phieuXuat;
	}

	public VatTuEntity getVatTu() {
		return vatTu;
	}

	public void setVatTu(VatTuEntity vatTu) {
		this.vatTu = vatTu;
	}

}

@Entity
@Table(name = "CTPX")
@IdClass(ChiTietPXVT.class)
public class CTPXEntity {
	public CTPXEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id

	@ManyToOne
	@JoinColumn(name = "MAPX")
	private PhieuXuatEntity phieuXuat;

	@Id
	@ManyToOne
	@JoinColumn(name = "MAVT")
	private VatTuEntity vatTu;

	@Column(name = "SOLUONG")
	private int soLuong;

	public PhieuXuatEntity getPhieuXuat() {
		return phieuXuat;
	}

	public void setPhieuXuat(PhieuXuatEntity phieuXuat) {
		this.phieuXuat = phieuXuat;
	}

	public VatTuEntity getVatTu() {
		return vatTu;
	}

	public void setVatTu(VatTuEntity vatTu) {
		this.vatTu = vatTu;
	}

	@Column(name = "DONGIA")
	private float donGia;

	public int getSoLuong() {
		return soLuong;
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