package projet.spring.boot.springpredicate.service;

import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;

import java.time.LocalDate;
import java.util.List;

public interface IEtudiant {
    List<EtudiantDTO> search(Integer pageNumber,Integer pageSize,String nom, String prenom,Boolean active);
}
