package com.meko.study.starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;

public class MessageConsumerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        MessageConsumer<Object> consumer = this.vertx.eventBus().consumer("MSG://EVENT/BUS");
        consumer.handler(message -> {
            System.out.println("I have receive the message:" + message.body());
            message.reply(new JsonObject().put("name","meko"));
        });
    }
}
