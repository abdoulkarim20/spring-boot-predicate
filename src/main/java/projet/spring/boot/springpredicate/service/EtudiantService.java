package projet.spring.boot.springpredicate.service;

import org.springframework.data.domain.Page;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;

import java.time.LocalDate;
import java.util.List;

public interface EtudiantService {
    Page<EtudiantDTO> search(Integer pageNumber, Integer pageSize, String nom, String prenom, Boolean active, LocalDate dateNaissance, LocalDate dateStart, LocalDate dateEnd);
    EtudiantDTO save(EtudiantDTO etudiantDTO);
}
