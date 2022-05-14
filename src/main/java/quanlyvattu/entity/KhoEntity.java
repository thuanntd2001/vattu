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
@Table(name = "Kho")
public class KhoEntity {
	@Id

	@Column(name = "MAKHO")
	private String maKho;
	@Column(name = "TENKHO")
	private String tenKho;
	@Column(name = "DIACHI")
	private String diaChi;

	@ManyToOne
	@JoinColumn(name = "MACN")
	private ChiNhanhEntity chiNhanh;

	@OneToMany(mappedBy = "kho", fetch = FetchType.LAZY)
	List<DatHangEntity> datHangs = new ArrayList<DatHangEntity>();

	@OneToMany(mappedBy = "kho", fetch = FetchType.LAZY)
	List<PhieuNhapEntity> phieuNhaps = new ArrayList<PhieuNhapEntity>();

	@OneToMany(mappedBy = "kho", fetch = FetchType.LAZY)
	List<PhieuXuatEntity> phieuXuats = new ArrayList<PhieuXuatEntity>();

	public ChiNhanhEntity getChiNhanh() {
		return chiNhanh;
	}

	public void setChiNhanh(ChiNhanhEntity chiNhanh) {
		this.chiNhanh = chiNhanh;
	}

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

}
