package com.jason.demo.redisson.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/redisson")
public class RedissonController {

    @Autowired(required = false)
    private RedissonClient redissonClient;

    @RequestMapping("testRedisson")
    public String testRedisson() {
        RLock lock = redissonClient.getLock("testRedissonLock");
        new Thread() {
            @Override
            public void run() {
                RLock lock2 = redissonClient.getLock("testRedissonLock");

                boolean locked2 = false;
                try {
                    Thread.sleep(1000);

                    locked2 = lock2.tryLock(0, 10, TimeUnit.SECONDS);

                    log.info("try locked2..................."+locked2);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.info("获取锁异常2.......................................");
                    return;
                } finally {
                    log.info("finally locked2..................."+locked2);

                    if (!locked2) {
                        log.info("获取锁失败2.......................................");
                        return;
                    }
                    lock.unlock();
                }

            }
        }.start();
        boolean locked = false;
        try {
            locked = lock.tryLock(0, 10, TimeUnit.SECONDS);
            if (locked) {
                Thread.sleep(5000);
                log.info("--------------ok");
                return "ok.......................................";
            } else {
                log.info("获取锁异常.......................................");

                return "获取锁失败.......................................";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "获取锁异常.......................................";
        } finally {
            if (!locked) {
                log.info("获取锁失败.......................................");

                return "获取锁失败";
            }
            lock.unlock();
        }
    }

}
