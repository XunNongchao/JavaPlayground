package com.me.play.todo.model.po;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

/**
 * User
 *
 * @author xunnongchao
 * @since 2024/2/4
 */
@MongoEntity(collection = "User")
public class User extends ReactivePanacheMongoEntity {
}
