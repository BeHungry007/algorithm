package test.demo;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class KafkaTest {

    public static AdminClient adminClient;

    public static void clientInit(){

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "192.168.9.217:9092");
        properties.put(CommonClientConfigs.RETRIES_CONFIG, Integer.MAX_VALUE);
        adminClient = KafkaAdminClient.create(properties);
        Set<NewTopic> listTopic = new HashSet<>();
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        KafkaFuture<Map<String, TopicListing>> mapKafkaFuture = listTopicsResult.namesToListings();
        Map<String, TopicListing> stringTopicListingMap = mapKafkaFuture.get();
        Set<Map.Entry<String, TopicListing>> entries = stringTopicListingMap.entrySet();
        Iterator<Map.Entry<String, TopicListing>> iterator = entries.iterator();
        if (iterator.hasNext()) {
            Map.Entry<String, TopicListing> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
    }
}
