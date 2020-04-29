package FunctionalInterface;

import entity.Employee;
import org.junit.Test;

import java.util.*;

public class TestFuncFilter {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //策略设计模式
    private List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp) {
        List<Employee> list = new ArrayList<>();
        emps.forEach(e -> {
            if (mp.test(e)) {
                list.add(e);
            }
        });
        return list;
    }


    //Lambda 表达式
    @Test
    public void test1() {
        List<Employee> list = filterEmployee(emps, (e) -> e.getAge() <= 35);
        list.forEach(System.out::println);
    }


    @Test
    public void test1_2() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
    }

    private Integer operation(Integer num, MyFun mf) {
        return mf.getValue2(num);
    }

    //--------------------------------------------------------------

    //匿名内部类
    @Test
    public void test2() {
        List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee t) {
                return t.getId() <= 103;
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }


    @Test
    public void test3() {
        List<Employee> list = filterEmployee(emps, new FilterEmployeeForAge());
        list.forEach(System.out::println);
        List<Employee> list2 = filterEmployee(emps, new FilterEmployeeForSalary());
        list2.forEach(System.out::println);
    }


}
