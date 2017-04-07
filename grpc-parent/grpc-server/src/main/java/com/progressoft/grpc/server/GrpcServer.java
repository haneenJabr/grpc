package com.progressoft.grpc.server;

import com.progressoft.grpc.api.DepartmentServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

/**
 * @author u538
 *
 */
public class GrpcServer {
	public static void main(String[] args) {
		Server server = ServerBuilder.forPort(8888)
				.addService(DepartmentServiceGrpc.bindService(new DepartmentServiceImpl())).build();
		try {
			server.start();
			server.awaitTermination();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}