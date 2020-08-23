package app.config;

import org.apache.http.client.CookieStore;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

/**
 * @program: jemter-testapp
 * @description: Http连接池
 * @author: hmj
 * @create: 2020-04-12 21:23
 **/
@Component
public class HttpConnectionManager {

    /** * 默认请求超时时间30s */
    private static final int DEFAUL_TTIME_OUT = 15000;
    /**  默认的连接数量*/
    private static final int MAX_TOTAL = 50;
    private static final int DEFAULT_MAX_PER_ROUTE = 20;

    PoolingHttpClientConnectionManager cm = null;

    @PostConstruct
    public void init() {
        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();
        cm =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
//        //最大连接数
        cm.setMaxTotal(MAX_TOTAL);
        //默认的每个路由的最大连接数
        cm.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
    }

    public CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
        return httpClient;
    }


    public CloseableHttpClient getHttpClientByCookieStore(CookieStore cookieStore){
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultCookieStore(cookieStore)
                .build();
        return httpClient;
    }
}
