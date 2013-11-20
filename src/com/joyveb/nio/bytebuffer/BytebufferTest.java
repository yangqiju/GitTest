package com.joyveb.nio.bytebuffer;

import java.nio.ByteBuffer;

/**   
 * @Title: BytebufferTest.java 
 * @Package com.joyveb.nio.bytebuffer 
 * @author ÑîÆä½Û
 * @date 2013-11-20 ÏÂÎç10:28:14 
 * @version V1.0   
 */
public class BytebufferTest {

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(1024);
		System.out.println(bb.capacity());
		System.out.println(bb.limit());
		System.out.println(bb.position());
	}
}

