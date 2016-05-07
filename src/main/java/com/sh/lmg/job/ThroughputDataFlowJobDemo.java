package com.sh.lmg.job;

import com.dangdang.ddframe.job.internal.job.AbstractJobExecutionShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.dataflow.AbstractIndividualThroughputDataFlowElasticJob;

import java.util.List;

/**
 * Created by liaomengge on 16/5/7.
 */
public class ThroughputDataFlowJobDemo extends AbstractIndividualThroughputDataFlowElasticJob {
    @Override
    public List fetchData(AbstractJobExecutionShardingContext abstractJobExecutionShardingContext) {
        return null;
    }

    @Override
    public boolean isStreamingProcess() {
        return true;
    }

    @Override
    public boolean processData(AbstractJobExecutionShardingContext abstractJobExecutionShardingContext, Object o) {
        return false;
    }
}
