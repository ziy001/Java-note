package ziy.v1;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import ziy.v1.event.Event;
import ziy.v1.event.MyEventFactory;
import ziy.v1.event.MyEventHandler;

import java.util.concurrent.Executors;

/**
 * @author ziy
 * @version 1.0
 * @date 下午7:23 2020/11/10
 * @description TODO:入门示例程序之lambda形式
 * @className MainTestLambda
 */
public class MainTestLambda {
    public static void main(String[] args) {
        Disruptor<Event> disruptor = new Disruptor<Event>(
                Event::new, 1024, Executors.defaultThreadFactory()
        );
        disruptor.handleEventsWith((event, sequence, end) ->
                System.out.println(event+"     "+ sequence +"     "+end));
        disruptor.start();
        //使用EventTranslator发布
        RingBuffer<Event> ringBuffer = disruptor.getRingBuffer();
        ringBuffer.publishEvent((event, sequence) -> event.setValue("lambda表达式示例程序"));
        ringBuffer.publishEvent((event, sequence, params) -> {
            String value = "";
            for (Object param : params) {
                value += param;
            }
            event.setValue(value);
        }, "v", "a", "r", "a", "r", "g");
    }
}
