package 计算浮点数;

/**
 * @author ZIY
 * @version 1.0
 * @date 2020/12/27 下午6:03
 * @description
 * TODO:啤酒 2.3元，饮料 1.9元 小明花了82.3元  啤酒数量 < 饮料数量。问 买了多少啤酒
 * @className 啤酒和饮料
 */
/*
设 啤酒数量:x个，饮料数量 y个
 */
public class 啤酒和饮料 {
    public static void main(String[] args) {
        test1();
//        BigDeci
    }
    public static void test1() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (23 * i + 19 * j == 823 && i < j) {
                    System.out.println("啤酒:" + i + "饮料:" + j);
                }
            }
        }
    }
}
