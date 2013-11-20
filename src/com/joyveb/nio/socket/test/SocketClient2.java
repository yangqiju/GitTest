package com.joyveb.nio.socket.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**   
 * @Title: SocketClient2.java 
 * @Package com.joyveb.nio.socket.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 杨其桔
 * @date 2013-11-20 下午11:23:13 
 * @version V1.0   
 */
public class SocketClient2 {

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			final int idx = i;
			new Thread(new MyRunnable(idx)).start();
		}
	}
	
private static final class MyRunnable implements Runnable {
		
		private final int idx;

		private MyRunnable(int idx) {
			this.idx = idx;
		}

		public void run() {
			SocketChannel socketChannel = null;
			try {
				socketChannel = SocketChannel.open();
				SocketAddress socketAddress = new InetSocketAddress("localhost", 8888);
				socketChannel.connect(socketAddress);

				sendData(socketChannel);
				String response = receiveData(socketChannel);
				System.out.println("[client]"+response);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					socketChannel.close();
				} catch(Exception ex) {}
			}
		}

		private void sendData(SocketChannel socketChannel) throws IOException {
			socketChannel.write(ByteBuffer.wrap("client send to server".getBytes()));
			socketChannel.socket().shutdownOutput();
		}

		private String receiveData(SocketChannel socketChannel) throws IOException {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] bytes;
			try {
				ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
				int count = 0;
				while ((count = socketChannel.read(buffer)) >= 0) {
					buffer.flip();
					bytes = new byte[count];
					buffer.get(bytes);
					baos.write(bytes);
					buffer.clear();
				}
				bytes = baos.toByteArray();
				socketChannel.socket().shutdownInput();
			} finally {
				try {
					baos.close();
				} catch(Exception ex) {}
			}
			return new String(bytes);
		}
	}
}

