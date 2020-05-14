package com.kaizhuo.common.core.log.format;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.log.format
 * @description:
 * @author: miaochen
 * @create: 2020-05-14 20:48
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class EasyHighlightingCompositeConverter extends ForegroundCompositeConverterBase<ILoggingEvent> {

    /**
     * 打印颜色
     * @param event
     * @return
     */
    @Override
    protected String getForegroundColorCode(ILoggingEvent event) {
        switch (event.getLevel().toInt()) {
            case Level.ERROR_INT:
                //红色
                return ANSIConstants.RED_FG;
            case Level.WARN_INT:
                //黄色
                return ANSIConstants.YELLOW_FG;
            case Level.INFO_INT:
                //绿色
                return ANSIConstants.GREEN_FG;
            case Level.DEBUG_INT:
                //
                return ANSIConstants.MAGENTA_FG;
            default:
                //默认白色
                return ANSIConstants.WHITE_FG;
        }
    }
}
