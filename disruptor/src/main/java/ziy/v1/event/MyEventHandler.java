package ziy.v1.event;

import com.lmax.disruptor.EventHandler;
import ziy.v1.event.Event;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:38 2020/11/10
 * @description TODO:消费者
 * @className EventHandler
 */
public class MyEventHandler implements EventHandler<Event> {
    private static int count = 0;
    /**
     * 消费方法
     * @param event 事件对象
     * @param sequence 位置
     * @param b 指明是不是最后一个元素
     * @throws Exception
     */
    @Override
    public void onEvent(Event event, long sequence, boolean b) throws Exception {
        //记录个数
        count++;
        System.out.println(event+"     "+ sequence +"     "+b);
    }
}
