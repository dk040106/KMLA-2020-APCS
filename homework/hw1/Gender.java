public enum Gender {
    M("Male"), F("Female"), O("Other");

    private final String label;

    private Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
