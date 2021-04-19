package tec.kafka.serde;

import com.google.gson.JsonObject;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class JsonObjectSerde implements Serde<JsonObject> {

    private final Serializer<JsonObject> serializer;
    private final Deserializer<JsonObject> deserializer;

    public JsonObjectSerde() {
        this.serializer = new JsonObjectSerializer();
        this.deserializer = new JsonObjecrDeserializer();
    }



    @Override
    public void close() {

    }

    @Override
    public Serializer<JsonObject> serializer() {
        return this.serializer;
    }

    @Override
    public Deserializer<JsonObject> deserializer() {
        return this.deserializer;
    }
}
