package uk.me.uohiro.protobuf.model.ch11.ex1;

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
    comments = "Source: ch11/ex1/sfapi.proto")
public final class StarFriendsGrpc {

  private StarFriendsGrpc() {}

  public static final String SERVICE_NAME = "ch11.ex1.StarFriends";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest,
      uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse> getGetFilmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFilm",
      requestType = uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest.class,
      responseType = uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest,
      uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse> getGetFilmMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest, uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse> getGetFilmMethod;
    if ((getGetFilmMethod = StarFriendsGrpc.getGetFilmMethod) == null) {
      synchronized (StarFriendsGrpc.class) {
        if ((getGetFilmMethod = StarFriendsGrpc.getGetFilmMethod) == null) {
          StarFriendsGrpc.getGetFilmMethod = getGetFilmMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest, uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch11.ex1.StarFriends", "GetFilm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StarFriendsMethodDescriptorSupplier("GetFilm"))
                  .build();
          }
        }
     }
     return getGetFilmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest,
      uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse> getListFilmsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFilms",
      requestType = uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest.class,
      responseType = uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest,
      uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse> getListFilmsMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest, uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse> getListFilmsMethod;
    if ((getListFilmsMethod = StarFriendsGrpc.getListFilmsMethod) == null) {
      synchronized (StarFriendsGrpc.class) {
        if ((getListFilmsMethod = StarFriendsGrpc.getListFilmsMethod) == null) {
          StarFriendsGrpc.getListFilmsMethod = getListFilmsMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest, uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch11.ex1.StarFriends", "ListFilms"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StarFriendsMethodDescriptorSupplier("ListFilms"))
                  .build();
          }
        }
     }
     return getListFilmsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StarFriendsStub newStub(io.grpc.Channel channel) {
    return new StarFriendsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StarFriendsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StarFriendsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StarFriendsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StarFriendsFutureStub(channel);
  }

  /**
   */
  public static abstract class StarFriendsImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFilm(uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFilmMethod(), responseObserver);
    }

    /**
     */
    public void listFilms(uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListFilmsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFilmMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest,
                uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse>(
                  this, METHODID_GET_FILM)))
          .addMethod(
            getListFilmsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest,
                uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse>(
                  this, METHODID_LIST_FILMS)))
          .build();
    }
  }

  /**
   */
  public static final class StarFriendsStub extends io.grpc.stub.AbstractStub<StarFriendsStub> {
    private StarFriendsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StarFriendsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StarFriendsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StarFriendsStub(channel, callOptions);
    }

    /**
     */
    public void getFilm(uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFilmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listFilms(uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListFilmsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StarFriendsBlockingStub extends io.grpc.stub.AbstractStub<StarFriendsBlockingStub> {
    private StarFriendsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StarFriendsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StarFriendsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StarFriendsBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse getFilm(uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFilmMethod(), getCallOptions(), request);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse listFilms(uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListFilmsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StarFriendsFutureStub extends io.grpc.stub.AbstractStub<StarFriendsFutureStub> {
    private StarFriendsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StarFriendsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StarFriendsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StarFriendsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse> getFilm(
        uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFilmMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse> listFilms(
        uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListFilmsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FILM = 0;
  private static final int METHODID_LIST_FILMS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StarFriendsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StarFriendsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FILM:
          serviceImpl.getFilm((uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse>) responseObserver);
          break;
        case METHODID_LIST_FILMS:
          serviceImpl.listFilms((uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse>) responseObserver);
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

  private static abstract class StarFriendsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StarFriendsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch11.ex1.StarFriendsAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StarFriends");
    }
  }

  private static final class StarFriendsFileDescriptorSupplier
      extends StarFriendsBaseDescriptorSupplier {
    StarFriendsFileDescriptorSupplier() {}
  }

  private static final class StarFriendsMethodDescriptorSupplier
      extends StarFriendsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StarFriendsMethodDescriptorSupplier(String methodName) {
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
      synchronized (StarFriendsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StarFriendsFileDescriptorSupplier())
              .addMethod(getGetFilmMethod())
              .addMethod(getListFilmsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
