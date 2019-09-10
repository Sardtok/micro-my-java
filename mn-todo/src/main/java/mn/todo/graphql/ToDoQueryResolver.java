package mn.todo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import mn.todo.ToDoRepository;
import mn.todo.model.ToDo;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;

@Singleton
public class ToDoQueryResolver implements GraphQLQueryResolver {
    @Inject
    ToDoRepository repository;

    public Collection<ToDo> toDos() {
        return repository.getToDos();
    }
}
