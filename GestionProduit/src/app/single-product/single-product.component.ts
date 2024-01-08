import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Produit } from '../models/produit';
import { ProduitService } from '../services/produit.service';

@Component({
  selector: 'app-single-product',
  templateUrl: './single-product.component.html',
  styleUrls: ['./single-product.component.css']
})
export class SingleProductComponent implements OnInit {
produit!: Produit;
  constructor(private ar:ActivatedRoute, private service: ProduitService) { }

  ngOnInit(): void {
    let id = this.ar.snapshot.params['id'];
    this.service.getProduct(id).subscribe(data=>this.produit=data);
  }

}
