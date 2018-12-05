package uk.me.uohiro.protobuf.model.ch7.ex1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: ch7/error-mgmt.proto")
public final class ErrorManagementGrpc {

  private ErrorManagementGrpc() {}

  public static final String SERVICE_NAME = "ch7.ex1.ErrorManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest,
      uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse> getGetDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetData",
      requestType = uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest.class,
      responseType = uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest,
      uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse> getGetDataMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest, uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse> getGetDataMethod;
    if ((getGetDataMethod = ErrorManagementGrpc.getGetDataMethod) == null) {
      synchronized (ErrorManagementGrpc.class) {
        if ((getGetDataMethod = ErrorManagementGrpc.getGetDataMethod) == null) {
          ErrorManagementGrpc.getGetDataMethod = getGetDataMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest, uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex1.ErrorManagement", "GetData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ErrorManagementMethodDescriptorSupplier("GetData"))
                  .build();
          }
        }
     }
     return getGetDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ErrorManagementStub newStub(io.grpc.Channel channel) {
    return new ErrorManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ErrorManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ErrorManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ErrorManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ErrorManagementFutureStub(channel);
  }

  /**
   */
  public static abstract class ErrorManagementImplBase implements io.grpc.BindableService {

    /**
     */
    public void getData(uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest,
                uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse>(
                  this, METHODID_GET_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class ErrorManagementStub extends io.grpc.stub.AbstractStub<ErrorManagementStub> {
    private ErrorManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ErrorManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ErrorManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ErrorManagementStub(channel, callOptions);
    }

    /**
     */
    public void getData(uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ErrorManagementBlockingStub extends io.grpc.stub.AbstractStub<ErrorManagementBlockingStub> {
    private ErrorManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ErrorManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ErrorManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ErrorManagementBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse getData(uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ErrorManagementFutureStub extends io.grpc.stub.AbstractStub<ErrorManagementFutureStub> {
    private ErrorManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ErrorManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ErrorManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ErrorManagementFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse> getData(
        uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ErrorManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ErrorManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DATA:
          serviceImpl.getData((uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse>) responseObserver);
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

  private static abstract class ErrorManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ErrorManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch7.ex1.ErrorManagementAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ErrorManagement");
    }
  }

  private static final class ErrorManagementFileDescriptorSupplier
      extends ErrorManagementBaseDescriptorSupplier {
    ErrorManagementFileDescriptorSupplier() {}
  }

  private static final class ErrorManagementMethodDescriptorSupplier
      extends ErrorManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ErrorManagementMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ErrorManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ErrorManagementFileDescriptorSupplier())
              .addMethod(getGetDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
