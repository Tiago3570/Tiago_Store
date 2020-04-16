package com.example.TDS_Store_Back.facade.facade.impl;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.facade.converter.ProduitConverter;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import com.example.TDS_Store_Back.facade.facade.IProduitFacade;
import com.example.TDS_Store_Back.service.IProduitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import com.example.TDS_Store_Back.facade.populator.*;

import java.util.ArrayList;
import java.util.List;

@Service    // un facade est de type service aussi
@Slf4j      // Pour les logs
public class ProduitFacadeImpl implements IProduitFacade {

    @Autowired
    private IProduitService serviceProduit;

    @Autowired
    private IPopulator<ProduitEntity,ProduitDTO> produitPopulator;

    @Autowired
    private Converter<ProduitDTO, ProduitEntity> converterProduit;

    @Override
    public ProduitDTO getProduitById(Long id) {
        ProduitEntity produitEntity = this.serviceProduit.getById(id);
        ProduitDTO produitDTO = new ProduitDTO();
        produitPopulator.populate(produitEntity,produitDTO);
        return produitDTO;
    }

    @Override
    public List<ProduitDTO> findAll() {
        List<ProduitEntity> listProduitEntity = this.serviceProduit.findAll();
        List<ProduitDTO> listProduitDTO = new ArrayList<>();
        this.produitPopulator.populate(listProduitEntity,listProduitDTO);
        return listProduitDTO;
    }

    @Override
    public List<ProduitDTO> chercherUnProduitCher(Long prix) {
        List<ProduitEntity> listProduitEntity = this.serviceProduit.chercherUnProduitCher(prix);
        List<ProduitDTO> listProduitDTO = new ArrayList<>();
        this.produitPopulator.populate(listProduitEntity,listProduitDTO);
        return listProduitDTO;
    }

    @Override
    public ProduitDTO save(ProduitDTO produitDTO) {
        //conversion produit
        final ProduitEntity produitEntity = this.converterProduit.convert(produitDTO);
        // On sauvegarde
        ProduitEntity produitSav = this.serviceProduit.save(produitEntity);
        // On transforme la réponse et on la retourne
        ProduitDTO produitDtoSave = new ProduitDTO();
        this.produitPopulator.populate(produitSav,produitDtoSave);
        return produitDtoSave;
    }

    @Override
    public ProduitDTO update(ProduitDTO produitDTO) {
        //conversion produit
        final ProduitEntity produitEntity = this.converterProduit.convert(produitDTO);
        // On sauvegarde
        ProduitEntity produitSav = this.serviceProduit.update(produitEntity);
        // On transforme la réponse et on la retourne
        ProduitDTO produitDtoSave = new ProduitDTO();
        this.produitPopulator.populate(produitSav,produitDtoSave);
        return produitDtoSave;
    }

    @Override
    public void delete(ProduitDTO produitDTO) {
        // conversion produit
        final ProduitEntity produitEntity = this.converterProduit.convert(produitDTO);
        this.serviceProduit.delete(produitEntity);
    }

    @Override
    public void deleteById(Long id) {
        this.serviceProduit.deleteById(id);
    }


}
