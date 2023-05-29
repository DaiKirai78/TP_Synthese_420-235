package payables;
import exceptions.ExceptionEcheanceInsuffisante;

/**
 * La classe abstraite Payable est la classe de base pour toutes les entités pouvant être payées.
 */
public abstract class Payable {
	private final int ID;
	protected Categorie categorie;
	protected int echeanceJours;
	protected String memo;

	/**
	 * Premier constructeur de la classe Payable.
	 * @param id	L'identifiant de l'élément payable
	 * @param memo	Une note/mémo sur l'élément payable
	 */
	public Payable (int id, String memo) {
		this.ID = id;
		this.echeanceJours = 0;
		this.memo = memo;
	}

	/**
	 * Deuxième constructeur de la classe Payable.
	 * @param id	L'identifiant de l'élément payable
	 */
	public Payable (int id) {
		this.ID = id;
		this.echeanceJours = 0;
		this.memo = "";
	}

	/**
	 * Méthode pour obtenir l'identifiant de l'élément payable.
	 * @return	l'identifiant de l'élément payable
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Méthode pour obtenir le nombre de jours restants avant l'échéance de l'élément payable.
	 * @return Le nombre de jours avant l'échéance de l'élément payable
	 */
	public int getEcheanceJours() {
		return echeanceJours;
	}

	/**
	 * Méthode pour définir le nombre de jours avant l'échéance de l'élément payable.
	 * @param echeanceJours	Le nombre de jours avant l'échéance de l'élément payable
	 */
	public void setEcheanceJours(int echeanceJours) {
		this.echeanceJours = echeanceJours;
	}

	/**
	 * Méthode pour augmenter le nombre de jours avant l'échéance de l'élément payable.
	 * @param jours	Nombre de jours avant l'échéance de l'élément payable
	 */
	public void augmenterEcheance(int jours) {
		echeanceJours += jours;
	}

	/**
	 * Méthode pour diminuer le nombre de jours avant l'échéance de l'élément payable.
	 * @param jours	Nombre de jours avant l'échéance de l'élément payable
	 * @throws ExceptionEcheanceInsuffisante	Si le nombre de jours à soustraire est supérieur au nombre de jours restants avant l'échéance
	 */
	public void diminuerEcheance(int jours) throws ExceptionEcheanceInsuffisante {
		if (jours > echeanceJours) {
			throw new ExceptionEcheanceInsuffisante(jours);
		}
		this.echeanceJours -= jours;
	}

	/**
	 * Méthode pour obtenir le mémo sur l'élément payable.
	 * @return	le mémo sur l'élément payable
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * Méthode pour définir le mémo sur l'élément payable.
	 * @param memo Le mémo sur l'élément payable
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * Méthode abstraite pour obtenir le montant du paiement pour l'élément payable.
	 * @return le montant du paiement pour l'élément payable
	 */
	public abstract double getMontantPaiement();

	/**
	 * Méthode pour obtenir la catégorie de l'élément payable sous forme de chaîne de caractères.
	 * @return	la catégorie de l'élément payable sous forme de chaîne de caractères
	 */
	public String getCategorieString() {
		try {
			return categorie.toString();
		} catch(NullPointerException e) {}
		return "";
	}

	/**
	 * Description formatée de l'élément payable avec son identifiant, sa catégorie,
	 * sa note/mémo, son échéance et son montant de paiement.
	 *
	 * @return	La représentation formatée pour affichage de l'élément payable avec son identifiant,
	 * sa catégorie, sa note/mémo, son échéance et son montant de paiement
	 */
	public String toStringAffichage() {
		String info = String.format("ID [%3d] Catégorie [%25s] Mémo [%15s] Échéance [%3d]\nPaiement [%10.2f]",
				this.ID, this.getCategorieString(), this.getMemo(), this.getEcheanceJours(), this.getMontantPaiement());
		return info;
	}

	/**
	 * Description formatée pour la sauvegarde de l'élément payable avec son identifiant,
	 * sa catégorie, sa note/mémo, son échéance et sa catégorie.
	 *
	 * @return	La représentation formatée pour la sauvegarde de l'élément payable avec son identifiant,
	 * sa catégorie, sa note/mémo, son échéance et sa catégorie
	 */
	public abstract String toStringSauvegarde();
}
