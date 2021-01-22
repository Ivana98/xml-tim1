package tim1.backend.helper;

public interface MapperInterface<T,U> {

    T toEntity(U dto);

    U toDto(T entity);
}
