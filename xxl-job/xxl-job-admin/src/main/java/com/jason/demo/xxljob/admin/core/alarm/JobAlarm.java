package com.jason.demo.xxljob.admin.core.alarm;

import com.jason.demo.xxljob.admin.core.model.XxlJobInfo;
import com.jason.demo.xxljob.admin.core.model.XxlJobLog;

/**
 * @author jason 2020-01-19
 */
public interface JobAlarm {

    /**
     * job alarm
     *
     * @param info
     * @param jobLog
     * @return
     */
    public boolean doAlarm(XxlJobInfo info, XxlJobLog jobLog);

}
