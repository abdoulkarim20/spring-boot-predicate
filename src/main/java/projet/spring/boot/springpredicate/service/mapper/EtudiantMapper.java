package projet.spring.boot.springpredicate.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projet.spring.boot.springpredicate.entitie.Etudiant;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;
@Mapper(componentModel = "spring")
public interface EtudiantMapper extends EntityMapper<EtudiantDTO, Etudiant>{
    @Mapping(target = "departement",source = "departement")
    EtudiantDTO toDto(Etudiant etudiant);
}
