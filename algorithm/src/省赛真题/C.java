package 省赛真题;

/**
 * @author ZIY
 * @version 1.0
 * @date 2020/12/27 下午12:32
 * @description TODO:跑步锻炼
 *              TODO:判断闰年
 * @className C
 */
public class C {
    public static void main(String[] args) {
        System.out.println(test1());
    }
    public static int test1() {
        int km = 0;
        DayOfWeek dayOfWeek = new DayOfWeek(6);
        //表示一年的每月的天数
        int[] months = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //循环到2020年
        for (int year = 2000; year <= 2020; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                //闰年
                months[1] = 29;
            } else {
                //平年
                months[1] = 28;
            }
            //调用方法，返回当年的一个跑步路程
            int plus = plus(year, km, dayOfWeek, months);
            km = plus;
        }
        return km;
    }
    public static int plus(int year, int km, DayOfWeek dayOfWeek, int[] months) {
        int max = months.length;
        if (year == 2020) {
            max = 9;
            km += 2;
        }
        for (int i = 0; i < max; i++) {
            //每个月1号
            km += 2;
            dayOfWeek.plusOneDay();
            for (int j = 2; j <= months[i]; j++) {
                if (dayOfWeek.getValue() == 1) {
                    km += 2;
                } else {
                    km++;
                }
                dayOfWeek.plusOneDay();
            }
        }
        return km;
    }
    private static class DayOfWeek {
        int value;
        DayOfWeek(int day) {
            this.value = day;
        }

        public void plusOneDay() {
            value++;
            if (value > 7) {
                value = 1;
            }
        }
        public int getValue() {
            return value;
        }
    }
}
