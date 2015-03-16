package no.mesan.clouddevops.rest;

import no.mesan.clouddevops.domain.Todo;
import no.mesan.clouddevops.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/todo")
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Todo> getAll() {
        return todoService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Todo create(@RequestBody final Todo todo) {
        return todoService.create(todo);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Todo update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable final Long id) {
        todoService.delete(id);
    }


}
