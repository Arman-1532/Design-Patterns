package abstract_factory;

public class Main {
    public static void main(String[] args) {

        ThemeFactory themeFactory = new DarkThemeFactory();

        Button button = themeFactory.createButton();
        Checkbox checkbox = themeFactory.createCheckbox();

        button.render();
        checkbox.render();
    }
}

