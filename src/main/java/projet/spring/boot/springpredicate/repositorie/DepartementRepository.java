package projet.spring.boot.springpredicate.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.spring.boot.springpredicate.entitie.Departement;

import java.util.Optional;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {
    Departement getDepartementByLibelle(String libelle);
/*
    Optional<Departement>getDepartementByLibelle(String libelle);
*/
}
