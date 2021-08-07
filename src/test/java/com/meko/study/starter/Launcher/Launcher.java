package com.meko.study.starter.Launcher;

import io.vertx.core.Vertx;

import java.util.function.Consumer;

public interface Launcher {
    void start(Consumer<Vertx> startConsumer);

}
