package quanlyvattu.entity;

import java.io.Serializable;


public class IDChiTietDDH implements Serializable{

	
	private DatHangEntity datHang;
	private VatTuEntity vatTu;

	public IDChiTietDDH(DatHangEntity datHang, VatTuEntity vatTu) {
		super();
		this.datHang = datHang;
		this.vatTu = vatTu;
	}

	public IDChiTietDDH() {
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
