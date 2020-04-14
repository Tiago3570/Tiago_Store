package com.example.TDS_Store_Back.facade.facade;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import com.example.TDS_Store_Back.facade.facade.impl.ProduitFacadeImpl;
import com.example.TDS_Store_Back.facade.populator.IPopulator;
import com.example.TDS_Store_Back.service.IProduitService;
import com.example.TDS_Store_Back.service.impl.ProduitServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProduitFacadeTest {

    @Mock
    IProduitService serviceProduit;
    @Mock
    Converter<ProduitDTO, ProduitEntity> converterProduit;
    @Mock
    IPopulator<ProduitEntity, ProduitDTO> populatorProduit;

    @InjectMocks
    ProduitFacadeImpl produitFacadeImpl;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getByIdSansDonnee()
            throws Exception
    {

        final ProduitEntity PRODUI_ENTITY = null;

        // mock
        when(serviceProduit.getById(anyLong()))
                .thenReturn(null);

        doNothing().when(populatorProduit)
                .populate(any(ProduitEntity.class),
                        any(ProduitDTO.class));

        // appel
        final ProduitDTO result = produitFacadeImpl.getProduitById(100L);


        // test
        verify(serviceProduit, times(1))
                .getById(anyLong());

        verify(populatorProduit, times(0))
                .populate(anyListOf(ProduitEntity.class),
                        anyListOf(ProduitDTO.class));
    }


    @Test
    public void getByI()
            throws Exception
    {

        //jeu de données
        final Long id = 1L;
        final String nom = "nom";
        final Float prix = 100F;
        final Date creationDate = new Date();
        final Date modificationDate = new Date();

        final ProduitEntity PRODUI_ENTITY = new ProduitEntity();
        PRODUI_ENTITY.setId(id);
        PRODUI_ENTITY.setNom(nom);
        PRODUI_ENTITY.setPrix(prix);
        PRODUI_ENTITY.setCreationDate(creationDate);
        PRODUI_ENTITY.setModificationDate(modificationDate);

        // mock
        when(serviceProduit.getById(anyLong()))
                .thenReturn(PRODUI_ENTITY);

        final ProduitDTO PRODUI_DTO = new ProduitDTO();

        doNothing().when(populatorProduit)
                .populate(any(ProduitEntity.class),
                        any(ProduitDTO.class));

        // appel
        final ProduitDTO result = produitFacadeImpl.getProduitById(100L);


        // test
        verify(serviceProduit, times(1))
                .getById(anyLong());

        verify(populatorProduit, times(1))
                .populate(any(ProduitEntity.class),
                        any(ProduitDTO.class));
    }
}
