class Cart {
    private String customerName;
    private int itemCount;

    Cart(String customerName, int itemCount) {
        this.customerName = customerName;
        this.itemCount = itemCount;
    }

    String getCustomerName() { return customerName; }
    int getItemCount() { return itemCount; }

}

class POSline {
    private String id;
    private boolean active;
    private Cart[] line;

    POSline(String id) {
        this.id = id;
        this.active = true;
        this.line = new Cart[20]; 
    }

    void joinLine(Cart newCart) {
        for (int i = 0; i < line.length; i++) {
            if (line[i] == null) {
                line[i] = newCart;
                break; 
            }
        }
    }
public Cart removeFirst() {
    if (line == null) {
        return null;
    }
    
    Cart firstCart = line[0];
    
    line[0] = null;
    
  return firstCart;
}
    void checkoutCart() {
        if (line[0] != null) {
            leaveLine(0); 
        }
    }

    Cart leaveLine(int n) {
        Cart temp = line[n];
        for (int i = n; i < line.length - 1; i++) {
            line[i] = line[i + 1];
        }
        line[line.length - 1] = null;
        return temp;
    }

    Cart getLine(int n) {
        if (n >= 0 && n < line.length) return line[n];
        return null;
    }

    String getId() { return id; }
    boolean isActive() { return active; }
    void setActive(boolean active) { this.active = active; }
}

class POSsystem {
    private POSline[] counters = new POSline[10];
    private int count = 0;

    void addCounter(POSline targetLine) {
        if (count < counters.length) {
            counters[count] = targetLine;
            count++;
        }
    }

    POSline getCounter(int idx) {
        if (idx >= 0 && idx < count) return counters[idx];
        return null;
    }

    public POSline split(POSline number1) {
   POSline number2 = new POSline(number1.getId() + " - Split");
    
    int i = 1;
    while (number1.getLine(i) != null) {
        Cart cartToMove = number1.leaveLine(i);
        number2.joinLine(cartToMove);
        i++;     }
    
    return number2;
}


}

public class optionD {
    public static void main(String[] args) {
        POSsystem sys = new POSsystem();

        POSline l1 = new POSline("L1");
        POSline l2 = new POSline("L2");
        sys.addCounter(l1);
        sys.addCounter(l2);

        Cart c1 = new Cart("Alice", 12);
        Cart c2 = new Cart("Bob", 45);
        Cart c3 = new Cart("Charlie", 5);

        l1.joinLine(c1);
        l1.joinLine(c2);
        l1.joinLine(c3);
    }
}