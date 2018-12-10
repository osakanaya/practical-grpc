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
public final class WeatherStreamingGrpc {

  private WeatherStreamingGrpc() {}

  public static final String SERVICE_NAME = "extras.ex3.WeatherStreaming";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest,
      uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse> getObserveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Observe",
      requestType = uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest.class,
      responseType = uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest,
      uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse> getObserveMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest, uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse> getObserveMethod;
    if ((getObserveMethod = WeatherStreamingGrpc.getObserveMethod) == null) {
      synchronized (WeatherStreamingGrpc.class) {
        if ((getObserveMethod = WeatherStreamingGrpc.getObserveMethod) == null) {
          WeatherStreamingGrpc.getObserveMethod = getObserveMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest, uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "extras.ex3.WeatherStreaming", "Observe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WeatherStreamingMethodDescriptorSupplier("Observe"))
                  .build();
          }
        }
     }
     return getObserveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WeatherStreamingStub newStub(io.grpc.Channel channel) {
    return new WeatherStreamingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WeatherStreamingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WeatherStreamingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WeatherStreamingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WeatherStreamingFutureStub(channel);
  }

  /**
   */
  public static abstract class WeatherStreamingImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest> observe(
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getObserveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getObserveMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest,
                uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse>(
                  this, METHODID_OBSERVE)))
          .build();
    }
  }

  /**
   */
  public static final class WeatherStreamingStub extends io.grpc.stub.AbstractStub<WeatherStreamingStub> {
    private WeatherStreamingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherStreamingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherStreamingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherStreamingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest> observe(
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getObserveMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class WeatherStreamingBlockingStub extends io.grpc.stub.AbstractStub<WeatherStreamingBlockingStub> {
    private WeatherStreamingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherStreamingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherStreamingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherStreamingBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class WeatherStreamingFutureStub extends io.grpc.stub.AbstractStub<WeatherStreamingFutureStub> {
    private WeatherStreamingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherStreamingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherStreamingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherStreamingFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_OBSERVE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WeatherStreamingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WeatherStreamingImplBase serviceImpl, int methodId) {
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
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WeatherStreamingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WeatherStreamingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.extras.ex3.WeatherAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WeatherStreaming");
    }
  }

  private static final class WeatherStreamingFileDescriptorSupplier
      extends WeatherStreamingBaseDescriptorSupplier {
    WeatherStreamingFileDescriptorSupplier() {}
  }

  private static final class WeatherStreamingMethodDescriptorSupplier
      extends WeatherStreamingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WeatherStreamingMethodDescriptorSupplier(String methodName) {
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
      synchronized (WeatherStreamingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WeatherStreamingFileDescriptorSupplier())
              .addMethod(getObserveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
