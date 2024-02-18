package com.me.play.todo.api;

import com.me.play.todo.model.converter.TaskConverter;
import com.me.play.todo.model.dto.TaskParam;
import com.me.play.todo.model.po.Task;
import io.smallrye.mutiny.Uni;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * TaskApi
 *
 * @author xunnongchao
 * @since 2024/2/5
 */
@Path("task")
@Produces(MediaType.APPLICATION_JSON)
public class TaskApi {

    private final TaskConverter taskConverter;

    public TaskApi(TaskConverter taskConverter) {
        this.taskConverter = taskConverter;
    }

    @GET
    @Path("listAll")
    public Uni<List<Task>> listAll() {
        return Task.listAll();
    }

    @POST
    @Path("persist")
    public Uni<Void> persist(@NotEmpty List<TaskParam> tasks) {
        return Task.persistOrUpdate(taskConverter.toPoList(tasks));
    }

    @DELETE
    @Path("deleteById/{id}")
    public Uni<Boolean> deleteById(@NotBlank String id) {
        return Task.deleteById(new ObjectId(id));
    }

    @DELETE
    @Path("deleteSelective")
    public Uni<Void> deleteSelective(@NotNull TaskParam param) {
        return taskConverter.toPo(param).delete();
    }
}
