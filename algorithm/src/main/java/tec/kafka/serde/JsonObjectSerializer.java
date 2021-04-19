package tec.kafka.serde;

import com.google.gson.JsonObject;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JsonObjectSerializer implements Serializer<JsonObject> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, JsonObject jsonObject) {
        return jsonObject.toString().getBytes(StandardCharsets.UTF_8);
    }


    @Override
    public void close() {

    }
}
