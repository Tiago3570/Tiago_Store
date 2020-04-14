package com.example.TDS_Store_Back.facade.populator.impl;


import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import org.springframework.core.convert.ConversionException;
import org.springframework.stereotype.Component;
import com.example.TDS_Store_Back.facade.populator.*;

import java.util.List;

/**
 * Cette classe permet de convertir des Entity en DTO
 * DTO : utlisé par le front + Controlleur + Facade
 * Entity: utilisé par la Facade + Service + Repository
 *
 * Remarque: C'est la facade qui utlise cette classe
 */
@Component
public class ProduitPopulator implements IPopulator<ProduitEntity,ProduitDTO> {

    @Override
    public void populate(ProduitEntity produitEntity, ProduitDTO produitDTO) throws ConversionException {
        produitDTO.setId(produitEntity.getId());
        produitDTO.setNom(produitEntity.getNom());
        produitDTO.setPrix(produitEntity.getPrix());
        produitDTO.setCreationDate(produitEntity.getCreationDate());
        produitDTO.setModificationDate(produitEntity.getModificationDate());
    }

    @Override
    public void populate(List<ProduitEntity> source, List<ProduitDTO> target) throws ConversionException {
        source.stream().forEach(habilitationEntity -> {
            final ProduitDTO dto = new ProduitDTO();
            this.populate(habilitationEntity, dto);
            target.add(dto);
        });
    }
}
