package service.interfaces;

import java.util.List;
import java.util.UUID;

public interface DefaultService <T> {
    T save(List<T> list, T t);
    T updade(List<T> list, T t);
    Void deleteById(List<T> list, UUID id);
}
