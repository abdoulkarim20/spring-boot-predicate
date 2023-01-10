package projet.spring.boot.springpredicate.service;

import org.springframework.data.domain.Page;
import projet.spring.boot.springpredicate.service.dto.DepartementDTO;

public interface DepartementService {
    Page<DepartementDTO>getAllDepartement(int page,int size);
}
