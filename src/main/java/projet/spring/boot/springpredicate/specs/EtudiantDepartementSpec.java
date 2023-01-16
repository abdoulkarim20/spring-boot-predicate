package projet.spring.boot.springpredicate.specs;

import org.springframework.data.jpa.domain.Specification;
import projet.spring.boot.springpredicate.entitie.Departement;
import projet.spring.boot.springpredicate.entitie.Etudiant;


import javax.persistence.criteria.Join;

public class EtudiantDepartementSpec {
    public static Specification<Etudiant>getEtudiantByFilterField(String libelle){
        Specification<Etudiant>specifications=null;
        Specification<Etudiant>temp=null;
        if (libelle!=null){
            specifications=getAllEtudiantByDepartement(libelle);
            temp=specifications!=null?Specification.where(specifications).and(temp):temp;
        }
        return specifications;
    }
    private static Specification<Etudiant>getAllEtudiantByDepartement(String libelle){
        return (root, query, criteriaBuilder) -> {
            Join<Etudiant, Departement> etudiants=root.join("etudiants");
            return criteriaBuilder.equal(etudiants.get("libelle"),libelle);
        };
    }
}
