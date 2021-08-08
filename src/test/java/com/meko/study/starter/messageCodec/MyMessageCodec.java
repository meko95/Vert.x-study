package com.meko.study.starter.messageCodec;

import com.meko.study.starter.entity.UserInfo;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;

public class MyMessageCodec implements MessageCodec<UserInfo,UserInfo> {

    @Override
    public void encodeToWire(Buffer buffer, UserInfo userInfo) {

    }

    @Override
    public UserInfo decodeFromWire(int i, Buffer buffer) {
        return null;
    }

    @Override
    public UserInfo transform(UserInfo userInfo) {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public byte systemCodecID() {
        return 0;
    }
}
