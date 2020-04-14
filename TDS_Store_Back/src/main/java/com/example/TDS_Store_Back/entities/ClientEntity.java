package com.example.TDS_Store_Back.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity                     // Pour dire qu'il s'agit d'une entité une classe en BDD
@Table(name = "Client")     // Le nom de la classe
@AllArgsConstructor         // Lambock demande d'un constructeur avec tous les paramètres
@NoArgsConstructor          // Lambock demande d'un construteur vide
@Getter                     // Demande tous les Getter
@Setter                     // Demande tous les setter

/**
 * Classe à l'image de la table Client. Hibernate l'utilise pour la génération de la Table
 */
public class ClientEntity implements Serializable {

    private static final long serialVersionUID = 5104355377350251539L;

    @Id
    @GeneratedValue         // Insertion automatique de la valeur
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "DATE_NAISSANCE")
    private Date dateNaissance;

    @CreatedDate      // On demande d'inserer la date à la première création
    @Column(name = "CREATION_DATE", updatable = false, nullable = false)
    private Date creationDate;

    @LastModifiedDate  // a chaque modification on mets à jour la date
    @Column(name = "MODIFICATION_DATE")
    private Date modificationDate;
}
