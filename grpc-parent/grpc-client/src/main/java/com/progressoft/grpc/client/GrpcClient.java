package com.progressoft.grpc.client;

import com.progressoft.grpc.api.AllDepartmentsReply;
import com.progressoft.grpc.api.DeleteDepartmentRequest;
import com.progressoft.grpc.api.DepartmentReply;
import com.progressoft.grpc.api.DepartmentRequest;
import com.progressoft.grpc.api.DepartmentServiceGrpc;
import com.progressoft.grpc.api.DepartmentServiceGrpc.DepartmentServiceBlockingStub;
import com.progressoft.grpc.api.EmptyRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Created by user on 04/03/17.
 */
public class GrpcClient {

	public static void main(String[] args) throws InterruptedException {

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888).usePlaintext(true).build();
		DepartmentServiceGrpc.DepartmentServiceBlockingStub stub = DepartmentServiceGrpc.newBlockingStub(channel);
		Double start = startTime();
		insertDepartments(stub);
		double end = endTime();
		System.out.println("insertion time using grpc is " + (end - start));

		start = startTime();
		updateDepartments(stub);
		end = endTime();
		System.out.println("update time using grpc is " + (end - start));

		start = startTime();
		selectAllDepartments(stub);
		end = endTime();
		System.out.println("select time using grpc is " + (end - start));

		start = startTime();
		deleteDepartments(stub);
		end = endTime();
		System.out.println("delete time using grpc is " + (end - start));
	}

	private static void selectAllDepartments(DepartmentServiceBlockingStub stub) {

		try {
			AllDepartmentsReply reply  = stub.select(EmptyRequest.newBuilder().build());

		} catch (Exception e) {
			System.out.println("error occure from server caused by " + e.getMessage());
		}

	}

	private static void updateDepartments(DepartmentServiceBlockingStub stub) {

		try {
			for (int i = 0; i < 10000; ++i) {
				DepartmentReply reply = stub.update(DepartmentRequest.newBuilder().setDepartmentName("department" + i)
						.setDepartmentNumber(String.valueOf(i)).build());
			}
		} catch (Exception e) {
			System.out.println("error occure from server caused by " + e.getMessage());
		}
	}

	private static void deleteDepartments(DepartmentServiceBlockingStub stub) {

		try {
			for (int i = 0; i < 10000; ++i) {
				DepartmentReply	reply = stub.delete(DeleteDepartmentRequest.newBuilder().setDeptId(String.valueOf(i)).build());
			}
		} catch (Exception e) {
			System.out.println("error occure from server caused by " + e.getMessage());
		}
	}

	private static void insertDepartments(DepartmentServiceBlockingStub stub) {

		try {
			for (int i = 0; i < 10000; ++i) {
				DepartmentReply reply = stub.insert(DepartmentRequest.newBuilder().setDepartmentName("department" + i)
						.setDepartmentNumber(String.valueOf(i)).build());
			}
		} catch (Exception e) {
			System.out.println("error occure from server caused by " + e.getMessage());
		}
	}

	private static double startTime() {
		return (double) (System.currentTimeMillis() / 1000);
	}

	private static double endTime() {
		return (double) (System.currentTimeMillis() / 1000);
	}
}
