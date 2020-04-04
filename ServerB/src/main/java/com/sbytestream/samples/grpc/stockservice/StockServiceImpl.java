package com.sbytestream.samples.grpc.stockservice;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import org.joda.time.DateTime;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@GRpcService
public class StockServiceImpl extends StockServiceGrpc.StockServiceImplBase {
    public StockServiceImpl() {
        populateData();
    }

    @Override
    public void getTicks(Empty request, StreamObserver<Stocks> responseObserver) {
        logger.info("getTicks called");
        responseObserver.onNext(Stocks.newBuilder().addAllStocks(stocks).build());
        responseObserver.onCompleted();
    }

    private void populateData() {
        int year = 2020;
        int month = 4;
        int day = 3;
        int hour = 15;

        stocks.add(createStock(23.4F, 23F, "NSE", "RBX",
                getUnixTime(year, month, day, hour, 28, 01),
                getUnixTime(year, month, day, hour, 27, 01))
        );

        stocks.add(createStock(230.4F, 230F, "NSE", "MARUTI",
                getUnixTime(year, month, day, hour, 28, 01),
                getUnixTime(year, month, day, hour, 27, 01))
        );

        stocks.add(createStock(120.4F, 130F, "NSE", "HDFCLIFE",
                getUnixTime(year, month, day, hour, 28, 01),
                getUnixTime(year, month, day, hour, 27, 01))
        );
    }

    private Stock createStock(float ask, float bid, String exch,
                                          String symbol, long qtm, long ttm) {
        return Stock.newBuilder()
            .setASK(ask)
            .setBID(bid)
            .setEXC(exch)
            .setSYM(symbol)
            .setQTM(qtm)
            .setTTM(ttm)
            .build();
    }

    private long getUnixTime(int year, int month, int day, int hour, int minutes, int seconds) {
        return new DateTime(year, month, day, hour, minutes, seconds).getMillis() / 1000;
    }

    private DateTime getDateTime(long unixTime) {
        return new DateTime(unixTime * 1000);
    }

    private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
    private List<Stock> stocks = new ArrayList<>();
}
