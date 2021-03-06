// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schemas/asteroids.proto

package com.paulovap.asteroids.proto;

/**
 * Protobuf type {@code IAsteroids}
 */
public  final class IAsteroids extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:IAsteroids)
    IAsteroidsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use IAsteroids.newBuilder() to construct.
  private IAsteroids(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private IAsteroids() {
    asteroids_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new IAsteroids();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private IAsteroids(
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              asteroids_ = new java.util.ArrayList<com.paulovap.asteroids.proto.IAsteroid>();
              mutable_bitField0_ |= 0x00000001;
            }
            asteroids_.add(
                input.readMessage(com.paulovap.asteroids.proto.IAsteroid.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        asteroids_ = java.util.Collections.unmodifiableList(asteroids_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.paulovap.asteroids.proto.Asteroids.internal_static_IAsteroids_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.paulovap.asteroids.proto.Asteroids.internal_static_IAsteroids_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.paulovap.asteroids.proto.IAsteroids.class, com.paulovap.asteroids.proto.IAsteroids.Builder.class);
  }

  public static final int ASTEROIDS_FIELD_NUMBER = 1;
  private java.util.List<com.paulovap.asteroids.proto.IAsteroid> asteroids_;
  /**
   * <code>repeated .IAsteroid asteroids = 1;</code>
   */
  public java.util.List<com.paulovap.asteroids.proto.IAsteroid> getAsteroidsList() {
    return asteroids_;
  }
  /**
   * <code>repeated .IAsteroid asteroids = 1;</code>
   */
  public java.util.List<? extends com.paulovap.asteroids.proto.IAsteroidOrBuilder> 
      getAsteroidsOrBuilderList() {
    return asteroids_;
  }
  /**
   * <code>repeated .IAsteroid asteroids = 1;</code>
   */
  public int getAsteroidsCount() {
    return asteroids_.size();
  }
  /**
   * <code>repeated .IAsteroid asteroids = 1;</code>
   */
  public com.paulovap.asteroids.proto.IAsteroid getAsteroids(int index) {
    return asteroids_.get(index);
  }
  /**
   * <code>repeated .IAsteroid asteroids = 1;</code>
   */
  public com.paulovap.asteroids.proto.IAsteroidOrBuilder getAsteroidsOrBuilder(
      int index) {
    return asteroids_.get(index);
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
    for (int i = 0; i < asteroids_.size(); i++) {
      output.writeMessage(1, asteroids_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < asteroids_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, asteroids_.get(i));
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
    if (!(obj instanceof com.paulovap.asteroids.proto.IAsteroids)) {
      return super.equals(obj);
    }
    com.paulovap.asteroids.proto.IAsteroids other = (com.paulovap.asteroids.proto.IAsteroids) obj;

    if (!getAsteroidsList()
        .equals(other.getAsteroidsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getAsteroidsCount() > 0) {
      hash = (37 * hash) + ASTEROIDS_FIELD_NUMBER;
      hash = (53 * hash) + getAsteroidsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.paulovap.asteroids.proto.IAsteroids parseFrom(
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
  public static Builder newBuilder(com.paulovap.asteroids.proto.IAsteroids prototype) {
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
   * Protobuf type {@code IAsteroids}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:IAsteroids)
      com.paulovap.asteroids.proto.IAsteroidsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.paulovap.asteroids.proto.Asteroids.internal_static_IAsteroids_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.paulovap.asteroids.proto.Asteroids.internal_static_IAsteroids_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.paulovap.asteroids.proto.IAsteroids.class, com.paulovap.asteroids.proto.IAsteroids.Builder.class);
    }

    // Construct using com.paulovap.asteroids.proto.IAsteroids.newBuilder()
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
        getAsteroidsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (asteroidsBuilder_ == null) {
        asteroids_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        asteroidsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.paulovap.asteroids.proto.Asteroids.internal_static_IAsteroids_descriptor;
    }

    @java.lang.Override
    public com.paulovap.asteroids.proto.IAsteroids getDefaultInstanceForType() {
      return com.paulovap.asteroids.proto.IAsteroids.getDefaultInstance();
    }

    @java.lang.Override
    public com.paulovap.asteroids.proto.IAsteroids build() {
      com.paulovap.asteroids.proto.IAsteroids result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.paulovap.asteroids.proto.IAsteroids buildPartial() {
      com.paulovap.asteroids.proto.IAsteroids result = new com.paulovap.asteroids.proto.IAsteroids(this);
      int from_bitField0_ = bitField0_;
      if (asteroidsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          asteroids_ = java.util.Collections.unmodifiableList(asteroids_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.asteroids_ = asteroids_;
      } else {
        result.asteroids_ = asteroidsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.paulovap.asteroids.proto.IAsteroids) {
        return mergeFrom((com.paulovap.asteroids.proto.IAsteroids)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.paulovap.asteroids.proto.IAsteroids other) {
      if (other == com.paulovap.asteroids.proto.IAsteroids.getDefaultInstance()) return this;
      if (asteroidsBuilder_ == null) {
        if (!other.asteroids_.isEmpty()) {
          if (asteroids_.isEmpty()) {
            asteroids_ = other.asteroids_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureAsteroidsIsMutable();
            asteroids_.addAll(other.asteroids_);
          }
          onChanged();
        }
      } else {
        if (!other.asteroids_.isEmpty()) {
          if (asteroidsBuilder_.isEmpty()) {
            asteroidsBuilder_.dispose();
            asteroidsBuilder_ = null;
            asteroids_ = other.asteroids_;
            bitField0_ = (bitField0_ & ~0x00000001);
            asteroidsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getAsteroidsFieldBuilder() : null;
          } else {
            asteroidsBuilder_.addAllMessages(other.asteroids_);
          }
        }
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
      com.paulovap.asteroids.proto.IAsteroids parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.paulovap.asteroids.proto.IAsteroids) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.paulovap.asteroids.proto.IAsteroid> asteroids_ =
      java.util.Collections.emptyList();
    private void ensureAsteroidsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        asteroids_ = new java.util.ArrayList<com.paulovap.asteroids.proto.IAsteroid>(asteroids_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.paulovap.asteroids.proto.IAsteroid, com.paulovap.asteroids.proto.IAsteroid.Builder, com.paulovap.asteroids.proto.IAsteroidOrBuilder> asteroidsBuilder_;

    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public java.util.List<com.paulovap.asteroids.proto.IAsteroid> getAsteroidsList() {
      if (asteroidsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(asteroids_);
      } else {
        return asteroidsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public int getAsteroidsCount() {
      if (asteroidsBuilder_ == null) {
        return asteroids_.size();
      } else {
        return asteroidsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public com.paulovap.asteroids.proto.IAsteroid getAsteroids(int index) {
      if (asteroidsBuilder_ == null) {
        return asteroids_.get(index);
      } else {
        return asteroidsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public Builder setAsteroids(
        int index, com.paulovap.asteroids.proto.IAsteroid value) {
      if (asteroidsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAsteroidsIsMutable();
        asteroids_.set(index, value);
        onChanged();
      } else {
        asteroidsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public Builder setAsteroids(
        int index, com.paulovap.asteroids.proto.IAsteroid.Builder builderForValue) {
      if (asteroidsBuilder_ == null) {
        ensureAsteroidsIsMutable();
        asteroids_.set(index, builderForValue.build());
        onChanged();
      } else {
        asteroidsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public Builder addAsteroids(com.paulovap.asteroids.proto.IAsteroid value) {
      if (asteroidsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAsteroidsIsMutable();
        asteroids_.add(value);
        onChanged();
      } else {
        asteroidsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public Builder addAsteroids(
        int index, com.paulovap.asteroids.proto.IAsteroid value) {
      if (asteroidsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAsteroidsIsMutable();
        asteroids_.add(index, value);
        onChanged();
      } else {
        asteroidsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public Builder addAsteroids(
        com.paulovap.asteroids.proto.IAsteroid.Builder builderForValue) {
      if (asteroidsBuilder_ == null) {
        ensureAsteroidsIsMutable();
        asteroids_.add(builderForValue.build());
        onChanged();
      } else {
        asteroidsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public Builder addAsteroids(
        int index, com.paulovap.asteroids.proto.IAsteroid.Builder builderForValue) {
      if (asteroidsBuilder_ == null) {
        ensureAsteroidsIsMutable();
        asteroids_.add(index, builderForValue.build());
        onChanged();
      } else {
        asteroidsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public Builder addAllAsteroids(
        java.lang.Iterable<? extends com.paulovap.asteroids.proto.IAsteroid> values) {
      if (asteroidsBuilder_ == null) {
        ensureAsteroidsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, asteroids_);
        onChanged();
      } else {
        asteroidsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public Builder clearAsteroids() {
      if (asteroidsBuilder_ == null) {
        asteroids_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        asteroidsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public Builder removeAsteroids(int index) {
      if (asteroidsBuilder_ == null) {
        ensureAsteroidsIsMutable();
        asteroids_.remove(index);
        onChanged();
      } else {
        asteroidsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public com.paulovap.asteroids.proto.IAsteroid.Builder getAsteroidsBuilder(
        int index) {
      return getAsteroidsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public com.paulovap.asteroids.proto.IAsteroidOrBuilder getAsteroidsOrBuilder(
        int index) {
      if (asteroidsBuilder_ == null) {
        return asteroids_.get(index);  } else {
        return asteroidsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public java.util.List<? extends com.paulovap.asteroids.proto.IAsteroidOrBuilder> 
         getAsteroidsOrBuilderList() {
      if (asteroidsBuilder_ != null) {
        return asteroidsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(asteroids_);
      }
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public com.paulovap.asteroids.proto.IAsteroid.Builder addAsteroidsBuilder() {
      return getAsteroidsFieldBuilder().addBuilder(
          com.paulovap.asteroids.proto.IAsteroid.getDefaultInstance());
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public com.paulovap.asteroids.proto.IAsteroid.Builder addAsteroidsBuilder(
        int index) {
      return getAsteroidsFieldBuilder().addBuilder(
          index, com.paulovap.asteroids.proto.IAsteroid.getDefaultInstance());
    }
    /**
     * <code>repeated .IAsteroid asteroids = 1;</code>
     */
    public java.util.List<com.paulovap.asteroids.proto.IAsteroid.Builder> 
         getAsteroidsBuilderList() {
      return getAsteroidsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.paulovap.asteroids.proto.IAsteroid, com.paulovap.asteroids.proto.IAsteroid.Builder, com.paulovap.asteroids.proto.IAsteroidOrBuilder> 
        getAsteroidsFieldBuilder() {
      if (asteroidsBuilder_ == null) {
        asteroidsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.paulovap.asteroids.proto.IAsteroid, com.paulovap.asteroids.proto.IAsteroid.Builder, com.paulovap.asteroids.proto.IAsteroidOrBuilder>(
                asteroids_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        asteroids_ = null;
      }
      return asteroidsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:IAsteroids)
  }

  // @@protoc_insertion_point(class_scope:IAsteroids)
  private static final com.paulovap.asteroids.proto.IAsteroids DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.paulovap.asteroids.proto.IAsteroids();
  }

  public static com.paulovap.asteroids.proto.IAsteroids getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<IAsteroids>
      PARSER = new com.google.protobuf.AbstractParser<IAsteroids>() {
    @java.lang.Override
    public IAsteroids parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new IAsteroids(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<IAsteroids> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<IAsteroids> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.paulovap.asteroids.proto.IAsteroids getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

