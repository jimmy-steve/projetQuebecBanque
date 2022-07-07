package modele;

public class Compte {
    private String email;
    private String typeCompte;
    private String titulaire;
    private String nomClient;
    private String prenomClient;
    private int jourNaissance;
    private int moisNaissance;
    private int anneeNaissance;
    private String pays;
    private String motDePasse;
    private String ville;
    private String telephone;
    private String adresse;

    public Compte() {
    }

    public Compte( String email, String typeCompte, String titulaire, String nomClient,
                  String prenomClient, int jourNaissance, int moisNaissance, int anneeNaissance, String pays,
                  String motDePasse, String ville, String telephone, String adresse) {

        this.email = email;
        this.typeCompte = typeCompte;
        this.titulaire = titulaire;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.jourNaissance = jourNaissance;
        this.moisNaissance = moisNaissance;
        this.anneeNaissance = anneeNaissance;
        this.pays = pays;
        this.motDePasse = motDePasse;
        this.ville = ville;
        this.telephone = telephone;
        this.adresse = adresse;
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

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public int getJourNaissance() {
        return jourNaissance;
    }

    public void setJourNaissance(int jourNaissance) {
        this.jourNaissance = jourNaissance;
    }

    public int getMoisNaissance() {
        return moisNaissance;
    }

    public void setMoisNaissance(int moisNaissance) {
        this.moisNaissance = moisNaissance;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "email='" + email + '\'' +
                ", typeCompte='" + typeCompte + '\'' +
                ", titulaire='" + titulaire + '\'' +
                ", nomClient='" + nomClient + '\'' +
                ", prenomClient='" + prenomClient + '\'' +
                ", jourNaissance=" + jourNaissance +
                ", moisNaissance=" + moisNaissance +
                ", anneeNaissance=" + anneeNaissance +
                ", pays='" + pays + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", ville='" + ville + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
