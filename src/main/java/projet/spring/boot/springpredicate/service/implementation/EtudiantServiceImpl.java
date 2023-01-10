package projet.spring.boot.springpredicate.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.spring.boot.springpredicate.entitie.Etudiant;
import projet.spring.boot.springpredicate.repositorie.EtudiantRepository;
import projet.spring.boot.springpredicate.service.EtudiantService;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;
import projet.spring.boot.springpredicate.service.mapper.EtudiantMapper;
import projet.spring.boot.springpredicate.specs.EtudiantFieldSpec;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class EtudiantServiceImpl implements EtudiantService {
    private EtudiantRepository etudiantRepository;
    private EtudiantMapper etudiantMapper;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository, EtudiantMapper etudiantMapper) {
        this.etudiantRepository = etudiantRepository;
        this.etudiantMapper = etudiantMapper;
    }

    @Override
    public Page<EtudiantDTO> search(Integer pageNumber, Integer pageSize, String nom, String prenom, Boolean active, LocalDate dateNaissance, LocalDate dateStart, LocalDate dateEnd) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize, Sort.by("dateNaissance").ascending());
        Specification<EtudiantDTO>etudiantDTOSpecification=EtudiantFieldSpec.getSpecs(nom,prenom,active,dateNaissance,dateStart,dateEnd);
        return etudiantRepository.findAll(etudiantDTOSpecification,pageable);
    }

    @Override
    public EtudiantDTO save(EtudiantDTO etudiantDTO) {
        Etudiant etudiant=etudiantMapper.toEntity(etudiantDTO);
        return etudiantMapper.toDto(etudiantRepository.save(etudiant));
    }

}
