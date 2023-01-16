package projet.spring.boot.springpredicate.service;

import org.springframework.data.domain.Page;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;
import projet.spring.boot.springpredicate.service.dto.EtudiantDepartementDTO;

import java.time.LocalDate;

public interface EtudiantService {
    Page<EtudiantDTO> search(Integer pageNumber, Integer pageSize, String nom, String prenom, Boolean active, LocalDate dateNaissance, LocalDate dateStart, LocalDate dateEnd);
    EtudiantDTO save(EtudiantDTO etudiantDTO);
    Page<EtudiantDepartementDTO>getAllEtudiantByFilter(int page,int size,String libelle);
}
