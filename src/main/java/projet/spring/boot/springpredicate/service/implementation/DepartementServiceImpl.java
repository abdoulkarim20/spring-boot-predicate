package projet.spring.boot.springpredicate.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.spring.boot.springpredicate.entitie.Departement;
import projet.spring.boot.springpredicate.repositorie.DepartementRepository;
import projet.spring.boot.springpredicate.service.DepartementService;
import projet.spring.boot.springpredicate.service.dto.DepartementDTO;
import projet.spring.boot.springpredicate.service.mapper.DepartementMapper;
@Service
@Transactional
public class DepartementServiceImpl implements DepartementService {
    private DepartementRepository departementRepository;
    private DepartementMapper departementMapper;

    public DepartementServiceImpl(DepartementRepository departementRepository, DepartementMapper departementMapper) {
        this.departementRepository = departementRepository;
        this.departementMapper = departementMapper;
    }

    @Override
    public Page<DepartementDTO> getAllDepartement(int page, int size) {
        Pageable pageable= PageRequest.of(page,size, Sort.by("libelle").descending());
        Page<Departement>departements=departementRepository.findAll(pageable);
        return departements.map(departementMapper::toDto);
    }
}
