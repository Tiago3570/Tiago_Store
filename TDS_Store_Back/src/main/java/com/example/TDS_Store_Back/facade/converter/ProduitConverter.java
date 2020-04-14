package com.example.TDS_Store_Back.facade.converter;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Cette classe permet de convertir des DTO en Entity
 * DTO : utlisé par le front + Controlleur + Facade
 * Entity: utilisé par la Facade + Service + Repository
 *
 * Remarque: C'est la facade qui utlise cette classe
 */
@Component
public class ProduitConverter implements Converter<ProduitDTO, ProduitEntity> {

    @Override
    public ProduitEntity convert(ProduitDTO produitDTO) {
        ProduitEntity produitEntity = new ProduitEntity();
        produitEntity.setId(produitDTO.getId());
        produitEntity.setNom(produitDTO.getNom());
        produitEntity.setPrix(produitDTO.getPrix());
        produitEntity.setCreationDate(produitDTO.getCreationDate());
        produitEntity.setModificationDate(produitDTO.getModificationDate());
        return produitEntity;
    }
}
