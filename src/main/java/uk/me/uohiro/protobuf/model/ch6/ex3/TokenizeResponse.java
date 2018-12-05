// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch6/tokenizer.proto

package uk.me.uohiro.protobuf.model.ch6.ex3;

/**
 * Protobuf type {@code ch6.ex3.TokenizeResponse}
 */
public  final class TokenizeResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ch6.ex3.TokenizeResponse)
    TokenizeResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TokenizeResponse.newBuilder() to construct.
  private TokenizeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TokenizeResponse() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TokenizeResponse(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              words_ = com.google.protobuf.MapField.newMapField(
                  WordsDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.String, java.lang.Long>
            words__ = input.readMessage(
                WordsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            words_.getMutableMap().put(
                words__.getKey(), words__.getValue());
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
    return uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerServiceProto.internal_static_ch6_ex3_TokenizeResponse_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 1:
        return internalGetWords();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerServiceProto.internal_static_ch6_ex3_TokenizeResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse.class, uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse.Builder.class);
  }

  public static final int WORDS_FIELD_NUMBER = 1;
  private static final class WordsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.Long> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.Long>newDefaultInstance(
                uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerServiceProto.internal_static_ch6_ex3_TokenizeResponse_WordsEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.INT64,
                0L);
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.Long> words_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.Long>
  internalGetWords() {
    if (words_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          WordsDefaultEntryHolder.defaultEntry);
    }
    return words_;
  }

  public int getWordsCount() {
    return internalGetWords().getMap().size();
  }
  /**
   * <code>map&lt;string, int64&gt; words = 1;</code>
   */

  public boolean containsWords(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetWords().getMap().containsKey(key);
  }
  /**
   * Use {@link #getWordsMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, java.lang.Long> getWords() {
    return getWordsMap();
  }
  /**
   * <code>map&lt;string, int64&gt; words = 1;</code>
   */

  public java.util.Map<java.lang.String, java.lang.Long> getWordsMap() {
    return internalGetWords().getMap();
  }
  /**
   * <code>map&lt;string, int64&gt; words = 1;</code>
   */

  public long getWordsOrDefault(
      java.lang.String key,
      long defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.Long> map =
        internalGetWords().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, int64&gt; words = 1;</code>
   */

  public long getWordsOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.Long> map =
        internalGetWords().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetWords(),
        WordsDefaultEntryHolder.defaultEntry,
        1);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (java.util.Map.Entry<java.lang.String, java.lang.Long> entry
         : internalGetWords().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.Long>
      words__ = WordsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, words__);
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
    if (!(obj instanceof uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse)) {
      return super.equals(obj);
    }
    uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse other = (uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse) obj;

    boolean result = true;
    result = result && internalGetWords().equals(
        other.internalGetWords());
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
    if (!internalGetWords().getMap().isEmpty()) {
      hash = (37 * hash) + WORDS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetWords().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parseFrom(
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
  public static Builder newBuilder(uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse prototype) {
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
   * Protobuf type {@code ch6.ex3.TokenizeResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ch6.ex3.TokenizeResponse)
      uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerServiceProto.internal_static_ch6_ex3_TokenizeResponse_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetWords();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetMutableWords();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerServiceProto.internal_static_ch6_ex3_TokenizeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse.class, uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse.Builder.class);
    }

    // Construct using uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse.newBuilder()
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
      internalGetMutableWords().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerServiceProto.internal_static_ch6_ex3_TokenizeResponse_descriptor;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse getDefaultInstanceForType() {
      return uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse.getDefaultInstance();
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse build() {
      uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse buildPartial() {
      uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse result = new uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse(this);
      int from_bitField0_ = bitField0_;
      result.words_ = internalGetWords();
      result.words_.makeImmutable();
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
      if (other instanceof uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse) {
        return mergeFrom((uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse other) {
      if (other == uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse.getDefaultInstance()) return this;
      internalGetMutableWords().mergeFrom(
          other.internalGetWords());
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
      uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.Long> words_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.Long>
    internalGetWords() {
      if (words_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            WordsDefaultEntryHolder.defaultEntry);
      }
      return words_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.Long>
    internalGetMutableWords() {
      onChanged();;
      if (words_ == null) {
        words_ = com.google.protobuf.MapField.newMapField(
            WordsDefaultEntryHolder.defaultEntry);
      }
      if (!words_.isMutable()) {
        words_ = words_.copy();
      }
      return words_;
    }

    public int getWordsCount() {
      return internalGetWords().getMap().size();
    }
    /**
     * <code>map&lt;string, int64&gt; words = 1;</code>
     */

    public boolean containsWords(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetWords().getMap().containsKey(key);
    }
    /**
     * Use {@link #getWordsMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.Long> getWords() {
      return getWordsMap();
    }
    /**
     * <code>map&lt;string, int64&gt; words = 1;</code>
     */

    public java.util.Map<java.lang.String, java.lang.Long> getWordsMap() {
      return internalGetWords().getMap();
    }
    /**
     * <code>map&lt;string, int64&gt; words = 1;</code>
     */

    public long getWordsOrDefault(
        java.lang.String key,
        long defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.Long> map =
          internalGetWords().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, int64&gt; words = 1;</code>
     */

    public long getWordsOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.Long> map =
          internalGetWords().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearWords() {
      internalGetMutableWords().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, int64&gt; words = 1;</code>
     */

    public Builder removeWords(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableWords().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.Long>
    getMutableWords() {
      return internalGetMutableWords().getMutableMap();
    }
    /**
     * <code>map&lt;string, int64&gt; words = 1;</code>
     */
    public Builder putWords(
        java.lang.String key,
        long value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      
      internalGetMutableWords().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, int64&gt; words = 1;</code>
     */

    public Builder putAllWords(
        java.util.Map<java.lang.String, java.lang.Long> values) {
      internalGetMutableWords().getMutableMap()
          .putAll(values);
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


    // @@protoc_insertion_point(builder_scope:ch6.ex3.TokenizeResponse)
  }

  // @@protoc_insertion_point(class_scope:ch6.ex3.TokenizeResponse)
  private static final uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse();
  }

  public static uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TokenizeResponse>
      PARSER = new com.google.protobuf.AbstractParser<TokenizeResponse>() {
    @java.lang.Override
    public TokenizeResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TokenizeResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TokenizeResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TokenizeResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
