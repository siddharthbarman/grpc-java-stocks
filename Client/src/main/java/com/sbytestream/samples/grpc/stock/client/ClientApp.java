package com.sbytestream.samples.grpc.stock.client;

import com.sbytestream.samples.grpc.stockservice.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApp {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();
        StockServiceGrpc.StockServiceBlockingStub client = StockServiceGrpc.newBlockingStub(channel);
        Stocks stocks = client.getTicks(Empty.getDefaultInstance());
        for (Stock stock : stocks.getStocksList()) {
            System.out.println(stock.toString());
        }
    }
}
