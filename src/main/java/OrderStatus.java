public enum OrderStatus {
    PROCESSING("processing"),
    IN_DELIVERY("inDelivery"),
    COMPLETED("completed");

    private final String status;

    private OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}