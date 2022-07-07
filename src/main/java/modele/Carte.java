package modele;

public class Carte {
    private int idCarte;
    private long noCarte;
    private String dateExp;
    private String email;
    private String typeCompte;
    private double total;

    public Carte() {
    }

    public Carte(int idCarte, long noCarte, String dateExp, String email, String typeCompte, double total) {
        this.idCarte = idCarte;
        this.noCarte = noCarte;
        this.dateExp = dateExp;
        this.email = email;
        this.typeCompte = typeCompte;
        this.total = total;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public long getNoCarte() {
        return noCarte;
    }

    public void setNoCarte(long noCarte) {
        this.noCarte = noCarte;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "idCarte=" + idCarte +
                ", noCarte=" + noCarte +
                ", dateExp=" + dateExp +
                ", email='" + email + '\'' +
                ", typeCompte='" + typeCompte + '\'' +
                ", total=" + total +
                '}';
    }
}
