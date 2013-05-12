package com.joyveb;

/**
 * @Title: RunnableTest.java
 * @Package com.joyveb
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 杨其桔
 * @date 2013-5-9 下午10:39:47
 * @version V1.0
 */
public class RunnableTest {

	public static void main(String[] args) {
		RunnableBean test1 = new RunnableBean("test1");
		RunnableBean test2 = new RunnableBean("test2");
		Thread thread1 = new Thread(test1);
		Thread thread2 = new Thread(test2);
		System.out.println(Thread.currentThread().getPriority());
		thread1.start();
		System.out.println(thread1.getPriority());
		thread2.start();
		System.out.println(thread2.getPriority());
	}

}

class RunnableBean implements Runnable {
	private String name;

	public RunnableBean(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			System.out.println(name + i);
		}
	}

}
