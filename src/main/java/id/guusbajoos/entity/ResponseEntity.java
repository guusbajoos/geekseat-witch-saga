package id.guusbajoos.entity;

public class ResponseEntity {
    private String message;
    private Double value;

    public ResponseEntity() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
