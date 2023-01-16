package projet.spring.boot.springpredicate.service;

import org.springframework.data.domain.Page;
import projet.spring.boot.springpredicate.service.dto.DepartementDTO;

import java.util.List;

public interface DepartementService {
    List<DepartementDTO> getAllDepartement();
    DepartementDTO save(DepartementDTO departementDTO);
}
