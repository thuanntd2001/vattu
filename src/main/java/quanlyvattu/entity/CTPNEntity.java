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
@Table(name="CTPN")

public class CTPNEntity {
	@Id

	@Column(name="MAPN")
	private String maPN;
	@Column(name="MAVT")
	private String maVT;
	@Column(name="SOLUONG")
	private int soLuong;
	@Column(name="DONGIA")
	private float donGia;
	
	@ManyToOne
	@JoinColumn(name="MAVT")
	private VatTuEntity vatTu;
	
	public String getMaPN() {
		return maPN;
	}
	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}
	public String getMaVT() {
		return maVT;
	}
	public void setMaVT(String maVT) {
		this.maVT = maVT;
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
