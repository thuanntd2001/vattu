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
@Table(name="DatHang")

public class DatHangEntity {
	@Id

	@Column(name="MASODDH")
	private String maSoDDH;
	@Column(name="NGAY")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Timestamp ngay;
	@Column(name="NHACC")
	private String nhaCC;

	@Column(name="MAKHO")
	private String maKho;
	
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVienEntity nhanVien;
	
	@OneToMany(mappedBy = "datHang", fetch = FetchType.EAGER)
	List<PhieuNhapEntity> phieuNhaps = new ArrayList<PhieuNhapEntity>();
	
	public String getMaSoDDH() {
		return maSoDDH;
	}
	public void setMaSoDDH(String maSoDDH) {
		this.maSoDDH = maSoDDH;
	}
	public Timestamp getNgay() {
		return ngay;
	}
	public void setNgay(Timestamp ngay) {
		this.ngay = ngay;
	}
	public String getNhaCC() {
		return nhaCC;
	}
	public void setNhaCC(String nhaCC) {
		this.nhaCC = nhaCC;
	}

	public String getMaKho() {
		return maKho;
	}
	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}
	
	
}
