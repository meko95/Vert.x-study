package com.meko.study.starter.verticles.tcp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;

public class TcpServerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        NetServerOptions options = new NetServerOptions().setPort(4321);
        NetServer netServer = this.vertx.createNetServer(options);
        netServer.connectHandler(netSocket -> {
            //这里处理传入的连接
            System.out.println(netSocket.remoteAddress());
            netSocket.handler(buffer -> {
                float aFloat = buffer.getFloat(0);
                System.out.println("I received some bytes: " + buffer.length());
                System.out.println("I received a float:" + aFloat);
            });
        });
        netServer.listen(res -> {
            if (res.succeeded()){
                System.out.println("Server is now listening");

            }else {
                System.out.println("Failed to bind!");
            }
        });
    }
}
