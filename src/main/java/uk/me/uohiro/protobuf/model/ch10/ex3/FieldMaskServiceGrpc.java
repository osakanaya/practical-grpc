package uk.me.uohiro.protobuf.model.ch10.ex3;

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
    comments = "Source: ch10/ex3/field_mask.proto")
public final class FieldMaskServiceGrpc {

  private FieldMaskServiceGrpc() {}

  public static final String SERVICE_NAME = "ch10.ex3.FieldMaskService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest,
      uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse> getProcessRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessRequest",
      requestType = uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest.class,
      responseType = uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest,
      uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse> getProcessRequestMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest, uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse> getProcessRequestMethod;
    if ((getProcessRequestMethod = FieldMaskServiceGrpc.getProcessRequestMethod) == null) {
      synchronized (FieldMaskServiceGrpc.class) {
        if ((getProcessRequestMethod = FieldMaskServiceGrpc.getProcessRequestMethod) == null) {
          FieldMaskServiceGrpc.getProcessRequestMethod = getProcessRequestMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest, uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch10.ex3.FieldMaskService", "ProcessRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FieldMaskServiceMethodDescriptorSupplier("ProcessRequest"))
                  .build();
          }
        }
     }
     return getProcessRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FieldMaskServiceStub newStub(io.grpc.Channel channel) {
    return new FieldMaskServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FieldMaskServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FieldMaskServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FieldMaskServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FieldMaskServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FieldMaskServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void processRequest(uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest,
                uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse>(
                  this, METHODID_PROCESS_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class FieldMaskServiceStub extends io.grpc.stub.AbstractStub<FieldMaskServiceStub> {
    private FieldMaskServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FieldMaskServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FieldMaskServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FieldMaskServiceStub(channel, callOptions);
    }

    /**
     */
    public void processRequest(uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FieldMaskServiceBlockingStub extends io.grpc.stub.AbstractStub<FieldMaskServiceBlockingStub> {
    private FieldMaskServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FieldMaskServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FieldMaskServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FieldMaskServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse processRequest(uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FieldMaskServiceFutureStub extends io.grpc.stub.AbstractStub<FieldMaskServiceFutureStub> {
    private FieldMaskServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FieldMaskServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FieldMaskServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FieldMaskServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse> processRequest(
        uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest request) {
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
    private final FieldMaskServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FieldMaskServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_REQUEST:
          serviceImpl.processRequest((uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse>) responseObserver);
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

  private static abstract class FieldMaskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FieldMaskServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FieldMaskService");
    }
  }

  private static final class FieldMaskServiceFileDescriptorSupplier
      extends FieldMaskServiceBaseDescriptorSupplier {
    FieldMaskServiceFileDescriptorSupplier() {}
  }

  private static final class FieldMaskServiceMethodDescriptorSupplier
      extends FieldMaskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FieldMaskServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FieldMaskServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FieldMaskServiceFileDescriptorSupplier())
              .addMethod(getProcessRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
