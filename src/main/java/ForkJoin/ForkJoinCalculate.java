package ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * 有返回结果
 * RecursiveTask
 */
public class ForkJoinCalculate extends RecursiveTask<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 13475679780L;
	
	private long start;
	private long end;
	
	private static final long THRESHOLD = 10L; //临界值
	
	public ForkJoinCalculate(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		long length = end - start;
		
		if(length <= THRESHOLD){
			long sum = 0;
			
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			
			return sum;
		}else{
			long middle = (start + end) / 2;
			
			ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
			left.fork(); //拆分，并将该子任务压入线程队列
			
			ForkJoinCalculate right = new ForkJoinCalculate(middle+1, end);
			right.fork();
			Long leftjoin = left.join();
			Long rightjoin = right.join();
			return  leftjoin+ rightjoin;
		}
		
	}

	public static void main(String[] args) {
		ForkJoinCalculate obj=new ForkJoinCalculate(1,12);
		System.out.println(obj.compute());


	}

}
