package uk.me.uohiro.protobuf.model.extras.ex3;

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
    comments = "Source: extras/ex3/weather.proto")
public final class HumidityServiceStreamingGrpc {

  private HumidityServiceStreamingGrpc() {}

  public static final String SERVICE_NAME = "extras.ex3.HumidityServiceStreaming";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex3.Coordinates,
      uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse> getObserveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Observe",
      requestType = uk.me.uohiro.protobuf.model.extras.ex3.Coordinates.class,
      responseType = uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex3.Coordinates,
      uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse> getObserveMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex3.Coordinates, uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse> getObserveMethod;
    if ((getObserveMethod = HumidityServiceStreamingGrpc.getObserveMethod) == null) {
      synchronized (HumidityServiceStreamingGrpc.class) {
        if ((getObserveMethod = HumidityServiceStreamingGrpc.getObserveMethod) == null) {
          HumidityServiceStreamingGrpc.getObserveMethod = getObserveMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.extras.ex3.Coordinates, uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "extras.ex3.HumidityServiceStreaming", "Observe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex3.Coordinates.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HumidityServiceStreamingMethodDescriptorSupplier("Observe"))
                  .build();
          }
        }
     }
     return getObserveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HumidityServiceStreamingStub newStub(io.grpc.Channel channel) {
    return new HumidityServiceStreamingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HumidityServiceStreamingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HumidityServiceStreamingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HumidityServiceStreamingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HumidityServiceStreamingFutureStub(channel);
  }

  /**
   */
  public static abstract class HumidityServiceStreamingImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.Coordinates> observe(
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getObserveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getObserveMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.extras.ex3.Coordinates,
                uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse>(
                  this, METHODID_OBSERVE)))
          .build();
    }
  }

  /**
   */
  public static final class HumidityServiceStreamingStub extends io.grpc.stub.AbstractStub<HumidityServiceStreamingStub> {
    private HumidityServiceStreamingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HumidityServiceStreamingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityServiceStreamingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HumidityServiceStreamingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.Coordinates> observe(
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getObserveMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HumidityServiceStreamingBlockingStub extends io.grpc.stub.AbstractStub<HumidityServiceStreamingBlockingStub> {
    private HumidityServiceStreamingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HumidityServiceStreamingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityServiceStreamingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HumidityServiceStreamingBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class HumidityServiceStreamingFutureStub extends io.grpc.stub.AbstractStub<HumidityServiceStreamingFutureStub> {
    private HumidityServiceStreamingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HumidityServiceStreamingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityServiceStreamingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HumidityServiceStreamingFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_OBSERVE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HumidityServiceStreamingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HumidityServiceStreamingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OBSERVE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.observe(
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HumidityServiceStreamingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HumidityServiceStreamingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.extras.ex3.WeatherAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HumidityServiceStreaming");
    }
  }

  private static final class HumidityServiceStreamingFileDescriptorSupplier
      extends HumidityServiceStreamingBaseDescriptorSupplier {
    HumidityServiceStreamingFileDescriptorSupplier() {}
  }

  private static final class HumidityServiceStreamingMethodDescriptorSupplier
      extends HumidityServiceStreamingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HumidityServiceStreamingMethodDescriptorSupplier(String methodName) {
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
      synchronized (HumidityServiceStreamingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HumidityServiceStreamingFileDescriptorSupplier())
              .addMethod(getObserveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
