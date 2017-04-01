package com.progressoft.grpc.api;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 0.14.0)",
    comments = "Source: departments.proto")
public class DepartmentServiceGrpc {

  private DepartmentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.progressoft.grpc.api.DepartmentService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.progressoft.grpc.api.DepartmentRequest,
      com.progressoft.grpc.api.DepartmentReply> METHOD_DEPARTMENT_REQUEST_HANDLER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.progressoft.grpc.api.DepartmentService", "departmentRequestHandler"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.progressoft.grpc.api.DepartmentRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.progressoft.grpc.api.DepartmentReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DepartmentServiceStub newStub(io.grpc.Channel channel) {
    return new DepartmentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DepartmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DepartmentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static DepartmentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DepartmentServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static interface DepartmentService {

    /**
     * <pre>
     * insert a department
     * </pre>
     */
    public void departmentRequestHandler(com.progressoft.grpc.api.DepartmentRequest request,
        io.grpc.stub.StreamObserver<com.progressoft.grpc.api.DepartmentReply> responseObserver);
  }

  @io.grpc.ExperimentalApi
  public static abstract class AbstractDepartmentService implements DepartmentService, io.grpc.BindableService {

    @java.lang.Override
    public void departmentRequestHandler(com.progressoft.grpc.api.DepartmentRequest request,
        io.grpc.stub.StreamObserver<com.progressoft.grpc.api.DepartmentReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DEPARTMENT_REQUEST_HANDLER, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return DepartmentServiceGrpc.bindService(this);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static interface DepartmentServiceBlockingClient {

    /**
     * <pre>
     * insert a department
     * </pre>
     */
    public com.progressoft.grpc.api.DepartmentReply departmentRequestHandler(com.progressoft.grpc.api.DepartmentRequest request);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static interface DepartmentServiceFutureClient {

    /**
     * <pre>
     * insert a department
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.progressoft.grpc.api.DepartmentReply> departmentRequestHandler(
        com.progressoft.grpc.api.DepartmentRequest request);
  }

  public static class DepartmentServiceStub extends io.grpc.stub.AbstractStub<DepartmentServiceStub>
      implements DepartmentService {
    private DepartmentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepartmentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepartmentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepartmentServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void departmentRequestHandler(com.progressoft.grpc.api.DepartmentRequest request,
        io.grpc.stub.StreamObserver<com.progressoft.grpc.api.DepartmentReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DEPARTMENT_REQUEST_HANDLER, getCallOptions()), request, responseObserver);
    }
  }

  public static class DepartmentServiceBlockingStub extends io.grpc.stub.AbstractStub<DepartmentServiceBlockingStub>
      implements DepartmentServiceBlockingClient {
    private DepartmentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepartmentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepartmentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepartmentServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.progressoft.grpc.api.DepartmentReply departmentRequestHandler(com.progressoft.grpc.api.DepartmentRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DEPARTMENT_REQUEST_HANDLER, getCallOptions(), request);
    }
  }

  public static class DepartmentServiceFutureStub extends io.grpc.stub.AbstractStub<DepartmentServiceFutureStub>
      implements DepartmentServiceFutureClient {
    private DepartmentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepartmentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepartmentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepartmentServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.progressoft.grpc.api.DepartmentReply> departmentRequestHandler(
        com.progressoft.grpc.api.DepartmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DEPARTMENT_REQUEST_HANDLER, getCallOptions()), request);
    }
  }

  private static final int METHODID_DEPARTMENT_REQUEST_HANDLER = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DepartmentService serviceImpl;
    private final int methodId;

    public MethodHandlers(DepartmentService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEPARTMENT_REQUEST_HANDLER:
          serviceImpl.departmentRequestHandler((com.progressoft.grpc.api.DepartmentRequest) request,
              (io.grpc.stub.StreamObserver<com.progressoft.grpc.api.DepartmentReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final DepartmentService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
        .addMethod(
          METHOD_DEPARTMENT_REQUEST_HANDLER,
          asyncUnaryCall(
            new MethodHandlers<
              com.progressoft.grpc.api.DepartmentRequest,
              com.progressoft.grpc.api.DepartmentReply>(
                serviceImpl, METHODID_DEPARTMENT_REQUEST_HANDLER)))
        .build();
  }
}
