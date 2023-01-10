package projet.spring.boot.springpredicate.repositorie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.spring.boot.springpredicate.entitie.Etudiant;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Page<EtudiantDTO> findAll(Specification<EtudiantDTO> etudiantDTOSpecification, Pageable pageable);
}
