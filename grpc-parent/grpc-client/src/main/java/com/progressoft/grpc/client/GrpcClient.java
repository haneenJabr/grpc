package com.progressoft.grpc.client;

import java.util.ArrayList;
import java.util.List;

import com.progressoft.grpc.api.DepartmentReply;
import com.progressoft.grpc.api.DepartmentRequest;
import com.progressoft.grpc.api.DepartmentRequest.Department;
import com.progressoft.grpc.api.DepartmentServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author u538
 *
 */
public class GrpcClient {
	public static void main(String[] args) throws InterruptedException {

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888).usePlaintext(true).build();
		DepartmentServiceGrpc.DepartmentServiceBlockingStub stub = DepartmentServiceGrpc.newBlockingStub(channel);
		List<Department> departments = fillDepartments();
		Double start = startTime();
		for (int i = 0; i < 100000; i++) {
			DepartmentReply reply = stub
					.departmentRequestHandler(DepartmentRequest.newBuilder().addAllDepartments(departments).build());
		}
		double end = endTime();
		System.out.println("request time using grpc is " + (end - start));
	}

	private static List<Department> fillDepartments() {
		List<Department> departments = new ArrayList();
		for (int i = 0; i < 100000; i++) {
			departments.add(Department.newBuilder().setId(i + "").setName("hr").build());
		}
		return departments;
	}

	private static double startTime() {
		return (double) (System.currentTimeMillis());
	}

	private static double endTime() {
		return (double) (System.currentTimeMillis());
	}
}
