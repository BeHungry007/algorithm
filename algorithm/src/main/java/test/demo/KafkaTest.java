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
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "192.168.13.132:9092");
        properties.put(CommonClientConfigs.RETRIES_CONFIG, Integer.MAX_VALUE);
        adminClient = KafkaAdminClient.create(properties);
        NewTopic newTopic = new NewTopic("test1", 24, (short) 1);
        Set<NewTopic> listTopic = new HashSet<>();
        listTopic.add(newTopic);
        ListTopicsResult listTopicsResult = adminClient.listTopics();

        KafkaFuture<Set<String>> names = listTopicsResult.names();
        Set<String> strings = names.get();
        System.out.println(strings.toArray().toString());
        CreateTopicsResult topics = adminClient.createTopics(listTopic);
        Map<String, KafkaFuture<Void>> values = topics.values();
        System.out.println(values.toString());

    }
}
