package xyz.shuttle.filebox.basis.domain;

public enum UserFilesField {
    FILE_NAME("filename"), USER_NAME("username");

    private final String field;

    UserFilesField(String field) {
        this.field = field;
    }

    public String field() {
        return field;
    }
}
