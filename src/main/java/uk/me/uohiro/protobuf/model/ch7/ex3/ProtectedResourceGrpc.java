package uk.me.uohiro.protobuf.model.ch7.ex3;

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
    comments = "Source: ch7/oauth_authentication.proto")
public final class ProtectedResourceGrpc {

  private ProtectedResourceGrpc() {}

  public static final String SERVICE_NAME = "ch7.ex3.ProtectedResource";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex3.Empty,
      uk.me.uohiro.protobuf.model.ch7.ex3.Greeting> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = uk.me.uohiro.protobuf.model.ch7.ex3.Empty.class,
      responseType = uk.me.uohiro.protobuf.model.ch7.ex3.Greeting.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex3.Empty,
      uk.me.uohiro.protobuf.model.ch7.ex3.Greeting> getSayHelloMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch7.ex3.Empty, uk.me.uohiro.protobuf.model.ch7.ex3.Greeting> getSayHelloMethod;
    if ((getSayHelloMethod = ProtectedResourceGrpc.getSayHelloMethod) == null) {
      synchronized (ProtectedResourceGrpc.class) {
        if ((getSayHelloMethod = ProtectedResourceGrpc.getSayHelloMethod) == null) {
          ProtectedResourceGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch7.ex3.Empty, uk.me.uohiro.protobuf.model.ch7.ex3.Greeting>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ch7.ex3.ProtectedResource", "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex3.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch7.ex3.Greeting.getDefaultInstance()))
                  .setSchemaDescriptor(new ProtectedResourceMethodDescriptorSupplier("SayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProtectedResourceStub newStub(io.grpc.Channel channel) {
    return new ProtectedResourceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProtectedResourceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProtectedResourceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProtectedResourceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProtectedResourceFutureStub(channel);
  }

  /**
   */
  public static abstract class ProtectedResourceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(uk.me.uohiro.protobuf.model.ch7.ex3.Empty request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex3.Greeting> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch7.ex3.Empty,
                uk.me.uohiro.protobuf.model.ch7.ex3.Greeting>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class ProtectedResourceStub extends io.grpc.stub.AbstractStub<ProtectedResourceStub> {
    private ProtectedResourceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtectedResourceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtectedResourceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtectedResourceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(uk.me.uohiro.protobuf.model.ch7.ex3.Empty request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex3.Greeting> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProtectedResourceBlockingStub extends io.grpc.stub.AbstractStub<ProtectedResourceBlockingStub> {
    private ProtectedResourceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtectedResourceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtectedResourceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtectedResourceBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.protobuf.model.ch7.ex3.Greeting sayHello(uk.me.uohiro.protobuf.model.ch7.ex3.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProtectedResourceFutureStub extends io.grpc.stub.AbstractStub<ProtectedResourceFutureStub> {
    private ProtectedResourceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtectedResourceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtectedResourceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtectedResourceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.protobuf.model.ch7.ex3.Greeting> sayHello(
        uk.me.uohiro.protobuf.model.ch7.ex3.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProtectedResourceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProtectedResourceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((uk.me.uohiro.protobuf.model.ch7.ex3.Empty) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch7.ex3.Greeting>) responseObserver);
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

  private static abstract class ProtectedResourceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProtectedResourceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch7.ex3.ProtectedResourceAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProtectedResource");
    }
  }

  private static final class ProtectedResourceFileDescriptorSupplier
      extends ProtectedResourceBaseDescriptorSupplier {
    ProtectedResourceFileDescriptorSupplier() {}
  }

  private static final class ProtectedResourceMethodDescriptorSupplier
      extends ProtectedResourceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProtectedResourceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProtectedResourceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProtectedResourceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
