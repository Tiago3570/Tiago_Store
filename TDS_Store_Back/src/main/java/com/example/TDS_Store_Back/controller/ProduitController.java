package com.example.TDS_Store_Back.controller;

import com.example.TDS_Store_Back.exception.ProduitIntrouvableException;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import com.example.TDS_Store_Back.facade.facade.IProduitFacade;
import com.example.TDS_Store_Back.json.ProduitJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin  // Pour donner l'autorisation au front de consulter l'url
@RestController
@RequestMapping({"/api"})

// Pour ajouter des informations à swagger facultatif
@Api(description= "Gestion des produits")
public class ProduitController {

    @Autowired
    private IProduitFacade produitFacade;

    @Autowired
    Converter<ProduitJson,ProduitDTO> produitJsonParser;

    /**
     * Retourne le produit en fonction de l'ID
     * @param id
     * @return
     */
    @ApiOperation(value="Retourne le produit en fonction de l'ID") //swager
    @GetMapping(value = "Produits/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id){
        ProduitDTO produitDTO = this.produitFacade.getProduitById(id);
        return new ResponseEntity<>(produitDTO, HttpStatus.OK);
    }

    /**
     * Retourne tous les produits de la BDD
     * @return
     * @throws ProduitIntrouvableException
     */
    @ApiOperation(value="Retourne tous les produits de la BDD") //swager
    @GetMapping(value = "Produits")
    public ResponseEntity<ProduitDTO> getAllProduit() throws ProduitIntrouvableException {
        List<ProduitDTO> listProduitDTO = this.produitFacade.findAll();
        return new ResponseEntity(listProduitDTO, HttpStatus.OK);
    }

    /**
     * Retourne tous les produits on le prix est supérieur au prix en paramètre
     * @param prix
     * @return
     */
    @ApiOperation(value="Retourne tous les produits on le prix est supérieur au prix en paramètre") //swager
    @GetMapping(value = "Produits/rush/{prix}")
    public ResponseEntity<List<ProduitDTO>> getProduitCher(@PathVariable Long prix){
        List<ProduitDTO> listProduitDTO = this.produitFacade.chercherUnProduitCher(prix);
        return new ResponseEntity<List<ProduitDTO>>(listProduitDTO, HttpStatus.OK);
    }

    @PostMapping(value = "Produits")
    @ApiOperation(value="Ajoute le produit à la BDD et retourne le produit")
    // Pour que @Valid fonctionne il faut des anotation de vérification dans Product comme @Length
    public ResponseEntity<ProduitDTO> ajouterProduit(@Valid @RequestBody ProduitJson produitJson){

        // conversion de l'objet JSON
        final ProduitDTO produitDTO =
                this.produitJsonParser.convert(produitJson);

        ProduitDTO produitSav = this.produitFacade.save(produitDTO);
        return new ResponseEntity<ProduitDTO>(produitSav, HttpStatus.CREATED);
    }


    @PutMapping(value = "Produits")
    @ApiOperation(value="Mets à jour le produit fourni en paramètre et retourne le produit à jour")
    public ResponseEntity<ProduitDTO> modifierProduit(@Valid @RequestBody ProduitJson produitJson){

        // conversion de l'objet JSON
        final ProduitDTO produitDTO =
                this.produitJsonParser.convert(produitJson);

        ProduitDTO produitUpdate = this.produitFacade.update(produitDTO);
        return new ResponseEntity<ProduitDTO>(produitUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "Produits")
    @ApiOperation(value="Supprime le produit passer en paramètre")
    public ResponseEntity supprimerProduit(@Valid @RequestBody ProduitJson produitJson){

        // conversion de l'objet JSON
        final ProduitDTO produitDTO =
                this.produitJsonParser.convert(produitJson);

        this.produitFacade.delete(produitDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "Produits/{id}")
    @ApiOperation(value="Supprime le produit en fonction de l'id")
    public ResponseEntity supprimerProduit(@PathVariable Long id){
        this.produitFacade.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
