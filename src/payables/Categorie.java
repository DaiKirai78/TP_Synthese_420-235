package payables;

/**
 * Enumération représentant les catégories des éléments payables.
 */
public enum Categorie {

    /**
     * Catégorie correspondant aux factures.
     */
    Facture,

    /**
     * Catégorie correspondant aux employés horaires.
     */
    EmployeHoraire,

    /**
     * Catégorie correspondant aux employés horaires avec commission.
     */
    EmployeHoraireAvecCommission,

    /**
     * Catégorie correspondant aux employés salariés.
     */
    EmployeSalarie,

    /**
     * Catégorie correspondant aux employés salariés avec commission.
     */
    EmployeSalarieAvecCommission
}