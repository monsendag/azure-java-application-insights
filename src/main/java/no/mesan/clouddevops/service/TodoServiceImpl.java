package no.mesan.clouddevops.service;

import no.mesan.clouddevops.domain.Todo;
import no.mesan.clouddevops.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo add(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }
}
