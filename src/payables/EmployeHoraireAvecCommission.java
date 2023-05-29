package payables;

/**
 * La classe EmployeHoraireAvecCommission représente un employé rémunéré à l'heure
 * avec une commission et hérite de la classe EmployeHoraire.
 * Elle implémente l'interface Commission.
 */
public class EmployeHoraireAvecCommission extends EmployeHoraire implements Commission {
    private double tauxCommission;
    private double ventesBrutes;

    /**
     * Constructeur de la classe EmployeHoraireAvecCommission.
     * @param id    Identifiant de l'employé
     * @param nom   Nom complet de l'employé
     * @param nas   Numéro d'assurance social de l'employé
     * @param tauxHoraire   Le taux horaire de l'employé
     * @param heuresTravaillees   Le nombre d'heures travaillées par l'employé
     * @param tauxCommission    Le taux de commission de l'employé
     * @param ventesBrutes    Le montant des ventes brutes réalisées par l'employé
     * @param memo   Une note/mémo sur l'employé
     */
    public EmployeHoraireAvecCommission(int id, String nom, String nas,
                                        double tauxHoraire, double heuresTravaillees,
                                        double tauxCommission, double ventesBrutes, String memo) {
        super(id, nom, nas, tauxHoraire, heuresTravaillees, memo);
        setTauxCommission(tauxCommission);
        categorie = Categorie.EmployeHoraireAvecCommission;
        setVentesBrutes(ventesBrutes);
    }

    /**
     * Méthode pour obtenir le taux de commission d'un employéé
     * @return Le taux de commission de l'employé
     */
    public double getTauxCommission() {
        return tauxCommission;
    }
    //
    // TODO 03-- Ajoutez tout le code nécessaire pour coder la classe au complet en vous basant sur le diagramme UML
    //         ainsi que la gestion des erreurs possibles si nécessaire
    //

    /**
     * Méthode pour définir le taux de commission d'un employé.
     * @param taux  Le taux de commission de l'employé
     */
    public void setTauxCommission(double taux) {
        tauxCommission = taux;
    }

    /**
     * Méthode pour obtenir le montant des ventes brutes réalisées par un employé.
     * @return  Le montant des ventes brutes
     */
    public double getVentesBrutes() {
        return ventesBrutes;
    }

    /**
     * Méthode pour définir le montant des ventes brutes réalisées par un employé.
     * @param ventes    Montant des ventes brutes
     */
    public void setVentesBrutes(double ventes) {
        ventesBrutes = ventes;
    }

    /**
     * Méthode pour obtenir le montant de la commission d'un employé en fonction des ventes brutes.
     * @param ventesBrutes  Montant des ventes brutes
     * @return  Le montant de la commission d'un employé
     */
    public double getMontantCommission(double ventesBrutes) {
        return ventesBrutes * tauxCommission;
    }

    /**
     * Méthode pour obtenir le montant total du paiement de l'employé en prenant en compte
     * le salaire horaire, les heures travaillées et la commission sur les ventes brutes.
     * @return  Le montant total du paiement d'un employé
     */
    public double getMontantPaiement() {
        return super.getMontantPaiement() + getMontantCommission(ventesBrutes);
    }

    /**
     * Description de l'employé à taux horaire avec commission.
     * @return La représentation sous forme de chaîne de caractères de l'employé.
     */
    @Override
    public String toString() {
        return String.format("%s; %s: %,.2f",
                super.toString(),
                "taux de commission", getTauxCommission(),
                "ventes brutes", getVentesBrutes());
    }

    /**
     * Description spécifique de l'employé à taux horaire avec commission.
     * @return La représentation spécifique pour affichage de l'employé
     */
    public String toStringAffichage() {
        String info = super.toStringAffichage();
        info += " Commission [" + this.getTauxCommission() + "] Ventes [" + this.getVentesBrutes() + "]";
        return info;
    }

    /**
     * Description formatée pour la sauvegarde d'un employé à taux horaire avec commission.
     * @return La représentation formatée à la sauvegarde d'un employé.
     */
    public String toStringSauvegarde() {
        String info = String.format("ID [%3d] Nom complet [%20s] NAS [%9s] Taux Horaire [%4.2f] Heures travaillées [%4.2f] Taux commission [%4.2f] Ventes [%10.2f] Mémo [%15s] Catégorie [%20s]",
                this.getID(), this.getNomComplet(), this.getNumeroAssuranceSociale(),
                this.getTauxHoraire(), this.getHeuresTravaillees(),
                this.getTauxCommission(), this.getVentesBrutes(),
                this.getMemo(), this.getCategorieString());
        return info;
    }
}
