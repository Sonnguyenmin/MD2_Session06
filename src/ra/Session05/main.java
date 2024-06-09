package ra.Session05;

import java.util.Scanner;

public class main {
    public static Products[] arrProducts = new Products[100];
    public static int indexProduct = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        do {
            System.out.println("**********************************PRODUCTS MENU******************************");
            System.out.println("*       1. Nhập thong tin cac san pham                                      *");
            System.out.println("*       2. Hien thi thong tin cac san pham                                  *");
            System.out.println("*       3. Sap xep cac san pham theo gia                                    *");
            System.out.println("*       4. Cap nhat thong tin san pham theo ma san pham                     *");
            System.out.println("*       5. Xoa san pham theo ma san pham                                    *");
            System.out.println("*       6. Tim kiem cac san pham theo ten san pham                          *");
            System.out.println("*       7. Tim kiem san pham trong khoang gia a-b (a, b nhap tu ban phim)   *");
            System.out.println("*       8. Thoat                                                            *");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputListProduct(scanner);
                    break;
                case 2:
                    displayListProduct();
                    break;
                case 3:
                    sortAsxendingProduct();
                    break;
                case 4:
                    updateProduct(scanner);
                    break;
                case 5:
                    deleteProduct(scanner);
                    break;
                case 6:
                    searchProductByName(scanner);
                    break;
                case 7:
                    searchProductByPrice(scanner);
                    break;
                case 8:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui long nhap tu 1-8");
            }
        } while (isExit);
    }

    //1. Menu San pham
    //case 1: Nhap thong tin cac danh muc
    public static void inputListProduct(Scanner scanner) {
        System.out.println("Nhap so san pham can nhap: ");
        int countProduct = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countProduct; i++) {
            //Nhap thong tin cho danh muc co chi so indexCatalog trong mang
            arrProducts[indexProduct] = new Products();
            arrProducts[indexProduct].inputData(scanner);
            indexProduct++;
        }
    }
    //case 2: Hiển thị thông tin san pham
    public static void displayListProduct() {
        for (int i = 0; i < indexProduct; i++) {
            arrProducts[i].displayData();
        }
    }
    //case 3: Sap xep cac san pham theo gia
    public static void sortAsxendingProduct() {
        for (int i = 0; i < indexProduct; i++) {
            for (int j = i+1; j < indexProduct; j++) {
                if(arrProducts[i].getPrice() > arrProducts[j].getPrice()){
                    Products temp = arrProducts[i];
                    arrProducts[i] = arrProducts[j];
                    arrProducts[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep san pham theo gia");
    }
    //case 4: Cap nhat trang thai danh muc
    public static  void updateProduct(Scanner scanner) {
        System.out.println("Nhap vao ma san pham can nhap: ");
        String productId = scanner.nextLine();
        int indexUpdate = getIndexByProductId(productId);
        if(indexUpdate >= 0) {
            boolean isExit = true;//co danh muc
            do {
                System.out.println("1. Cap nhat ten san pham");
                System.out.println("2. Cap nhat gia san pham");
                System.out.println("3. Cap nhat mo ta san pham");
//                System.out.println("4. Cap nhat ngay");
                System.out.println("5. Cap nhat trang thai san pham");
                System.out.println("6. Thoat");
                System.out.println("Lua chon cua ban");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        arrProducts[indexUpdate].setProductName(scanner.nextLine());
                        break;
                    case 2:
                        arrProducts[indexUpdate].setPrice(scanner.nextFloat());
                        break;
                    case 3:
                        arrProducts[indexUpdate].setDescription(scanner.nextLine());
                        break;
                    case 4:
                        arrProducts[indexUpdate].setProductStatus(scanner.nextInt());
                        break;
                    default:
                        isExit =false;
                }
            }
            while (isExit);
        } else {
            System.err.println("Ma san pham khong ton tai");
        }
    }

    //lay vi tri id
    public static int getIndexByProductId(String productId) {
        for (int i = 0; i < indexProduct; i++) {
            if(arrProducts[i].getProductId().equals(productId)){
                return i;
            }
        }
        return -1;
    }

    //case 5:  Xóa san pham
    public static void deleteProduct(Scanner scanner) {
        System.out.println("Nhap vao san pham can xoa:");
        String productId = scanner.nextLine();
        int indexDelete = getIndexByProductId(productId);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < indexProduct; i++) {
                arrProducts[i] = arrProducts[i +1];
            }
            indexProduct--;
        }
        else {
            System.err.println("Ma san pham khong ton tai");
        }
    }
    //case 6: Tim kiem san pham theo ten san pham
    public static void searchProductByName(Scanner scanner) {
        System.out.println("Nhap vao ten san pham can tim:");
        String productNameSearch = scanner.nextLine();
        int countProduct = 0;
        System.out.println("San pham duoc tim thay:");
        for (int i = 0; i < indexProduct; i++) {
            if(arrProducts[i].getProductName().toLowerCase().contains(productNameSearch.toLowerCase())){
                arrProducts[i].displayData();
                countProduct++;
            }
        }
        System.out.printf("Co %d san pham duoc tim thay\n", countProduct);
    }
    //case 7: Tim kiem san pham trong khoang gia a-b (a, b nhap tu ban phim)
    public static void searchProductByPrice(Scanner scanner) {
        System.out.println("Nhap khoang giá can tim kiem:");
        System.out.println("Gia bat dau = ");
        float fromPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Gia ket thuc = ");
        float toPrice = Float.parseFloat(scanner.nextLine());
        int countProduct = 0;
        System.out.println("Cac san pham trong khoang gia [" + fromPrice + "-" + toPrice + "] la:");
        for (int i = 0; i < indexProduct; i++) {
            if(arrProducts[i].getPrice() >= fromPrice && arrProducts[i].getPrice() <= toPrice){
                arrProducts[i].displayData();
                countProduct++;
            }
        }
        System.out.printf("Co %d san pham duoc tim thay trong khoang gia [" + fromPrice +"-"+ toPrice +"]\n", countProduct);

    }
}
