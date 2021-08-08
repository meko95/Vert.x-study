package com.meko.study.starter.verticles.tcp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;
import io.vertx.core.net.SocketAddress;

public class TcpClientVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        NetClient netClient = this.vertx.createNetClient();


        netClient.connect(4321,"127.0.0.1",netSocketAsyncResult -> {
           if (netSocketAsyncResult.succeeded()){
               System.out.println("客户端连接成功");
           }else {
               System.out.println("客户端连接失败");
           }
            NetSocket netSocket = netSocketAsyncResult.result();
            Buffer buffer = Buffer.buffer();
            for (int i = 0 ; i < 10 ;i++){
                buffer.appendInt(i);
                netSocket.write(buffer);

            }
//            netSocket.write(buffer);
        });

    }
}
