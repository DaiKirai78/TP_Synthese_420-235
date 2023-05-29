package payables;

/**
 * La classe EmployeHoraire représente un employé rémunéré à l'heure.
 * Hérite de la classe Employe.
 */
public class EmployeHoraire extends Employe {

	public final double HEURES_TEMPS_COMPLET = 40;
	public final double RATIO_TEMPS_SUPP = 1.5;
	private double tauxHoraire;
	private double heuresTravaillees;

	/**
	 * Constructeur de la classe EmployeHoraire.
	 * @param id	L'identifiant de l'employé
	 * @param nom	Le nom complet de l'employé
	 * @param nas	Le numéro d'assurance sociale de l'employé
	 * @param tauxHoraire	Le taux horaire de l'employé
	 * @param heuresTravaillees   Le nombre d'heures travaillées par l'employé
	 * @param memo	Une note/mémo sur l'employé
	 */
	public EmployeHoraire(int id, String nom, String nas,
						  double tauxHoraire, double heuresTravaillees, String memo) {
		super(id, nom, nas, memo);
		categorie = Categorie.EmployeHoraire;
		setTauxHoraire(tauxHoraire);
		setHeuresTravaillees(heuresTravaillees);
	}

	/**
	 * Méthode pour obtenir le taux horaire de l'employé.
	 * @return Le taux horaire de l'employé.
	 */
	public double getTauxHoraire() {
		return tauxHoraire;
	}

	/**
	 * Méthode pour définir le taux horaire d'un employé.
	 * @param tauxHoraire Le taux horaire de l'employé.
	 * @throws IllegalArgumentException si le taux horaire est inférieur à 0.0
	 */
	public void setTauxHoraire(double tauxHoraire) {
		if (tauxHoraire >= 0.0)
			this.tauxHoraire = tauxHoraire;
		else
			throw new IllegalArgumentException("Le salaire horaire doit être >= 0.0" );
	}

	/**
	 * Méthode pour obtenir le nombre d'heures travaillées par un employé.
	 * @return Le nombre d'heures travaillées par un employé.
	 */
	public double getHeuresTravaillees() {
		return heuresTravaillees;
	}

	/**
	 * Méthode pour définir le nombre d'heures travaillées par un employé.
	 * @param heuresTravaillees Nombre d'heures travaillées par un employé.
	 * @throws IllegalArgumentException si les heures travaillées sont en dehors de la plage valide (0.0 à 168.0)
	 */
	public void setHeuresTravaillees(double heuresTravaillees) {
		if ((heuresTravaillees >= 0.0) && (heuresTravaillees <= 168.0))
			this.heuresTravaillees = heuresTravaillees;
		else
			throw new IllegalArgumentException("Les heures travaillées doivent être >= 0.0 et <= 168.0" );
	}
	//
	// TODO 04-- Ajoutez tout le code nécessaire pour coder la classe au complet coder la classe au completen vous basant sur le diagramme UML
	//         ainsi que la gestion des erreurs possibles si nécessaire
	//

	/**
	 * Méthode pour obtenir le montant du paiement de l'employé selon le nombre
	 * d'heures travaillées, le ratio d'heures supplémentaires et le taux horaire.
	 * @return Le montant du paiement de l'employé
	 */
	@Override
	public double getMontantPaiement() {
		if (getHeuresTravaillees() <= HEURES_TEMPS_COMPLET)
			return getHeuresTravaillees() * getTauxHoraire();
		else
			return getTauxHoraire() * HEURES_TEMPS_COMPLET + (getHeuresTravaillees() - HEURES_TEMPS_COMPLET) *
					getTauxHoraire() * RATIO_TEMPS_SUPP;
	}

	/**
	 * Description de l'employé à taux horaire.
	 * @return La représentation sous forme de chaîne de caractères de l'employé.
	 */
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: %,.2f; %s: %.2f",
				getCategorieString(), super.toString(), "taux horaire", getTauxHoraire(), "heures travaillées", getHeuresTravaillees());
	}

	/**
	 * Description spécifique de l'employé à taux horaire.
	 * @return La représentation spécifique pour affichage de l'employé
	 */
	public String toStringAffichage() {
		String info = super.toStringAffichage();
		info += " Salaire [" + this.getTauxHoraire()  + "] Heures [" + this.getHeuresTravaillees() + "]";
		return info;
	}

	/**
	 * Description formatée pour la sauvegarde d'un employé à taux horaire.
	 * @return La représentation formatée à la sauvegarde d'un employé.
	 */
	public String toStringSauvegarde() {
		String info = String.format("ID [%3d] Nom complet [%20s] NAS [%9s] Taux Horaire [%4.2f] Heures travaillées [%4.2f] Mémo [%15s] Catégorie [%20s]",
				this.getID(), this.getNomComplet(), this.getNumeroAssuranceSociale(),
				this.getTauxHoraire(), this.getHeuresTravaillees(), this.getMemo(), this.getCategorieString());
		return info;
	}
}
