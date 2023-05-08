package payables;

// TODO 01-- Ajoutez tout le code nécessaire pour coder la classe au complet en vous basant sur le diagramme UML
//         ainsi que la gestion des erreurs possibles si nécessaire
//
public class EmployeSalarieAvecCommission extends EmployeSalarie {
    private double tauxCommission;
    private double ventesBrutes;

    public EmployeSalarieAvecCommission(int ID, String n, String nas, double s, double tC, double vB, String m) {
        super(ID, n, nas, s, m);
        tauxCommission = tC;
        ventesBrutes = vB;
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
        return String.format("%s: %s%n%s: %,.2f%n%s: %,.2f",
                getCategorieString(), super.toString(), "paiement dû", getTauxCommission(),
                 "ventes brutes", getVentesBrutes());
    }

    public String toStringAffichage() {
        String info = super.toStringAffichage();
        info += " Paiement dû [" + this.getTauxCommission()  + "]\n" +
         " Ventes brutes [" + this.getVentesBrutes() + "]";
        return info;
    }

    public String toStringSauvegarde() {
        String info = String.format("ID [%3d] Nom complet [%20s] NAS [%9s] Salaire [%6.2f] Mémo [%15s] Catégorie [%20s] Taux commission [%6.2f] Ventes brutes [%,.2f]",
                super.getID(), super.getNomComplet(), super.getNumeroAssuranceSociale(),
                super.getSalaireHebdomadaire(), super.getMemo(), super.getCategorieString(),
                this.getTauxCommission(), this.getVentesBrutes());
        return info;
    }
}