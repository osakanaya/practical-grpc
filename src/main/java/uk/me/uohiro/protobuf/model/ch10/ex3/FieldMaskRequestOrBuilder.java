// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch10/ex3/field_mask.proto

package uk.me.uohiro.protobuf.model.ch10.ex3;

public interface FieldMaskRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ch10.ex3.FieldMaskRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.StringValue string_value = 1;</code>
   */
  boolean hasStringValue();
  /**
   * <code>.google.protobuf.StringValue string_value = 1;</code>
   */
  com.google.protobuf.StringValue getStringValue();
  /**
   * <code>.google.protobuf.StringValue string_value = 1;</code>
   */
  com.google.protobuf.StringValueOrBuilder getStringValueOrBuilder();

  /**
   * <code>.google.protobuf.Int32Value int32_value = 2;</code>
   */
  boolean hasInt32Value();
  /**
   * <code>.google.protobuf.Int32Value int32_value = 2;</code>
   */
  com.google.protobuf.Int32Value getInt32Value();
  /**
   * <code>.google.protobuf.Int32Value int32_value = 2;</code>
   */
  com.google.protobuf.Int32ValueOrBuilder getInt32ValueOrBuilder();

  /**
   * <code>.ch10.ex3.FieldMaskRequest.NestedMessage nested_message = 3;</code>
   */
  boolean hasNestedMessage();
  /**
   * <code>.ch10.ex3.FieldMaskRequest.NestedMessage nested_message = 3;</code>
   */
  uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest.NestedMessage getNestedMessage();
  /**
   * <code>.ch10.ex3.FieldMaskRequest.NestedMessage nested_message = 3;</code>
   */
  uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest.NestedMessageOrBuilder getNestedMessageOrBuilder();

  /**
   * <code>.google.protobuf.FieldMask mask = 4;</code>
   */
  boolean hasMask();
  /**
   * <code>.google.protobuf.FieldMask mask = 4;</code>
   */
  com.google.protobuf.FieldMask getMask();
  /**
   * <code>.google.protobuf.FieldMask mask = 4;</code>
   */
  com.google.protobuf.FieldMaskOrBuilder getMaskOrBuilder();
}
