class Item {
    private String itemCode;
    private double price;

    public Item(String itemCode, double price) {
        this.itemCode = itemCode;
        this.price = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public double getPrice() {
        return price;
    }
}

class Twostacks {
    private int[] arr;
    private int top1; 
    private int top2; 
    private int size;

    public Twostacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;       
        top2 = n;       
    }

    public void push1(int x) {
        if (top1 < top2 - 1) { 
            arr[++top1] = x;
        } 
    }

    public void push2(int x) {
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        } 
    }

    public int pop1() {
        if (top1 >= 0) {
            int num = arr[top1];
            arr[top1] = 0;
            top1--;
            return num;
        } else {
            return -1;
        }
    }

    public int pop2() {
        if (top2 < size) {
            int num = arr[top2];
            arr[top2] = 0;
            top2++;
            return num;
        } else {
            return -1;
        }
    }
}

class Payment {
    private FoodItem[] fi = new FoodItem[100];
    private int fiCount;
    private static double foodTax = 0.2; 
    private DrinkItem[] di = new DrinkItem[100];
    private int diCount;
    private static double drinkTax = 0.1; 

    public Payment() {
        fiCount = 0;
        diCount = 0;
    }

    public DrinkItem getDi(int x) {
        return di[x];
    }

    public int getFiCount() {
        return fiCount;
    }

    public static double getFoodTax() {
        return foodTax;
    }

    public void addFoodItem(FoodItem newItem) {
        if (fiCount < 100) {
            fi[fiCount] = newItem;
            fiCount++;
        }
    }

    public void addDrinkItem(DrinkItem newItem) {
        if (diCount < 100) {
            di[diCount] = newItem;
            diCount++;
        }
    }

    public static double findPrice(Item[] pl, String c) {
        for (int i = 0; i < pl.length; i++) {
            if (pl[i] != null && pl[i].getItemCode().equals(c)) {
                return pl[i].getPrice();
            }
        }
        return 0.0;
    }

    public double calculateBill(Item[] pl) {
        double foodSubtotal = 0.0;
        double drinkSubtotal = 0.0;

        for (int i = 0; i < fiCount; i++) {
            double price = findPrice(pl, fi[i].getItemCode());
            foodSubtotal += price * fi[i].getQuantity();
        }

        for (int i = 0; i < diCount; i++) {
            double price = findPrice(pl, di[i].getItemCode());
            drinkSubtotal += price * di[i].getQuantity();
        }

        double totalFoodCost = foodSubtotal * (1 + foodTax);
        double totalDrinkCost = drinkSubtotal * (1 + drinkTax);

        return totalFoodCost + totalDrinkCost;
    }
}

class FoodItem {
    private String itemCode;
    private int quantity;

    public FoodItem(String x, int y) {
        itemCode = x;
        quantity = y;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }
}

class DrinkItem {
    private String itemCode;
    private int quantity;

    public DrinkItem(String x, int y) {
        itemCode = x;
        quantity = y;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class homework3 {
    public static void main(String[] args) {
        Twostacks TwoSt = new Twostacks(6);
        TwoSt.push1(4);
        TwoSt.push1(1);
        TwoSt.push1(3);
        TwoSt.pop1();
        TwoSt.push1(8);
        TwoSt.pop1();

        Payment[] tables = new Payment[3];
        tables[1] = new Payment();
        tables[2] = new Payment();

        FoodItem a = new FoodItem("f102", 2);
        FoodItem b = new FoodItem("f100", 1);
        DrinkItem c = new DrinkItem("d102", 3);

        tables[1].addFoodItem(a);
        tables[1].addFoodItem(b);
        tables[2].addDrinkItem(c);
        tables[2].addDrinkItem(new DrinkItem("d103", 1));

        System.out.println(tables[1].getFiCount());
        System.out.println(Payment.getFoodTax());
        System.out.println(tables[2].getDi(1).getItemCode());
    }
}