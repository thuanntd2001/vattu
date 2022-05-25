package quanlyvattu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



class ChiTietDHVT implements Serializable {
	private DatHangEntity datHang;
	private VatTuEntity vatTu;

	public ChiTietDHVT(DatHangEntity datHang, VatTuEntity vatTu) {
		super();
		this.datHang = datHang;
		this.vatTu = vatTu;
	}

	public ChiTietDHVT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatHangEntity getDatHang() {
		return datHang;
	}

	public void setDatHang(DatHangEntity datHang) {
		this.datHang = datHang;
	}

	public VatTuEntity getVatTu() {
		return vatTu;
	}

	public void setVatTu(VatTuEntity vatTu) {
		this.vatTu = vatTu;
	}

}

@Entity
@IdClass(ChiTietDHVT.class)
@Table(name = "CTDDH")

public class CTDDHEntity {
	@Id
	@ManyToOne
	@JoinColumn(name = "MASODDH")
	private DatHangEntity datHang;

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

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public DatHangEntity getDatHang() {
		return datHang;
	}

	public void setDatHang(DatHangEntity datHang) {
		this.datHang = datHang;
	}

	public VatTuEntity getVatTu() {
		return vatTu;
	}

	public void setVatTu(VatTuEntity vatTu) {
		this.vatTu = vatTu;
	}

}
