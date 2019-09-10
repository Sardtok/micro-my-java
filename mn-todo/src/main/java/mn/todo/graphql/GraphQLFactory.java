package mn.todo.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.coxautodev.graphql.tools.SchemaParserBuilder;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class GraphQLFactory {
    @Bean
    @Singleton
    public GraphQL graphQL(ToDoQueryResolver toDoQueryResolver) {
        SchemaParserBuilder builder = SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(toDoQueryResolver);
        GraphQLSchema schema = builder.build().makeExecutableSchema();
        return GraphQL.newGraphQL(schema).build();
    }
}
