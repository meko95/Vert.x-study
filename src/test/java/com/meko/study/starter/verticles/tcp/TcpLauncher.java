package com.meko.study.starter.verticles.tcp;

import com.meko.study.starter.Launcher.ClusterLauncher;
import com.meko.study.starter.Launcher.Launcher;
import com.meko.study.starter.Launcher.SingleLauncher;
import io.vertx.core.DeploymentOptions;

public class TcpLauncher {
    public static void main(String[] args) throws Exception{
        // 哪种模式？
        final boolean isClustered = false;
        final Launcher launcher = isClustered ? new ClusterLauncher() :
                new SingleLauncher();
        System.out.println(Thread.currentThread().getName() + ","
                + Thread.currentThread().getId());
        launcher.start(vertx -> {
            vertx.deployVerticle("com.meko.study.starter.verticles.tcp.TcpServerVerticle",
                    new DeploymentOptions().setWorker(true),
                        stringAsyncResult -> {
                            if (stringAsyncResult.succeeded()){
                                System.out.println("部署成功");
                            }else {
                                System.out.println("部署失败");
                            }
            });
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

            vertx.deployVerticle("com.meko.study.starter.verticles.tcp.TcpClientVerticle", new DeploymentOptions().setWorker(true),stringAsyncResult -> {
                if (stringAsyncResult.succeeded()){
                    System.out.println("部署成功");
                }
            });
//            vertx.deployVerticle("com.meko.study.starter.verticles.TcpSer",
//                    new DeploymentOptions().setInstances(4), res ->{
//                        if (res.succeeded()){
//                            System.out.println("DeploymentId is "   + res.result());
//                        }
//                    });
        });
    }
}
