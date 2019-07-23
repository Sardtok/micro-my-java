package mn.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.UUID;

@Valid
@Data
@Builder(toBuilder=true)
@RequiredArgsConstructor
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
public class ToDo {
    @Null
    UUID uuid;
    @Null
    String text;
    @Null
    Boolean completed;
}
