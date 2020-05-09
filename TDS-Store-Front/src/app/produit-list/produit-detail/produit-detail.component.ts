import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Produit} from "../../models/Produit.model";
import {ProduitsService} from "../../services/produits.service";
import {Router} from "@angular/router";
import {ModalManager} from "ngb-modal";
import {ModalProduitComponent} from "../modal-produit/modal-produit.component";

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.scss']
})
export class ProduitDetailComponent implements OnInit {

  @Input() produit: Produit;

  private modalRef: ModalProduitComponent;

  constructor(private produitService: ProduitsService,
              private router: Router,
              private modalService: ModalManager) { }

  ngOnInit(): void {
  }

  supprimerProduit(){
    this.produitService.supprimerProduit(this.produit.id);
  }




}
