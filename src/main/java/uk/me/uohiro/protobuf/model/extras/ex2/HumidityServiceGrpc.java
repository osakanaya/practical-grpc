package uk.me.uohiro.protobuf.model.extras.ex2;

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
    comments = "Source: extras/ex2/weather.proto")
public final class HumidityServiceGrpc {

  private HumidityServiceGrpc() {}

  public static final String SERVICE_NAME = "extras.ex2.HumidityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex2.Coordinates,
      uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse> getGetCurrentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrent",
      requestType = uk.me.uohiro.protobuf.model.extras.ex2.Coordinates.class,
      responseType = uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex2.Coordinates,
      uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse> getGetCurrentMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex2.Coordinates, uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse> getGetCurrentMethod;
    if ((getGetCurrentMethod = HumidityServiceGrpc.getGetCurrentMethod) == null) {
      synchronized (HumidityServiceGrpc.class) {
        if ((getGetCurrentMethod = HumidityServiceGrpc.getGetCurrentMethod) == null) {
          HumidityServiceGrpc.getGetCurrentMethod = getGetCurrentMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.extras.ex2.Coordinates, uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "extras.ex2.HumidityService", "GetCurrent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex2.Coordinates.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HumidityServiceMethodDescriptorSupplier("GetCurrent"))
                  .build();
          }
        }
     }
     return getGetCurrentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HumidityServiceStub newStub(io.grpc.Channel channel) {
    return new HumidityServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HumidityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HumidityServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HumidityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HumidityServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HumidityServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCurrent(uk.me.uohiro.protobuf.model.extras.ex2.Coordinates request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.extras.ex2.Coordinates,
                uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse>(
                  this, METHODID_GET_CURRENT)))
          .build();
    }
  }

  /**
   */
  public static final class HumidityServiceStub extends io.grpc.stub.AbstractStub<HumidityServiceStub> {
    private HumidityServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HumidityServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HumidityServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCurrent(uk.me.uohiro.protobuf.model.extras.ex2.Coordinates request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HumidityServiceBlockingStub extends io.grpc.stub.AbstractStub<HumidityServiceBlockingStub> {
    private HumidityServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HumidityServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HumidityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse getCurrent(uk.me.uohiro.protobuf.model.extras.ex2.Coordinates request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HumidityServiceFutureStub extends io.grpc.stub.AbstractStub<HumidityServiceFutureStub> {
    private HumidityServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HumidityServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HumidityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse> getCurrent(
        uk.me.uohiro.protobuf.model.extras.ex2.Coordinates request) {
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
    private final HumidityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HumidityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT:
          serviceImpl.getCurrent((uk.me.uohiro.protobuf.model.extras.ex2.Coordinates) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse>) responseObserver);
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

  private static abstract class HumidityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HumidityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.extras.ex2.WeatherAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HumidityService");
    }
  }

  private static final class HumidityServiceFileDescriptorSupplier
      extends HumidityServiceBaseDescriptorSupplier {
    HumidityServiceFileDescriptorSupplier() {}
  }

  private static final class HumidityServiceMethodDescriptorSupplier
      extends HumidityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HumidityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HumidityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HumidityServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
