package com.chart.batch.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RstasticsRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // bookNum = 현재 bcount 합 - 그동안 bookNum의 합, DB에 있는 최근 날짜 + 1
    public void insertData(){
        jdbcTemplate.batchUpdate("insert into rental_statistics(bookNum, currentDate) values" +
                "(" +
                "    NVL((select sum(bcount) from booklist) - " +
                "    (select sum(bookNum) from rental_statistics), 0)" +
                ", " +
                "NVL((select * from(" +
                    " select max(currentdate)" +
                    " from rental_statistics" +
                    " ))+1 , sysdate" +
                "))");
    }
}
