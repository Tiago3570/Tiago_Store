package com.example.TDS_Store_Back.controller;


import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import com.example.TDS_Store_Back.facade.facade.IProduitFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProduitControllerTest {

    @InjectMocks
    ProduitController produitController;

    @Mock
    IProduitFacade facadeProduit;

    @Test
    public void testGetProduitById() {
        // Préparation du mock
        ProduitDTO produitDTO = new ProduitDTO();
        when(facadeProduit.getProduitById(anyLong())).thenReturn(produitDTO);

        // Appel de la méthode
        ResponseEntity<ProduitDTO> response = produitController.getProduitById(1000L);

        // Vérifications
        verify(facadeProduit, times(1)).getProduitById(anyLong());

        assertEquals(HttpStatus.OK, response.getStatusCode(), "Le status HTTP de la réponse n'est pas OK.");
        assertEquals(produitDTO, response.getBody(), "Le corps de la réponse ne correspond pas.");
    }
}
