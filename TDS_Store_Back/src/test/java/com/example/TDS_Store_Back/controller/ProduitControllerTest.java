package com.example.TDS_Store_Back.controller;

import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import com.example.TDS_Store_Back.facade.facade.IProduitFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;



import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProduitControllerTest {

    @InjectMocks
    ProduitController produitController;

    @Mock
    IProduitFacade facadeProduit;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProduitById() {

        // mock
        when(this.facadeProduit
                .getProduitById(anyLong()))
                .thenReturn(new ProduitDTO());


        // appel de la méthode
        final ResponseEntity<ProduitDTO> res = this.produitController.getProduitById(1000L);

        // tests
        // nombre d'appels effectués
        verify(this.facadeProduit, times(1))
                .getProduitById(anyLong());

        assertEquals("Le status HTTP de la réponse n'est pas OK.", HttpStatus.OK, res.getStatusCode());

    }
}
