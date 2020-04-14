package com.example.TDS_Store_Back.service.impl;



import com.example.TDS_Store_Back.entities.ProduitEntity;

import com.example.TDS_Store_Back.repository.IProduitRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProduitServiceImplTest {

    /**
     * Classe à tester.
     */
    @InjectMocks
    ProduitServiceImpl produitServiceImpl;

    @Mock
    IProduitRepository repository;


    /* Très important il faut mettre le setUp de mockito pour qu'il fonctionne */
    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test de la méthode FindByIdPPAndTypeIdNatPersEquals.
     */
    @Test
    public void testChercherUnProduitCher()
    {
        // donnée attendue
        final List<ProduitEntity> produitExpected =new ArrayList();

        // mock
        when(this.produitServiceImpl.chercherUnProduitCher(anyLong()))
                .thenReturn(produitExpected);

        // appel
        final List<ProduitEntity> produitResult =
                this.produitServiceImpl.chercherUnProduitCher(10L);

        // tests
        // nombre d'appels
        verify(this.repository, times(1))
                .chercherUnProduitCher(anyLong());

        // résultat
        Assert.assertEquals("résultat identique", produitExpected, produitResult);
        Assert.assertTrue("résultat présent", produitResult != null);

    }
}
