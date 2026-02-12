package domain;

import jakarta.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur {

    private int niveau;

    public Administrateur() {
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
