// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch7/deadline.proto

package uk.me.uohiro.protobuf.model.ch7.ex4;

/**
 * Protobuf type {@code ch7.ex4.DeadlineResponse}
 */
public  final class DeadlineResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ch7.ex4.DeadlineResponse)
    DeadlineResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DeadlineResponse.newBuilder() to construct.
  private DeadlineResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeadlineResponse() {
    result_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DeadlineResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              result_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            result_.add(s);
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        result_ = result_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineAPIProto.internal_static_ch7_ex4_DeadlineResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineAPIProto.internal_static_ch7_ex4_DeadlineResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.class, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.Builder.class);
  }

  public static final int RESULT_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList result_;
  /**
   * <code>repeated string result = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getResultList() {
    return result_;
  }
  /**
   * <code>repeated string result = 1;</code>
   */
  public int getResultCount() {
    return result_.size();
  }
  /**
   * <code>repeated string result = 1;</code>
   */
  public java.lang.String getResult(int index) {
    return result_.get(index);
  }
  /**
   * <code>repeated string result = 1;</code>
   */
  public com.google.protobuf.ByteString
      getResultBytes(int index) {
    return result_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < result_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, result_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < result_.size(); i++) {
        dataSize += computeStringSizeNoTag(result_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getResultList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse)) {
      return super.equals(obj);
    }
    uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse other = (uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse) obj;

    boolean result = true;
    result = result && getResultList()
        .equals(other.getResultList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getResultCount() > 0) {
      hash = (37 * hash) + RESULT_FIELD_NUMBER;
      hash = (53 * hash) + getResultList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ch7.ex4.DeadlineResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ch7.ex4.DeadlineResponse)
      uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineAPIProto.internal_static_ch7_ex4_DeadlineResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineAPIProto.internal_static_ch7_ex4_DeadlineResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.class, uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.Builder.class);
    }

    // Construct using uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      result_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineAPIProto.internal_static_ch7_ex4_DeadlineResponse_descriptor;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse getDefaultInstanceForType() {
      return uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.getDefaultInstance();
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse build() {
      uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse buildPartial() {
      uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse result = new uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        result_ = result_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.result_ = result_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse) {
        return mergeFrom((uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse other) {
      if (other == uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.getDefaultInstance()) return this;
      if (!other.result_.isEmpty()) {
        if (result_.isEmpty()) {
          result_ = other.result_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureResultIsMutable();
          result_.addAll(other.result_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList result_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureResultIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        result_ = new com.google.protobuf.LazyStringArrayList(result_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string result = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getResultList() {
      return result_.getUnmodifiableView();
    }
    /**
     * <code>repeated string result = 1;</code>
     */
    public int getResultCount() {
      return result_.size();
    }
    /**
     * <code>repeated string result = 1;</code>
     */
    public java.lang.String getResult(int index) {
      return result_.get(index);
    }
    /**
     * <code>repeated string result = 1;</code>
     */
    public com.google.protobuf.ByteString
        getResultBytes(int index) {
      return result_.getByteString(index);
    }
    /**
     * <code>repeated string result = 1;</code>
     */
    public Builder setResult(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureResultIsMutable();
      result_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string result = 1;</code>
     */
    public Builder addResult(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureResultIsMutable();
      result_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string result = 1;</code>
     */
    public Builder addAllResult(
        java.lang.Iterable<java.lang.String> values) {
      ensureResultIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, result_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string result = 1;</code>
     */
    public Builder clearResult() {
      result_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string result = 1;</code>
     */
    public Builder addResultBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureResultIsMutable();
      result_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ch7.ex4.DeadlineResponse)
  }

  // @@protoc_insertion_point(class_scope:ch7.ex4.DeadlineResponse)
  private static final uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse();
  }

  public static uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DeadlineResponse>
      PARSER = new com.google.protobuf.AbstractParser<DeadlineResponse>() {
    @java.lang.Override
    public DeadlineResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DeadlineResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DeadlineResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeadlineResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
