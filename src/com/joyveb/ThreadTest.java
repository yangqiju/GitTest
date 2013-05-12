package com.joyveb;

/**
 * @Title: ThreadTest.java
 * @Package com.joyveb
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author �����
 * @date 2013-5-9 ����10:18:35
 * @version V1.0
 */
public class ThreadTest {

	public static void main(String[] args) {
		TestThread thread1 = new TestThread("test1");
		TestThread thread2 = new TestThread("test1");
		thread1.start();
		thread2.start();
		System.out.println("thread1:"+thread1.getId()+"---"+thread1.getName());
		System.out.println("thread2:"+thread2.getId()+"---"+thread2.getName());
	}
}

class TestThread extends Thread {
	public TestThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println("test:" + i);
		}
	}
}
