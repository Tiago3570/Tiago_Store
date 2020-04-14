package com.example.TDS_Store_Back.service.impl;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.exception.ProduitIntrouvableException;
import com.example.TDS_Store_Back.repository.IProduitRepository;
import com.example.TDS_Store_Back.service.IProduitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    private IProduitRepository repositoryProduit;


    @Override
    public ProduitEntity getById(Long produitId) {
        log.info("de la merde");
        Optional<ProduitEntity> produitEntity = this.repositoryProduit.findById(produitId);
        if(produitEntity.isPresent()){
            return produitEntity.get();
        }
        throw new ProduitIntrouvableException("Le produit avec l'id "+produitId+" n'existe pas");
    }

    @Override
    public List<ProduitEntity> findAll() {
        return this.repositoryProduit.findAll();
    }

    @Override
    public List<ProduitEntity> chercherUnProduitCher(Long prix) {
        //List<ProduitEntity> ll = new ArrayList<ProduitEntity>();
        //return ll;
        return this.repositoryProduit.chercherUnProduitCher(prix);
    }


}
