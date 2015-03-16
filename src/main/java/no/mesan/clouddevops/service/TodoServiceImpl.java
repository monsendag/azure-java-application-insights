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
    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo) { return todoRepository.save(todo); }

    @Override
    public void delete(Long id) {
        todoRepository.delete(id);
    }

}
