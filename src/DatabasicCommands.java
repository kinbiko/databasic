// https://stackoverflow.com/a/19894176
enum DataBasicCommands {
    // Enums always would be uppercase (see comment in GitHub)
    INSERT, HELP;

    // Type toString and tab/enter
    @Override
    public String toString() {
        return name().toLowerCase();

    }
}