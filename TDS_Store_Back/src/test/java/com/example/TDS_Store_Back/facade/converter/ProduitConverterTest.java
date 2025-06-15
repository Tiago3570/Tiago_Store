package com.example.TDS_Store_Back.facade.converter;


import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class ProduitConverterTest {

    ProduitConverter produitConverter = new ProduitConverter();

    @Test
    public void testConvert() {
        final Long id = 1L;
        final String nom = "nom";
        final Float prix = 100F;
        final Date fixedDate = new GregorianCalendar(2023, Calendar.JUNE, 15).getTime();

        ProduitDTO source = new ProduitDTO();
        source.setId(id);
        source.setNom(nom);
        source.setPrix(prix);
        source.setCreationDate(fixedDate);
        source.setModificationDate(fixedDate);

        ProduitEntity target = produitConverter.convert(source);

        assertNotNull(target, "ProduitEntity ne doit pas être null");
        assertEquals(id, target.getId(), "Id");
        assertEquals(nom, target.getNom(), "Nom");
        assertEquals(prix, target.getPrix(), 0.001f, "Prix");
        assertEquals(fixedDate, target.getCreationDate(), "CreationDate");
        assertEquals(fixedDate, target.getModificationDate(), "ModificationDate");
    }
}
