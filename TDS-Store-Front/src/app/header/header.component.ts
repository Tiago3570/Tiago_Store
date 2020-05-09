import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  isAuth: boolean;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    //TODO revoir le système pour que le bouton connexion devien deconnexion au moment de la connexion.
    //this.authService.signIn();
    //this.isAuth = this.authService.isAuth;
  }

}
