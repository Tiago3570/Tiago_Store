import { Directive, ElementRef, HostListener } from '@angular/core';
import {NgControl} from "@angular/forms";

@Directive({
  selector: '[uppercaseDirective]'
})
export class UppercaseDirective {
  timeout = null;

  constructor(public elt: ElementRef, private control: NgControl) {}

  /**
   * A l'écoute de l'evenement keypress
   * Change la valeur du style en UPPERCASE (immediatement)
   * Puis on change la valeur du string en UPPERCASE (quelques milli secondes après)
   * Puis on met la nouvelle valeur dans le formControl
   * Garde la position du caret au changement pour éviter qu'il se positionne à la fin
   * Doit être utilisé avec un input formControlName
   */
  @HostListener('keypress')
  public onKeypress() {
    clearTimeout(this.timeout);
    // on change la valeur du style en UPPERCASE (immediatement au niveau de l'ihm)
    this.elt.nativeElement.style.textTransform = 'uppercase';
    this.timeout = setTimeout(() => {
      let caretPos = this.elt.nativeElement.selectionStart;
      // on change la valeur du string en UPPERCASE
      this.elt.nativeElement.value = this.elt.nativeElement.value.toUpperCase();
      // on met la nouvelle valeur dans le formControl
      this.control.control.setValue(this.elt.nativeElement.value);
      // on remet le curseur à la position initiale
      this.elt.nativeElement.setSelectionRange(caretPos, caretPos);
    });
  }
}
