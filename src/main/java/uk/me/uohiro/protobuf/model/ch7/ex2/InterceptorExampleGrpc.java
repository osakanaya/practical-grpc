package uk.me.uohiro.protobuf.model.ch7.ex2;

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
    comments = "Source: ch7/interceptor.proto")
public final class InterceptorExampleGrpc {

  private InterceptorExampleGrpc() {}

  public static final String SERVICE_NAME = "ch7.ex2.InterceptorExample";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest,
      uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> getGetDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetData",
      requestType = uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest.class,
      responseType = uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest,
      uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> getGetDataMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest, uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> getGetDataMethod;
    if ((getGetDataMethod = InterceptorExampleGrpc.getGetDataMethod) == null) {
      synchronized (InterceptorExampleGrpc.class) {
        if ((getGetDataMethod = InterceptorExampleGrpc.getGetDataMethod) == null) {
          InterceptorExampleGrpc.getGetDataMethod = getGetDataMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest, uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex2.InterceptorExample", "GetData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new InterceptorExampleMethodDescriptorSupplier("GetData"))
                  .build();
          }
        }
     }
     return getGetDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex2.Empty,
      uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> getGetStreamDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStreamData",
      requestType = uk.me.uohiro.protobuf.model.ch7.ex2.Empty.class,
      responseType = uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex2.Empty,
      uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> getGetStreamDataMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex2.Empty, uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> getGetStreamDataMethod;
    if ((getGetStreamDataMethod = InterceptorExampleGrpc.getGetStreamDataMethod) == null) {
      synchronized (InterceptorExampleGrpc.class) {
        if ((getGetStreamDataMethod = InterceptorExampleGrpc.getGetStreamDataMethod) == null) {
          InterceptorExampleGrpc.getGetStreamDataMethod = getGetStreamDataMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex2.Empty, uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex2.InterceptorExample", "GetStreamData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex2.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new InterceptorExampleMethodDescriptorSupplier("GetStreamData"))
                  .build();
          }
        }
     }
     return getGetStreamDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InterceptorExampleStub newStub(io.grpc.Channel channel) {
    return new InterceptorExampleStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InterceptorExampleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InterceptorExampleBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InterceptorExampleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InterceptorExampleFutureStub(channel);
  }

  /**
   */
  public static abstract class InterceptorExampleImplBase implements io.grpc.BindableService {

    /**
     */
    public void getData(uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDataMethod(), responseObserver);
    }

    /**
     */
    public void getStreamData(uk.me.uohiro.protobuf.model.ch7.ex2.Empty request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest,
                uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse>(
                  this, METHODID_GET_DATA)))
          .addMethod(
            getGetStreamDataMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch7.ex2.Empty,
                uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse>(
                  this, METHODID_GET_STREAM_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class InterceptorExampleStub extends io.grpc.stub.AbstractStub<InterceptorExampleStub> {
    private InterceptorExampleStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InterceptorExampleStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InterceptorExampleStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InterceptorExampleStub(channel, callOptions);
    }

    /**
     */
    public void getData(uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStreamData(uk.me.uohiro.protobuf.model.ch7.ex2.Empty request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class InterceptorExampleBlockingStub extends io.grpc.stub.AbstractStub<InterceptorExampleBlockingStub> {
    private InterceptorExampleBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InterceptorExampleBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InterceptorExampleBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InterceptorExampleBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse getData(uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> getStreamData(
        uk.me.uohiro.protobuf.model.ch7.ex2.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class InterceptorExampleFutureStub extends io.grpc.stub.AbstractStub<InterceptorExampleFutureStub> {
    private InterceptorExampleFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InterceptorExampleFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InterceptorExampleFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InterceptorExampleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse> getData(
        uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATA = 0;
  private static final int METHODID_GET_STREAM_DATA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InterceptorExampleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InterceptorExampleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DATA:
          serviceImpl.getData((uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse>) responseObserver);
          break;
        case METHODID_GET_STREAM_DATA:
          serviceImpl.getStreamData((uk.me.uohiro.protobuf.model.ch7.ex2.Empty) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse>) responseObserver);
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

  private static abstract class InterceptorExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InterceptorExampleBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch7.ex2.InterceptorAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InterceptorExample");
    }
  }

  private static final class InterceptorExampleFileDescriptorSupplier
      extends InterceptorExampleBaseDescriptorSupplier {
    InterceptorExampleFileDescriptorSupplier() {}
  }

  private static final class InterceptorExampleMethodDescriptorSupplier
      extends InterceptorExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InterceptorExampleMethodDescriptorSupplier(String methodName) {
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
      synchronized (InterceptorExampleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InterceptorExampleFileDescriptorSupplier())
              .addMethod(getGetDataMethod())
              .addMethod(getGetStreamDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
