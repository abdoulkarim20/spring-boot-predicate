package projet.spring.boot.springpredicate.specs;

import org.springframework.data.jpa.domain.Specification;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;

public class EtudiantFieldSpec {
    public static Specification<EtudiantDTO> getSpecs(String nom, String prenom,Boolean active){
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
}
