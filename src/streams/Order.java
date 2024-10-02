package streams;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate,
                 List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    //Stream per prodotti Baby
    public static List<Order> ordinaBaby(List<Order> babyOrders) {
        return babyOrders.stream()  // Creo uno stream dai prodotti di ogni ordine
                .filter(myOrder -> myOrder.getProducts()
                        .stream().anyMatch(product -> product.getCategory()
                                .equalsIgnoreCase("Baby")))  // se almeno un prodotto e della categoria Baby
                .collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", deliveryDate ='" + deliveryDate + '\'' +
                ", products ='" + products + '\'' +
                ", customer ='" + customer + '\'' +
                '}';

    }
}

