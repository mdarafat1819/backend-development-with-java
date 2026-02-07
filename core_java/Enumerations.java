enum Level {
    HIGH("High Level"),
    MEDIUM,
    LOW;

    private String description;
    private Level() {}
    private Level(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

}
public class Enumerations {
    public static void main(String[] args) {
        Level lv = Level.HIGH;

        System.out.println(lv);
        System.out.println(lv.getDescription());

        for(Level level : Level.values()) {
            System.out.println(level);
        }
    }
}
