package domain;

import jakarta.persistence.*;

@Entity
public class Lieu {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private String adresse;
    private String ville;
    private String pays;
    private int capacite;

    public Lieu() {}
}
