package com.example.TDS_Store_Back.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity                     // Pour dire qu'il s'agit d'une entité une classe en BDD
@Table(name = "Produit")    // Le nom de la classe
@AllArgsConstructor         // Lambock demande d'un constructeur avec tous les paramètres
@NoArgsConstructor          // Lambock demande d'un construteur vide
@Getter                     // Demande tous les Getter
@Setter                     // Demande tous les setter

/*
// Permet de mettre une condition quand on fait un get le where vaa se rajouter à la requête
@Where(clause = "deleted = false")
*/

/*
 * Lambok si tu souhaite que IntLij te propose les Get et les Set il faut installer le plugin Lambock
 * remarque on peut mettre les @Getter et @Setter au dessus de chaque attribut si l'on ne souhaite pas attribuer
 * les setter et le getter à tous les attributs de la classe
 *
 * CF : le fichier Informations.txt à la racine du projet
 *
 * Un exemple si tu souhaite ajouter une contrainte à la table
 * @Table(name = "Produit",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"TYPE_ID_NAT_PERS", "ID_PP"})})
 */


/**
 * Classe à l'image de la table Produit. Hibernate l'utilise pour la génération de la Table
 */
public class ProduitEntity implements Serializable {

    private static final long serialVersionUID = 5104355377350251539L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produit_generator")
    @SequenceGenerator(name="produit_generator", sequenceName = "produit_seq", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRIX", nullable = false)
    private Float prix;

    @Column(name = "PRIX_ACHAT")
    private Float prixAchat;

    @Column(name = "CREATION_DATE", updatable = false, nullable = false)
    private Date creationDate;

    @Column(name = "MODIFICATION_DATE")
    private Date modificationDate;


}
