/**
 * 
 */
package com.progressoft.grpc.client;

import java.util.HashMap;
import java.util.Map;

import com.progressoft.grpc.api.DepartmentReply;
import com.progressoft.grpc.api.DepartmentRequest;
import com.progressoft.grpc.api.DepartmentServiceGrpc;
import com.progressoft.grpc.api.DepartmentServiceGrpc.DepartmentServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author u538
 *
 */
public class OnotherGrpcClient {
	
	public static void main(String[] args) throws InterruptedException {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888).usePlaintext(true).build();
		DepartmentServiceGrpc.DepartmentServiceBlockingStub stub = DepartmentServiceGrpc.newBlockingStub(channel);
		insertDepartments(stub);
	}
	
	private static void insertDepartments(DepartmentServiceBlockingStub stub) {
		Double start=(double) (System.currentTimeMillis()/1000);
		DepartmentReply reply=null;
		try{
			
//		reply = stub.insert(DepartmentRequest.newBuilder().putAllDepartments(createDepartments()).setClientName("client 2 ").build());
		}
		catch(Exception e){
			System.out.println("error occure from server caused by "+e.getMessage());
		}
		Double end=(double) (System.currentTimeMillis()/1000);
		System.out.println("insertion from client 2 time using grpc is "+ (end-start));
		System.out.println("replay message is " + reply);
	}
	
	private static Map<String,String> createDepartments(){
		Map<String, String> departments = new HashMap<>();
		for (int i = 1500; i < 50; ++i) {
			departments.put(String.valueOf(i), "department" + i);
		}
		return departments;
	}

}
