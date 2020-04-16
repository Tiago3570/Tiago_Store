package com.example.TDS_Store_Back.service.impl;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.exception.ProduitIntrouvableException;
import com.example.TDS_Store_Back.repository.IProduitRepository;
import com.example.TDS_Store_Back.service.IProduitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        return this.repositoryProduit.chercherUnProduitCher(prix);
    }

    @Override
    public ProduitEntity save(ProduitEntity produitEntity) {
        // On modifie les dates
        produitEntity.setModificationDate(new Date());
        produitEntity.setCreationDate(new Date());
        produitEntity = this.repositoryProduit.save(produitEntity);
        log.info("Insertion du produit id "+produitEntity.getId());
        return produitEntity;
    }

    @Override
    public ProduitEntity update(ProduitEntity produitEntity) {
        produitEntity.setModificationDate(new Date());
        produitEntity = this.repositoryProduit.save(produitEntity);
        log.info("Mise à jour du produit id "+produitEntity.getId());
        return produitEntity;
    }

    @Override
    public void delete(ProduitEntity produitEntity) {
        this.repositoryProduit.delete(produitEntity);
        log.info("Suppression du produit avec l'id "+produitEntity.getId());
    }

    @Override
    public void deleteById(Long id) {
        this.repositoryProduit.deleteById(id);
        log.info("Suppression du produit avec l'id "+id);
    }

}
