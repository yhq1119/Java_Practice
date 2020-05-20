package java_fx.rental_system2.model;

public class Property {
    private String id;
    private String address;
    private int rooms;
    private double price;
    private double penalty;

    public Property(String id, String address, int rooms, double price, double penalty) {
        this.id = id;
        this.address = address;
        this.rooms = rooms;
        this.price = price;
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", rooms=" + rooms +
                ", price=" + price +
                ", penalty=" + penalty +
                '}';
    }
}
