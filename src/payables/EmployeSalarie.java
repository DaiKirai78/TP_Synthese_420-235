package payables;

/**
 * La classe EmployeSalarie représente un employé rémunéré avec un salaire fixe et étend la classe Employe.
 */
public class EmployeSalarie extends Employe {
	private double salaireHebdomadaire;
	//
	// TODO 02-- Ajoutez tout le code nécessaire pour coder la classe au complet en vous basant sur le diagramme UML
	//         ainsi que la gestion des erreurs possibles si nécessaire
	//

	/**
	 * Constructeur de la classe EmployeSalarie.
	 * @param ID	L'identifiant de l'employé
	 * @param n		Le nom complet de l'employé
	 * @param nas	Le numéro d'assurance social de l'employé
	 * @param s		Le salaire hebdomadaire de l'employé
	 * @param m		Une note/mémo sur l'employé
	 */
	public EmployeSalarie(int ID, String n, String nas, double s, String m) {
		super(ID, n, nas, m);
		salaireHebdomadaire = s;
		categorie = Categorie.EmployeSalarie;
	}

	/**
	 * Méthode pour obtenir le salaire hebdomadaire d'un employé.
	 * @return Le salaire hebdomadaire d'un employé
	 */
	public double getSalaireHebdomadaire() {
		return salaireHebdomadaire;
	}

	/**
	 * Méthode pour définir le salaire hebdomadaire d'un employé.
	 * @param salaire	Le salaire hebdomadaire d'un employé
	 */
	public void setSalaireHebdomadaire(double salaire) {
		salaireHebdomadaire = salaire;
	}

	/**
	 * Méthode pour obtenir le montant total du paiement d'un employé.
	 * @return	Le montant total du paiement d'un employé (qui correspond au salaire hebdomadaire)
	 */
	@Override
	public double getMontantPaiement() {
		return getSalaireHebdomadaire();
	}

	/**
	 * Description de l'employé salarié.
	 * @return	La représentation sous forme de chaîne de caractères de l'employé.
	 */
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: %,.2f",
				getCategorieString(), super.toString(), "salaire hebdomadaire", getSalaireHebdomadaire());
	}

	/**
	 * Description spécifique de l'employé salarié.
	 * @return	La représentation spécifique pour affichage de l'employé
	 */
	public String toStringAffichage() {
			String info = super.toStringAffichage();
			info += " Salaire hebdomadaire [" + this.getSalaireHebdomadaire()  + "]";
			return info;
	}

	/**
	 * Description formatée pour la sauvegarde d'un employé salarié.
	 * @return La représentation formatée à la sauvegarde d'un employé.
	 */
	public String toStringSauvegarde() {
		String info = String.format("ID [%3d] Nom complet [%20s] NAS [%9s] Salaire [%6.2f] Mémo [%15s] Catégorie [%20s]",
				this.getID(), this.getNomComplet(), this.getNumeroAssuranceSociale(),
				this.getSalaireHebdomadaire(), this.getMemo(), this.getCategorieString());
		return info;
	}
}
