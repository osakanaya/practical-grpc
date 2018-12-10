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
public final class WindServiceGrpc {

  private WindServiceGrpc() {}

  public static final String SERVICE_NAME = "extras.ex2.WindService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex2.Coordinates,
      uk.me.uohiro.protobuf.model.extras.ex2.Wind> getGetCurrentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrent",
      requestType = uk.me.uohiro.protobuf.model.extras.ex2.Coordinates.class,
      responseType = uk.me.uohiro.protobuf.model.extras.ex2.Wind.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex2.Coordinates,
      uk.me.uohiro.protobuf.model.extras.ex2.Wind> getGetCurrentMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.extras.ex2.Coordinates, uk.me.uohiro.protobuf.model.extras.ex2.Wind> getGetCurrentMethod;
    if ((getGetCurrentMethod = WindServiceGrpc.getGetCurrentMethod) == null) {
      synchronized (WindServiceGrpc.class) {
        if ((getGetCurrentMethod = WindServiceGrpc.getGetCurrentMethod) == null) {
          WindServiceGrpc.getGetCurrentMethod = getGetCurrentMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.extras.ex2.Coordinates, uk.me.uohiro.protobuf.model.extras.ex2.Wind>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "extras.ex2.WindService", "GetCurrent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex2.Coordinates.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.extras.ex2.Wind.getDefaultInstance()))
                  .setSchemaDescriptor(new WindServiceMethodDescriptorSupplier("GetCurrent"))
                  .build();
          }
        }
     }
     return getGetCurrentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WindServiceStub newStub(io.grpc.Channel channel) {
    return new WindServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WindServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WindServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WindServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WindServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class WindServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCurrent(uk.me.uohiro.protobuf.model.extras.ex2.Coordinates request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex2.Wind> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.extras.ex2.Coordinates,
                uk.me.uohiro.protobuf.model.extras.ex2.Wind>(
                  this, METHODID_GET_CURRENT)))
          .build();
    }
  }

  /**
   */
  public static final class WindServiceStub extends io.grpc.stub.AbstractStub<WindServiceStub> {
    private WindServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WindServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WindServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WindServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCurrent(uk.me.uohiro.protobuf.model.extras.ex2.Coordinates request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex2.Wind> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WindServiceBlockingStub extends io.grpc.stub.AbstractStub<WindServiceBlockingStub> {
    private WindServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WindServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WindServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WindServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.extras.ex2.Wind getCurrent(uk.me.uohiro.protobuf.model.extras.ex2.Coordinates request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WindServiceFutureStub extends io.grpc.stub.AbstractStub<WindServiceFutureStub> {
    private WindServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WindServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WindServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WindServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.extras.ex2.Wind> getCurrent(
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
    private final WindServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WindServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT:
          serviceImpl.getCurrent((uk.me.uohiro.protobuf.model.extras.ex2.Coordinates) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.extras.ex2.Wind>) responseObserver);
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

  private static abstract class WindServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WindServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.extras.ex2.WeatherAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WindService");
    }
  }

  private static final class WindServiceFileDescriptorSupplier
      extends WindServiceBaseDescriptorSupplier {
    WindServiceFileDescriptorSupplier() {}
  }

  private static final class WindServiceMethodDescriptorSupplier
      extends WindServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WindServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WindServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WindServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
