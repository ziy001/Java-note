package ziy.v1;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import ziy.v1.event.Event;
import ziy.v1.event.MyEventFactory;
import ziy.v1.event.MyEventHandler;

import java.util.concurrent.Executors;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:13 2020/11/10
 * @description TODO:Disruptor框架的入门使用
 * @className MainTest1
 */
public class MainTest1 {
    public static void main(String[] args) {
        /*
        第一个参数:指定Event事件的创建工厂,在程序开始的时候它会通过工厂创建Event事件并填满整个RingBuffer后续只修饰事件属性避免再new 减少GC频率
        第二个参数:指定RingBuffer的size
        第三个参数:创建消费者线程的线程工厂
         */
        Disruptor<Event> disruptor = new Disruptor<>(
                new MyEventFactory(), 1024, Executors.defaultThreadFactory());
        //指定消费处理类
        disruptor.handleEventsWith(new MyEventHandler());
        //启动
        disruptor.start();

        //生产
        RingBuffer<Event> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();
        try {
            //获取指定位置上的事件
            Event event = ringBuffer.get(sequence);
            event.setValue("最简单的示例程序");
        }
        finally {
            //将指定序号发布
            ringBuffer.publish(sequence);
        }


    }
}
