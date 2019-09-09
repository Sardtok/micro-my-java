package mn.todo;

import io.micronaut.http.HttpStatus;
import mn.todo.model.ToDo;

import javax.inject.Singleton;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import io.micronaut.http.exceptions.HttpStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class ToDoRepository {
    Logger logger = LoggerFactory.getLogger(ToDoRepository.class);
    Map<UUID, ToDo> store = new ConcurrentHashMap<>();

    public ToDo getToDo(UUID uuid) {
        return store.get(uuid);
    }

    public Collection<ToDo> getToDos() {
        return store.values();
    }

    public UUID createToDo(ToDo toDo) {
        logger.info(toDo.toString());
        toDo.setUuid(UUID.randomUUID());
        store.put(toDo.getUuid(), toDo);
        return toDo.getUuid();
    }

    public ToDo updateToDo(UUID uuid, ToDo updatedToDo) {
        ToDo toDo = store.get(uuid);
        if (toDo == null) {
            throw new HttpStatusException(HttpStatus.NOT_FOUND, "No such To Do");
        }

        if (updatedToDo.getCompleted() != null) {
            toDo.setCompleted(updatedToDo.getCompleted());
        }

        if (updatedToDo.getText() != null) {
            toDo.setText(updatedToDo.getText());
        }

        store.put(uuid, toDo);
        return toDo;
    }
}
