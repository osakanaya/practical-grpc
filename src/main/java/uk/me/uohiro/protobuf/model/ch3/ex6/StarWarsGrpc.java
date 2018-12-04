package uk.me.uohiro.protobuf.model.ch3.ex6;

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
    comments = "Source: ch3/ex6.proto")
public final class StarWarsGrpc {

  private StarWarsGrpc() {}

  public static final String SERVICE_NAME = "ch3.ex6.StarWars";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest,
      uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse> getGetFilmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFilm",
      requestType = uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest.class,
      responseType = uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest,
      uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse> getGetFilmMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest, uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse> getGetFilmMethod;
    if ((getGetFilmMethod = StarWarsGrpc.getGetFilmMethod) == null) {
      synchronized (StarWarsGrpc.class) {
        if ((getGetFilmMethod = StarWarsGrpc.getGetFilmMethod) == null) {
          StarWarsGrpc.getGetFilmMethod = getGetFilmMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest, uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch3.ex6.StarWars", "GetFilm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StarWarsMethodDescriptorSupplier("GetFilm"))
                  .build();
          }
        }
     }
     return getGetFilmMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StarWarsStub newStub(io.grpc.Channel channel) {
    return new StarWarsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StarWarsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StarWarsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StarWarsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StarWarsFutureStub(channel);
  }

  /**
   */
  public static abstract class StarWarsImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFilm(uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFilmMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFilmMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest,
                uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse>(
                  this, METHODID_GET_FILM)))
          .build();
    }
  }

  /**
   */
  public static final class StarWarsStub extends io.grpc.stub.AbstractStub<StarWarsStub> {
    private StarWarsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StarWarsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StarWarsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StarWarsStub(channel, callOptions);
    }

    /**
     */
    public void getFilm(uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFilmMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StarWarsBlockingStub extends io.grpc.stub.AbstractStub<StarWarsBlockingStub> {
    private StarWarsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StarWarsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StarWarsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StarWarsBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse getFilm(uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFilmMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StarWarsFutureStub extends io.grpc.stub.AbstractStub<StarWarsFutureStub> {
    private StarWarsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StarWarsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StarWarsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StarWarsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse> getFilm(
        uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFilmMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FILM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StarWarsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StarWarsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FILM:
          serviceImpl.getFilm((uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse>) responseObserver);
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

  private static abstract class StarWarsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StarWarsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch3.ex6.FilmProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StarWars");
    }
  }

  private static final class StarWarsFileDescriptorSupplier
      extends StarWarsBaseDescriptorSupplier {
    StarWarsFileDescriptorSupplier() {}
  }

  private static final class StarWarsMethodDescriptorSupplier
      extends StarWarsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StarWarsMethodDescriptorSupplier(String methodName) {
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
      synchronized (StarWarsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StarWarsFileDescriptorSupplier())
              .addMethod(getGetFilmMethod())
              .build();
        }
      }
    }
    return result;
  }
}
