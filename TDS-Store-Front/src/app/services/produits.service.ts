import {Produit} from "../models/Produit.model";
import {Subject} from "rxjs/index";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  produits: Produit[] = [];
  produitSubject = new Subject<Produit[]>();

  constructor(private http: HttpClient) {
  }

  emitProduit() {
    this.produitSubject.next(this.produits);
  }

  getListProduit(){
    this.http.get('http://localhost:8080/api/Produits').subscribe(
      (produits: Produit[])=>{
        console.log("liste des produits ",produits);
        this.produits = produits;
        this.emitProduit();
      }
    )
  }

  sauvegarderProduit(produit : Produit){
    return new Promise(
      (resolve, reject) => {
        this.http.post('http://localhost:8080/api/Produits',produit).subscribe(
          (data) => {
            this.produits.push(produit);
            this.emitProduit();
            resolve();
          },
          (error) => {
            console.log('Il y a une erreur dans la sauvegarde ',error);
            reject(error);
          }
        );
      });
  }

  supprimerProduit(idProduit: string){
    return new Promise(
      (resolve, reject) => {
        this.http.delete('http://localhost:8080/api/Produits/'+idProduit).subscribe(
          (data) => {
            const index = this.produits.findIndex(pr => pr.id === idProduit);
            if(index){
              this.produits.splice(index, 1);
              this.emitProduit();
            }
            resolve();
          },
          (error) => {
            console.log('Il y a une erreur dans la sauvegarde ',error);
            reject(error);
          }
        );
      });
  }



}
