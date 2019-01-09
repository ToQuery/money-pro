package io.github.toquery.moneypro.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.base.Strings;

import java.io.IOException;

/**
 * @author toquery
 * @version 1
 */
public class ChineseCurrencyJsonDeserializer extends JsonDeserializer<Double> {

    private static final String CURRENCY_SYMBOL = "CN¥";

    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String rawValue = jsonParser.getValueAsString().trim();
        if (Strings.isNullOrEmpty(rawValue)) {
            return null;
        }
        boolean negative = rawValue.contains("(") && rawValue.contains(")");
        rawValue = rawValue.replaceAll(",", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .substring(CURRENCY_SYMBOL.length());
        Double result = Double.valueOf(rawValue);
        return negative ? -result : result;

    }
}
