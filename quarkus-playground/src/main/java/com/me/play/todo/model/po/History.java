package com.me.play.todo.model.po;


import com.me.play.todo.enums.HistoryType;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

/**
 * History
 * 编辑记录
 *
 * @author xunnongchao
 * @since 2024/2/2
 */
@MongoEntity(collection = "History")
public class History extends ReactivePanacheMongoEntity {

    private HistoryType type;
}
