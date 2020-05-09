package com.eden.dolphin.broker.xtp;


import com.eden.dolphin.broker.xtp.handler.XTPQuoteHandler;
import com.eden.dolphin.core.broker.AbstractBroker;
import com.eden.dolphin.core.broker.request.CancelRequest;
import com.eden.dolphin.core.broker.request.OrderRequest;
import com.eden.dolphin.core.broker.request.SubscribeRequest;
import com.eden.dolphin.core.event.EventEngine;
import com.zts.xtp.common.enums.JniLogLevel;
import com.zts.xtp.common.enums.TransferProtocol;
import com.zts.xtp.common.enums.XtpLogLevel;
import com.zts.xtp.common.jni.JNILoadLibrary;
import com.zts.xtp.quote.api.QuoteApi;

import java.util.Map;

public class XTPBroker extends AbstractBroker {

    private QuoteApi quoteApi;

    public XTPBroker(String name, EventEngine eventEngine) {
        super(name, eventEngine);
        init();
    }

    private void init(){
        JNILoadLibrary.loadLibrary();
        XTPQuoteHandler handler = new XTPQuoteHandler(this);
        quoteApi = new QuoteApi(handler);


    }




    public void connect(Map<String, String> settings) {
        String XTP_TRADE_SERVER_IP = "120.27.164.69";//xtp交易server的ip
        int XTP_TRADE_SERVER_PORT = 6001;//xtp交易server的端口
        String TRADE_KEY = "b8aa7173bba3470e390d787219b2112e";//xtp交易serverkey
        short CLIENT_ID = 18;//xtp允许的clientid
        String XTP_QUOTE_SERVER_IP = "120.27.164.138";//xtp行情server的ip
        int XTP_QUOTE_SERVER_PORT = 6002;//xtp行情server的端口
        String ACCOUNT = "53191000748";//xtp资金账号
        String PASSWORD = "b9j7rGqQ";//xtp密码
        String DATA_FOLDER = "d:/";//java api输出日志的本地目录
        int UDPBUFFERSIZE = 1024;//如果是udp协议，需要设置缓冲区

        quoteApi.init(CLIENT_ID,DATA_FOLDER, XtpLogLevel.XTP_LOG_LEVEL_INFO, JniLogLevel.JNI_LOG_LEVEL_INFO);
        quoteApi.setUDPBufferSize(UDPBUFFERSIZE);

        int login_result = quoteApi.login(XTP_QUOTE_SERVER_IP,XTP_QUOTE_SERVER_PORT,ACCOUNT,PASSWORD, TransferProtocol.XTP_PROTOCOL_TCP);//XTP_PROTOCOL_TCP

        System.out.println(login_result);

    }

    @Override
    public void close() {

    }

    @Override
    public void subscribe(SubscribeRequest request) {
        quoteApi.subscribeMarketData(new String[]{"300498"},1,2);
    }

    @Override
    public String sendOrder(OrderRequest request) {
        return null;
    }

    @Override
    public void cancelOrder(CancelRequest request) {

    }
}
