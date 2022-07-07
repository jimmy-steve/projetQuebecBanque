package modele;

import java.util.ArrayList;

public class RegistreCompte {
    public ArrayList<Compte> registre;

    public RegistreCompte() {
        this.registre = new ArrayList<>();
    }

    public RegistreCompte(ArrayList<Compte> registre) {
        this.registre = registre;
    }

    public ArrayList<Compte> getRegistre() {
        return registre;
    }

    public void setRegistre(ArrayList<Compte> registre) {
        this.registre = registre;
    }

    public void ajouterCompte(Compte compte) {
        this.registre.add(compte);
    }

    @Override
    public String toString() {
        return "RegistreCompte{" +
                "registre=" + registre +
                '}';
    }
}
