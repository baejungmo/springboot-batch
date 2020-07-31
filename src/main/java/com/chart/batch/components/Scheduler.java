package com.chart.batch.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Scheduler {

    @Autowired
    RstasticsRepo rstasticsRepo;
    @Transactional
    @Scheduled(cron = "*/10 * * * * *")
    public void Helloworld(){
        System.out.println("Current Thread : " + Thread.currentThread().getName());
        rstasticsRepo.insertData();
    }
}
