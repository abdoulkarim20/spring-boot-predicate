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
import projet.spring.boot.springpredicate.service.dto.EtudiantDepartementDTO;
import projet.spring.boot.springpredicate.service.mapper.EtudiantDepartementMapper;
import projet.spring.boot.springpredicate.service.mapper.EtudiantMapper;
import projet.spring.boot.springpredicate.specs.EtudiantDepartementSpec;
import projet.spring.boot.springpredicate.specs.EtudiantFieldSpec;

import java.time.LocalDate;

@Transactional
@Service
public class EtudiantServiceImpl implements EtudiantService {
    private EtudiantRepository etudiantRepository;
    private EtudiantMapper etudiantMapper;
    private EtudiantDepartementMapper etudiantDepartementMapper;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository, EtudiantMapper etudiantMapper, EtudiantDepartementMapper etudiantDepartementMapper) {
        this.etudiantRepository = etudiantRepository;
        this.etudiantMapper = etudiantMapper;
        this.etudiantDepartementMapper = etudiantDepartementMapper;
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

    @Override
    public Page<EtudiantDepartementDTO> getAllEtudiantByFilter(int page, int size,String libelle) {
        Pageable pageable=PageRequest.of(page,size,Sort.by("dateNaissance").descending());
        Specification<Etudiant>etudiants=EtudiantDepartementSpec.getEtudiantByFilterField(libelle);
        return etudiantRepository.findAllEtudiantByDepartement(etudiants,pageable).map(etudiantDepartementMapper::toDto);
    }


}
