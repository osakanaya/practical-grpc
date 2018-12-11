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
public final class DeadlineExampleGrpc {

  private DeadlineExampleGrpc() {}

  public static final String SERVICE_NAME = "ch7.ex4.DeadlineExample";

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
    if ((getFastMethod = DeadlineExampleGrpc.getFastMethod) == null) {
      synchronized (DeadlineExampleGrpc.class) {
        if ((getFastMethod = DeadlineExampleGrpc.getFastMethod) == null) {
          DeadlineExampleGrpc.getFastMethod = getFastMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex4.Empty, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex4.DeadlineExample", "Fast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeadlineExampleMethodDescriptorSupplier("Fast"))
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
    if ((getSlowMethod = DeadlineExampleGrpc.getSlowMethod) == null) {
      synchronized (DeadlineExampleGrpc.class) {
        if ((getSlowMethod = DeadlineExampleGrpc.getSlowMethod) == null) {
          DeadlineExampleGrpc.getSlowMethod = getSlowMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex4.Empty, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex4.DeadlineExample", "Slow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeadlineExampleMethodDescriptorSupplier("Slow"))
                  .build();
          }
        }
     }
     return getSlowMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeadlineExampleStub newStub(io.grpc.Channel channel) {
    return new DeadlineExampleStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeadlineExampleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DeadlineExampleBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeadlineExampleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DeadlineExampleFutureStub(channel);
  }

  /**
   */
  public static abstract class DeadlineExampleImplBase implements io.grpc.BindableService {

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
  public static final class DeadlineExampleStub extends io.grpc.stub.AbstractStub<DeadlineExampleStub> {
    private DeadlineExampleStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeadlineExampleStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeadlineExampleStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeadlineExampleStub(channel, callOptions);
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
  public static final class DeadlineExampleBlockingStub extends io.grpc.stub.AbstractStub<DeadlineExampleBlockingStub> {
    private DeadlineExampleBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeadlineExampleBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeadlineExampleBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeadlineExampleBlockingStub(channel, callOptions);
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
  public static final class DeadlineExampleFutureStub extends io.grpc.stub.AbstractStub<DeadlineExampleFutureStub> {
    private DeadlineExampleFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeadlineExampleFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeadlineExampleFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeadlineExampleFutureStub(channel, callOptions);
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
    private final DeadlineExampleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeadlineExampleImplBase serviceImpl, int methodId) {
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

  private static abstract class DeadlineExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeadlineExampleBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeadlineExample");
    }
  }

  private static final class DeadlineExampleFileDescriptorSupplier
      extends DeadlineExampleBaseDescriptorSupplier {
    DeadlineExampleFileDescriptorSupplier() {}
  }

  private static final class DeadlineExampleMethodDescriptorSupplier
      extends DeadlineExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeadlineExampleMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeadlineExampleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeadlineExampleFileDescriptorSupplier())
              .addMethod(getFastMethod())
              .addMethod(getSlowMethod())
              .build();
        }
      }
    }
    return result;
  }
}
