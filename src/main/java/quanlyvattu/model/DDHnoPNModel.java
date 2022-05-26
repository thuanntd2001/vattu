package quanlyvattu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DDHnoPNModel {
	private String maSoDDH;
	
	@Temporal(TemporalType.DATE)
	private Date ngayLap;
	
	private String nhaCC;
	
	private String ho;
	
	private String ten;
	
	private String tenVT;
	
	private int soLuong;
	
	private float donGia;
	
	
	public String getMaSoDDH() {
		return maSoDDH;
	}
	
	public void setMaSoDDH(String maSoDDH) {
		this.maSoDDH = maSoDDH;
	}
	
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public String getTenVT() {
		return tenVT;
	}
	public void setTenVT(String tenVT) {
		this.tenVT = tenVT;
	}
	
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
