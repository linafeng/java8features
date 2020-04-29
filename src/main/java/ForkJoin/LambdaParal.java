package ForkJoin;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Description: ${description}
 * @Author: lina.feng
 * @Date: 2020/4/29 16:04
 * @Version: 1.0
 */
public class LambdaParal {
    public static void main(String[] args) {
        Long sum = LongStream.rangeClosed(0L, 10000000000L)
                .parallel()
                .sum();
    }

    @Test
    public void test1(){
        ForkJoinPool pool = new ForkJoinPool();

       // ForkJoinTask<Long> task = new ForkJoinCalculate(1L, 12L);
       // long sum = pool.invoke(task);
        //System.out.println(sum);

        ForkJoinTask action=new ForkJoinCalculateVoid(1,12L);
        pool.execute(action);
        //pool.shutdown();
    }

}
