package com.me.play.todo.model.converter;

import com.me.play.todo.model.dto.TaskParam;
import com.me.play.todo.model.po.Task;
import io.quarkus.runtime.util.StringUtil;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * TaskConverter
 *
 * @author xunnongchao
 * @since 2024/2/6
 */
@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface TaskConverter {

    Task toPo(TaskParam task);
    List<Task> toPoList(List<TaskParam> list);

    default String toString(ObjectId id) {
        return id.toString();
    }

    default ObjectId toObjectId(String id) {
        return StringUtil.isNullOrEmpty(id) ? new ObjectId() : new ObjectId(id);
    }
}
