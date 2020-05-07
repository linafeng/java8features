package FunctionalInterface.java_consumer;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Description: ${description}
 * @Author: lina.feng
 * @Date: 2020/4/29 12:22
 * @Version: 1.0
 */
public class TestConsumer {

    /**
     * rt.jar java.util.function包里面有很多函数式接口
     */
    @Test
    public void test8() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("我大尚硅谷威武！");
    }


    //Consumer<T> 消费型接口 :
    @Test
    public void test1() {
        happy(10000, (m) -> System.out.println("你们刚哥喜欢大宝剑，每次消费：" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

   /* public static void main(String[] args) {
        BinaryOperator<Integer> add = Integer::sum;
        BinaryOperator<Integer> subtraction = (a, b) -> a - b;
        System.out.println(subtraction.apply(add.apply(1, 2), 3));
    }*/

}
