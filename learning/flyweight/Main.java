package learning.flyweight;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<FormattedCharacter> text = new ArrayList<>();
        text.add(new FormattedCharacter('H', TextFormatFactory.getTextFormat("Arial", 12, "Bold")));
        text.add(new FormattedCharacter('e', TextFormatFactory.getTextFormat("Arial", 12, "Bold")));
        text.add(new FormattedCharacter('l', TextFormatFactory.getTextFormat("Arial", 12, "Bold")));
        text.add(new FormattedCharacter('l', TextFormatFactory.getTextFormat("Times", 12, "Italic")));
        text.add(new FormattedCharacter('o', TextFormatFactory.getTextFormat("Times", 12, "Italic")));

        for (FormattedCharacter fc : text) {
            fc.display();
        }
    }
}

