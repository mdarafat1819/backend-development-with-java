enum Status {

    PENDING("Pending"), IN_PROGRESS("In Progress"), DONE("Done");
    private String description;

    Status() {
    }
    Status(String description) {
        this.description = description;
    }
    String getDescription() {
        return description;
    }
}
