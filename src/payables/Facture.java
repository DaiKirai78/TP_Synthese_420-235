package payables;

/**
 * La classe Facture représente une facture d'achat, et elle hérite de la classe Payable.
 */
public class Facture extends Payable {
	private final String numeroPiece;
	private String descriptionPiece;
	private int quantite;
	private double prixParItem;

	/**
	 * Constructeur de la classe Facture.
	 * @param id	L'identifiant de la facture
	 * @param numero	Le numéro de la pièce de la facture
	 * @param description	La description de la pièce de la facture
	 * @param nombre	La quantité achetée
	 * @param prix		Le coût par item
	 * @param memo		Une note/mémo sur le vendeur
	 */
	public Facture(int id, String numero, String description, int nombre, double prix, String memo) {
		super(id, memo);
		categorie = Categorie.Facture;
		numeroPiece = numero;
		descriptionPiece = description;
		setQuantite(nombre);
		setPrixParItem(prix);
	}

	/**
	 * Méthode pour obtenir le numéro de la pièce achetée.
	 * @return le numéro de la pièce
	 */
	public String getNumeroPiece() {
		return numeroPiece;
	}

	/**
	 * Méthode pour obtenir la description de la pièce achetée.
	 * @return la description de la pièce achetée
	 */
	public String getDescriptionPiece() {
		return descriptionPiece;
	}

	/**
	 * Méthode pour définir la description de la pièce achetée.
	 * @param description	La description de la pièce
	 */
	public void setDescriptionPiece(String description) {
		descriptionPiece = description;
	}

	/**
	 * Méthode pour obtenir la quantité d'item acheté.
	 * @return	la quantité d'item acheté
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * Méthode pour définir la quantité d'items achetée.
	 * @param nombre Le nombre d'items acheté
	 */
	public void setQuantite(int nombre) {
		if (nombre >= 0)
			quantite = nombre;
		else
			throw new IllegalArgumentException("La quantité doit être >= 0");
	}

	/**
	 * Méthode pour obtenir le prix par item.
	 * @return	Le prix par item
	 */
	public double getPrixParItem() {
		return prixParItem;
	}
	//
	// TODO 05-- Ajoutez les méthodes nécessaires en vous basant sur le diagramme UML
	//  		que la gestion des erreurs possibles si nécessaire.
	//

	/**
	 * Méthode pour définir le prix par item.
	 * @param prix Le prix par item
	 */
	public void setPrixParItem(double prix) {
		prixParItem = prix;
	}

	/**
	 * Méthode pour obtenir le montant du paiement pour les items achetés.
	 * @return	le montant du paiement pour les items achetés
	 */
	public double getMontantPaiement() {
		return getPrixParItem() * getQuantite();
	}

	/**
	 * Description de la facture avec son numéro de pièce, sa description, sa quantité et son prix par article.
	 * @return La représentation sous forme de chaîne de caractères de la facture avec son numéro de pièce,
	 * sa description, sa quantité et son prix par article
	 */
	@Override
	public String toString() {
		return String.format("%s:%n%s: %s (%s)%n%s: %s%n%s: %s",
				getCategorieString(), "numéro de la pièce", getNumeroPiece(), getDescriptionPiece(),
				"quantité", getQuantite(), "prix par facture", getPrixParItem());
	}

	/**
	 * Description spécifique de la facture avec son numéro de pièce, sa description, sa quantité et son prix par article.
	 * @return La représentation formatée pour affichage de la facture avec son numéro de pièce,
	 * sa description, sa quantité et son prix par article
	 */
	public String toStringAffichage() {
		String info = super.toStringAffichage();
		info += " Code [" + getNumeroPiece()  + "] Description [" + getDescriptionPiece() +
		"] Quantité [" + getQuantite() + "] Prix [" + getPrixParItem() + "]";
		return info;
	}

	/**
	 * Description formatée de la facture avec son numéro de pièce, sa description, sa quantité, son prix par article et sa catégorie.
	 * @return La représentation formatée pour la sauvegarde de la facture avec son numéro de pièce,
	 * sa description, sa quantité, son prix par article et sa catégorie
	 */
	public String toStringSauvegarde() {
		String info = String.format("ID [%3d] Numéro [%15s] Description [%25s] Nombre [%3d] Prix [%10.2f] Mémo [%15s] Catégorie [%20s]",
				this.getID(), this.numeroPiece, this.getDescriptionPiece(), this.getQuantite(), this.getPrixParItem(), this.getMemo(), this.getCategorieString());
		return info;
	}
}
