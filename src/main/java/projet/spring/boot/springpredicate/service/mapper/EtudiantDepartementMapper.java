package projet.spring.boot.springpredicate.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projet.spring.boot.springpredicate.entitie.Etudiant;
import projet.spring.boot.springpredicate.service.dto.EtudiantDepartementDTO;
@Mapper(componentModel = "spring")
public interface EtudiantDepartementMapper extends EntityMapper<EtudiantDepartementDTO, Etudiant>{
    @Mapping(target = "departement",source = "departement")
    EtudiantDepartementDTO toDto(Etudiant etudiant);
}
