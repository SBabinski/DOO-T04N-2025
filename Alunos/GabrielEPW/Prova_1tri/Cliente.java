class Clientee {
    private String id;
    private String name;
    private String email;

    public Clientee(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
