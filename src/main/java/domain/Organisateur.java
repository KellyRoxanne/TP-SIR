package domain;

import jakarta.persistence.Entity;

@Entity
public class Organisateur extends Utilisateur {

    private String siret;
    private String nomEntreprise;

    public Organisateur() {
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }
}
