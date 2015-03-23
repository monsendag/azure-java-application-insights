package no.mesan.clouddevops.rest;

import no.mesan.clouddevops.domain.Todo;
import no.mesan.clouddevops.service.TodoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/todos")
public class TodoRestController {

    final Logger logger = LoggerFactory.getLogger(TodoRestController.class);

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Todo> getAll() {
        logger.info("getAll() called");
        final Iterable<Todo> result = todoService.getAll();
        logger.info("getAll() finished");
        return result;
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
