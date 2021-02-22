package ziy.v1.event;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:15 2020/11/10
 * @description TODO:Event事件
 * @className Event
 */
public class Event {
    private String value = "";

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Event{" +
                "value='" + value + '\'' +
                '}';
    }
}
