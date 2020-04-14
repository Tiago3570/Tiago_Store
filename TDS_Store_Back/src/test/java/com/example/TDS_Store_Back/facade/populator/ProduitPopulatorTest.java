package com.example.TDS_Store_Back.facade.populator;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import com.example.TDS_Store_Back.facade.populator.impl.ProduitPopulator;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProduitPopulatorTest {

    IPopulator<ProduitEntity,ProduitDTO> produitPopulator = new ProduitPopulator();

    @Test
    public void testPopulate()
    {
        final Long id = 1L;
        final String nom = "nom";
        final Float prix = 100F;
        final Date creationDate = new Date();
        final Date modificationDate = new Date();

        ProduitEntity source = new ProduitEntity();

        source.setId(id);
        source.setNom(nom);
        source.setPrix(prix);
        source.setCreationDate(creationDate);
        source.setModificationDate(modificationDate);

        ProduitDTO target = new ProduitDTO();

        this.produitPopulator.populate(source,target);

        assertNotNull("Produit DTO ne doit pas être null", target);
        assertNotNull("Produit Entity ne doit pas être null", source);
        assertEquals("Id", source.getId(), target.getId());
        assertEquals("Nom", source.getNom(), target.getNom());
        assertEquals("Prix", source.getPrix(), target.getPrix());
        assertEquals("CreationDate", source.getCreationDate(), target.getCreationDate());
        assertEquals("ModificationDate", source.getModificationDate(), target.getModificationDate());
    }
}
