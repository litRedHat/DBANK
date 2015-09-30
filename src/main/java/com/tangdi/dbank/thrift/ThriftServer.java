package com.tangdi.dbank.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.tangdi.dbank.thrift.Hello.Processor; 


public class ThriftServer {
    public void startServer() {  
        try {  
            System.out.println("thrift server open port 1234");
            TServerSocket serverTransport = new TServerSocket(1234);  
            Hello.Processor process = new Processor(new HelloImpl());  
            Factory portFactory = new TBinaryProtocol.Factory(true, true);  
            Args args = new Args(serverTransport);  
            args.processor(process);  
            args.protocolFactory(portFactory);  
            TServer server = new TThreadPoolServer(args);  
            server.serve();  
        } catch (TTransportException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static void main(String[] args) {  
    	System.out.println("thrift server init");
        ThriftServer server = new ThriftServer();  
        System.out.println("thrift server start");
        server.startServer();  
        System.out.println("thrift server end");
    }  
}
