package com.example.TDS_Store_Back.facade.facade;

import com.example.TDS_Store_Back.facade.dto.ProduitDTO;

import java.util.List;

public interface IProduitFacade {

    /**
     * Retourne le produit en fonction de l'ID
     * @param id
     * @return
     */
    ProduitDTO getProduitById(Long id);

    /**
     * Retourne tous les produits de la BDD
     * @return
     */
    List<ProduitDTO> findAll();

    /**
     * Retourne tous les produits on le prix est supérieur au prix en paramètre
     * @param prix
     * @return
     */
    List<ProduitDTO> chercherUnProduitCher(Long prix);
}
