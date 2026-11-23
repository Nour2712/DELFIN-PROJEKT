public enum Discipline {
    BUTTERFLY,
    CRAWL,
    BACK_CRAWL,
    BREASTSTROKE;

    public static Discipline parse(String input) {
        return Discipline.valueOf(input.toUpperCase());
    }
}
