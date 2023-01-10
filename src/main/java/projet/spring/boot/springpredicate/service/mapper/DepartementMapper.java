package projet.spring.boot.springpredicate.service.mapper;

import org.mapstruct.Mapper;
import projet.spring.boot.springpredicate.entitie.Departement;
import projet.spring.boot.springpredicate.service.dto.DepartementDTO;
@Mapper(componentModel = "spring")
public interface DepartementMapper extends EntityMapper<DepartementDTO, Departement>{
    DepartementDTO toDto(Departement departement);
}
