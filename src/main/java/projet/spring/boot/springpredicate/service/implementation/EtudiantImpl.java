package projet.spring.boot.springpredicate.service.implementation;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.spring.boot.springpredicate.repositorie.EtudiantRepository;
import projet.spring.boot.springpredicate.service.IEtudiant;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;
import projet.spring.boot.springpredicate.specs.EtudiantFieldSpec;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class EtudiantImpl implements IEtudiant {
    private EtudiantRepository etudiantRepository;

    public EtudiantImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<EtudiantDTO> search(Integer pageNumber,Integer pageSize,String nom, String prenom,Boolean active) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Specification<EtudiantDTO>etudiantDTOSpecification=EtudiantFieldSpec.getSpecs(nom,prenom,active);
        return etudiantRepository.findAll(etudiantDTOSpecification,pageable);
    }

}
