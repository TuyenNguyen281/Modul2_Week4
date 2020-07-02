package bt_quan_ly_sanpham_luu_ra_file_nhi_phan;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Product> productList = new ArrayList<>();

    public static void displayFunction() {
        System.out.println( ".................." );
        System.out.println( "Chọn một chức năng: " );
        System.out.println( ".................." );
        System.out.println( "1. Thêm sản phẩm" );
        System.out.println( "2. Hiển thị danh sách sản phẩm" );
        System.out.println( "3. Tìm kiếm sản phẩm theo tên" );
        System.out.println( "4. Lưu ra File" );
        System.out.println( "5. Đọc File và in ra màn hình" );
        System.out.println( "0. Thoát chương trình" );
    }

    public static void chooseFunction(int number) throws IOException {
        switch (number) {
            case 1:
                addProduct();
                displayFunction();
                recallFunction();
                break;
            case 2:
                showProductList();
                displayFunction();
                recallFunction();
                break;
            case 3:
                seachProduct();
                displayFunction();
                recallFunction();
                break;
            case 4:
                addFile();
                displayFunction();
                recallFunction();
                break;
            case 5:
                readFile();
                displayFunction();
                recallFunction();


            case 0:
                System.exit( 0 );
                break;
            default:
                System.out.println( "Không có sự lựa chọn" );
                displayFunction();
                recallFunction();

        }
    }

    public static void recallFunction() throws IOException {
        Scanner scanner = new Scanner( System.in );
        int number = scanner.nextInt();
        chooseFunction( number );
    }

    public static void addProduct() {
        Product product;
        int id;
        if (productList.size() == 0) {
            id = 0;
        } else {
            id = (productList.size() - 1) + 1;
        }
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Nhập tên sản phẩm: " );
        String name = scanner.next();
        System.out.println( "Nhập giá sản phẩm: " );
        int price = scanner.nextInt();
        product = new Product( id, name, price );
        if (productList.add( product )) {
            System.out.println( "Thêm sản phẩm thành công" );
        } else {
            System.out.println( "Thêm sản phẩm không thành công" );
        }
    }

    public static void showProductList() {
        System.out.println( "Danh sách sản phảm là:................." );
        for (int i = 0; i < productList.size(); i++) {
            System.out.println( productList.get( i ) );
        }
    }

    public static void seachProduct() {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Nhập tên sản phẩm cần tìm:" );
        String name = scanner.next();
        boolean checkName = false;

        for (int i = 0; i < productList.size(); i++) {
            if (name.equals( productList.get( i ).getName() )) {
                System.out.println( productList.get( i ) );
                checkName = true;
            }
        }
        if (!checkName) {
            System.out.println( "Không tìm thấy" );
        }
    }

    public static void addFile() throws IOException {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream( "G:\\Modul2\\Week_4\\src\\bt_quan_ly_sanpham_luu_ra_file_nhi_phan\\Quanlysanpham.txt" );
            ObjectOutputStream output = new ObjectOutputStream( fileOutputStream );
//            for (int i = 0; i < productList.size(); i++) {
//
//                output.writeObject( productList.get( i ) );
//             }
            output.writeObject( productList );
            output.close();
            System.out.println("Lưu ra File thành công");

        } catch (IOException e) {
            System.out.println( "Lưu ra File không thành công" );

        }
    }

    public static void readFile() throws IOException {
        List<Product> products;

        try {
            FileInputStream fileInputStream = new FileInputStream( "G:\\Modul2\\Week_4\\src\\bt_quan_ly_sanpham_luu_ra_file_nhi_phan\\Quanlysanpham.txt" );
            ObjectInputStream intput = new ObjectInputStream( fileInputStream );
            products = (List<Product>) intput.readObject();
            for (int i = 0; i < products.size(); i++) {
                System.out.println( products.get( i ) );
            }
            intput.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println( "Khong tim thay file" );
        }
    }

    public static void main(String[] args) throws IOException {
        Product product1 = new Product( 0, "Tuyển", 300 );
        Product product2 = new Product( 1, "Cần", 200 );
        Product product3 = new Product( 2, "Tùng", 400 );
        Product product4 = new Product( 3, "Cường", 100 );
        productList.add( product1 );
        productList.add( product2 );
        productList.add( product3 );
        productList.add( product4 );
        displayFunction();
        Scanner scanner = new Scanner( System.in );
        int number = scanner.nextInt();
        chooseFunction( number );
    }
}

