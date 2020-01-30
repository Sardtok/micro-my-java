package mn.todo;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import mn.todo.model.ToDo;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Controller("/todos")
public class ToDoController {

    @Inject
    ToDoRepository repository;

    @Get
    public Collection<ToDo> listToDos() {
        return repository.getToDos();
    }

    @Get("{uuid}")
    public ToDo getToDo(UUID uuid) {
        return repository.getToDo(uuid);
    }

    @Post(consumes=MediaType.APPLICATION_JSON)
    public CompletableFuture<UUID> createToDo(@Body CompletableFuture<ToDo> newToDo) {
        return newToDo.thenApply(todo -> repository.createToDo(todo));
    }

    @Put("{uuid}")
    public ToDo updateToDo(UUID uuid, @Body @NotNull ToDo updatedToDo) {
        return repository.updateToDo(uuid, updatedToDo);
    }
}
