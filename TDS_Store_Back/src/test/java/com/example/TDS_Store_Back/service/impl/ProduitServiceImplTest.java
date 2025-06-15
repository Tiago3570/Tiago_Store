package com.example.TDS_Store_Back.service.impl;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import com.example.TDS_Store_Back.repository.IProduitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplTest {

    @InjectMocks
    ProduitServiceImpl produitServiceImpl;

    @Mock
    IProduitRepository repository;

    @Test
    public void testChercherUnProduitCher() {
        // Donnée attendue
        final List<ProduitEntity> produitExpected = new ArrayList<>();

        // Mock du repository, pas de la méthode à tester !
        when(repository.chercherUnProduitCher(anyLong()))
                .thenReturn(produitExpected);

        // Appel de la méthode à tester
        final List<ProduitEntity> produitResult = produitServiceImpl.chercherUnProduitCher(10L);

        // Vérifications
        verify(repository, times(1)).chercherUnProduitCher(anyLong());

        assertNotNull(produitResult, "Le résultat ne doit pas être null");
        assertEquals(produitExpected, produitResult, "Le résultat doit correspondre à la donnée mockée");
    }
}
