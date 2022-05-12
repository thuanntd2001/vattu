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
@Table(name="Kho")
public class KhoEntity {
	@Id

	@Column(name="MAKHO")
	private String maKho;
	@Column(name="TENKHO")
	private String tenKho;
	@Column(name="DIACHI")
	private String diaChi;
	@Column(name="MACN")
	private String maCN;
	
	@OneToMany(mappedBy = "Kho", fetch = FetchType.EAGER)
	List<PhieuNhapEntity> phieuNhaps = new ArrayList<PhieuNhapEntity>();
	
	@OneToMany(mappedBy = "Kho", fetch = FetchType.EAGER)
	List<PhieuXuatEntity> phieuXuats = new ArrayList<PhieuXuatEntity>();
	
	public String getMaKho() {
		return maKho;
	}
	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}
	public String getTenKho() {
		return tenKho;
	}
	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMaCN() {
		return maCN;
	}
	public void setMaCN(String maCN) {
		this.maCN = maCN;
	}
	

}
