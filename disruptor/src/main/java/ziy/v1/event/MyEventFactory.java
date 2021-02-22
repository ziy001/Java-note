package ziy.v1.event;

import com.lmax.disruptor.EventFactory;
import ziy.v1.event.Event;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:28 2020/11/10
 * @description TODO:Event事件的产生工厂
 * @className EventFactory
 */
public class MyEventFactory implements EventFactory<Event> {
    /**
     * 事件的创建工厂
     * @return
     */
    @Override
    public Event newInstance() {
        return new Event();
    }
}
