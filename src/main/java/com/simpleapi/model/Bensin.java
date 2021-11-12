package com.simpleapi.model;

import lombok.*;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bensin")
public class Bensin {

    // Generate variable for constructor & database table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nama;
    private String perusahaan;
    private int oktan;
    private int harga;
}
