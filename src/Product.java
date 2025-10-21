public class Product {
    private final int id;
    private final String name;
    private int quantity;
    private final int reorderThreshold;

    public Product(int id, String name, int initialQuantity, int reorderThreshold) {
        this.id = id;
        this.name = name;
        this.quantity = initialQuantity;
       this.reorderThreshold = reorderThreshold;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public synchronized int getQuantity() { return quantity; }
    public int getReorderThreshold() { return reorderThreshold; }
    public int getId() {
         return id;
          }
    public String getName() { 
        return name;
         }
    public synchronized int getQuantity() { 
        return quantity; 
        }
    public int getReorderThreshold() {
         return reorderThreshold;
          }

    public synchronized void increaseQuantity(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be non-negative");
        this.quantity += amount;
    }

    public synchronized void decreaseQuantity(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be non-negative");
        if (amount > this.quantity) throw new IllegalArgumentException("Insufficient stock");
        this.quantity -= amount;
    }
    public String toString() {
        return String.format("Product[id=%d, name=%s, qty=%d, threshold=%d]", id, name, quantity, reorderThreshold);
    }
}
