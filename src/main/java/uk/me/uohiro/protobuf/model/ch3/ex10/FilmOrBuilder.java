// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch3/ex10.proto

package uk.me.uohiro.protobuf.model.ch3.ex10;

public interface FilmOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ch3.ex10.Film)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string title = 1;</code>
   */
  java.lang.String getTitle();
  /**
   * <code>string title = 1;</code>
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string director = 2;</code>
   */
  java.lang.String getDirector();
  /**
   * <code>string director = 2;</code>
   */
  com.google.protobuf.ByteString
      getDirectorBytes();

  /**
   * <code>string producer = 3;</code>
   */
  java.lang.String getProducer();
  /**
   * <code>string producer = 3;</code>
   */
  com.google.protobuf.ByteString
      getProducerBytes();

  /**
   * <code>string release_date = 4;</code>
   */
  java.lang.String getReleaseDate();
  /**
   * <code>string release_date = 4;</code>
   */
  com.google.protobuf.ByteString
      getReleaseDateBytes();

  /**
   * <code>map&lt;string, .ch3.ex10.Character&gt; roles = 5;</code>
   */
  int getRolesCount();
  /**
   * <code>map&lt;string, .ch3.ex10.Character&gt; roles = 5;</code>
   */
  boolean containsRoles(
      java.lang.String key);
  /**
   * Use {@link #getRolesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, uk.me.uohiro.protobuf.model.ch3.ex10.Character>
  getRoles();
  /**
   * <code>map&lt;string, .ch3.ex10.Character&gt; roles = 5;</code>
   */
  java.util.Map<java.lang.String, uk.me.uohiro.protobuf.model.ch3.ex10.Character>
  getRolesMap();
  /**
   * <code>map&lt;string, .ch3.ex10.Character&gt; roles = 5;</code>
   */

  uk.me.uohiro.protobuf.model.ch3.ex10.Character getRolesOrDefault(
      java.lang.String key,
      uk.me.uohiro.protobuf.model.ch3.ex10.Character defaultValue);
  /**
   * <code>map&lt;string, .ch3.ex10.Character&gt; roles = 5;</code>
   */

  uk.me.uohiro.protobuf.model.ch3.ex10.Character getRolesOrThrow(
      java.lang.String key);

  /**
   * <code>.ch3.ex10.ProducerCompanies producer_company = 6;</code>
   */
  int getProducerCompanyValue();
  /**
   * <code>.ch3.ex10.ProducerCompanies producer_company = 6;</code>
   */
  uk.me.uohiro.protobuf.model.ch3.ex10.ProducerCompanies getProducerCompany();

  /**
   * <code>.google.protobuf.Any film_detail = 7;</code>
   */
  boolean hasFilmDetail();
  /**
   * <code>.google.protobuf.Any film_detail = 7;</code>
   */
  com.google.protobuf.Any getFilmDetail();
  /**
   * <code>.google.protobuf.Any film_detail = 7;</code>
   */
  com.google.protobuf.AnyOrBuilder getFilmDetailOrBuilder();
}
