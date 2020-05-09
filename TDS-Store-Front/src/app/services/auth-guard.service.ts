
// Si on utlise un service dans un service il faut mettre Injectable
import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {AuthService} from "./auth.service";
import {Observable} from "rxjs/index";

@Injectable()
// Pour que ce soit une garde il faut implémenter la classe CanActivate avec la méthode canActivate
export class AuthGuard implements CanActivate{

  constructor(private authService: AuthService, private router: Router){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> | Promise<boolean> | boolean{
    if(this.authService.isAuth){
      return true;
    }
    else{
      this.router.navigate(['/auth']);
    }
  }
}
