package ForkJoin;

import java.util.concurrent.RecursiveAction;

/**
 * 无返回结果
 * RecursiveTask
 */
public class ForkJoinCalculateVoid extends RecursiveAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 13475679780L;

	private long start;
	private long end;

	private static final long THRESHOLD = 10L; //临界值

	public ForkJoinCalculateVoid(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected void compute() {
		long length = end - start;
		
		if(length <= THRESHOLD){
			for (long i = start; i <= end; i++) {
				System.out.println(Thread.currentThread().getName()+"i的值"+i);
			}

		}else{
			long middle = (start + end) / 2;
			ForkJoinCalculateVoid left = new ForkJoinCalculateVoid(start, middle);
			ForkJoinCalculateVoid right = new ForkJoinCalculateVoid(middle+1, end);
			left.fork(); //拆分，并将该子任务压入线程队列
			right.fork();
			left.join();
			right.join();
		}
		
	}

	public static void main(String[] args) {
		ForkJoinCalculateVoid obj=new ForkJoinCalculateVoid(1,12);
		obj.compute();


	}

}
