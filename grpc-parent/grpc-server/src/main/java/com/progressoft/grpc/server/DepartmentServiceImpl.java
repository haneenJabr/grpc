package com.progressoft.grpc.server;

import com.progressoft.grpc.api.DepartmentReply;
import com.progressoft.grpc.api.DepartmentRequest;
import com.progressoft.grpc.api.DepartmentServiceGrpc;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

/**
 * @author u538
 *
 */
public class DepartmentServiceImpl implements DepartmentServiceGrpc.DepartmentService {

	@Override
	public void departmentRequestHandler(DepartmentRequest request, StreamObserver<DepartmentReply> responseObserver) {
		try {

			DepartmentReply reply = DepartmentReply.newBuilder().setMessage("completed successfully from server")
					.build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		} catch (Exception e) {
			responseObserver
					.onError(Status.ABORTED.withDescription(e.getMessage() + " error occure in server ").asException());
		}
	}
}
