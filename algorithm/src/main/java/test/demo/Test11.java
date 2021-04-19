package test.demo;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

public class Test11 {
    public static void main(String[] args) throws IOException {
        Test11 t = new Test11();
        RestHighLevelClient host = t.getHost();
        Request request = new Request("GET", "/_cat/indices");
        Response response = host.getLowLevelClient().performRequest(request);
        HttpEntity entity = response.getEntity();
        byte[] bytes = entity.getContent().readAllBytes();
        String content = new String(bytes, "utf-8");
        String[] indices = content.split("\n");
        for (String index : indices) {
            System.out.println(index);
        }
//        SearchRequest searchRequest = t.getRequest("logstash-v5.0-2021-1");
//        Request request = new Request("GET", "/_cat/indices");
//        SearchResponse search = host.search(searchRequest, RequestOptions.DEFAULT);
//        String scrollId = search.getScrollId();
//        SearchHit[] hits = search.getHits().getHits();
//        long total = search.getHits().getTotalHits();
//        for (SearchHit hit : hits) {
//            String jsonData = hit.getSourceAsString();
//            JsonParser jp = new JsonParser();
//            JsonObject obj = jp.parse(jsonData).getAsJsonObject();
//
//            String sensor_id = obj.get("SENSOR_ID").getAsString();
//            System.out.println(sensor_id);
//            System.out.println("aa");
//        }
    }

    public SearchRequest getRequest(String index) {
        SearchRequest searchRequest = new SearchRequest(index);
        final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1L));
        searchRequest.scroll(scroll);
        SearchSourceBuilder searchBuilder = new SearchSourceBuilder();
        searchBuilder.size();
        //QueryBuilder qb = QueryBuilders.termsQuery(QueryEsConfig.FIELD_NAME, QueryEsConfig.SENSOR_FILESYSTEM);

        searchBuilder.sort("TIME", SortOrder.ASC);
        searchBuilder.timeout(TimeValue.timeValueMillis(1));
        //searchBuilder.query(qb);
        searchRequest.source(searchBuilder);
        return searchRequest;
    }

    public RestHighLevelClient getHost() {
        HttpHost host = new HttpHost("192.168.9.217", 9200, "http");
        RestClientBuilder builder = RestClient.builder(host).setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder builder) {
                builder.setSocketTimeout(100000);
                return builder;
            }
        });
        builder.build();
        RestHighLevelClient highClient = new RestHighLevelClient(builder);
        return highClient;
    }

}

