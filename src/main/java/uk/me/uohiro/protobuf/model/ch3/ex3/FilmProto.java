// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch3/ex3.proto

package uk.me.uohiro.protobuf.model.ch3.ex3;

public final class FilmProto {
  private FilmProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch3_ex3_Film_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch3_ex3_Film_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch3_ex3_Film_Character_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch3_ex3_Film_Character_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch3_ex3_Film_RolesEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch3_ex3_Film_RolesEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rch3/ex3.proto\022\007ch3.ex3\"\351\001\n\004Film\022\r\n\005tit" +
      "le\030\001 \002(\t\022\020\n\010director\030\002 \002(\t\022\020\n\010producer\030\003" +
      " \002(\t\022\024\n\014release_date\030\004 \001(\t\022\'\n\005roles\030\005 \003(" +
      "\0132\030.ch3.ex3.Film.RolesEntry\032(\n\tCharacter" +
      "\022\014\n\004name\030\001 \002(\t\022\r\n\005birth\030\002 \002(\003\032E\n\nRolesEn" +
      "try\022\013\n\003key\030\001 \001(\t\022&\n\005value\030\002 \001(\0132\027.ch3.ex" +
      "3.Film.Character:\0028\001B4\n#uk.me.uohiro.pro" +
      "tobuf.model.ch3.ex3B\tFilmProtoH\001P\001"
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
    internal_static_ch3_ex3_Film_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ch3_ex3_Film_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch3_ex3_Film_descriptor,
        new java.lang.String[] { "Title", "Director", "Producer", "ReleaseDate", "Roles", });
    internal_static_ch3_ex3_Film_Character_descriptor =
      internal_static_ch3_ex3_Film_descriptor.getNestedTypes().get(0);
    internal_static_ch3_ex3_Film_Character_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch3_ex3_Film_Character_descriptor,
        new java.lang.String[] { "Name", "Birth", });
    internal_static_ch3_ex3_Film_RolesEntry_descriptor =
      internal_static_ch3_ex3_Film_descriptor.getNestedTypes().get(1);
    internal_static_ch3_ex3_Film_RolesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch3_ex3_Film_RolesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
