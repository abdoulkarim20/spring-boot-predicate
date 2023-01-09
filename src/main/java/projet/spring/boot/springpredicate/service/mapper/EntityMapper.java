package projet.spring.boot.springpredicate.service.mapper;

import java.util.List;

public interface EntityMapper<D,E> {
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDto(List<E> toEntityList);
    List<E> toEntity(List<D> toDtoList);
}
