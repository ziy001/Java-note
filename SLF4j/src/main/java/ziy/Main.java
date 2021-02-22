package ziy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午7:19 2020/12/8
 * @description TODO:
 * @className Main
 */
public class Main {
    public static void main(String[] args) {
        //创建日志记录器，并指定日志记录器的名字
        Logger logger = LoggerFactory.getLogger("testLogger");
        //记录日志信息
        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
        logger.debug("正在调试 {} {}", "now", "warn");
    }
}
