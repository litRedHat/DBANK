package com.tangdi.dbank.thrift;

import org.apache.thrift.TException;

import com.tangdi.dbank.thrift.Hello.Iface;

public class HelloImpl implements Iface{
	private static int count = 0;
	
	public String helloString(String word) throws TException {
		// TODO Auto-generated method stub
		count += 1;
		System.out.println("get " + word + " " +count);
		return "hello " + word + " " + count;
	}

}
