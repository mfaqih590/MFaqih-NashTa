package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(MahasiswaKey.class)
@Table(name = "mahasiswa")
public class Mahasiswa {
	@Id
	private long id;
	@Id
	private long idmahasiswa;
	private String nama;
	private String alamat;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_mahasiswa() {
		return idmahasiswa;
	}
	public void setId_mahasiswa(long id_mahasiswa) {
		this.idmahasiswa = id_mahasiswa;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
}
