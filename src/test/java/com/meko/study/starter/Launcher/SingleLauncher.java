package com.meko.study.starter.Launcher;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.function.Consumer;

public class SingleLauncher implements Launcher{
    @Override
    public void start(Consumer<Vertx> startConsumer) {
       final VertxOptions vertxOptions = new VertxOptions();
       final Vertx vertx = Vertx.vertx(vertxOptions);
       if (null != vertx){
           startConsumer.accept(vertx);
       }
    }
}
