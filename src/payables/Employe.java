package payables;

/**
 * La classe Employe est une classe abstraite qui hérite de la classe Payable.
 * Elle représente un employé et fournit des méthodes pour obtenir des informations sur l'employé.
 */
public abstract class Employe extends Payable {
	private final String nomComplet, numeroAssuranceSociale;

	/**
	 * Constructeur de la classe Employe.
	 * @param id	L'identifiant de l'employé.
	 * @param nom	Le nom complet de l'employé.
	 * @param nas	Le numéro d'assurance sociale de l'employé.
	 * @param memo	Une note ou un mémo lié à l'employé.
	 */
	public Employe(int id, String nom, String nas, String memo) {
		super(id, memo);
		this.nomComplet = nom;
		numeroAssuranceSociale = nas;
	}

	/**
	 * Méthode pour obtenir le nom complet de l'employé.
	 * @return Le nom complet de l'employé.
	 */
	public String getNomComplet() {
		return nomComplet;
	}

	/**
	 * Méthode pour obtenir le numéro d'assurance sociale de l'employé.
	 * @return Le numéro d'assurance sociale de l'employé.
	 */
	public String getNumeroAssuranceSociale() {
		return numeroAssuranceSociale;
	}

	/**
	 * Méthode abstraite pour obtenir le montant du paiement de l'employé.
	 * @return Le montant du paiement de l'employé.
	 */
	public abstract double getMontantPaiement();

	/**
	 * Description d'un employé.
	 * @return La représentation sous forme de chaîne de caractères de l'employé.
	 */
	@Override
	public String toString() {
		return String.format( "%s \nnuméro d'assurance sociale: %s",
				getNomComplet(), getNumeroAssuranceSociale());
	}

	/**
	 * Méthode utilisée pour un affichage spécifique de l'employé dans certains contextes.
	 * @return La représentation spécifique à l'affichage de l'employé.
	 */
	public String toStringAffichage() {
		String info = super.toStringAffichage();
		info += String.format(" Nom complet [%20s] NAS [%9s]",
				this.getNomComplet(), this.getNumeroAssuranceSociale());
		return info;
	}

	/**
	 * Méthode abstraite d'une description spécifique de la sauvegarde d'un employé.
	 * @return La représentation sous forme de chaîne de caractères spécifique de la sauvegarde d'un employé.
	 */
	public abstract String toStringSauvegarde();
}
