import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ProduitListComponent } from './produit-list/produit-list.component';
import {RouterModule, Routes} from "@angular/router";
import { HeaderComponent } from './header/header.component';
import {ProduitsService} from "./services/produits.service";
import { ProduitDetailComponent } from './produit-list/produit-detail/produit-detail.component';
import { AjouterProduitComponent } from './produit-list/ajouter-produit/ajouter-produit.component';
import {ModalModule} from "ngb-modal";
import { ModalProduitComponent } from './produit-list/modal-produit/modal-produit.component';

import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import { HttpClient } from '@angular/common/http';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import {TranslateLoader, TranslateModule, TranslateService} from "@ngx-translate/core";
import {UppercaseDirective} from "./shared/directives/uppercase.directive";
import { AuthComponent } from './auth/auth.component';
import {AuthService} from "./services/auth.service";
import {AuthGuard} from "./services/auth-guard.service";

registerLocaleData(localeFr);

export function HttpLoaderFactory(http: HttpClient) {
  //return new TranslateHttpLoader(http);
  return new TranslateHttpLoader(http, './assets/i18n/fr/', '.json');
}

const appRoutes: Routes = [
  { path: 'produits',canActivate: [AuthGuard], component: ProduitListComponent },
  { path: 'ajouterProduit',canActivate: [AuthGuard], component: AjouterProduitComponent },
  { path: 'auth', component: AuthComponent },
  { path: '', canActivate: [AuthGuard], component: ProduitListComponent, pathMatch: 'full' },
  { path: '**',  redirectTo: '/not-found' },
]

@NgModule({
  declarations: [
    AppComponent,
    ProduitListComponent,
    HeaderComponent,
    ProduitDetailComponent,
    AjouterProduitComponent,
    ModalProduitComponent,
    UppercaseDirective,
    AuthComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ModalModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [ HttpClient ]
      }
    }),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    ProduitsService,
    AuthService,
    AuthGuard
  ],
  exports:[
    TranslateModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

  constructor(translate: TranslateService) {
    // On détermine la langue
    translate.setDefaultLang('fr');
    translate.use('fr');

    // Pour récupérer directement la langue du navigateur
    //const browserLang = translate.getBrowserLang();
    //translate.use(browserLang.match(/en|fr/) ? browserLang : 'en');
  }
}
