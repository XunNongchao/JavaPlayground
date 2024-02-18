package com.me.play.todo.model.po;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

/**
 * TaskGroup
 *
 * @author xunnongchao
 * @since 2024/2/2
 */
@MongoEntity(collection = "TaskGroup")
public class TaskGroup extends ReactivePanacheMongoEntity {
}
