package FunctionalInterface;

import entity.Employee;
import org.junit.Test;

import java.util.*;

/**
 * @Description: ${description}
 * @Author: lina.feng
 * @Date: 2020/4/29 11:49
 * @Version: 1.0
 */
public class TestCommomFilter {
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );




    //优化方式四：Stream API
    @Test
    public void test7() {
        emps.stream()
                .filter((e) -> e.getAge() <= 35)
                .forEach(System.out::println);
        emps.stream()
                .map(Employee::getName)
                .limit(3)
                .sorted()
                .forEach(System.out::println);
    }

}
