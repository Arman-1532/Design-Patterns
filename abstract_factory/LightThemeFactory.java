package abstract_factory;

class LightThemeFactory implements ThemeFactory {
    public Button createButton() {
        return new LightButton();
    }

    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}