package com.example.TDS_Store_Back.facade.facade;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import com.example.TDS_Store_Back.facade.facade.impl.ProduitFacadeImpl;
import com.example.TDS_Store_Back.facade.populator.IPopulator;
import com.example.TDS_Store_Back.service.IProduitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProduitFacadeTest {

    @Mock
    IProduitService serviceProduit;

    @Mock
    Converter<ProduitDTO, ProduitEntity> converterProduit;

    @Mock
    IPopulator<ProduitEntity, ProduitDTO> populatorProduit;

    @InjectMocks
    ProduitFacadeImpl produitFacadeImpl;

    @BeforeEach
    void setUp() {
        // Plus besoin de MockitoAnnotations.initMocks(this) avec @ExtendWith
    }

    @Test
    public void getByIdSansDonnee() throws Exception {
        // mock : serviceProduit retourne null
        when(serviceProduit.getById(anyLong())).thenReturn(null);

        // appel
        ProduitDTO result = produitFacadeImpl.getProduitById(100L);

        // vérifications
        verify(serviceProduit, times(1)).getById(anyLong());
        // populator.populate ne doit pas être appelé car source null
        verify(populatorProduit, never()).populate(any(ProduitEntity.class), any(ProduitDTO.class));
    }

    @Test
    public void getByIdAvecDonnee() throws Exception {
        final Long id = 1L;
        final String nom = "nom";
        final Float prix = 100F;
        final Date creationDate = new Date();
        final Date modificationDate = new Date();

        ProduitEntity produitEntity = new ProduitEntity();
        produitEntity.setId(id);
        produitEntity.setNom(nom);
        produitEntity.setPrix(prix);
        produitEntity.setCreationDate(creationDate);
        produitEntity.setModificationDate(modificationDate);

        // mock : serviceProduit retourne une entité
        when(serviceProduit.getById(anyLong())).thenReturn(produitEntity);

        // mock populator.populate ne fait rien (void)
        doNothing().when(populatorProduit).populate(any(ProduitEntity.class), any(ProduitDTO.class));

        // appel
        ProduitDTO result = produitFacadeImpl.getProduitById(100L);

        // vérifications
        verify(serviceProduit, times(1)).getById(anyLong());
        verify(populatorProduit, times(1)).populate(any(ProduitEntity.class), any(ProduitDTO.class));
    }
}
