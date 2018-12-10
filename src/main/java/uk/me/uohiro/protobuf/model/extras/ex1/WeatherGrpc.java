package uk.me.uohiro.protobuf.model.extras.ex1;

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
    comments = "Source: extras/ex1/weather.proto")
public final class WeatherGrpc {

  private WeatherGrpc() {}

  public static final String SERVICE_NAME = "extras.ex1.Weather";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest,
      uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse> getGetCurrentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrent",
      requestType = uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest.class,
      responseType = uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest,
      uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse> getGetCurrentMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest, uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse> getGetCurrentMethod;
    if ((getGetCurrentMethod = WeatherGrpc.getGetCurrentMethod) == null) {
      synchronized (WeatherGrpc.class) {
        if ((getGetCurrentMethod = WeatherGrpc.getGetCurrentMethod) == null) {
          WeatherGrpc.getGetCurrentMethod = getGetCurrentMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest, uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "extras.ex1.Weather", "GetCurrent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WeatherMethodDescriptorSupplier("GetCurrent"))
                  .build();
          }
        }
     }
     return getGetCurrentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WeatherStub newStub(io.grpc.Channel channel) {
    return new WeatherStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WeatherBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WeatherBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WeatherFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WeatherFutureStub(channel);
  }

  /**
   */
  public static abstract class WeatherImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCurrent(uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest,
                uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse>(
                  this, METHODID_GET_CURRENT)))
          .build();
    }
  }

  /**
   */
  public static final class WeatherStub extends io.grpc.stub.AbstractStub<WeatherStub> {
    private WeatherStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherStub(channel, callOptions);
    }

    /**
     */
    public void getCurrent(uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WeatherBlockingStub extends io.grpc.stub.AbstractStub<WeatherBlockingStub> {
    private WeatherBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse getCurrent(uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WeatherFutureStub extends io.grpc.stub.AbstractStub<WeatherFutureStub> {
    private WeatherFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse> getCurrent(
        uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WeatherImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WeatherImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT:
          serviceImpl.getCurrent((uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse>) responseObserver);
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

  private static abstract class WeatherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WeatherBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.extras.ex1.WeatherAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Weather");
    }
  }

  private static final class WeatherFileDescriptorSupplier
      extends WeatherBaseDescriptorSupplier {
    WeatherFileDescriptorSupplier() {}
  }

  private static final class WeatherMethodDescriptorSupplier
      extends WeatherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WeatherMethodDescriptorSupplier(String methodName) {
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
      synchronized (WeatherGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WeatherFileDescriptorSupplier())
              .addMethod(getGetCurrentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
