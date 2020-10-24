package com.hengyunsoft.platform.security;
import java.util.Random;
/**
 * 登录循环计数器
 * 
 * 循环计数登录，而且保证在一个合理的周期内不会被覆盖。
 * 
 * @author 潘定遥
 *
 */
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 
 * start_random_bit： 启动随机数所占用的最大位数，比如占用5bit，那么随机数取值范围是[0,2^6-1] <=> [0,63] <br>
 * counter_bit: 计数器所占用的最大位数，比如是27bit，那么计数器的取值范围是： [1,2^28-1] <=> [1,268435455]<br>
 * 登录循环计数器。<br>
 * 支持系统的重启（但是也不要太频繁）<br>
 * 登录循环标记是存储在int数据类型中，占用32位。<br>
 * 我使用高位start_random_bit表示启动随机数占用的位数，使用低位counter_bit表示计数器所占用的位数。<br>
 * 表示形式如下<br>
 *     sssssssccccccccccccccccccccccccc<br>
 * 因为在重启后，导致以前已经在使用中的登录计数被重复使用，引发用户登录成功，但是网关一直认为用户登录失败。<br>
 * 网关中的登录用户计数会设置过期时间，比如设置过期时间是30分钟，那么30分钟过后，过期的计数器可以被重用。<br>
 * 计数器的取值范围是[1,(1&lt;&lt;counter_bit)-1].<br>
 * 重启会导致还未过期的计数被重复使用，导致用户登录后，网关哪里依然断定用户未登录，所以使用start_random_bit来标示启动码，<br>
 * 这是一个随机数，在启动频繁的情况下面，肯定希望冲突极小，那么可以将此划分更多的位数。<br>
 * @author 潘定遥
 *
 */
public class LoginCycleCounter {

	/**
	 * 计数器所占用的位数
	 */
	public final static byte counter_bit = 25;
	/**
	 * 启动随机数所占用的位数   
	 */
	public final static byte start_random_bit = 32-counter_bit;
	
	/**
	 * 最大计数器
	 * 计数不允许超过此值，但是可以等于此值。最大计数器是： 2^26-1 <=> (1<<(counter_bit))-1
	 */
	public static final int max_counter = (1<<(counter_bit))-1;
	
	/**
	 * 启动数据数模板
	 * 通过start_random_bit进行随机取值，并且移到了高位。
	 */
	public final int start_random_num;
	
	public final AtomicInteger count;
	
	public LoginCycleCounter() {
		

		Random random = new Random();
		
		int startRandom = random.nextInt(1<<(start_random_bit)) ;
		startRandom = startRandom << counter_bit ;
		start_random_num = startRandom;
		count = new AtomicInteger(1);
	}
	
	/**
	 * 值将从1~{@link LoginCycleCounter#count}中递增循环出现
	 * 
	 * @return
	 */
	public int nextCount() {
		
		int result ;
		do {
			//一定要先计算，在取值，否则后面的cas将永远不会成功。
			result = count.incrementAndGet();
			if(result > max_counter && count.compareAndSet(result, 2)) {
				//超过阀值，并且cas重新计数设置成功。
				result = 1;
			} 
			//一定要包在一个循环中，因为重置计数器仅有一个线程能搞定，而别的线程都是被拒绝的，
			//故被拒绝的线程需要重新获取计数器。
		}while(result > max_counter);
		
		//最终结果是计数器值 与上 启动数据模板
		return result | start_random_num;
	}
	
//	public int nextCount() {
//		
//		int result = count.getAndIncrement();  ①
//		if(result <= max_counter) {
//			return result;
//		} else if(count.compareAndSet(result, 2)) {  //这里存储一个严重的bug。不好排查，在多线程的环境下，很多的线程
	//在①处获取并递增了计数器，但是当第一个线程在执行cas时，期望值已经不再是它所拥有的result了，比如后一个线程刚刚完成getAndIncrement。
	//那么他的cas失败，而他执行②时获取的值就超出了阀值max_counter。故使用do-while去包装。防止这个bug的出现
//			return 1; // 仅仅有一个线程能够修改成功。修改失败的线程将会在后面重新获取数据。
//		}
//		return count.getAndIncrement(); ②
//	}
}
