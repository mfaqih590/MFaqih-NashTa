package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Mahasiswa;
import net.guides.springboot2.springboot2jpacrudexample.repository.MahasiswaRepository;

@RestController
@RequestMapping("/nashta")
public class MahasiswaController {
	
	@Autowired
	private MahasiswaRepository mahasiswaRepo;
	
	@GetMapping("/mahasiswa")
	public List<Mahasiswa> getAllMahasiswa() {
		return mahasiswaRepo.findAll();
	}
	
//	@GetMapping("/mahasiswa/{id}")
//	public ResponseEntity<Mahasiswa> getMahasiswaById(@PathVariable(value = "id") Long mhsId)
//			throws ResourceNotFoundException {
//		Mahasiswa mhs = mahasiswaRepo.findById(mhsId)
//				.orElseThrow(() -> new ResourceNotFoundException("Mahasiswa not found for this id :: " + mhsId));
//		return ResponseEntity.ok().body(mhs);
//	}
//
//	@PostMapping("/mahasiswa")
//	public Mahasiswa createMahasiswa(@Validated @RequestBody Mahasiswa mhs) {
//		return mahasiswaRepo.save(mhs);
//	}
//
//	@PutMapping("/mahasiswa/{id}")
//	public ResponseEntity<Mahasiswa> updateMahasiswa(@PathVariable(value = "id") Long mhsId,
//			@Validated @RequestBody Mahasiswa mhsDetails) throws ResourceNotFoundException {
//		Mahasiswa mhs = mahasiswaRepo.findById(mhsId)
//				.orElseThrow(() -> new ResourceNotFoundException("Mahasiswa not found for this id :: " + mhsId));
//
//		mhs.setNama(mhsDetails.getNama());
//		mhs.setAlamat(mhsDetails.getAlamat());
//		final Mahasiswa updateMhs = mahasiswaRepo.save(mhs);
//		return ResponseEntity.ok(updateMhs);
//	}
//
//	@DeleteMapping("/mahasiswa/{id}")
//	public Map<String, Boolean> deleteMahasiswa(@PathVariable(value = "id") Long mhsId)
//			throws ResourceNotFoundException {
//		Mahasiswa mhs = mahasiswaRepo.findById(mhsId)
//				.orElseThrow(() -> new ResourceNotFoundException("Mahasiswa not found for this id :: " + mhsId));
//
//		mahasiswaRepo.delete(mhs);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}

}
