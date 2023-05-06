package payables;

// TODO 01-- Ajoutez tout le code nécessaire pour coder la classe au complet en vous basant sur le diagramme UML
//         ainsi que la gestion des erreurs possibles si nécessaire
//
public class EmployeSalarieAvecCommission extends EmployeSalarie {
    private double tauxCommission;
    private double ventesBrutes;

    public EmployeSalarieAvecCommission(int ID, String n, String nas, double s, double tC, double vB, double m) {
        super(ID, n, nas, s, m);
        tauxCommission = tC;
        ventesBrutes = vB;
    }

    public double getTauxCommission() {
        return tauxCommission;
    }

    public void setTauxCommission(double taux) {

    }

    public double getVentesBrutes() {
        return ventesBrutes;
    }

    public void setVentesBrutes(double ventes) {

    }

    public double getMontantCommission(double ventesBrutes) {

    }

    @Override
    public double getMontantPaiement() {
        return super.getMontantPaiement();
    }

    @Override
    public String toString() {
        return "EmployeSalarieAvecCommission{" +
                "tauxCommission=" + tauxCommission +
                ", ventesBrutes=" + ventesBrutes +
                ", categorie=" + categorie +
                ", echeanceJours=" + echeanceJours +
                ", memo='" + memo + '\'' +
                '}';
    }

    public String toStringAffichage() {

    }

    public String toStringSauvegarde() {

    }
}