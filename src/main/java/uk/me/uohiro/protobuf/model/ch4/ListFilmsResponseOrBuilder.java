// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ch4/sfapi.proto

package uk.me.uohiro.protobuf.model.ch4;

public interface ListFilmsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ch4.ListFilmsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .ch4.Film films = 1;</code>
   */
  java.util.List<uk.me.uohiro.protobuf.model.ch4.Film> 
      getFilmsList();
  /**
   * <code>repeated .ch4.Film films = 1;</code>
   */
  uk.me.uohiro.protobuf.model.ch4.Film getFilms(int index);
  /**
   * <code>repeated .ch4.Film films = 1;</code>
   */
  int getFilmsCount();
  /**
   * <code>repeated .ch4.Film films = 1;</code>
   */
  java.util.List<? extends uk.me.uohiro.protobuf.model.ch4.FilmOrBuilder> 
      getFilmsOrBuilderList();
  /**
   * <code>repeated .ch4.Film films = 1;</code>
   */
  uk.me.uohiro.protobuf.model.ch4.FilmOrBuilder getFilmsOrBuilder(
      int index);
}