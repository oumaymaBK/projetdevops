import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListeProduitsComponent } from './liste-produits/liste-produits.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { SingleProductComponent } from './single-product/single-product.component';

const routes: Routes = [
  {path: "liste" , component: ListeProduitsComponent},
  {path: "liste/:id" , component: SingleProductComponent},
  {path: "" , redirectTo: "liste" , pathMatch: "full"},
  {path:"**" , component: NotfoundComponent}
 

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
