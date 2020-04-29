package streamapi;

import entity.Employee2;
import entity.Employee2.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/*
 *  Stream终止操作
 */
public class StreamAPIStopOp {

    List<Employee2> emps = Arrays.asList(
            new Employee2(102, "李四", 59, 6666.66, Status.BUSY),
            new Employee2(101, "张三", 18, 9999.99, Status.FREE),
            new Employee2(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee2(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee2(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee2(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee2(105, "田七", 38, 5555.55, Status.BUSY)
    );

    //3. 终止操作
	/*
		allMatch——检查是否匹配所有元素
		anyMatch——检查是否至少匹配一个元素
		noneMatch——检查是否没有匹配的元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素
		count——返回流中元素的总个数
		max——返回流中最大值
		min——返回流中最小值
	 */
    @Test
    public void test1() {
        //allMatch,anyMatch,noneMatch
        boolean bl = emps.stream()
                .allMatch((e) -> e.getStatus().equals(Status.BUSY));
        boolean bl1 = emps.stream()
                .anyMatch((e) -> e.getStatus().equals(Status.BUSY));
        boolean bl2 = emps.stream()
                .noneMatch((e) -> e.getStatus().equals(Status.BUSY));
    }

    @Test
    public void test2() {
        Optional<Employee2> op = emps.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();

        System.out.println(op.get());

        System.out.println("--------------------------------");

        Optional<Employee2> op2 = emps.parallelStream()
                .filter((e) -> e.getStatus().equals(Status.FREE))
                .findAny();

        System.out.println(op2.get());
    }

    @Test
    public void test3() {
        //max,min
        long count = emps.stream()
                .filter((e) -> e.getStatus().equals(Status.FREE))
                .count();

        System.out.println(count);

        Optional<Double> op = emps.stream()
                .map(Employee2::getSalary)
                .max(Double::compare);

        System.out.println(op.get());

        Optional<Employee2> op2 = emps.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println(op2.get());
    }

    //注意：流进行了终止操作后，不能再次使用
    @Test
    public void test4() {
        Stream<Employee2> stream = emps.stream()
                .filter((e) -> e.getStatus().equals(Status.FREE));

        long count = stream.count();

        stream.map(Employee2::getSalary)
                .max(Double::compare);
    }
}
