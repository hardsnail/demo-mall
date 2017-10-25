package com.demo.common.util;

import java.net.InetAddress;
import java.net.Socket;

/**
 * 本地主机工具类
 * 
 * @author james
 *
 */
public class LocalServers {

	/**
	 * 查看port端口是否被占用，如果占用了，将port累加，直接找到可用端口
	 * 
	 * @param port
	 * @return
	 */
	public static int getAvailablePort(int port) {
		if (port < 0 || port > 65535) {
			throw new IllegalArgumentException("不可用端口:" + port);
		}

		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			Socket socket = new Socket(inetAddress, port);
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return getAvailablePort(++port);
		} catch (Exception e) {
			return port;
		}
	}
}
