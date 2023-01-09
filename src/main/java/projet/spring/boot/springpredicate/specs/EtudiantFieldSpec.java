package projet.spring.boot.springpredicate.specs;

import org.springframework.data.jpa.domain.Specification;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;

import java.time.LocalDate;

public class EtudiantFieldSpec {
    public static Specification<EtudiantDTO> getSpecs(String nom, String prenom,Boolean active,LocalDate dateNaissance,LocalDate dateStart,LocalDate dateEnd){
        Specification<EtudiantDTO>spec=null;
        Specification<EtudiantDTO>temp=null;
        if (nom!=null){
            spec=getEtudiantByNom(nom);
            temp=spec!=null?Specification.where(spec).and(temp):temp;
        }
//        if (!dateNaissance.isEmpty() && nom!=null){
//            spec=getEtudiantByNom(nom);
//            temp=spec!=null?Specification.where(spec).and(temp):temp;
//        }
        if (prenom!=null){
            spec=getEtudiantByPrenom(prenom);
            temp=spec!=null?Specification.where(spec).and(temp):temp;
        }
        if (active!=null){
            if (active==true){
                spec=getEtudiantByEtatIsActive(active);
            }else {
                spec=getEtudiantByEtatIsDesactive(active);
            }
            temp=spec!=null?Specification.where(spec).and(temp):temp;
        }
        if (dateNaissance!=null){
            spec=getEtudiantByBrithDay(dateNaissance);
            temp=spec!=null?Specification.where(spec).and(temp):temp;
        }
        if (dateStart!=null && dateEnd!=null){
            spec=getAllEtudiantByBrithDayBetween(dateStart,dateEnd);
            temp=spec!=null?Specification.where(spec).and(temp):temp;
        }

        return spec;
    }

    private static Specification<EtudiantDTO> getEtudiantByPrenom(String prenom) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("prenom")),"%"+prenom.toLowerCase()+"%");
        };
    }

    private static Specification<EtudiantDTO> getEtudiantByNom(String nom) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("nom")),"%"+nom.toLowerCase()+"%");
        };
    }
    private static Specification<EtudiantDTO>getEtudiantByEtatIsActive(Boolean active){
        return (root, query, criteriaBuilder) -> {

            /*Boolean value="true".equalsIgnoreCase(String.valueOf(active))?Boolean.TRUE:"false".equalsIgnoreCase(String.valueOf(active))?Boolean.FALSE:null;
            Boolean =true?criteriaBuilder.isTrue(root.get("active")):criteriaBuilder.isFalse(root.get("active"));*/
            return criteriaBuilder.isTrue(root.get("active"));
        };
    }
    private static Specification<EtudiantDTO>getEtudiantByEtatIsDesactive(Boolean active){
        return (root, query, criteriaBuilder) -> {

            /*Boolean value="true".equalsIgnoreCase(String.valueOf(active))?Boolean.TRUE:"false".equalsIgnoreCase(String.valueOf(active))?Boolean.FALSE:null;
            Boolean =true?criteriaBuilder.isTrue(root.get("active")):criteriaBuilder.isFalse(root.get("active"));*/
            return criteriaBuilder.isFalse(root.get("active"));
        };
    }
    private static Specification<EtudiantDTO>getEtudiantByBrithDay(LocalDate dateNaissance){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("dateNaissance"),dateNaissance);
        };
    }
    private static Specification<EtudiantDTO>getAllEtudiantByBrithDayBetween(LocalDate dateStart,LocalDate dateEnd){
        return (root, query, criteriaBuilder) -> {
          return criteriaBuilder.between(root.get("dateNaissance"),dateStart,dateEnd);
        };
    }
}
