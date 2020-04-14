package com.example.TDS_Store_Back.facade.converter;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ProduitConverterTest {

    ProduitConverter produitConverter = new ProduitConverter();

    /**
     * Test la conversion d'un objet.
     */
    @Test
    public void testConvert()
    {
        final Long id = 1L;
        final String nom = "nom";
        final Float prix = 100F;
        final Date creationDate = new Date();
        final Date modificationDate = new Date();


        ProduitDTO source = new ProduitDTO();
        source.setId(id) ;
        source.setNom(nom);
        source.setPrix(prix);
        source.setCreationDate(creationDate);
        source.setModificationDate(modificationDate);

        ProduitEntity target = produitConverter.convert(source);
        Assert.assertNotNull(target);
        Assert.assertEquals(id,target.getId());
        Assert.assertEquals(nom,target.getNom());
        Assert.assertEquals(prix,target.getPrix());
        Assert.assertEquals(creationDate,target.getCreationDate());
        Assert.assertEquals(modificationDate,target.getModificationDate());

    }
}
