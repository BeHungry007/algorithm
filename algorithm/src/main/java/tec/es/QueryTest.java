package tec.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import test.demo.ESClient;

import java.io.IOException;

public class QueryTest {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient highClient = ESClient.getHighClient();
        final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(100);
        SearchRequest searchRequest = new SearchRequest("logstash-v5.0-2021.03.19")
                .source(searchSourceBuilder);
        SearchResponse search = highClient.search(searchRequest,RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        //search.getHits().getTotalHits();

    }
}
