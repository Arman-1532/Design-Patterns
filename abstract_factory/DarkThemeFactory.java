package abstract_factory;

class DarkThemeFactory implements ThemeFactory {
    public Button createButton() {
        return new DarkButton();
    }

    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}
