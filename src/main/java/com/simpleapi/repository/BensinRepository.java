package com.simpleapi.repository;

import com.simpleapi.model.Bensin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BensinRepository extends JpaRepository<Bensin, Long> {
    List<Bensin> findAll();
    List<Bensin> findById(long id);
    List<Bensin> findByPerusahaan(String perusahaan);
    List<Bensin> findByOktan(int oktan);
    List<Bensin> findByNamaAndPerusahaan(String nama, String perusahaan);

//    @Modifying
//    @Query("update bensin set harga = :harga where id = :id")
//    void updateBensin(@Param(value = "id") long id)
//
//    void deleteBensin(String nama, String perusahaan);

}
