import {Component, Input, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {ModalManager} from "ngb-modal";
import { ModalComponent } from 'ngb-modal';

@Component({
  selector: 'app-modal-produit',
  templateUrl: './modal-produit.component.html',
  styleUrls: ['./modal-produit.component.scss']
})
export class ModalProduitComponent implements OnInit {

  @ViewChild(ModalComponent) ModalComponent;
  @Input() data;


  /*private modalRef;
  @ViewChild('myModal') myModal;*/


  //constructor(private modalService: ModalManager) { }

  constructor(private modalService: ModalManager, private vcr: ViewContainerRef) {
    this.modalService.setDefaults({
      title: "new modal",
      size: "sm",
      modalClass: 'mymodal',
      hideCloseButton: true,
      centered: false,
      backdrop: true,
      animation: true,
      keyboard: true,
      closeOnOutsideClick: true,
      backdropClass: "modal-backdrop"
    })
    //this.modal.setRootViewContainerRef(this.vcr);
  }



  ngOnInit(): void {
  }

  openModal(){
    /*
    this.modalRef = this.modalService.open(this.myModal, {
      size: "md",
      modalClass: 'mymodal',
      hideCloseButton: false,
      centered: false,
      backdrop: true,
      animation: true,
      keyboard: false,
      closeOnOutsideClick: true,
      backdropClass: "modal-backdrop"
    })*/
  }


  closeModal(){
    /*
    this.modalService.close(this.modalRef);
    //or this.modalRef.close();*/
  }

}
