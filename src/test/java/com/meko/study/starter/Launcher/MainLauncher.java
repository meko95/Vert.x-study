package com.meko.study.starter.Launcher;

import io.vertx.core.Context;

public class MainLauncher {

    public static void main(String[] args) {
        final boolean isClustered = false;
        final Launcher launcher = isClustered ? new ClusterLauncher() :
                new SingleLauncher();
        System.out.println(Thread.currentThread().getName() + ","
                + Thread.currentThread().getId());
        launcher.start(vertx -> {
            // 执行Vertx相关后续逻辑
            // TODO ： 主逻辑
            final Context context = vertx.getOrCreateContext();
            context.put("data","hello");
            context.runOnContext(v -> {
                System.out.println(Thread.currentThread().getName() + ","
                        + Thread.currentThread().getId()
                        + ", This will be executed async ->" + v);
                Object hello = context.get("hello");
            });
        });
    }
}
