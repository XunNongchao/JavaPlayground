package com.me.play.todo.model.po;


import com.me.play.todo.enums.TaskStatus;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

import java.time.LocalDateTime;

/**
 * Task
 *
 * @author xunnongchao
 * @since 2024/2/2
 */
@MongoEntity(collection = "Task")
public class Task extends ReactivePanacheMongoEntity {

    /**
     * 标题
     */
    public String title;
    /**
     * 内容
     */
    public String content;

    /**
     * 颜色
     */
    public String color;
    /**
     * 图标
     */
    public String icon;

    /**
     * 状态
     */
    public TaskStatus status;

    /**
     * 截止时间
     */
    public LocalDateTime deadline;
    /**
     * 创建时间
     */
    public LocalDateTime createTime;
    /**
     * 更新时间
     */
    public LocalDateTime updateTime;


}
