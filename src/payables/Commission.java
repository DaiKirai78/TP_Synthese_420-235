package payables;

/**
 * Interface décrivant les fonctionnalités liées à la commission.
 */
public interface Commission {

    /**
     * Retourne le taux de commission.
     * @return Le taux de commission.
     */
    double getTauxCommission();

    /**
     * Retourne les ventes brutes.
     * @return Les ventes brutes.
     */
    double getVentesBrutes();

    /**
     * Calcule le montant de la commission en fonction des ventes brutes.
     * @param ventesBrutes Les ventes brutes.
     * @return Le montant de la commission.
     */
    double getMontantCommission(double ventesBrutes);
}
