import {Component, OnDestroy, OnInit} from '@angular/core';
import {Produit} from "../models/Produit.model";
import {Subscription} from "rxjs/index";
import {ProduitsService} from "../services/produits.service";

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.scss']
})
export class ProduitListComponent implements OnInit, OnDestroy {

  listeProduit: Produit[] = [];
  ProduitSubscription: Subscription;

  constructor(private produitService: ProduitsService) { }

  ngOnInit(): void {
    // On creer la subscription en s'abonnant
    this.ProduitSubscription = this.produitService.produitSubject.subscribe(
      (produits: Produit[]) =>{
        this.listeProduit = produits;
        console.log("list des produit 2 ",this.listeProduit);
      }
    )
    this.produitService.getListProduit();
    this.produitService.emitProduit();

  }

  ngOnDestroy(): void {
    this.ProduitSubscription.unsubscribe();
  }

}
