/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.sh.lmg.job;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.sh.lmg.json.fastjson.FastJsonUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class SimpleJobDemo extends AbstractSimpleElasticJob {

    @Override
    public void process(final JobExecutionMultipleShardingContext context) {

        List<Integer> shardingItems = context.getShardingItems();
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------------华丽的睡眠线-------------------------------------");

        System.out.println("SimpleJobDemo.process : jobName[" + context.getJobName() + "] jobParamter[" + context.getJobParameter() + "] sharding items" +
                FastJsonUtil.bean2Json(context.getShardingItems()) + "offset : " + FastJsonUtil.bean2Json(context.getOffsets()));
        System.out.println("------------------------------------------华丽的分割线-------------------------------------");
    }
}
