package no.mesan.clouddevops.service;

import no.mesan.clouddevops.domain.Todo;

public interface TodoService {

    Iterable<Todo> getAll();

    Todo create(Todo todo);

    Todo update(Todo todo);

    void delete(Long id);

}
