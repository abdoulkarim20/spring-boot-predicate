package projet.spring.boot.springpredicate.service;

import projet.spring.boot.springpredicate.exceptionHandlers.RessourceNotFoundException;
import projet.spring.boot.springpredicate.service.dto.DepartementDTO;

import java.util.List;

public interface DepartementService {
    List<DepartementDTO> getAllDepartement() throws RessourceNotFoundException;
    DepartementDTO save(DepartementDTO departementDTO) throws RessourceNotFoundException;
    DepartementDTO getOneDepartement(Long id) throws RessourceNotFoundException;
    DepartementDTO update(DepartementDTO departementDTO) throws RessourceNotFoundException;
}
