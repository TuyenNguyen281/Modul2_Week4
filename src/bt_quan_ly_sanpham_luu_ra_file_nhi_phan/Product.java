package bt_quan_ly_sanpham_luu_ra_file_nhi_phan;

public class Product implements java.io.Serializable {

    private int id;
    private String name;
    private int price;

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {

    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "   Name: " + getName() + "   Price " + getPrice();

    }
}

