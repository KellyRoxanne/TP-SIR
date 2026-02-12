package domain;

import jakarta.persistence.Entity;

@Entity
public class Client extends Utilisateur {

    public Client() {
    }

    public Client(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }
}
