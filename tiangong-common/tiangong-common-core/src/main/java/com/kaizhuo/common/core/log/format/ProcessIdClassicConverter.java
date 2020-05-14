package com.kaizhuo.common.core.log.format;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.log.format
 * @description:
 * @author: miaochen
 * @create: 2020-05-14 20:46
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class ProcessIdClassicConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        return name.substring(0, name.indexOf("@"));
    }
}
