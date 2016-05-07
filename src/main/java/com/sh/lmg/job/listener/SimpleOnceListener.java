
package com.sh.lmg.job.listener;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.api.listener.AbstractDistributeOnceElasticJobListener;

public class SimpleOnceListener extends AbstractDistributeOnceElasticJobListener {


    private final long startedTimeoutMilliseconds;

    private final long completedTimeoutMilliseconds;

    public SimpleOnceListener(final long startedTimeoutMilliseconds, final long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
        this.startedTimeoutMilliseconds = startedTimeoutMilliseconds;
        this.completedTimeoutMilliseconds = completedTimeoutMilliseconds;
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(final JobExecutionMultipleShardingContext shardingContext) {
        System.out.println("doBeforeJobExecutedAtLastStarted:" + shardingContext.getJobName());
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(final JobExecutionMultipleShardingContext shardingContext) {
        System.out.println("doAfterJobExecutedAtLastCompleted:" + startedTimeoutMilliseconds + "," + completedTimeoutMilliseconds);
    }
}
