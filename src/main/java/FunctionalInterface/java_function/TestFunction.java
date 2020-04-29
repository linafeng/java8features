package FunctionalInterface.java_function;

import org.junit.Test;

import java.util.function.Function;

/**
 * @Description: ${description}
 * @Author: lina.feng
 * @Date: 2020/4/29 12:22
 * @Version: 1.0
 */
public class TestFunction {
    //Function<T, R> 函数型接口：
    @Test
    public void test3() {
        String newStr = strHandler("\t\t\t 我大尚硅谷威武   ", (str) -> str.trim());
        System.out.println(newStr);

        String subStr = strHandler("我大尚硅谷威武", (str) -> str.substring(2, 5));
        System.out.println(subStr);
    }

    //需求：用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

}
