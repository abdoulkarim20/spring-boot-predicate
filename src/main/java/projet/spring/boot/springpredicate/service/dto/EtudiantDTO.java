package projet.spring.boot.springpredicate.service.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance;
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
