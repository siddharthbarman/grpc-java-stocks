// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stock_service.proto

package com.sbytestream.samples.grpc.stockservice;

public interface StocksOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.sbytestream.samples.grpc.stockservice.Stocks)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.sbytestream.samples.grpc.stockservice.Stock stocks = 1;</code>
   */
  java.util.List<com.sbytestream.samples.grpc.stockservice.Stock> 
      getStocksList();
  /**
   * <code>repeated .com.sbytestream.samples.grpc.stockservice.Stock stocks = 1;</code>
   */
  com.sbytestream.samples.grpc.stockservice.Stock getStocks(int index);
  /**
   * <code>repeated .com.sbytestream.samples.grpc.stockservice.Stock stocks = 1;</code>
   */
  int getStocksCount();
  /**
   * <code>repeated .com.sbytestream.samples.grpc.stockservice.Stock stocks = 1;</code>
   */
  java.util.List<? extends com.sbytestream.samples.grpc.stockservice.StockOrBuilder> 
      getStocksOrBuilderList();
  /**
   * <code>repeated .com.sbytestream.samples.grpc.stockservice.Stock stocks = 1;</code>
   */
  com.sbytestream.samples.grpc.stockservice.StockOrBuilder getStocksOrBuilder(
      int index);
}
