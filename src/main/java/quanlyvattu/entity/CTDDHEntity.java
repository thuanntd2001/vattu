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
@Table(name="CTDDH")

public class CTDDHEntity {
	@Id

	@Column(name="MASODDH")
	private String maSoDDH;

	@Column(name="SOLUONG")
	private int soLuong;
	@Column(name="DONGIA")
	private float donGia;
	
	@ManyToOne
	@JoinColumn(name="MAVT")
	private VatTuEntity vatTu;
	
	public String getMaSoDDH() {
		return maSoDDH;
	}
	public void setMaSoDDH(String maSoDDH) {
		this.maSoDDH = maSoDDH;
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
