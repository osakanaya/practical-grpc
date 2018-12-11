package uk.me.uohiro.protobuf.model.ch7.ex4;

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
    comments = "Source: ch7/deadline.proto")
public final class DeadlineMainGrpc {

  private DeadlineMainGrpc() {}

  public static final String SERVICE_NAME = "ch7.ex4.DeadlineMain";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex4.Empty,
      uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> getFastMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Fast",
      requestType = uk.me.uohiro.protobuf.model.ch7.ex4.Empty.class,
      responseType = uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex4.Empty,
      uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> getFastMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex4.Empty, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> getFastMethod;
    if ((getFastMethod = DeadlineMainGrpc.getFastMethod) == null) {
      synchronized (DeadlineMainGrpc.class) {
        if ((getFastMethod = DeadlineMainGrpc.getFastMethod) == null) {
          DeadlineMainGrpc.getFastMethod = getFastMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex4.Empty, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex4.DeadlineMain", "Fast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeadlineMainMethodDescriptorSupplier("Fast"))
                  .build();
          }
        }
     }
     return getFastMethod;
  }

  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex4.Empty,
      uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> getSlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Slow",
      requestType = uk.me.uohiro.protobuf.model.ch7.ex4.Empty.class,
      responseType = uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex4.Empty,
      uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> getSlowMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex4.Empty, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> getSlowMethod;
    if ((getSlowMethod = DeadlineMainGrpc.getSlowMethod) == null) {
      synchronized (DeadlineMainGrpc.class) {
        if ((getSlowMethod = DeadlineMainGrpc.getSlowMethod) == null) {
          DeadlineMainGrpc.getSlowMethod = getSlowMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex4.Empty, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex4.DeadlineMain", "Slow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeadlineMainMethodDescriptorSupplier("Slow"))
                  .build();
          }
        }
     }
     return getSlowMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeadlineMainStub newStub(io.grpc.Channel channel) {
    return new DeadlineMainStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeadlineMainBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DeadlineMainBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeadlineMainFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DeadlineMainFutureStub(channel);
  }

  /**
   */
  public static abstract class DeadlineMainImplBase implements io.grpc.BindableService {

    /**
     */
    public void fast(uk.me.uohiro.protobuf.model.ch7.ex4.Empty request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFastMethod(), responseObserver);
    }

    /**
     */
    public void slow(uk.me.uohiro.protobuf.model.ch7.ex4.Empty request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSlowMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFastMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch7.ex4.Empty,
                uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>(
                  this, METHODID_FAST)))
          .addMethod(
            getSlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch7.ex4.Empty,
                uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>(
                  this, METHODID_SLOW)))
          .build();
    }
  }

  /**
   */
  public static final class DeadlineMainStub extends io.grpc.stub.AbstractStub<DeadlineMainStub> {
    private DeadlineMainStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeadlineMainStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeadlineMainStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeadlineMainStub(channel, callOptions);
    }

    /**
     */
    public void fast(uk.me.uohiro.protobuf.model.ch7.ex4.Empty request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFastMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void slow(uk.me.uohiro.protobuf.model.ch7.ex4.Empty request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSlowMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DeadlineMainBlockingStub extends io.grpc.stub.AbstractStub<DeadlineMainBlockingStub> {
    private DeadlineMainBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeadlineMainBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeadlineMainBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeadlineMainBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse fast(uk.me.uohiro.protobuf.model.ch7.ex4.Empty request) {
      return blockingUnaryCall(
          getChannel(), getFastMethod(), getCallOptions(), request);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse slow(uk.me.uohiro.protobuf.model.ch7.ex4.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSlowMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DeadlineMainFutureStub extends io.grpc.stub.AbstractStub<DeadlineMainFutureStub> {
    private DeadlineMainFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeadlineMainFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeadlineMainFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeadlineMainFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> fast(
        uk.me.uohiro.protobuf.model.ch7.ex4.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getFastMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse> slow(
        uk.me.uohiro.protobuf.model.ch7.ex4.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSlowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FAST = 0;
  private static final int METHODID_SLOW = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeadlineMainImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeadlineMainImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FAST:
          serviceImpl.fast((uk.me.uohiro.protobuf.model.ch7.ex4.Empty) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>) responseObserver);
          break;
        case METHODID_SLOW:
          serviceImpl.slow((uk.me.uohiro.protobuf.model.ch7.ex4.Empty) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>) responseObserver);
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

  private static abstract class DeadlineMainBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeadlineMainBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeadlineMain");
    }
  }

  private static final class DeadlineMainFileDescriptorSupplier
      extends DeadlineMainBaseDescriptorSupplier {
    DeadlineMainFileDescriptorSupplier() {}
  }

  private static final class DeadlineMainMethodDescriptorSupplier
      extends DeadlineMainBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeadlineMainMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeadlineMainGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeadlineMainFileDescriptorSupplier())
              .addMethod(getFastMethod())
              .addMethod(getSlowMethod())
              .build();
        }
      }
    }
    return result;
  }
}
