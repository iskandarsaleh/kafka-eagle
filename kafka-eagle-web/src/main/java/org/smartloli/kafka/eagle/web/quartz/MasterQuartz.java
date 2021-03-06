/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.smartloli.kafka.eagle.web.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smartloli.kafka.eagle.common.util.CalendarUtils;
import org.smartloli.kafka.eagle.common.util.KConstants;
import org.smartloli.kafka.eagle.common.util.KConstants.MBean;
import org.smartloli.kafka.eagle.common.util.SystemConfigUtils;
import org.smartloli.kafka.eagle.common.util.WorkUtils;

import java.util.List;

/**
 * Used to periodically generate all tasks and issue work node execution policy.
 *
 * @author smartloli.
 * <p>
 * Created by Jul 06, 2020
 */
public class MasterQuartz {

    private final Logger LOG = LoggerFactory.getLogger(MasterQuartz.class);
    private static final String[] MBEAN_TASK_KEYS = new String[]{MBean.MESSAGEIN, MBean.BYTEIN, MBean.BYTEOUT, MBean.BYTESREJECTED, MBean.FAILEDFETCHREQUEST, MBean.FAILEDPRODUCEREQUEST, MBean.TOTALFETCHREQUESTSPERSEC, MBean.TOTALPRODUCEREQUESTSPERSEC, MBean.REPLICATIONBYTESINPERSEC, MBean.REPLICATIONBYTESOUTPERSEC, MBean.PRODUCEMESSAGECONVERSIONS, MBean.OSTOTALMEMORY, MBean.OSFREEMEMORY, MBean.CPUUSED};


    public void masterJobQuartz() {
        // whether is enable distributed
        if (SystemConfigUtils.getBooleanProperty("kafka.eagle.distributed.enable")) {
            jobForAllTasks();
        } else {

        }
    }

    private void jobForAllTasks() {
        String[] clusterAliass = SystemConfigUtils.getPropertyArray("kafka.eagle.zk.cluster.alias", ",");
        // get all kafka eagle work node
        List<String> workNodes = WorkUtils.getWorkNodes();
        for (String clusterAlias : clusterAliass) {
            // get all topics

            // get all consumer groups and topic

            // get all
        }
    }

}
