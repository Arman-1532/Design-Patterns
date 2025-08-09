package learning.flyweight;

import java.util.Map;
import java.util.HashMap;

public class TextFormatFactory {
    private static final Map<String, TextFormat> formatMap = new HashMap<>();

    public static TextFormat getTextFormat(String font, int size, String style) {
        String key = font + size + style;
        if (!formatMap.containsKey(key)) {
            formatMap.put(key, new TextFormat(font, size, style));
        }
        return formatMap.get(key);
    }
}