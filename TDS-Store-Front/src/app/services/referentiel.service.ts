import {TranslateService} from "@ngx-translate/core";
import { Observable } from 'rxjs';

export class ReferentielService {

  constructor(private translate: TranslateService) { }

  /**
   * Retourne le referentiel
   * @param cle
   */
  get (cle: string): Observable<any> {
    return this.translate.get(cle);
  }

  public listeDesPays() {
    const list: string[] = ['France', 'Espagne', 'Pologne', 'Portugal'];
    return list;
  }

}
