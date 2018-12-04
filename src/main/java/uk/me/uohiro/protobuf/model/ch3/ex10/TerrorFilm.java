// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch3/ex10.proto

package uk.me.uohiro.protobuf.model.ch3.ex10;

/**
 * Protobuf type {@code ch3.ex10.TerrorFilm}
 */
public  final class TerrorFilm extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ch3.ex10.TerrorFilm)
    TerrorFilmOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TerrorFilm.newBuilder() to construct.
  private TerrorFilm(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TerrorFilm() {
    hasZombies_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TerrorFilm(
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
          case 8: {

            hasZombies_ = input.readBool();
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
    return uk.me.uohiro.protobuf.model.ch3.ex10.FilmProto.internal_static_ch3_ex10_TerrorFilm_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return uk.me.uohiro.protobuf.model.ch3.ex10.FilmProto.internal_static_ch3_ex10_TerrorFilm_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm.class, uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm.Builder.class);
  }

  public static final int HAS_ZOMBIES_FIELD_NUMBER = 1;
  private boolean hasZombies_;
  /**
   * <code>bool has_zombies = 1;</code>
   */
  public boolean getHasZombies() {
    return hasZombies_;
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
    if (hasZombies_ != false) {
      output.writeBool(1, hasZombies_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (hasZombies_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, hasZombies_);
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
    if (!(obj instanceof uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm)) {
      return super.equals(obj);
    }
    uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm other = (uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm) obj;

    boolean result = true;
    result = result && (getHasZombies()
        == other.getHasZombies());
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
    hash = (37 * hash) + HAS_ZOMBIES_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getHasZombies());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parseFrom(
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
  public static Builder newBuilder(uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm prototype) {
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
   * Protobuf type {@code ch3.ex10.TerrorFilm}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ch3.ex10.TerrorFilm)
      uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilmOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return uk.me.uohiro.protobuf.model.ch3.ex10.FilmProto.internal_static_ch3_ex10_TerrorFilm_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return uk.me.uohiro.protobuf.model.ch3.ex10.FilmProto.internal_static_ch3_ex10_TerrorFilm_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm.class, uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm.Builder.class);
    }

    // Construct using uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm.newBuilder()
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
      hasZombies_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return uk.me.uohiro.protobuf.model.ch3.ex10.FilmProto.internal_static_ch3_ex10_TerrorFilm_descriptor;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm getDefaultInstanceForType() {
      return uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm.getDefaultInstance();
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm build() {
      uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm buildPartial() {
      uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm result = new uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm(this);
      result.hasZombies_ = hasZombies_;
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
      if (other instanceof uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm) {
        return mergeFrom((uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm other) {
      if (other == uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm.getDefaultInstance()) return this;
      if (other.getHasZombies() != false) {
        setHasZombies(other.getHasZombies());
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
      uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean hasZombies_ ;
    /**
     * <code>bool has_zombies = 1;</code>
     */
    public boolean getHasZombies() {
      return hasZombies_;
    }
    /**
     * <code>bool has_zombies = 1;</code>
     */
    public Builder setHasZombies(boolean value) {
      
      hasZombies_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool has_zombies = 1;</code>
     */
    public Builder clearHasZombies() {
      
      hasZombies_ = false;
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


    // @@protoc_insertion_point(builder_scope:ch3.ex10.TerrorFilm)
  }

  // @@protoc_insertion_point(class_scope:ch3.ex10.TerrorFilm)
  private static final uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm();
  }

  public static uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TerrorFilm>
      PARSER = new com.google.protobuf.AbstractParser<TerrorFilm>() {
    @java.lang.Override
    public TerrorFilm parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TerrorFilm(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TerrorFilm> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TerrorFilm> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

