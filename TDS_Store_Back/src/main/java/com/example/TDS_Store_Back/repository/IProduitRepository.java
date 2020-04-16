package com.example.TDS_Store_Back.repository;

import com.example.TDS_Store_Back.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Classe qui concentre toutes les requêes pour la table Produit
 */
@Repository // Pour dire que c'est la classe qui communique avec la BDD
public interface IProduitRepository extends JpaRepository<ProduitEntity, Long> {

    // Il ne faut pas oublier le value et le nativeQuery = true
    // il faut retourner l'ensemble de la table sinon on a une erreur. Il faut tous les éléments de ProduitEntity
    /**
     * Méthode qui récupère tous les produits de la BDD possédent un prix supérieur au prix en paramètre
     * @param prix
     * @return
     */
    @Query(value = "SELECT p.* FROM produit p WHERE p.prix > :prixLimit",nativeQuery = true)
    List<ProduitEntity> chercherUnProduitCher(@Param("prixLimit") Long prix);
}
