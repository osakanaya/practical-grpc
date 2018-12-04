// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch3/ex11.proto

package uk.me.uohiro.protobuf.model.ch3.ex11;

public interface FilmOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ch3.ex11.Film)
    com.google.protobuf.GeneratedMessageV3.
        ExtendableMessageOrBuilder<Film> {

  /**
   * <code>required string title = 1;</code>
   */
  boolean hasTitle();
  /**
   * <code>required string title = 1;</code>
   */
  java.lang.String getTitle();
  /**
   * <code>required string title = 1;</code>
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>required string director = 2;</code>
   */
  boolean hasDirector();
  /**
   * <code>required string director = 2;</code>
   */
  java.lang.String getDirector();
  /**
   * <code>required string director = 2;</code>
   */
  com.google.protobuf.ByteString
      getDirectorBytes();

  /**
   * <code>required string producer = 3;</code>
   */
  boolean hasProducer();
  /**
   * <code>required string producer = 3;</code>
   */
  java.lang.String getProducer();
  /**
   * <code>required string producer = 3;</code>
   */
  com.google.protobuf.ByteString
      getProducerBytes();

  /**
   * <code>optional string release_date = 4;</code>
   */
  boolean hasReleaseDate();
  /**
   * <code>optional string release_date = 4;</code>
   */
  java.lang.String getReleaseDate();
  /**
   * <code>optional string release_date = 4;</code>
   */
  com.google.protobuf.ByteString
      getReleaseDateBytes();

  /**
   * <code>map&lt;string, .ch3.ex11.Character&gt; roles = 5;</code>
   */
  int getRolesCount();
  /**
   * <code>map&lt;string, .ch3.ex11.Character&gt; roles = 5;</code>
   */
  boolean containsRoles(
      java.lang.String key);
  /**
   * Use {@link #getRolesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, uk.me.uohiro.protobuf.model.ch3.ex11.Character>
  getRoles();
  /**
   * <code>map&lt;string, .ch3.ex11.Character&gt; roles = 5;</code>
   */
  java.util.Map<java.lang.String, uk.me.uohiro.protobuf.model.ch3.ex11.Character>
  getRolesMap();
  /**
   * <code>map&lt;string, .ch3.ex11.Character&gt; roles = 5;</code>
   */

  uk.me.uohiro.protobuf.model.ch3.ex11.Character getRolesOrDefault(
      java.lang.String key,
      uk.me.uohiro.protobuf.model.ch3.ex11.Character defaultValue);
  /**
   * <code>map&lt;string, .ch3.ex11.Character&gt; roles = 5;</code>
   */

  uk.me.uohiro.protobuf.model.ch3.ex11.Character getRolesOrThrow(
      java.lang.String key);

  /**
   * <code>required .ch3.ex11.ProducerCompanies producer_company = 6 [default = UNKNOWN];</code>
   */
  boolean hasProducerCompany();
  /**
   * <code>required .ch3.ex11.ProducerCompanies producer_company = 6 [default = UNKNOWN];</code>
   */
  uk.me.uohiro.protobuf.model.ch3.ex11.ProducerCompanies getProducerCompany();

  /**
   * <code>required string comment = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated boolean hasComment();
  /**
   * <code>required string comment = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated java.lang.String getComment();
  /**
   * <code>required string comment = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getCommentBytes();
}
