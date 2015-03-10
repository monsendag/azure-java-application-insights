package no.mesan.clouddevops.rest;

import no.mesan.clouddevops.domain.Todo;
import no.mesan.clouddevops.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public Todo addTodo(@RequestParam final String title, @RequestParam final String content) {
        final Todo todo = new Todo();
        todo.setTitle(title);
        todo.setContent(content);
        return todoService.add(todo);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public Iterable<Todo> getAllTodos() {
        return todoService.getAll();
    }
}
