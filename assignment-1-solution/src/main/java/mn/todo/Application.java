package mn.todo;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.runtime.Micronaut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.Optional;

@Controller("/hello")
public class Application {

    @Get(uri="{/name}",produces = MediaType.TEXT_PLAIN)
    public String hello(@Nullable String name) {
        return String.format("Hello, %s!", Optional.ofNullable(name).orElse("World"));
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
