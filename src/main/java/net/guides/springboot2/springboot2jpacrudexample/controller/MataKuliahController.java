package net.guides.springboot2.springboot2jpacrudexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.MataKuliah;
import net.guides.springboot2.springboot2jpacrudexample.repository.MataKuliahRepository;

@RestController
@RequestMapping("/nashta")
public class MataKuliahController {
	@Autowired
	private MataKuliahRepository matkulRepo;
	
	@GetMapping("/mataKuliah")
	public List<MataKuliah> getAllMatkul() {
		return matkulRepo.findAll();
	}

//	@GetMapping("/mataKuliah/{id}")
//	public ResponseEntity<MataKuliah> getMatkulById(@PathVariable(value = "id") Long matkulId)
//			throws ResourceNotFoundException {
//		MataKuliah matkul = matkulRepo.findById(matkulId)
//				.orElseThrow(() -> new ResourceNotFoundException("Mata Kuliah not found for this id :: " + matkulId));
//		return ResponseEntity.ok().body(matkul);
//	}
//
//	@PostMapping("/mataKuliah")
//	public MataKuliah createMatkul(@Validated @RequestBody MataKuliah matkul) {
//		return matkulRepo.save(matkul);
//	}
//
//	@PutMapping("/mataKuliah/{id}")
//	public ResponseEntity<MataKuliah> updateMatkul(@PathVariable(value = "id") Long matkulId,
//			@Validated @RequestBody MataKuliah matkulDetails) throws ResourceNotFoundException {
//		MataKuliah matkul = matkulRepo.findById(matkulId)
//				.orElseThrow(() -> new ResourceNotFoundException("Mata Kuliah not found for this id :: " + matkulId));
//
//		matkul.setMataKuliah(matkulDetails.getMataKuliah());
//		matkul.setId_mahasiswa(matkulDetails.getId_mahasiswa());
//		final MataKuliah updateMatkul = matkulRepo.save(matkul);
//		return ResponseEntity.ok(updateMatkul);
//	}
//
//	@DeleteMapping("/mataKuliah/{id}")
//	public Map<String, Boolean> deleteMatkul(@PathVariable(value = "id") Long matkulId)
//			throws ResourceNotFoundException {
//		MataKuliah matkul = matkulRepo.findById(matkulId)
//				.orElseThrow(() -> new ResourceNotFoundException("Mata Kuliah not found for this id :: " + matkulId));
//
//		matkulRepo.delete(matkul);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}
}
