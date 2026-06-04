import java.util.LinkedList;

class Brand {
    private String bname;
    private float bprice;

    public Brand(String name, float price) {
        bname = name;
        bprice = price;
    }

    public float getBrandPrice() {
        return bprice;
    }

    public String getBrandName() {
        return bname;
    }

    public void setBrandPrice(float p) {
        bprice = p;
    }

    public void setBrandName(String n) {
        bname = n;
    }
}

class Product {
    private String pcode;
    private String ptype;
    private String pdesc;
    private Brand pbrand;
    private int psale;

    public Product(String code, String type, String desc, Brand brand, int sale) {
        pcode = code;
        ptype = type;
        pdesc = desc;
        pbrand = brand;
        psale = sale;
    }

    public int getProdSale() {
        return psale;
    }

    public Brand getProdBrand() {
        return pbrand;
    }

    public String getProdDescription() {
        return pdesc;
    }

    public String getProdCode() {
        return pcode;
    }

    public String getProdType() {
        return ptype;
    }

    public void setProdSale(int s) {
        psale = s;
    }

    public void setProdBrand(Brand b) {
        pbrand = b;
    }

    public void setProdDescription(String d) {
        pdesc = d;
    }

    public void setProdCode(String c) {
        pcode = c;
    }

    public void setProdType(String t) {
        ptype = t;
    }
}

class ProductManagement {
    private Product[] allProducts = new Product[25];

    public void sortProducts() {
        for (int i = 0; i < allProducts.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < allProducts.length; j++) {
                if (allProducts[j] != null && allProducts[max] != null) {
                    if (allProducts[j].getProdSale() > allProducts[max].getProdSale()) {
                        max = j;
                    }
                }
            }

            Product temp = allProducts[i];
            allProducts[i] = allProducts[max];
            allProducts[max] = temp;
        }
    }

    public void setProduct(int i, Product p) {
        allProducts[i] = p;
    }

    public Product getProduct(int i) {
        return allProducts[i];
    }
}

class Invoice {
    private String id;
    private static Product[] products = new Product[20];
    private static int[] qty = new int[20];
    private boolean discount;
    private int num;

    public Invoice(String invoiceID) {
        id = invoiceID;
        discount = false;
        num = 0;
    }

    public String getInvoiceID() {
        return id;
    }

    public boolean getDiscount() {
        return discount;
    }

    public void addProduct(Product product, int quantity) {
        products[num] = product;
        qty[num] = quantity;
        num++;
    }

    public void setQualifiesForDiscount() {
        float total = 0;

        for (int i = 0; i < num; i++) {
            total = total + products[i].getProdBrand().getBrandPrice() * qty[i];
        }

        if (total > 3000) {
            discount = true;
        }
    }
}

class Supplier {
    private String sname;
    private String scountry;
    private String[] pnames = new String[10];

    public Supplier(String name, String country, String[] products) {
        sname = name;
        scountry = country;
        pnames = products;
    }

    public String getSupplierName() {
        return sname;
    }

    public String getSupplierCountry() {
        return scountry;
    }

    public String displayData() {
        String s = "Supplier: " + sname + ", Country: " + scountry;
        System.out.println(s);
        return s;
    }
}

class SupplierManager {
    LinkedList<Supplier> supplierList;

    public SupplierManager() {
        supplierList = new LinkedList<Supplier>();
    }

    public void addSupplier(Supplier ns) {
        int i = 0;

        while (i < supplierList.size() && supplierList.get(i).getSupplierName().compareTo(ns.getSupplierName()) < 0) {
            i++;
        }

        supplierList.add(i, ns);
    }

    public void displayList() {
        for (int i = 0; i < supplierList.size(); i++) {
            supplierList.get(i).displayData();
        }
    }

    public static int countOfSuppliers(LinkedList<Supplier> list, String country, int n) {
        if (n == 0) {
            return 0;
        }

        if (list.get(n - 1).getSupplierCountry().equals(country)) {
            return 1 + countOfSuppliers(list, country, n - 1);
        }

        return countOfSuppliers(list, country, n - 1);
    }
}

public class June4{
    public static void main(String[] args) {
        Brand b = new Brand("Safesun", 2.17f);

        Product p1 = new Product("X123", "Sunscreen", "Skin product", b, 45);
        Product p2 = new Product("X124", "Cream", "Face cream", b, 21);

        ProductManagement pm = new ProductManagement();
        pm.setProduct(0, p1);
        pm.setProduct(1, p2);
        pm.sortProducts();

        Invoice inv = new Invoice("I01");
        inv.addProduct(p1, 3);
        inv.addProduct(p2, 2);
        inv.setQualifiesForDiscount();

        String[] ps = {"Sunscreen", "Cream"};
        Supplier s1 = new Supplier("Alpha", "Armenia", ps);
        Supplier s2 = new Supplier("Beta", "Georgia", ps);

        SupplierManager sm = new SupplierManager();
        sm.addSupplier(s2);
        sm.addSupplier(s1);
        sm.displayList();

        System.out.println(p1.getProdDescription());
        System.out.println(inv.getDiscount());
        System.out.println(SupplierManager.countOfSuppliers(sm.supplierList, "Armenia", sm.supplierList.size()));
    }
}
    

