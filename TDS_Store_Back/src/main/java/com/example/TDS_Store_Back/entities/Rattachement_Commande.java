package com.example.TDS_Store_Back.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Rattachement_Commande")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rattachement_Commande implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_PRODUIT")
    private Long idProduit;

    @Column(name = "ID_COMMANDE")
    private Long idCommande;

}
