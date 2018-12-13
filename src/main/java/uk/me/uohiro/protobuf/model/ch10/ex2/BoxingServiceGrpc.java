package uk.me.uohiro.protobuf.model.ch10.ex2;

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
    comments = "Source: ch10/ex2/boxing.proto")
public final class BoxingServiceGrpc {

  private BoxingServiceGrpc() {}

  public static final String SERVICE_NAME = "ch10.ex2.BoxingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest,
      uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse> getProcessRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessRequest",
      requestType = uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest.class,
      responseType = uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest,
      uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse> getProcessRequestMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest, uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse> getProcessRequestMethod;
    if ((getProcessRequestMethod = BoxingServiceGrpc.getProcessRequestMethod) == null) {
      synchronized (BoxingServiceGrpc.class) {
        if ((getProcessRequestMethod = BoxingServiceGrpc.getProcessRequestMethod) == null) {
          BoxingServiceGrpc.getProcessRequestMethod = getProcessRequestMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest, uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch10.ex2.BoxingService", "ProcessRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BoxingServiceMethodDescriptorSupplier("ProcessRequest"))
                  .build();
          }
        }
     }
     return getProcessRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BoxingServiceStub newStub(io.grpc.Channel channel) {
    return new BoxingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BoxingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BoxingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BoxingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BoxingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BoxingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void processRequest(uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest,
                uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse>(
                  this, METHODID_PROCESS_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class BoxingServiceStub extends io.grpc.stub.AbstractStub<BoxingServiceStub> {
    private BoxingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BoxingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BoxingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BoxingServiceStub(channel, callOptions);
    }

    /**
     */
    public void processRequest(uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BoxingServiceBlockingStub extends io.grpc.stub.AbstractStub<BoxingServiceBlockingStub> {
    private BoxingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BoxingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BoxingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BoxingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse processRequest(uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BoxingServiceFutureStub extends io.grpc.stub.AbstractStub<BoxingServiceFutureStub> {
    private BoxingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BoxingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BoxingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BoxingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse> processRequest(
        uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_REQUEST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BoxingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BoxingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_REQUEST:
          serviceImpl.processRequest((uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse>) responseObserver);
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

  private static abstract class BoxingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BoxingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch10.ex2.VersioningAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BoxingService");
    }
  }

  private static final class BoxingServiceFileDescriptorSupplier
      extends BoxingServiceBaseDescriptorSupplier {
    BoxingServiceFileDescriptorSupplier() {}
  }

  private static final class BoxingServiceMethodDescriptorSupplier
      extends BoxingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BoxingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BoxingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BoxingServiceFileDescriptorSupplier())
              .addMethod(getProcessRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
