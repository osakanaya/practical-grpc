// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch7/oauth_authentication.proto

package uk.me.uohiro.protobuf.model.ch7.ex3;

public final class ProtectedResourceAPIProto {
  private ProtectedResourceAPIProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch7_ex3_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch7_ex3_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch7_ex3_Greeting_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch7_ex3_Greeting_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036ch7/oauth_authentication.proto\022\007ch7.ex" +
      "3\"\007\n\005Empty\"\034\n\010Greeting\022\020\n\010greeting\030\002 \001(\t" +
      "2B\n\021ProtectedResource\022-\n\010SayHello\022\016.ch7." +
      "ex3.Empty\032\021.ch7.ex3.GreetingBD\n#uk.me.uo" +
      "hiro.protobuf.model.ch7.ex3B\031ProtectedRe" +
      "sourceAPIProtoH\001P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ch7_ex3_Empty_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ch7_ex3_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch7_ex3_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_ch7_ex3_Greeting_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ch7_ex3_Greeting_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch7_ex3_Greeting_descriptor,
        new java.lang.String[] { "Greeting", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}