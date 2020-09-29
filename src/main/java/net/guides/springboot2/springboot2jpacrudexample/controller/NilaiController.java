package net.guides.springboot2.springboot2jpacrudexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.dto.NilaiDTO;
import net.guides.springboot2.springboot2jpacrudexample.dto.ResponseJson;
import net.guides.springboot2.springboot2jpacrudexample.enums.ResponseCodes;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Nilai;
import net.guides.springboot2.springboot2jpacrudexample.repository.NilaiRepository;
import net.guides.springboot2.springboot2jpacrudexample.service.NilaiService;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/nashta")
public class NilaiController {
	
	@Autowired
	private NilaiRepository nilaiRepo;
	
	@Autowired
	private NilaiService nilaiService;
	
	@GetMapping("/nilai")
	public List<Nilai> getAllNilai() {
		return nilaiRepo.findAll();
	}
	
	@RequestMapping(value = "/{id_mahasiswa}/{id_matkul}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseJson>getByKebutuhan(
			@PathVariable(name="id_mahasiswa", required=true, value="")long Idmhs,
			@PathVariable(name="id_matkul", required=true, value="") long Idmatkul)
	{
		try {
			
			Nilai nilai = nilaiRepo.findOneById_mahasiswaAndId_matkul(Idmhs, Idmatkul);
			if(nilai!=null) {
				NilaiDTO nilaiDto = nilaiService.transformToDto(nilai);
				return ResponseEntity.ok(new ResponseJson(ResponseCodes.SUCCESS, nilaiDto));
			}else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseJson(ResponseCodes.NOTFOUND, "Data Not Found"));
		} 
		}catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJson(ResponseCodes.OTHER, e.getMessage()));
			}
	}
	

	
	@GetMapping("/nilai/{id}")
	public ResponseEntity<Nilai> getNilaiById(@PathVariable(value = "id") Long nilaiId)
			throws ResourceNotFoundException {
		Nilai nilai = nilaiRepo.findById(nilaiId)
				.orElseThrow(() -> new ResourceNotFoundException("Nilai not found for this id :: " + nilaiId));
		return ResponseEntity.ok().body(nilai);
	}
	

	@PostMapping("/nilai")
	public Nilai createNilai(@Validated @RequestBody Nilai nilai) {
		return nilaiRepo.save(nilai);
	}

	@PutMapping("/nilai/{id}")
	public ResponseEntity<Nilai> updateNilai(@PathVariable(value = "id") Long nilaiId,
			@Validated @RequestBody Nilai nilaiDetails) throws ResourceNotFoundException {
		Nilai nilai = nilaiRepo.findById(nilaiId)
				.orElseThrow(() -> new ResourceNotFoundException("Nilai not found for this id :: " + nilaiId));
		
		nilai.setId_mahasiswa(nilaiDetails.getId_mahasiswa());
		nilai.setId_matkul(nilaiDetails.getId_matkul());
		nilai.setNilai(nilaiDetails.getNilai());
		nilai.setKeterangan(nilaiDetails.getKeterangan());
		final Nilai updateNilai = nilaiRepo.save(nilai);
		return ResponseEntity.ok(updateNilai);
	}

	@DeleteMapping("/nilai/{id}")
	public Map<String, Boolean> deleteNilai(@PathVariable(value = "id") Long nilaiId)
			throws ResourceNotFoundException {
		Nilai nilai = nilaiRepo.findById(nilaiId)
				.orElseThrow(() -> new ResourceNotFoundException("Nilai not found for this id :: " + nilaiId));

		nilaiRepo.delete(nilai);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
