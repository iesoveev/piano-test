package com.piano.test.dto;

import com.alibaba.fastjson.JSON;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public final class Response {

    private final Boolean success;

    private final String description;

    public Response(String description) {
        this.success = false;
        this.description = description;
    }

    @Override
    public String toString() {
        Map<String, Object> res = new HashMap<>();
        res.put("success", success);
        res.put("description", description);
        byte[] json = JSON.toJSONString(res).getBytes(StandardCharsets.UTF_8);
        return new String(json, StandardCharsets.UTF_8);
    }
}
