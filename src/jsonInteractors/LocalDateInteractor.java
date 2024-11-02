package jsonInteractors;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * Class that describes methods of parsing the LocalDateformat
 */
public class LocalDateInteractor implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate>
{
    @Override
    public JsonElement serialize(LocalDate date, Type type, JsonSerializationContext context)
    {
        return new JsonPrimitive(date.toString());
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException
    {
        return LocalDate.parse(json.getAsString());
    }
}