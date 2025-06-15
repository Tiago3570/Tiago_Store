package com.example.TDS_Store_Back.facade.populator;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import com.example.TDS_Store_Back.facade.populator.impl.ProduitPopulator;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class ProduitPopulatorTest {

    IPopulator<ProduitEntity,ProduitDTO> produitPopulator = new ProduitPopulator();

    @Test
    public void testPopulate() {
        final Long id = 1L;
        final String nom = "nom";
        final Float prix = 100F;
        final Date fixedDate = new GregorianCalendar(2023, Calendar.JUNE, 15).getTime();

        ProduitEntity source = new ProduitEntity();
        source.setId(id);
        source.setNom(nom);
        source.setPrix(prix);
        source.setCreationDate(fixedDate);
        source.setModificationDate(fixedDate);

        ProduitDTO target = new ProduitDTO();

        produitPopulator.populate(source, target);

        assertNotNull(target, "Produit DTO ne doit pas être null");
        assertNotNull(source, "Produit Entity ne doit pas être null");
        assertEquals(source.getId(), target.getId(), "Id");
        assertEquals(source.getNom(), target.getNom(), "Nom");
        assertEquals(source.getPrix(), target.getPrix(), 0.001f, "Prix");
        assertEquals(source.getCreationDate(), target.getCreationDate(), "CreationDate");
        assertEquals(source.getModificationDate(), target.getModificationDate(), "ModificationDate");
    }
}
