package com.eden.dolphin.broker.xtp;

import com.zts.xtp.common.enums.JniLogLevel;
import com.zts.xtp.common.enums.TransferProtocol;
import com.zts.xtp.common.enums.XtpLogLevel;
import com.zts.xtp.common.jni.JNILoadLibrary;
import com.zts.xtp.quote.api.QuoteApi;


import org.junit.*;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class QuoteApiTest {

    private static QuoteApi quoteApi;



    private static final String XTP_TRADE_SERVER_IP = "120.27.164.69";//xtp交易server的ip
    private static final int XTP_TRADE_SERVER_PORT = 6001;//xtp交易server的端口
    private static final String TRADE_KEY = "b8aa7173bba3470e390d787219b2112e";//xtp交易serverkey
    private static final short CLIENT_ID = 18;//xtp允许的clientid
    private static final String XTP_QUOTE_SERVER_IP = "120.27.164.138";//xtp行情server的ip
    private static final int XTP_QUOTE_SERVER_PORT = 6002;//xtp行情server的端口
    private static final String ACCOUNT = "53191000748";//xtp资金账号
    private static final String PASSWORD = "b9j7rGqQ";//xtp密码
    private static final String DATA_FOLDER = "d:/";//java api输出日志的本地目录
    private static final int UDPBUFFERSIZE = 1024;//如果是udp协议，需要设置缓冲区

    @BeforeClass
    public static void setUp() throws Exception {
        JNILoadLibrary.loadLibrary();
        TestQuoteSpi testspi = new TestQuoteSpi();
        quoteApi = new QuoteApi(testspi);
        quoteApi.init(CLIENT_ID,DATA_FOLDER,XtpLogLevel.XTP_LOG_LEVEL_INFO, JniLogLevel.JNI_LOG_LEVEL_INFO);
        quoteApi.setUDPBufferSize(UDPBUFFERSIZE);
//        quoteApi.setHeartBeatInterval(60*10);
        int login_result = quoteApi.login(XTP_QUOTE_SERVER_IP,XTP_QUOTE_SERVER_PORT,ACCOUNT,PASSWORD,TransferProtocol.XTP_PROTOCOL_TCP);//XTP_PROTOCOL_TCP
        Assert.assertEquals(login_result, 0);

//        System.out.println("subscribeAllTickByTick");
//        quoteApi.subscribeAllTickByTick(2);

//        System.out.println("subscribeAllOrderBook");
//        quoteApi.subscribeAllOrderBook(2);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        int logout_result = quoteApi.logout();
        Assert.assertEquals(logout_result,0);
        quoteApi.disconnect();
    }

    @After
    public void waitSomeTime() throws InterruptedException {
        Thread.sleep(500000);
    }


    @Test
    public void setHeartBeatInterval() {
        System.out.println("setHeartBeatInterval");
        quoteApi.setHeartBeatInterval(1000);
    }

    @Test
    public void subscribeMarketData() {
        System.out.println("subscribeMarketData");
        quoteApi.subscribeMarketData(new String[]{"300498"},1,2);//20008025
    }

    @Test
    public void unSubscribeMarketData() {
        System.out.println("unSubscribeMarketData");
        quoteApi.unSubscribeMarketData(new String[]{"300498"},1,2);//11011077
    }

    @Test
    public void subscribeOrderBook() {
        System.out.println("subscribeOrderBook");
        quoteApi.subscribeOrderBook(new String[]{"300498"},1,2);//11011077
    }

    @Test
    public void unSubscribeOrderBook() {
        System.out.println("unSubscribeOrderBook");
        quoteApi.unSubscribeOrderBook(new String[]{"300498"},1,2);//11011077
    }

    @Test
    public void subscribeTickByTick() {
        System.out.println("subscribeTickByTick");
        quoteApi.subscribeTickByTick(new String[]{"300498"},1,2);//11011077
    }

    @Test
    public void unSubscribeTickByTick() {
        System.out.println("unSubscribeTickByTick");
        quoteApi.unSubscribeTickByTick(new String[]{"300498"},1,2);//11011077
    }

    @Test
    public void subscribeAllMarketData() {
        System.out.println("subscribeAllMarketData");
        quoteApi.subscribeAllMarketData(2);
    }

    @Test
    public void unSubscribeAllMarketData() {
        System.out.println("unSubscribeAllMarketData");
        quoteApi.unSubscribeAllMarketData(2);
    }

    @Test
    public void subscribeAllOrderBook() {
        System.out.println("subscribeAllOrderBook");
        quoteApi.subscribeAllOrderBook(2);
    }

    @Test
    public void unSubscribeAllOrderBook() {
        System.out.println("unSubscribeAllOrderBook");
        quoteApi.unSubscribeAllOrderBook(2);
    }

    @Test
    public void subscribeAllTickByTick() {
        System.out.println("subscribeAllTickByTick");
        quoteApi.subscribeAllTickByTick(2);
    }

    @Test
    public void unSubscribeAllTickByTick() {
        System.out.println("unSubscribeAllTickByTick");
        quoteApi.unSubscribeAllTickByTick(2);
    }

    @Test
    public void queryAllTickers() {
        System.out.println("queryAllTickers");
        quoteApi.queryAllTickers(2);
    }

    @Test
    public void queryTickersPriceInfo() {
        System.out.println("queryTickersPriceInfo");
        quoteApi.queryTickersPriceInfo(new String[]{"300498"},1,2);//11011077
    }

    @Test
    public void subscribeAllOptionMarketData(){
        System.out.println("subscribeAllOptionMarketData");
        quoteApi.subscribeAllOptionMarketData(2);
    }

    @Test
    public void unSubscribeAllOptionMarketData(){
        System.out.println("unSubscribeAllOptionMarketData");
        quoteApi.unSubscribeAllOptionMarketData(2);
    }

    @Test
    public void subscribeAllOptionOrderBook(){
        System.out.println("subscribeAllOptionOrderBook");
        quoteApi.subscribeAllOptionOrderBook(2);
    }

    @Test
    public void unSubscribeAllOptionOrderBook(){
        System.out.println("unSubscribeAllOptionOrderBook");
        quoteApi.unSubscribeAllOptionOrderBook(2);
    }

    @Test
    public void subscribeAllOptionTickByTick(){
        System.out.println("subscribeAllOptionTickByTick");
        quoteApi.subscribeAllOptionTickByTick(2);
    }

    @Test
    public void unSubscribeAllOptionTickByTick(){
        System.out.println("unSubscribeAllOptionTickByTick");
        quoteApi.unSubscribeAllOptionTickByTick(2);
    }
}