package tec.kafka.serde;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class JsonObjecrDeserializer implements Deserializer<JsonObject> {

    private static final JsonParser jp = new JsonParser();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public JsonObject deserialize(String s, byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return jp.parse(new String(bytes)).getAsJsonObject();
    }

    @Override
    public void close() {

    }
}
