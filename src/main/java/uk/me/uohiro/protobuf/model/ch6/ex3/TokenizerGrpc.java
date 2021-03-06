package uk.me.uohiro.protobuf.model.ch6.ex3;

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
    comments = "Source: ch6/tokenizer.proto")
public final class TokenizerGrpc {

  private TokenizerGrpc() {}

  public static final String SERVICE_NAME = "ch6.ex3.Tokenizer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest,
      uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse> getTokenizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Tokenize",
      requestType = uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest.class,
      responseType = uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest,
      uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse> getTokenizeMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest, uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse> getTokenizeMethod;
    if ((getTokenizeMethod = TokenizerGrpc.getTokenizeMethod) == null) {
      synchronized (TokenizerGrpc.class) {
        if ((getTokenizeMethod = TokenizerGrpc.getTokenizeMethod) == null) {
          TokenizerGrpc.getTokenizeMethod = getTokenizeMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest, uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ch6.ex3.Tokenizer", "Tokenize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TokenizerMethodDescriptorSupplier("Tokenize"))
                  .build();
          }
        }
     }
     return getTokenizeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TokenizerStub newStub(io.grpc.Channel channel) {
    return new TokenizerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TokenizerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TokenizerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TokenizerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TokenizerFutureStub(channel);
  }

  /**
   */
  public static abstract class TokenizerImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest> tokenize(
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTokenizeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTokenizeMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest,
                uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse>(
                  this, METHODID_TOKENIZE)))
          .build();
    }
  }

  /**
   */
  public static final class TokenizerStub extends io.grpc.stub.AbstractStub<TokenizerStub> {
    private TokenizerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TokenizerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TokenizerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TokenizerStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest> tokenize(
        io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTokenizeMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TokenizerBlockingStub extends io.grpc.stub.AbstractStub<TokenizerBlockingStub> {
    private TokenizerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TokenizerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TokenizerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TokenizerBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class TokenizerFutureStub extends io.grpc.stub.AbstractStub<TokenizerFutureStub> {
    private TokenizerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TokenizerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TokenizerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TokenizerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TOKENIZE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TokenizerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TokenizerImplBase serviceImpl, int methodId) {
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
        case METHODID_TOKENIZE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.tokenize(
              (io.grpc.stub.StreamObserver<uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TokenizerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TokenizerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Tokenizer");
    }
  }

  private static final class TokenizerFileDescriptorSupplier
      extends TokenizerBaseDescriptorSupplier {
    TokenizerFileDescriptorSupplier() {}
  }

  private static final class TokenizerMethodDescriptorSupplier
      extends TokenizerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TokenizerMethodDescriptorSupplier(String methodName) {
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
      synchronized (TokenizerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TokenizerFileDescriptorSupplier())
              .addMethod(getTokenizeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
