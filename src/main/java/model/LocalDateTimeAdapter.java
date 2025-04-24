package model;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(formatter));
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsString(), formatter);
    }
}