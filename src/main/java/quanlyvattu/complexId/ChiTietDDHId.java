package quanlyvattu.complexId;

import java.io.Serializable;

import quanlyvattu.entity.DatHangEntity;
import quanlyvattu.entity.VatTuEntity;

public class ChiTietDDHId implements Serializable {
	private DatHangEntity datHang;
	private VatTuEntity vatTu;

	public ChiTietDDHId(DatHangEntity datHang, VatTuEntity vatTu) {
		super();
		this.datHang = datHang;
		this.vatTu = vatTu;
	}

	public ChiTietDDHId() {
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
	
	 public int hashCode() {
	        return (int) datHang.hashCode() + vatTu.hashCode();
	    }
	 
	 public boolean equals(Object obj) {
	        if (obj == this) return true;
	        if (!(obj instanceof ChiTietDDHId)) return false;
	        if (obj == null) return false;
	        ChiTietDDHId pk = (ChiTietDDHId) obj;
	        return pk.datHang.getMaSoDDH().equals(datHang.getMaSoDDH()) && pk.vatTu.getMaVT().equals(vatTu.getMaVT());
	    }

}