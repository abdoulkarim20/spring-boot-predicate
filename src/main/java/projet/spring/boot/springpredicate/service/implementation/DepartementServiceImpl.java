package projet.spring.boot.springpredicate.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.spring.boot.springpredicate.entitie.Departement;
import projet.spring.boot.springpredicate.exceptionHandlers.RessourceNotFoundException;
import projet.spring.boot.springpredicate.repositorie.DepartementRepository;
import projet.spring.boot.springpredicate.service.DepartementService;
import projet.spring.boot.springpredicate.service.dto.DepartementDTO;
import projet.spring.boot.springpredicate.service.mapper.DepartementMapper;

import java.util.List;

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
    public List<DepartementDTO> getAllDepartement() throws RessourceNotFoundException {
        //Pageable pageable= PageRequest.of(page,size, Sort.by("libelle").descending());
        List<Departement>departements=departementRepository.findAll();
        if (departements.isEmpty()) throw new RessourceNotFoundException("Aucun enregistrement existant");
        return departementMapper.toDto(departements);
    }

    @Override
    public DepartementDTO save(DepartementDTO departementDTO) throws RessourceNotFoundException {
        Departement departement=departementMapper.toEntity(departementDTO);
        Departement existe=departementRepository.getDepartementByLibelle(departement.getLibelle());
        if (existe!=null) throw new RessourceNotFoundException("Ce departement existe deja");
        return departementMapper.toDto(departementRepository.save(departement));
    }

    @Override
    public DepartementDTO getOneDepartement(Long id) throws RessourceNotFoundException {
        Departement departement=departementRepository.findById(id).orElseThrow(()->
               new RessourceNotFoundException("Ce departement n'existe pas "+id)
        );
        return departementMapper.toDto(departement);
    }

    @Override
    public DepartementDTO update(DepartementDTO departementDTO) throws RessourceNotFoundException {
        Departement departement=departementMapper.toEntity(departementDTO);
        Departement existe=departementRepository.getDepartementByLibelle(departement.getLibelle());
        if (existe!=null && (!existe.getId().equals(departementDTO.getId()))) throw new RessourceNotFoundException("Ce departement existe deja");
        return departementMapper.toDto(departementRepository.save(departement));
    }
}
