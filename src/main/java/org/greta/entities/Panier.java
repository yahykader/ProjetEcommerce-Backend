package org.greta.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class Panier implements Serializable {
	
    /*
     * c'est une HashMap de Produit de type Long 
     * && LigneCommande
     */
	private HashMap<Long, LigneCommande>items=new HashMap<Long, LigneCommande>();
	
	// ajouter une LigneCommande
	public void addArticle(Produit p,int quantite) {
		
		if(items.get(p.getIdProduit())==null) {
			LigneCommande lc = new LigneCommande();
			lc.setProduit(p);
			lc.setQuantite(quantite);
			lc.setPrix(p.getPrix());	
		}
		else {	
			LigneCommande lc = items.get(p.getIdProduit());
			lc.setQuantite(lc.getQuantite()+quantite);
		}	
	}
	
	//Retourner les nombres des lignes dans le panier
	public Collection<LigneCommande> getItems(){
		return items.values();
	}
	
	//retourner le prixTotal de panier
	public double getTotalPrix() {
		
		double total=0;
		for (LigneCommande lc : items.values()) {
			total+=lc.getPrix()*lc.getQuantite();
			
		}
		 return total;
	}
	
	// retouner le size de panier
	public int getSize() {
		return items.size();
	}
	// Supprimer un ligne de commande 
	public void deleteItem(Long idProduit) {
		
		items.remove(idProduit);
	}
	
	
}
