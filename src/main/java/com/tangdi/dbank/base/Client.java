package com.tangdi.dbank.base;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
	private static final Logger logger = LoggerFactory.getLogger(Client.class);
	String host = "10.18.16.1"; // 要连接的服务端IP地址
	int port = 5401; // 要连接的服务端对应的监听端口
	int timeout = 10000;// 连接超时时间

	public static void main(String args[]) throws Exception {
		new Client().SocketTool1();
	}

	public void SocketTool1() throws Exception {
		// 为了简单起见，所有的异常都直接往外抛
		// 与服务端建立连接
		Socket client = new Socket();
		SocketAddress endpoint = new InetSocketAddress(host, port);
		client.connect(endpoint, timeout);
		// 建立连接后就可以往服务端写数据了
		Writer writer = new OutputStreamWriter(client.getOutputStream());
		writer.write(
				"00000413<?xml version=\"1.0\" encoding=\"gbk\"?><Msg><Head><TransCode>7021</TransCode><ChnlType>10</ChnlType><TransDate>20150819</TransDate><TransTime>154912</TransTime><TrcNo>20150819000000614752</TrcNo></Head><Body><Telephone>15618389010</Telephone><Content>动态密码：389593(2分钟内有效)。您正在进行海南银行椰Bank安全认证。</Content><Protocol>C200</Protocol><TempCode>9999</TempCode><SrcBranch>9999</SrcBranch></Body></Msg>");
		writer.flush();// 写完后要记得flush
		Reader reader = new InputStreamReader(client.getInputStream(), "gbk");
		char chars[] = new char[64];
		int len;
		StringBuilder sb = new StringBuilder();
		while ((len = reader.read(chars)) != -1) {
			sb.append(new String(chars, 0, len));
		}
		String result = sb.toString().replace("\n", "").replace("	", "");
		logger.info("from client: " + result);
		reader.close();
		writer.close();
		client.close();
	}
}
