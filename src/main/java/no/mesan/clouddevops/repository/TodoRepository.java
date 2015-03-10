package no.mesan.clouddevops.repository;

import no.mesan.clouddevops.domain.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}
