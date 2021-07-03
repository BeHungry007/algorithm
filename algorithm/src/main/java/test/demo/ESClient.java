package test.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class ESClient {

    public static RestHighLevelClient highClient = null;

    public static RestHighLevelClient getHighClient() {
        if (highClient == null) {
            synchronized (ESClient.class) {
                if (highClient == null) {
//                    HttpHost host = new HttpHost("192.168.13.132", 9200, "http");

                    HttpHost host = new HttpHost("192.168.13.132", 9200, "http");
                    RestClientBuilder builder = RestClient.builder(host).setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
                        @Override
                        public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder builder) {
                            builder.setSocketTimeout(30000 * 4);
                            return builder;
                        }
                    });
                    builder.build();
                    highClient = new RestHighLevelClient(builder);

                }
            }
        }
        return highClient;
    }
}
