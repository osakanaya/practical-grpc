// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch3/ex6.proto

package uk.me.uohiro.protobuf.model.ch3.ex6;

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
    internal_static_ch3_ex6_Film_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch3_ex6_Film_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch3_ex6_Film_Character_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch3_ex6_Film_Character_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch3_ex6_Film_RolesEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch3_ex6_Film_RolesEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch3_ex6_GetFilmRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch3_ex6_GetFilmRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ch3_ex6_GetFilmResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ch3_ex6_GetFilmResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rch3/ex6.proto\022\007ch3.ex6\"\273\003\n\004Film\022\r\n\005tit" +
      "le\030\001 \002(\t\022\020\n\010director\030\002 \002(\t\022\020\n\010producer\030\003" +
      " \002(\t\022\024\n\014release_date\030\004 \001(\t\022\'\n\005roles\030\005 \003(" +
      "\0132\030.ch3.ex6.Film.RolesEntry\022B\n\020producer_" +
      "company\030\006 \002(\0162\037.ch3.ex6.Film.ProducerCom" +
      "panies:\007UNKNOWN\032g\n\tCharacter\022\014\n\004name\030\001 \002" +
      "(\t\022\r\n\005birth\030\002 \002(\003\022\031\n\017laser_gun_model\030\003 \001" +
      "(\tH\000\022\033\n\021laser_sword_power\030\004 \001(\005H\000B\005\n\003has" +
      "\032E\n\nRolesEntry\022\013\n\003key\030\001 \001(\t\022&\n\005value\030\002 \001" +
      "(\0132\027.ch3.ex6.Film.Character:\0028\001\"M\n\021Produ" +
      "cerCompanies\022\013\n\007UNKNOWN\020\000\022\017\n\013WARNER_BROS" +
      "\020\001\022\r\n\tPARAMOUNT\020\002\022\013\n\007NETFLIX\020\003\"\034\n\016GetFil" +
      "mRequest\022\n\n\002id\030\001 \002(\t\".\n\017GetFilmResponse\022" +
      "\033\n\004film\030\001 \002(\0132\r.ch3.ex6.Film2H\n\010StarWars" +
      "\022<\n\007GetFilm\022\027.ch3.ex6.GetFilmRequest\032\030.c" +
      "h3.ex6.GetFilmResponseB4\n#uk.me.uohiro.p" +
      "rotobuf.model.ch3.ex6B\tFilmProtoH\001P\001"
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
    internal_static_ch3_ex6_Film_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ch3_ex6_Film_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch3_ex6_Film_descriptor,
        new java.lang.String[] { "Title", "Director", "Producer", "ReleaseDate", "Roles", "ProducerCompany", });
    internal_static_ch3_ex6_Film_Character_descriptor =
      internal_static_ch3_ex6_Film_descriptor.getNestedTypes().get(0);
    internal_static_ch3_ex6_Film_Character_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch3_ex6_Film_Character_descriptor,
        new java.lang.String[] { "Name", "Birth", "LaserGunModel", "LaserSwordPower", "Has", });
    internal_static_ch3_ex6_Film_RolesEntry_descriptor =
      internal_static_ch3_ex6_Film_descriptor.getNestedTypes().get(1);
    internal_static_ch3_ex6_Film_RolesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch3_ex6_Film_RolesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_ch3_ex6_GetFilmRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ch3_ex6_GetFilmRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch3_ex6_GetFilmRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_ch3_ex6_GetFilmResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ch3_ex6_GetFilmResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ch3_ex6_GetFilmResponse_descriptor,
        new java.lang.String[] { "Film", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
