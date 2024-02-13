package com.mehmetberkan.SimpleSpringRedisExample.controller;

import com.mehmetberkan.SimpleSpringRedisExample.service.RedisCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis-cache")
public class RedisCacheController {

    private final RedisCacheService redisCacheService;

    private int count = 0;

    public RedisCacheController(RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if (count == 5) {
            redisCacheService.clearCache();
            count = 0;
        }

        count++;

        return redisCacheService.longRunningMethod();
    }
}
