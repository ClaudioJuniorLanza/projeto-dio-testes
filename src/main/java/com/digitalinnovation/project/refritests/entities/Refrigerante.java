package com.digitalinnovation.project.refritests.entities;

import com.digitalinnovation.project.refritests.enums.RefriSabores;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Refrigerante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private int max;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RefriSabores type;

}
