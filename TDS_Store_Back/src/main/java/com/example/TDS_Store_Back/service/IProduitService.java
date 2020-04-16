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

    /**
     * sauvegarde le produit
     * @param produitEntity
     * @return le produit sauvegarder
     */
    ProduitEntity save(ProduitEntity produitEntity);

    /**
     * met à jour un produit
     * @param produitEntity
     * @return le produit mis à jour
     */
    ProduitEntity update(ProduitEntity produitEntity);

    /**
     * supprime le poroduit
     * @param produitEntity
     */
    void delete(ProduitEntity produitEntity);

    /**
     * supprime le produit en fontion de l'id
     * @param id
     */
    void deleteById(Long id);

}
