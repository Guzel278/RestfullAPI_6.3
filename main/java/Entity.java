public class Entity {
    private static long counter = 0;

    private long id;
    private String name;

    public Entity(String name) {
        this.id = counter++;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}