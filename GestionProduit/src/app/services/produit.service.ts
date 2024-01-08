import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../models/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  host = "http://localhost:8080/restapiproduit";
  constructor(private client: HttpClient ) { }

  public getallProducts():Observable<Produit[]> {
    return this.client.get<Produit[]>(this.host+"/all");//le type de retour est un observable
  }
  public getProduct(id:number):Observable<Produit> {
    return this.client.get<Produit>(this.host+"/getProduct/"+id);}
}
