// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch3/ex15.proto

package uk.me.uohiro.protobuf.model.ch3.ex15;

/**
 * Protobuf type {@code ch3.ex15.Test2}
 */
public  final class Test2 extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ch3.ex15.Test2)
    Test2OrBuilder {
private static final long serialVersionUID = 0L;
  // Use Test2.newBuilder() to construct.
  private Test2(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Test2() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Test2(
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
          case 18: {
            uk.me.uohiro.protobuf.model.ch3.ex15.Test1.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = value_.toBuilder();
            }
            value_ = input.readMessage(uk.me.uohiro.protobuf.model.ch3.ex15.Test1.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(value_);
              value_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          default: {
            if (!parseUnknownField(
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return uk.me.uohiro.protobuf.model.ch3.ex15.VariantProto.internal_static_ch3_ex15_Test2_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return uk.me.uohiro.protobuf.model.ch3.ex15.VariantProto.internal_static_ch3_ex15_Test2_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            uk.me.uohiro.protobuf.model.ch3.ex15.Test2.class, uk.me.uohiro.protobuf.model.ch3.ex15.Test2.Builder.class);
  }

  private int bitField0_;
  public static final int VALUE_FIELD_NUMBER = 2;
  private uk.me.uohiro.protobuf.model.ch3.ex15.Test1 value_;
  /**
   * <code>required .ch3.ex15.Test1 value = 2;</code>
   */
  public boolean hasValue() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required .ch3.ex15.Test1 value = 2;</code>
   */
  public uk.me.uohiro.protobuf.model.ch3.ex15.Test1 getValue() {
    return value_ == null ? uk.me.uohiro.protobuf.model.ch3.ex15.Test1.getDefaultInstance() : value_;
  }
  /**
   * <code>required .ch3.ex15.Test1 value = 2;</code>
   */
  public uk.me.uohiro.protobuf.model.ch3.ex15.Test1OrBuilder getValueOrBuilder() {
    return value_ == null ? uk.me.uohiro.protobuf.model.ch3.ex15.Test1.getDefaultInstance() : value_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasValue()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!getValue().isInitialized()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeMessage(2, getValue());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getValue());
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
    if (!(obj instanceof uk.me.uohiro.protobuf.model.ch3.ex15.Test2)) {
      return super.equals(obj);
    }
    uk.me.uohiro.protobuf.model.ch3.ex15.Test2 other = (uk.me.uohiro.protobuf.model.ch3.ex15.Test2) obj;

    boolean result = true;
    result = result && (hasValue() == other.hasValue());
    if (hasValue()) {
      result = result && getValue()
          .equals(other.getValue());
    }
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
    if (hasValue()) {
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parseFrom(
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
  public static Builder newBuilder(uk.me.uohiro.protobuf.model.ch3.ex15.Test2 prototype) {
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
   * Protobuf type {@code ch3.ex15.Test2}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ch3.ex15.Test2)
      uk.me.uohiro.protobuf.model.ch3.ex15.Test2OrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return uk.me.uohiro.protobuf.model.ch3.ex15.VariantProto.internal_static_ch3_ex15_Test2_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return uk.me.uohiro.protobuf.model.ch3.ex15.VariantProto.internal_static_ch3_ex15_Test2_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              uk.me.uohiro.protobuf.model.ch3.ex15.Test2.class, uk.me.uohiro.protobuf.model.ch3.ex15.Test2.Builder.class);
    }

    // Construct using uk.me.uohiro.protobuf.model.ch3.ex15.Test2.newBuilder()
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
        getValueFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (valueBuilder_ == null) {
        value_ = null;
      } else {
        valueBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return uk.me.uohiro.protobuf.model.ch3.ex15.VariantProto.internal_static_ch3_ex15_Test2_descriptor;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch3.ex15.Test2 getDefaultInstanceForType() {
      return uk.me.uohiro.protobuf.model.ch3.ex15.Test2.getDefaultInstance();
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch3.ex15.Test2 build() {
      uk.me.uohiro.protobuf.model.ch3.ex15.Test2 result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch3.ex15.Test2 buildPartial() {
      uk.me.uohiro.protobuf.model.ch3.ex15.Test2 result = new uk.me.uohiro.protobuf.model.ch3.ex15.Test2(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (valueBuilder_ == null) {
        result.value_ = value_;
      } else {
        result.value_ = valueBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof uk.me.uohiro.protobuf.model.ch3.ex15.Test2) {
        return mergeFrom((uk.me.uohiro.protobuf.model.ch3.ex15.Test2)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(uk.me.uohiro.protobuf.model.ch3.ex15.Test2 other) {
      if (other == uk.me.uohiro.protobuf.model.ch3.ex15.Test2.getDefaultInstance()) return this;
      if (other.hasValue()) {
        mergeValue(other.getValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasValue()) {
        return false;
      }
      if (!getValue().isInitialized()) {
        return false;
      }
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      uk.me.uohiro.protobuf.model.ch3.ex15.Test2 parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (uk.me.uohiro.protobuf.model.ch3.ex15.Test2) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private uk.me.uohiro.protobuf.model.ch3.ex15.Test1 value_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        uk.me.uohiro.protobuf.model.ch3.ex15.Test1, uk.me.uohiro.protobuf.model.ch3.ex15.Test1.Builder, uk.me.uohiro.protobuf.model.ch3.ex15.Test1OrBuilder> valueBuilder_;
    /**
     * <code>required .ch3.ex15.Test1 value = 2;</code>
     */
    public boolean hasValue() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .ch3.ex15.Test1 value = 2;</code>
     */
    public uk.me.uohiro.protobuf.model.ch3.ex15.Test1 getValue() {
      if (valueBuilder_ == null) {
        return value_ == null ? uk.me.uohiro.protobuf.model.ch3.ex15.Test1.getDefaultInstance() : value_;
      } else {
        return valueBuilder_.getMessage();
      }
    }
    /**
     * <code>required .ch3.ex15.Test1 value = 2;</code>
     */
    public Builder setValue(uk.me.uohiro.protobuf.model.ch3.ex15.Test1 value) {
      if (valueBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        value_ = value;
        onChanged();
      } else {
        valueBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .ch3.ex15.Test1 value = 2;</code>
     */
    public Builder setValue(
        uk.me.uohiro.protobuf.model.ch3.ex15.Test1.Builder builderForValue) {
      if (valueBuilder_ == null) {
        value_ = builderForValue.build();
        onChanged();
      } else {
        valueBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .ch3.ex15.Test1 value = 2;</code>
     */
    public Builder mergeValue(uk.me.uohiro.protobuf.model.ch3.ex15.Test1 value) {
      if (valueBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
            value_ != null &&
            value_ != uk.me.uohiro.protobuf.model.ch3.ex15.Test1.getDefaultInstance()) {
          value_ =
            uk.me.uohiro.protobuf.model.ch3.ex15.Test1.newBuilder(value_).mergeFrom(value).buildPartial();
        } else {
          value_ = value;
        }
        onChanged();
      } else {
        valueBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .ch3.ex15.Test1 value = 2;</code>
     */
    public Builder clearValue() {
      if (valueBuilder_ == null) {
        value_ = null;
        onChanged();
      } else {
        valueBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>required .ch3.ex15.Test1 value = 2;</code>
     */
    public uk.me.uohiro.protobuf.model.ch3.ex15.Test1.Builder getValueBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getValueFieldBuilder().getBuilder();
    }
    /**
     * <code>required .ch3.ex15.Test1 value = 2;</code>
     */
    public uk.me.uohiro.protobuf.model.ch3.ex15.Test1OrBuilder getValueOrBuilder() {
      if (valueBuilder_ != null) {
        return valueBuilder_.getMessageOrBuilder();
      } else {
        return value_ == null ?
            uk.me.uohiro.protobuf.model.ch3.ex15.Test1.getDefaultInstance() : value_;
      }
    }
    /**
     * <code>required .ch3.ex15.Test1 value = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        uk.me.uohiro.protobuf.model.ch3.ex15.Test1, uk.me.uohiro.protobuf.model.ch3.ex15.Test1.Builder, uk.me.uohiro.protobuf.model.ch3.ex15.Test1OrBuilder> 
        getValueFieldBuilder() {
      if (valueBuilder_ == null) {
        valueBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            uk.me.uohiro.protobuf.model.ch3.ex15.Test1, uk.me.uohiro.protobuf.model.ch3.ex15.Test1.Builder, uk.me.uohiro.protobuf.model.ch3.ex15.Test1OrBuilder>(
                getValue(),
                getParentForChildren(),
                isClean());
        value_ = null;
      }
      return valueBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ch3.ex15.Test2)
  }

  // @@protoc_insertion_point(class_scope:ch3.ex15.Test2)
  private static final uk.me.uohiro.protobuf.model.ch3.ex15.Test2 DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new uk.me.uohiro.protobuf.model.ch3.ex15.Test2();
  }

  public static uk.me.uohiro.protobuf.model.ch3.ex15.Test2 getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<Test2>
      PARSER = new com.google.protobuf.AbstractParser<Test2>() {
    @java.lang.Override
    public Test2 parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Test2(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Test2> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Test2> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public uk.me.uohiro.protobuf.model.ch3.ex15.Test2 getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

