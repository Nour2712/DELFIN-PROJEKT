public enum AgeGroup {
    JUNIOR,
    SENIOR,
    SENIOR_PLUS;

    public static AgeGroup parse(String input) {
        return AgeGroup.valueOf(input.toUpperCase());
    }
}
