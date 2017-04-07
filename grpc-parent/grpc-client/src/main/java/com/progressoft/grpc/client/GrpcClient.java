package com.progressoft.grpc.client;

import java.util.ArrayList;
import java.util.List;

import com.progressoft.grpc.api.Department;
import com.progressoft.grpc.api.DepartmentReply;
import com.progressoft.grpc.api.DepartmentRequest;

import com.progressoft.grpc.api.DepartmentServiceGrpc;
import com.progressoft.grpc.api.Employee;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author u538
 *
 */
public class GrpcClient {

	public static void main(String[] args) throws InterruptedException {

		DepartmentServiceGrpc.DepartmentServiceBlockingStub stub = DepartmentServiceGrpc
				.newBlockingStub(createChannel());
		List<Department> departments = fillDepartments();
		Double start = startTime();
		for (int i = 0; i < 10000; i++) {
			DepartmentReply reply = stub
					.departmentRequestHandler(DepartmentRequest.newBuilder().addAllDepartments(departments).build());
		}
		double end = endTime();
		System.out.println("request time using grpc is " + (end - start));
	}

	private static ManagedChannel createChannel() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888).usePlaintext(true)
				.maxInboundMessageSize(16373890).build();
		return channel;
	}

	private static List<Department> fillDepartments() {
		List<Department> departments = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			departments.add(Department.newBuilder().setId(i + "").setName("hr")
					.setDescription(
							"this is human resource department ,the department in an organization dealing with matters involving employees, as hiring, training, labor relations, and benefits")
					.addAllEmployees(fillEmployees()).build());
		}
		return departments;
	}

	private static Iterable<Employee> fillEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			employees.add(Employee.newBuilder().setEmployeeId(i).setEmployeeName("haneen").setBirthDate("07/01/1992")
					.setPhone(124567893).build());
		}
		return employees;
	}

	private static double startTime() {
		return (double) (System.currentTimeMillis());
	}

	private static double endTime() {
		return (double) (System.currentTimeMillis());
	}
}
