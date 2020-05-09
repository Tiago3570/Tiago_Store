import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Produit} from "../../models/Produit.model";
import {ProduitsService} from "../../services/produits.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-ajouter-produit',
  templateUrl: './ajouter-produit.component.html',
  styleUrls: ['./ajouter-produit.component.scss']
})
export class AjouterProduitComponent implements OnInit {

  ajouterProduitForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private produiService: ProduitsService,
              private router: Router
  ) { }

  ngOnInit(): void {
    this.initForm();
  }


  onSaveProduit(){
      let p : Produit = new Produit();
      p.nom = this.ajouterProduitForm.get('nom').value;
      p.prix = this.ajouterProduitForm.get('prix').value;
      this.produiService.sauvegarderProduit(p).then(
        (succes)=>{
          this.router.navigate(['/produits']);
        },
        (error)=>{
          console.log('il y a une erreur avec la sauvegarde ',error);
        }
      )
  }

  initForm(){
    this.ajouterProduitForm = this.formBuilder.group({
      nom: ['', Validators.required],
      prix: ['', Validators.required]
    });
  }

}
