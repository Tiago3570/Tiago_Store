package com.example.TDS_Store_Back.service;

import com.example.TDS_Store_Back.entities.ProduitEntity;

import java.util.List;
import java.util.Optional;

public interface IProduitService {

    /**
     * Récupère un id en fonction de l'id
     * @param produitId
     * @return
     */
    ProduitEntity getById(Long produitId);

    /**
     * Récupère toute les liste des produits de la BDD
     * @return une liste de produits
     */
    List<ProduitEntity> findAll();

    /**
     * Récupère tous les produits possédant un prix supérieur au prix en paramètre
     * @param prix
     * @return une List de produit
     */
    List<ProduitEntity> chercherUnProduitCher(Long prix);

}
