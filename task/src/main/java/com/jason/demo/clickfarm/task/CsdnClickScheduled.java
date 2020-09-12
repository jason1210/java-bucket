package com.jason.demo.clickfarm.task;

import com.jason.demo.clickfarm.util.csdn.UrlCrawBoke;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 同步定时任务
 *
 * @author jason
 * @date 2020/3/2
 */
@Slf4j
@Component
public class CsdnClickScheduled {

    /**
     * 同步知乎线索数据
     */
    @Scheduled(cron = "30 * * * * ?")
    public void clickCsdn() {
        log.info("定时刷新csdn点击量");
        try {
            UrlCrawBoke.main(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 刷新百科点击量
     */
    //@Scheduled(cron = "0/1 * * * * ?")
    @Scheduled(cron = "30 * * * * ?")
    public void clickWebBaike() {
        log.info("定时刷新csdn的springboot技术栈博客点击量");
        try {
            UrlCrawBoke.doGet("https://blog.csdn.net/zhu719224032/article/details/107999106");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
