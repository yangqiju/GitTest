package com.joyveb.nio.socket.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**   
 * @Title: SocketClient1.java 
 * @Package com.joyveb.nio.socket.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 杨其桔
 * @date 2013-11-20 下午11:09:02 
 * @version V1.0   
 */
public class SocketClient1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",8888);
		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out =new DataOutputStream(socket.getOutputStream());
		out.write("client send to server".getBytes());
		out.flush();
		socket.shutdownOutput();
		String str = in.readLine();
		System.out.println("[client]:"+str);
		in.close();
		out.close();
		socket.close();
	}
}

