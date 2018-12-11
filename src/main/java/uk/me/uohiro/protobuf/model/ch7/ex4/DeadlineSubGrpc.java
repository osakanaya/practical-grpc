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
public final class DeadlineSubGrpc {

  private DeadlineSubGrpc() {}

  public static final String SERVICE_NAME = "ch7.ex4.DeadlineSub";

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
    if ((getFastMethod = DeadlineSubGrpc.getFastMethod) == null) {
      synchronized (DeadlineSubGrpc.class) {
        if ((getFastMethod = DeadlineSubGrpc.getFastMethod) == null) {
          DeadlineSubGrpc.getFastMethod = getFastMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex4.Empty, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex4.DeadlineSub", "Fast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeadlineSubMethodDescriptorSupplier("Fast"))
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
    if ((getSlowMethod = DeadlineSubGrpc.getSlowMethod) == null) {
      synchronized (DeadlineSubGrpc.class) {
        if ((getSlowMethod = DeadlineSubGrpc.getSlowMethod) == null) {
          DeadlineSubGrpc.getSlowMethod = getSlowMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex4.Empty, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex4.DeadlineSub", "Slow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeadlineSubMethodDescriptorSupplier("Slow"))
                  .build();
          }
        }
     }
     return getSlowMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeadlineSubStub newStub(io.grpc.Channel channel) {
    return new DeadlineSubStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeadlineSubBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DeadlineSubBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeadlineSubFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DeadlineSubFutureStub(channel);
  }

  /**
   */
  public static abstract class DeadlineSubImplBase implements io.grpc.BindableService {

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
  public static final class DeadlineSubStub extends io.grpc.stub.AbstractStub<DeadlineSubStub> {
    private DeadlineSubStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeadlineSubStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeadlineSubStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeadlineSubStub(channel, callOptions);
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
  public static final class DeadlineSubBlockingStub extends io.grpc.stub.AbstractStub<DeadlineSubBlockingStub> {
    private DeadlineSubBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeadlineSubBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeadlineSubBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeadlineSubBlockingStub(channel, callOptions);
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
  public static final class DeadlineSubFutureStub extends io.grpc.stub.AbstractStub<DeadlineSubFutureStub> {
    private DeadlineSubFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeadlineSubFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeadlineSubFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeadlineSubFutureStub(channel, callOptions);
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
    private final DeadlineSubImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeadlineSubImplBase serviceImpl, int methodId) {
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

  private static abstract class DeadlineSubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeadlineSubBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeadlineSub");
    }
  }

  private static final class DeadlineSubFileDescriptorSupplier
      extends DeadlineSubBaseDescriptorSupplier {
    DeadlineSubFileDescriptorSupplier() {}
  }

  private static final class DeadlineSubMethodDescriptorSupplier
      extends DeadlineSubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeadlineSubMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeadlineSubGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeadlineSubFileDescriptorSupplier())
              .addMethod(getFastMethod())
              .addMethod(getSlowMethod())
              .build();
        }
      }
    }
    return result;
  }
}
