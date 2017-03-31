package com.progressoft.grpc.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;

import com.progressoft.grpc.api.AllDepartmentsReply;
import com.progressoft.grpc.api.DeleteDepartmentRequest;
import com.progressoft.grpc.api.DepartmentReply;
import com.progressoft.grpc.api.DepartmentRequest;
import com.progressoft.grpc.api.DepartmentServiceGrpc;
import com.progressoft.grpc.api.EmptyRequest;
import com.progressoft.jpa.entities.Department;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import repository.DepartmentRepository;
import repository.DepartmentRepositoryImpl;

/**
 * @author u538
 *
 */
public class DepartmentServiceImpl implements DepartmentServiceGrpc.DepartmentService {
	private DepartmentRepository repository = new DepartmentRepositoryImpl();

	@Override
	public void insert(DepartmentRequest request, StreamObserver<DepartmentReply> responseObserver) {

		String clientName = request.getClientName();

		// TODO client failed after send request before server complete
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// throw new IllegalArgumentException();
		DepartmentReply reply = insertDepartments(responseObserver, request.getDepartmentNumber(),
				request.getDepartmentName(), clientName);
		responseObserver.onNext(reply);

		responseObserver.onCompleted();

	}

	private DepartmentReply insertDepartments(StreamObserver<DepartmentReply> responseObserver, String departmentNumber,
			String departmentName, String clientName) {
		try {
			insertIntoDatabase(departmentNumber, departmentName);
		} catch (ConstraintViolationException e) {
			responseObserver.onError(Status.ALREADY_EXISTS.withDescription(e.getMessage()).asException());
		} catch (Exception e) {
			responseObserver.onError(
					Status.ABORTED.withDescription(e.getMessage() + " requset from " + clientName).asException());
		}
		DepartmentReply reply = DepartmentReply.newBuilder()
				.setMessage("insertion completed successfully from " + clientName).build();
		return reply;
	}

	private void insertIntoDatabase(String departmentNumber, String departmentName) {
		Department department = new Department();
		department.setDeptNo(departmentNumber);
		department.setName(departmentName);
		repository.add(department);
	}

	@Override
	public void delete(DeleteDepartmentRequest request, StreamObserver<DepartmentReply> responseObserver) {
		repository.delete(request.getDeptId());
		responseObserver.onNext(DepartmentReply.newBuilder().setMessage("deletion completed successfully").build());
		responseObserver.onCompleted();
	}

	@Override
	public void update(DepartmentRequest request, StreamObserver<DepartmentReply> responseObserver) {
		
			Department department = new Department();
			department.setDeptNo(request.getDepartmentNumber());
			department.setName(request.getDepartmentName());
			repository.update(department);
		
		responseObserver.onNext(DepartmentReply.newBuilder().setMessage("update completed successfully").build());
		responseObserver.onCompleted();
	}

	@Override
	public void select(EmptyRequest request, StreamObserver<AllDepartmentsReply> responseObserver) {
		List<Department> departments = repository.listAllDepartments();

		Map<String, String> departmentsMap = new HashMap<>();

		for (Department department : departments) {
			departmentsMap.put(department.getDeptNo(), department.getName());
		}
		responseObserver.onNext(AllDepartmentsReply.newBuilder().putAllDepartments(departmentsMap)
				.setMessage("selection completed successfully").build());
		responseObserver.onCompleted();
	}
}
