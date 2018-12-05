package uk.me.uohiro.protobuf.model.ch6.ex2;

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
    comments = "Source: ch6/archiver.proto")
public final class ArchiverGrpc {

  private ArchiverGrpc() {}

  public static final String SERVICE_NAME = "ch6.ex2.Archiver";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest,
      uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse> getZipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Zip",
      requestType = uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest.class,
      responseType = uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest,
      uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse> getZipMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest, uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse> getZipMethod;
    if ((getZipMethod = ArchiverGrpc.getZipMethod) == null) {
      synchronized (ArchiverGrpc.class) {
        if ((getZipMethod = ArchiverGrpc.getZipMethod) == null) {
          ArchiverGrpc.getZipMethod = getZipMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest, uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ch6.ex2.Archiver", "Zip"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ArchiverMethodDescriptorSupplier("Zip"))
                  .build();
          }
        }
     }
     return getZipMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ArchiverStub newStub(io.grpc.Channel channel) {
    return new ArchiverStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ArchiverBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ArchiverBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ArchiverFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ArchiverFutureStub(channel);
  }

  /**
   */
  public static abstract class ArchiverImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest> zip(
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getZipMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getZipMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest,
                uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse>(
                  this, METHODID_ZIP)))
          .build();
    }
  }

  /**
   */
  public static final class ArchiverStub extends io.grpc.stub.AbstractStub<ArchiverStub> {
    private ArchiverStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArchiverStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArchiverStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArchiverStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest> zip(
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getZipMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ArchiverBlockingStub extends io.grpc.stub.AbstractStub<ArchiverBlockingStub> {
    private ArchiverBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArchiverBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArchiverBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArchiverBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ArchiverFutureStub extends io.grpc.stub.AbstractStub<ArchiverFutureStub> {
    private ArchiverFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArchiverFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArchiverFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArchiverFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ZIP = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ArchiverImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ArchiverImplBase serviceImpl, int methodId) {
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
        case METHODID_ZIP:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.zip(
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ArchiverBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArchiverBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch6.ex2.ArchiverServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Archiver");
    }
  }

  private static final class ArchiverFileDescriptorSupplier
      extends ArchiverBaseDescriptorSupplier {
    ArchiverFileDescriptorSupplier() {}
  }

  private static final class ArchiverMethodDescriptorSupplier
      extends ArchiverBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ArchiverMethodDescriptorSupplier(String methodName) {
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
      synchronized (ArchiverGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ArchiverFileDescriptorSupplier())
              .addMethod(getZipMethod())
              .build();
        }
      }
    }
    return result;
  }
}
