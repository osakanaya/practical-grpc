// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch11/ex1/sfapi.proto

package uk.me.uohiro.protobuf.model.ch11.ex1;

public final class StarFriendsAPIProto {
  private StarFriendsAPIProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch11_ex1_GetFilmRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch11_ex1_GetFilmRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch11_ex1_GetFilmResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch11_ex1_GetFilmResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch11_ex1_ListFilmsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch11_ex1_ListFilmsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch11_ex1_ListFilmsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch11_ex1_ListFilmsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch11_ex1_Film_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch11_ex1_Film_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024ch11/ex1/sfapi.proto\022\010ch11.ex1\032\037google" +
      "/protobuf/timestamp.proto\032\034google/api/an" +
      "notations.proto\"\034\n\016GetFilmRequest\022\n\n\002id\030" +
      "\001 \001(\t\"/\n\017GetFilmResponse\022\034\n\004film\030\001 \001(\0132\016" +
      ".ch11.ex1.Film\"\022\n\020ListFilmsRequest\"2\n\021Li" +
      "stFilmsResponse\022\035\n\005films\030\001 \003(\0132\016.ch11.ex" +
      "1.Film\"w\n\004Film\022\n\n\002id\030\001 \001(\t\022\r\n\005title\030\002 \001(" +
      "\t\022\020\n\010director\030\003 \001(\t\022\020\n\010producer\030\004 \001(\t\0220\n" +
      "\014release_date\030\005 \001(\0132\032.google.protobuf.Ti" +
      "mestamp2\312\001\n\013StarFriends\022\\\n\007GetFilm\022\030.ch1" +
      "1.ex1.GetFilmRequest\032\031.ch11.ex1.GetFilmR" +
      "esponse\"\034\202\323\344\223\002\026\022\024/sfapi/v1/films/{id}\022]\n" +
      "\tListFilms\022\032.ch11.ex1.ListFilmsRequest\032\033" +
      ".ch11.ex1.ListFilmsResponse\"\027\202\323\344\223\002\021\022\017/sf" +
      "api/v1/filmsB?\n$uk.me.uohiro.protobuf.mo" +
      "del.ch11.ex1B\023StarFriendsAPIProtoH\001P\001b\006p" +
      "roto3"
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
          com.google.protobuf.TimestampProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
        }, assigner);
    internal_static_ch11_ex1_GetFilmRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ch11_ex1_GetFilmRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch11_ex1_GetFilmRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_ch11_ex1_GetFilmResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ch11_ex1_GetFilmResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch11_ex1_GetFilmResponse_descriptor,
        new java.lang.String[] { "Film", });
    internal_static_ch11_ex1_ListFilmsRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ch11_ex1_ListFilmsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch11_ex1_ListFilmsRequest_descriptor,
        new java.lang.String[] { });
    internal_static_ch11_ex1_ListFilmsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ch11_ex1_ListFilmsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch11_ex1_ListFilmsResponse_descriptor,
        new java.lang.String[] { "Films", });
    internal_static_ch11_ex1_Film_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ch11_ex1_Film_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch11_ex1_Film_descriptor,
        new java.lang.String[] { "Id", "Title", "Director", "Producer", "ReleaseDate", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
