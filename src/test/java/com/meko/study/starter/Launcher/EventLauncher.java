package com.meko.study.starter.Launcher;

import com.meko.study.starter.messageCodec.MyMessageCodec;
import io.vertx.core.DeploymentOptions;

public class EventLauncher {
    public static void main(String[] args) {
        // 哪种模式？
        final boolean isClustered = false;
        final Launcher launcher = isClustered ? new ClusterLauncher() :
                new SingleLauncher();
        System.out.println(Thread.currentThread().getName() + ","
                + Thread.currentThread().getId());
        launcher.start(vertx -> {
            vertx.eventBus().registerCodec(new MyMessageCodec());
            // 发布Standard
            vertx.deployVerticle("com.meko.study.starter.verticles.AcceptorVerticle",
                    new DeploymentOptions().setInstances(4),res ->{
                        if (res.succeeded()){
                            System.out.println("DeploymentId is "   + res.result());
                        }
                    });
            // 发布Worker
            vertx.deployVerticle("com.meko.study.starter.verticles.WorkerVerticle",
                    new DeploymentOptions().setWorker(true).setInstances(8));            // 发布Worker
            vertx.deployVerticle("com.meko.study.starter.verticles.MessageConsumerVerticle",
                    new DeploymentOptions().setWorker(true).setInstances(6));
        });
        System.out.println(1);
    }

}
