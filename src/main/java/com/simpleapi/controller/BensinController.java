package com.simpleapi.controller;

import com.simpleapi.model.Bensin;
import com.simpleapi.repository.BensinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("bensin")
public class BensinController {

    // Create instance object
    @Autowired
    BensinRepository bensinRepo;

    @PostMapping("/insert")
    public String insertDataBensin(@RequestBody Bensin bensin) {
        bensinRepo.save(bensin);
        return "Produk bensin berhasil ditambahkan";
    }

    @GetMapping("/index")
    public List<Bensin> getAllData() {
        return bensinRepo.findAll();
    }

    @GetMapping("/getById/{id}")
    public List<Bensin> findById(@PathVariable(value = "id") long id) {
        return bensinRepo.findById(id);
    }

    @GetMapping("/getByPerusahaan/{perusahaan}")
    public List<Bensin> findByPerusahaan(@PathVariable(value = "perusahaan") String perusahaan) {
        return bensinRepo.findByPerusahaan(perusahaan);
    }

    @GetMapping("/getByOktan/{oktan}")
    public List<Bensin> findByOktan(@PathVariable(value = "oktan") int oktan) {
        return bensinRepo.findByOktan(oktan);
    }

    @GetMapping("/getByNama-Perusahaan")
    public List<Bensin> findByNamaAndPerusahaan(@RequestParam(value = "nama") String nama, @RequestParam(value = "perusahaan") String perusahaan) {
        return bensinRepo.findByNamaAndPerusahaan(nama, perusahaan);
    }

    @PostMapping("/update")
    public String updateBensin(@RequestBody Bensin bensin) {
        bensinRepo.save(bensin);
        return "Data bensin berhasil diubah";
    }

    @Transactional
    @DeleteMapping("/deleteByNama-Perusahaan")
    public String deleteBensin(@RequestParam(value = "nama") String nama, @RequestParam(value = "perusahaan") String perusahaan) {
        bensinRepo.deleteByNamaAndPerusahaan(nama, perusahaan);
        return "Produk bensin" + perusahaan + " " + nama + " berhasil dihapus";
    }

    // @DeleteMapping("/deleteByNama-Perusahaan")
    // public String deleteBensin(@RequestParam(value = "id") Long idBensin, @RequestParam(value = "nama") String nama, @RequestParam(value = "perusahaan") String perusahaan) {
    //     bensinRepo.deleteById(idBensin);
    //     return "Produk bensin" + perusahaan + nama + " berhasil dihapus";
    // }

}
