package no.mesan.clouddevops.service;

import no.mesan.clouddevops.domain.Todo;

public interface TodoService {

    Todo add(Todo todo);

    Iterable<Todo> getAll();
}
