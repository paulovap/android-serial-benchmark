// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schemas/asteroids.proto

package com.paulovap.asteroids.proto;

public interface IGeolocationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:IGeolocation)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string type = 1;</code>
   */
  java.lang.String getType();
  /**
   * <code>string type = 1;</code>
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>repeated double coordinates = 2;</code>
   */
  java.util.List<java.lang.Double> getCoordinatesList();
  /**
   * <code>repeated double coordinates = 2;</code>
   */
  int getCoordinatesCount();
  /**
   * <code>repeated double coordinates = 2;</code>
   */
  double getCoordinates(int index);
}
