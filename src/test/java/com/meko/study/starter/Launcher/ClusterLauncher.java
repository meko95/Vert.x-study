package com.meko.study.starter.Launcher;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.function.Consumer;

public class ClusterLauncher implements Launcher{
    @Override
    public void start(Consumer<Vertx> startConsumer) {
        final VertxOptions options  = new VertxOptions();
        Vertx.clusteredVertx(options,handler -> {
            if (handler.succeeded()){
                final Vertx vertx = handler.result();
                if (null != vertx){
                    startConsumer.accept(vertx);
                }
            }else {
                final Throwable ex = handler.cause();
                if (null != ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
