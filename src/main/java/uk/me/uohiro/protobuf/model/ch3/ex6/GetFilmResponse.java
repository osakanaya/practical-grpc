// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch3/ex6.proto

package uk.me.uohiro.protobuf.model.ch3.ex6;

/**
 * Protobuf type {@code ch3.ex6.GetFilmResponse}
 */
public  final class GetFilmResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ch3.ex6.GetFilmResponse)
    GetFilmResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetFilmResponse.newBuilder() to construct.
  private GetFilmResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetFilmResponse() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetFilmResponse(
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
            uk.me.uohiro.protobuf.model.ch3.ex6.Film.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = film_.toBuilder();
            }
            film_ = input.readMessage(uk.me.uohiro.protobuf.model.ch3.ex6.Film.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(film_);
              film_ = subBuilder.buildPartial();
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
    return uk.me.uohiro.protobuf.model.ch3.ex6.FilmProto.internal_static_ch3_ex6_GetFilmResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return uk.me.uohiro.protobuf.model.ch3.ex6.FilmProto.internal_static_ch3_ex6_GetFilmResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse.class, uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse.Builder.class);
  }

  private int bitField0_;
  public static final int FILM_FIELD_NUMBER = 1;
  private uk.me.uohiro.protobuf.model.ch3.ex6.Film film_;
  /**
   * <code>required .ch3.ex6.Film film = 1;</code>
   */
  public boolean hasFilm() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required .ch3.ex6.Film film = 1;</code>
   */
  public uk.me.uohiro.protobuf.model.ch3.ex6.Film getFilm() {
    return film_ == null ? uk.me.uohiro.protobuf.model.ch3.ex6.Film.getDefaultInstance() : film_;
  }
  /**
   * <code>required .ch3.ex6.Film film = 1;</code>
   */
  public uk.me.uohiro.protobuf.model.ch3.ex6.FilmOrBuilder getFilmOrBuilder() {
    return film_ == null ? uk.me.uohiro.protobuf.model.ch3.ex6.Film.getDefaultInstance() : film_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasFilm()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!getFilm().isInitialized()) {
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
      output.writeMessage(1, getFilm());
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
        .computeMessageSize(1, getFilm());
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
    if (!(obj instanceof uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse)) {
      return super.equals(obj);
    }
    uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse other = (uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse) obj;

    boolean result = true;
    result = result && (hasFilm() == other.hasFilm());
    if (hasFilm()) {
      result = result && getFilm()
          .equals(other.getFilm());
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
    if (hasFilm()) {
      hash = (37 * hash) + FILM_FIELD_NUMBER;
      hash = (53 * hash) + getFilm().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parseFrom(
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
  public static Builder newBuilder(uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse prototype) {
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
   * Protobuf type {@code ch3.ex6.GetFilmResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ch3.ex6.GetFilmResponse)
      uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return uk.me.uohiro.protobuf.model.ch3.ex6.FilmProto.internal_static_ch3_ex6_GetFilmResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return uk.me.uohiro.protobuf.model.ch3.ex6.FilmProto.internal_static_ch3_ex6_GetFilmResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse.class, uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse.Builder.class);
    }

    // Construct using uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse.newBuilder()
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
        getFilmFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (filmBuilder_ == null) {
        film_ = null;
      } else {
        filmBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return uk.me.uohiro.protobuf.model.ch3.ex6.FilmProto.internal_static_ch3_ex6_GetFilmResponse_descriptor;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse getDefaultInstanceForType() {
      return uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse.getDefaultInstance();
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse build() {
      uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse buildPartial() {
      uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse result = new uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (filmBuilder_ == null) {
        result.film_ = film_;
      } else {
        result.film_ = filmBuilder_.build();
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
      if (other instanceof uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse) {
        return mergeFrom((uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse other) {
      if (other == uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse.getDefaultInstance()) return this;
      if (other.hasFilm()) {
        mergeFilm(other.getFilm());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasFilm()) {
        return false;
      }
      if (!getFilm().isInitialized()) {
        return false;
      }
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private uk.me.uohiro.protobuf.model.ch3.ex6.Film film_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        uk.me.uohiro.protobuf.model.ch3.ex6.Film, uk.me.uohiro.protobuf.model.ch3.ex6.Film.Builder, uk.me.uohiro.protobuf.model.ch3.ex6.FilmOrBuilder> filmBuilder_;
    /**
     * <code>required .ch3.ex6.Film film = 1;</code>
     */
    public boolean hasFilm() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .ch3.ex6.Film film = 1;</code>
     */
    public uk.me.uohiro.protobuf.model.ch3.ex6.Film getFilm() {
      if (filmBuilder_ == null) {
        return film_ == null ? uk.me.uohiro.protobuf.model.ch3.ex6.Film.getDefaultInstance() : film_;
      } else {
        return filmBuilder_.getMessage();
      }
    }
    /**
     * <code>required .ch3.ex6.Film film = 1;</code>
     */
    public Builder setFilm(uk.me.uohiro.protobuf.model.ch3.ex6.Film value) {
      if (filmBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        film_ = value;
        onChanged();
      } else {
        filmBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .ch3.ex6.Film film = 1;</code>
     */
    public Builder setFilm(
        uk.me.uohiro.protobuf.model.ch3.ex6.Film.Builder builderForValue) {
      if (filmBuilder_ == null) {
        film_ = builderForValue.build();
        onChanged();
      } else {
        filmBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .ch3.ex6.Film film = 1;</code>
     */
    public Builder mergeFilm(uk.me.uohiro.protobuf.model.ch3.ex6.Film value) {
      if (filmBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
            film_ != null &&
            film_ != uk.me.uohiro.protobuf.model.ch3.ex6.Film.getDefaultInstance()) {
          film_ =
            uk.me.uohiro.protobuf.model.ch3.ex6.Film.newBuilder(film_).mergeFrom(value).buildPartial();
        } else {
          film_ = value;
        }
        onChanged();
      } else {
        filmBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .ch3.ex6.Film film = 1;</code>
     */
    public Builder clearFilm() {
      if (filmBuilder_ == null) {
        film_ = null;
        onChanged();
      } else {
        filmBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>required .ch3.ex6.Film film = 1;</code>
     */
    public uk.me.uohiro.protobuf.model.ch3.ex6.Film.Builder getFilmBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getFilmFieldBuilder().getBuilder();
    }
    /**
     * <code>required .ch3.ex6.Film film = 1;</code>
     */
    public uk.me.uohiro.protobuf.model.ch3.ex6.FilmOrBuilder getFilmOrBuilder() {
      if (filmBuilder_ != null) {
        return filmBuilder_.getMessageOrBuilder();
      } else {
        return film_ == null ?
            uk.me.uohiro.protobuf.model.ch3.ex6.Film.getDefaultInstance() : film_;
      }
    }
    /**
     * <code>required .ch3.ex6.Film film = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        uk.me.uohiro.protobuf.model.ch3.ex6.Film, uk.me.uohiro.protobuf.model.ch3.ex6.Film.Builder, uk.me.uohiro.protobuf.model.ch3.ex6.FilmOrBuilder> 
        getFilmFieldBuilder() {
      if (filmBuilder_ == null) {
        filmBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            uk.me.uohiro.protobuf.model.ch3.ex6.Film, uk.me.uohiro.protobuf.model.ch3.ex6.Film.Builder, uk.me.uohiro.protobuf.model.ch3.ex6.FilmOrBuilder>(
                getFilm(),
                getParentForChildren(),
                isClean());
        film_ = null;
      }
      return filmBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ch3.ex6.GetFilmResponse)
  }

  // @@protoc_insertion_point(class_scope:ch3.ex6.GetFilmResponse)
  private static final uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse();
  }

  public static uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<GetFilmResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetFilmResponse>() {
    @java.lang.Override
    public GetFilmResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetFilmResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetFilmResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetFilmResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public uk.me.uohiro.protobuf.model.ch3.ex6.GetFilmResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

