package FunctionalInterface.java_predicate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */
public class TestPredicate {

    //Predicate<T> 断言型接口：
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);
        strList.forEach(System.out::println);
    }

    //需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        list.forEach(str -> {
            if (pre.test(str)) {
                strList.add(str);
            }
        });
        return strList;
    }

    /**
     * BiPredicate 相比Predicate他有2个参数
     */
    @Test
    public void refMethod() {
        //原本
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("abcde", "abcde"));
        //类名 :: 实例方法名
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("abc", "abc"));

    }
    @Test
    public void refMethod2() {
        BiPredicate<Foo, Integer> bp2 = Foo::say;
        System.out.println(bp2.test(new Foo(1), 1));
    }




}
