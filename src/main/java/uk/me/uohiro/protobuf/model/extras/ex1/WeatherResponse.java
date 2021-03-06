// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: extras/ex1/weather.proto

package uk.me.uohiro.protobuf.model.extras.ex1;

/**
 * Protobuf type {@code extras.ex1.WeatherResponse}
 */
public  final class WeatherResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:extras.ex1.WeatherResponse)
    WeatherResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WeatherResponse.newBuilder() to construct.
  private WeatherResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WeatherResponse() {
    humidity_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WeatherResponse(
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
            uk.me.uohiro.protobuf.model.extras.ex1.Temperature.Builder subBuilder = null;
            if (temperature_ != null) {
              subBuilder = temperature_.toBuilder();
            }
            temperature_ = input.readMessage(uk.me.uohiro.protobuf.model.extras.ex1.Temperature.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(temperature_);
              temperature_ = subBuilder.buildPartial();
            }

            break;
          }
          case 21: {

            humidity_ = input.readFloat();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return uk.me.uohiro.protobuf.model.extras.ex1.WeatherAPIProto.internal_static_extras_ex1_WeatherResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return uk.me.uohiro.protobuf.model.extras.ex1.WeatherAPIProto.internal_static_extras_ex1_WeatherResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse.class, uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse.Builder.class);
  }

  public static final int TEMPERATURE_FIELD_NUMBER = 1;
  private uk.me.uohiro.protobuf.model.extras.ex1.Temperature temperature_;
  /**
   * <code>.extras.ex1.Temperature temperature = 1;</code>
   */
  public boolean hasTemperature() {
    return temperature_ != null;
  }
  /**
   * <code>.extras.ex1.Temperature temperature = 1;</code>
   */
  public uk.me.uohiro.protobuf.model.extras.ex1.Temperature getTemperature() {
    return temperature_ == null ? uk.me.uohiro.protobuf.model.extras.ex1.Temperature.getDefaultInstance() : temperature_;
  }
  /**
   * <code>.extras.ex1.Temperature temperature = 1;</code>
   */
  public uk.me.uohiro.protobuf.model.extras.ex1.TemperatureOrBuilder getTemperatureOrBuilder() {
    return getTemperature();
  }

  public static final int HUMIDITY_FIELD_NUMBER = 2;
  private float humidity_;
  /**
   * <code>float humidity = 2;</code>
   */
  public float getHumidity() {
    return humidity_;
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
    if (temperature_ != null) {
      output.writeMessage(1, getTemperature());
    }
    if (humidity_ != 0F) {
      output.writeFloat(2, humidity_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (temperature_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getTemperature());
    }
    if (humidity_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, humidity_);
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
    if (!(obj instanceof uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse)) {
      return super.equals(obj);
    }
    uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse other = (uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse) obj;

    boolean result = true;
    result = result && (hasTemperature() == other.hasTemperature());
    if (hasTemperature()) {
      result = result && getTemperature()
          .equals(other.getTemperature());
    }
    result = result && (
        java.lang.Float.floatToIntBits(getHumidity())
        == java.lang.Float.floatToIntBits(
            other.getHumidity()));
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
    if (hasTemperature()) {
      hash = (37 * hash) + TEMPERATURE_FIELD_NUMBER;
      hash = (53 * hash) + getTemperature().hashCode();
    }
    hash = (37 * hash) + HUMIDITY_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getHumidity());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parseFrom(
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
  public static Builder newBuilder(uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse prototype) {
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
   * Protobuf type {@code extras.ex1.WeatherResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:extras.ex1.WeatherResponse)
      uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return uk.me.uohiro.protobuf.model.extras.ex1.WeatherAPIProto.internal_static_extras_ex1_WeatherResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return uk.me.uohiro.protobuf.model.extras.ex1.WeatherAPIProto.internal_static_extras_ex1_WeatherResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse.class, uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse.Builder.class);
    }

    // Construct using uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse.newBuilder()
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
      if (temperatureBuilder_ == null) {
        temperature_ = null;
      } else {
        temperature_ = null;
        temperatureBuilder_ = null;
      }
      humidity_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return uk.me.uohiro.protobuf.model.extras.ex1.WeatherAPIProto.internal_static_extras_ex1_WeatherResponse_descriptor;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse getDefaultInstanceForType() {
      return uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse.getDefaultInstance();
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse build() {
      uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse buildPartial() {
      uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse result = new uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse(this);
      if (temperatureBuilder_ == null) {
        result.temperature_ = temperature_;
      } else {
        result.temperature_ = temperatureBuilder_.build();
      }
      result.humidity_ = humidity_;
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
      if (other instanceof uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse) {
        return mergeFrom((uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse other) {
      if (other == uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse.getDefaultInstance()) return this;
      if (other.hasTemperature()) {
        mergeTemperature(other.getTemperature());
      }
      if (other.getHumidity() != 0F) {
        setHumidity(other.getHumidity());
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
      uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private uk.me.uohiro.protobuf.model.extras.ex1.Temperature temperature_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        uk.me.uohiro.protobuf.model.extras.ex1.Temperature, uk.me.uohiro.protobuf.model.extras.ex1.Temperature.Builder, uk.me.uohiro.protobuf.model.extras.ex1.TemperatureOrBuilder> temperatureBuilder_;
    /**
     * <code>.extras.ex1.Temperature temperature = 1;</code>
     */
    public boolean hasTemperature() {
      return temperatureBuilder_ != null || temperature_ != null;
    }
    /**
     * <code>.extras.ex1.Temperature temperature = 1;</code>
     */
    public uk.me.uohiro.protobuf.model.extras.ex1.Temperature getTemperature() {
      if (temperatureBuilder_ == null) {
        return temperature_ == null ? uk.me.uohiro.protobuf.model.extras.ex1.Temperature.getDefaultInstance() : temperature_;
      } else {
        return temperatureBuilder_.getMessage();
      }
    }
    /**
     * <code>.extras.ex1.Temperature temperature = 1;</code>
     */
    public Builder setTemperature(uk.me.uohiro.protobuf.model.extras.ex1.Temperature value) {
      if (temperatureBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        temperature_ = value;
        onChanged();
      } else {
        temperatureBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.extras.ex1.Temperature temperature = 1;</code>
     */
    public Builder setTemperature(
        uk.me.uohiro.protobuf.model.extras.ex1.Temperature.Builder builderForValue) {
      if (temperatureBuilder_ == null) {
        temperature_ = builderForValue.build();
        onChanged();
      } else {
        temperatureBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.extras.ex1.Temperature temperature = 1;</code>
     */
    public Builder mergeTemperature(uk.me.uohiro.protobuf.model.extras.ex1.Temperature value) {
      if (temperatureBuilder_ == null) {
        if (temperature_ != null) {
          temperature_ =
            uk.me.uohiro.protobuf.model.extras.ex1.Temperature.newBuilder(temperature_).mergeFrom(value).buildPartial();
        } else {
          temperature_ = value;
        }
        onChanged();
      } else {
        temperatureBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.extras.ex1.Temperature temperature = 1;</code>
     */
    public Builder clearTemperature() {
      if (temperatureBuilder_ == null) {
        temperature_ = null;
        onChanged();
      } else {
        temperature_ = null;
        temperatureBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.extras.ex1.Temperature temperature = 1;</code>
     */
    public uk.me.uohiro.protobuf.model.extras.ex1.Temperature.Builder getTemperatureBuilder() {
      
      onChanged();
      return getTemperatureFieldBuilder().getBuilder();
    }
    /**
     * <code>.extras.ex1.Temperature temperature = 1;</code>
     */
    public uk.me.uohiro.protobuf.model.extras.ex1.TemperatureOrBuilder getTemperatureOrBuilder() {
      if (temperatureBuilder_ != null) {
        return temperatureBuilder_.getMessageOrBuilder();
      } else {
        return temperature_ == null ?
            uk.me.uohiro.protobuf.model.extras.ex1.Temperature.getDefaultInstance() : temperature_;
      }
    }
    /**
     * <code>.extras.ex1.Temperature temperature = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        uk.me.uohiro.protobuf.model.extras.ex1.Temperature, uk.me.uohiro.protobuf.model.extras.ex1.Temperature.Builder, uk.me.uohiro.protobuf.model.extras.ex1.TemperatureOrBuilder> 
        getTemperatureFieldBuilder() {
      if (temperatureBuilder_ == null) {
        temperatureBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            uk.me.uohiro.protobuf.model.extras.ex1.Temperature, uk.me.uohiro.protobuf.model.extras.ex1.Temperature.Builder, uk.me.uohiro.protobuf.model.extras.ex1.TemperatureOrBuilder>(
                getTemperature(),
                getParentForChildren(),
                isClean());
        temperature_ = null;
      }
      return temperatureBuilder_;
    }

    private float humidity_ ;
    /**
     * <code>float humidity = 2;</code>
     */
    public float getHumidity() {
      return humidity_;
    }
    /**
     * <code>float humidity = 2;</code>
     */
    public Builder setHumidity(float value) {
      
      humidity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float humidity = 2;</code>
     */
    public Builder clearHumidity() {
      
      humidity_ = 0F;
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


    // @@protoc_insertion_point(builder_scope:extras.ex1.WeatherResponse)
  }

  // @@protoc_insertion_point(class_scope:extras.ex1.WeatherResponse)
  private static final uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse();
  }

  public static uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WeatherResponse>
      PARSER = new com.google.protobuf.AbstractParser<WeatherResponse>() {
    @java.lang.Override
    public WeatherResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WeatherResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WeatherResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WeatherResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

