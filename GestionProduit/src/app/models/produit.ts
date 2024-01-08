import { Categorie } from "./categorie";

export interface Produit {
    id: number;
    nom: string;
    prix: number;
    quantite: number;
    imageName: string;
    categorie: Categorie
}
