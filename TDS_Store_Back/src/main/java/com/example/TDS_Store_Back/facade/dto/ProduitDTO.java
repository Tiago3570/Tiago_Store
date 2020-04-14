package com.example.TDS_Store_Back.facade.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor         // Lambock demande d'un constructeur avec tous les paramètres
@NoArgsConstructor          // Lambock demande d'un construteur vide
@Getter                     // Demande tous les Getter
@Setter                     // Demande tous les setter

public class ProduitDTO {

    private Long id;

    private String nom;

    private Float prix;

    private Date creationDate;

    private Date modificationDate;

}

