package payables;

// TODO 01-- Ajoutez tout le code nécessaire pour coder la classe au complet en vous basant sur le diagramme UML
//         ainsi que la gestion des erreurs possibles si nécessaire
//
public class EmployeSalarieAvecCommission extends EmployeSalarie implements Commission {
    private double tauxCommission;
    private double ventesBrutes;

    public EmployeSalarieAvecCommission(int ID, String n, String nas, double s, double tC, double vB, String m) {
        super(ID, n, nas, s, m);
        tauxCommission = tC;
        ventesBrutes = vB;
        categorie = Categorie.EmployeSalarieAvecCommission;
    }

    public double getTauxCommission() {
        return tauxCommission;
    }

    public void setTauxCommission(double taux) {
        tauxCommission = taux;
    }

    public double getVentesBrutes() {
        return ventesBrutes;
    }

    public void setVentesBrutes(double ventes) {
        ventesBrutes = ventes;
    }

    public double getMontantCommission(double ventesBrutes) {
        return ventesBrutes * tauxCommission;
    }

    public double getMontantPaiement() {
        return super.getSalaireHebdomadaire() + getMontantCommission(ventesBrutes);
    }

    @Override
    public String toString() {
        return String.format("%s; %s: %,.2f",
                super.toString(), "taux de commission", getTauxCommission());
    }

    public String toStringAffichage() {
        String info = super.toStringAffichage();
        info += " Commission [" + this.getTauxCommission()  + "] " +
         "Ventes [" + this.getVentesBrutes() + "]";
        return info;
    }

    public String toStringSauvegarde() {
        String info = String.format("ID [%3d] Nom complet [%20s] NAS [%9s] Salaire [%6.2f] Mémo [%15s] Catégorie [%20s] Taux commission [%6.2f] Ventes brutes [%,.2f]",
                this.getID(), this.getNomComplet(), this.getNumeroAssuranceSociale(),
                super.getSalaireHebdomadaire(), this.getMemo(), this.getCategorieString(),
                this.getTauxCommission(), this.getVentesBrutes());
        return info;
    }
}