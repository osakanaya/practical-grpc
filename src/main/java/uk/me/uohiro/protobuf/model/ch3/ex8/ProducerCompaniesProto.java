// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch3/ex8_producer_companies.proto

package uk.me.uohiro.protobuf.model.ch3.ex8;

public final class ProducerCompaniesProto {
  private ProducerCompaniesProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n ch3/ex8_producer_companies.proto\022\007ch3." +
      "ex8*M\n\021ProducerCompanies\022\013\n\007UNKNOWN\020\000\022\017\n" +
      "\013WARNER_BROS\020\001\022\r\n\tPARAMOUNT\020\002\022\013\n\007NETFLIX" +
      "\020\003BA\n#uk.me.uohiro.protobuf.model.ch3.ex" +
      "8B\026ProducerCompaniesProtoH\001P\001"
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
  }

  // @@protoc_insertion_point(outer_class_scope)
}
