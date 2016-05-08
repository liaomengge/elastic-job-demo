package com.sh.lmg.job;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.sh.lmg.json.fastjson.FastJsonUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SimpleJobDemo extends AbstractSimpleElasticJob {

    private final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private List<Person> list = new ArrayList<>();

    @Override
    public void process(final JobExecutionMultipleShardingContext context) {
        initData();

        List<Integer> shardingItems = context.getShardingItems();
        int shardingTotalCount = context.getShardingTotalCount();
        for (Person person : list) {
            int id = person.getId();
            if (shardingItems.indexOf(id % shardingTotalCount) != -1) {
                System.out.println(DateFormatUtils.format(new Date(), DATE_FORMAT) + " ---- SimpleJobDemo.process : " + "total count : " + shardingTotalCount + ", sharding items : " + FastJsonUtil.bean2Json(shardingItems)
                        + ", json : " + FastJsonUtil.bean2Json(person));
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void initData() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(new Person(i, "lmg" + i, 20 + i));
        }
    }
}

class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}