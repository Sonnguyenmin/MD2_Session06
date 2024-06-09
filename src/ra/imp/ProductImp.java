package ra.imp;

import ra.entity.Products;

import java.util.Scanner;

public class ProductImp {
    public static Products[] arrProduct = new Products[100];
    public static int indexProducts = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**************************QUAN LY SAN PHAM********************************");
            System.out.println("*           1. Nhập thông tin n san pham (n nhập từ bàn phím)            *");
            System.out.println("*           2. Tính lợi nhuận các san pham                               *");
            System.out.println("*           3. Hiển thị thông tin san pham                               *");
            System.out.println("*           4. Sắp xếp san pham theo lợi nhuận giảm dần                  *");
            System.out.println("*           5. Tìm sách theo tên san pham (tên san pham nhập từ bàn phím)*");
            System.out.println("*           6. Thống kê cac san pham theo gia                            *");
            System.out.println("*           7. Nhap san pham                                             *");
            System.out.println("*           8. Ban san pham                                              *");
            System.out.println("*           9. Cập nhật trạng thái sản phẩm                              *");
            System.out.println("*           10: Thoát                                                     *");
            System.out.println("**************************************************************************");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputListStudent(scanner);
                    break;
                case 2:
                    calculateProfit();
                    break;
                case 3:
                    displayListProducts();
                    break;
                case 4:
                    sortDescendingProfit();
                    break;
                case 5:
                    searchProductByName(scanner);
                    break;
                case 6:
                    statiticPrice(scanner);
                    break;
                case 7:
                    inputProduct(scanner);
                    break;
                case 8:
                    sellProduct(scanner);
                    break;
                case 9:
                    inputUpdateStatus(scanner);
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.err.println("Vui long chon 1 - 9");
            }
        }while (true) ;
    }

    //Case 1:
    public static void inputListStudent(Scanner scanner) {
        System.out.println("Nhap so san pham can nhap thong tin:");
        int countProduct = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countProduct; i++) {
            //Nhap thong tin cho san pham co chi so indexProduct trong mang
            arrProduct[indexProducts] = new Products();
            arrProduct[indexProducts].inputData(scanner);
            indexProducts++;
        }
    }
    //Case 2:
    public static void calculateProfit() {
        for (int i = 0; i < indexProducts; i++) {
            arrProduct[i].inputProfit();
        }
        System.out.println("Da tinh loi nhuan cho tat cac cac san pham");
    }
    //Case 3:
    public static void displayListProducts() {
        for (int i = 0; i < indexProducts; i++) {
            arrProduct[i].displayData();
        }
    }
    //Case 4: Sắp xếp san pham theo lợi nhuận giảm dần
    public static void sortDescendingProfit() {
        for (int i = 0; i < indexProducts - 1; i++) {
            for (int j = i + 1; j < indexProducts; j++) {
                if (arrProduct[i].getProfit() < arrProduct[j].getProfit()) {
                    Products temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep xong sach theo loi nhuan giam dan");
    }
    //Case 5:
    public static void searchProductByName(Scanner scanner) {
        System.out.println("Nhap ten san pham muon tim kiem:");
        String productNameSearch = scanner.nextLine();
        int countPro = 0;
        System.out.println(" Tat ca san pham duoc tim thay: ");
        for (int i = 0; i < indexProducts; i++) {
            if(arrProduct[i].getProductName().toLowerCase().contains(productNameSearch.toLowerCase())) {
                arrProduct[i].displayData();
                countPro++;
            }
        }
        System.out.printf("Cos %d san pham duoc tim thay \n", countPro);
    }
    //Case 6: Thống kê cac san pham theo gia
    public static void statiticPrice(Scanner scanner) {
        System.out.println("Nhap vao gia san pham bat dau:");
        int fromPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap vao gia san pham ket thuc:");
        int toPrice = Integer.parseInt(scanner.nextLine());
        int countProduct = 0;
        for (int i = 0; i < indexProducts; i++) {
            if(arrProduct[i].getImportPrice() >= fromPrice && arrProduct[i].getImportPrice() <= toPrice) {
                countProduct++;
            }
        }
        System.out.printf("Co %d san pham cos gia tu %d den %d \n", countProduct, fromPrice, toPrice);
    }
    //Case  7: Nhap san pham
    public static void inputProduct(Scanner scanner) {
        arrProduct[indexProducts] = new Products();
        arrProduct[indexProducts].inputData(scanner);
        indexProducts++;
        System.out.println("Da them san pham moi thanh cong!");
    }
    //Case 8: Bán sản phẩm
    //
    //Cho phép người dùng nhập vào tên sản phẩm và số lượng sản phẩm cần bán
    //Tiến hành trừ số lượng vừa bán từ quantity của sản phẩm có tên sản phẩm cần bán

    public static void sellProduct(Scanner scanner) {
        System.out.println("Nhap vao ma san pham can ban: ");
        String productId = scanner.nextLine();
        int indexProduct = getIndexByProductId(productId);

        if(indexProduct >= 0) {
            System.out.println("Nhap vao san pham can ban:");
            int quantityToSell = Integer.parseInt(scanner.nextLine());
            if(arrProduct[indexProduct].getQuantity() >= quantityToSell){
                arrProduct[indexProduct].setQuantity(arrProduct[indexProduct].getQuantity() - quantityToSell);
                System.out.println("Sản phẩm đã được bán thành công. Số lượng cập nhật: " + arrProduct[indexProduct].getQuantity());
            }
            else {
                System.err.println("Số lượng tồn kho không đủ.");
            }
        }
        else {
            System.err.println("Ma san pham khong ton tai");
        }
    }

    //lay vi tri id
    public static int getIndexByProductId(String productId) {
        for (int i = 0; i < indexProducts; i++) {
            if(arrProduct[i].getProductId().equals(productId)){
                return i;
            }
        }
        return -1;
    }

    //Case 9: Thay doi trang thai
    public static void inputUpdateStatus(Scanner scanner) {
        System.out.println("Nhap vao danh muc can thay doi trang thai:");
        String productId = scanner.nextLine();
        int indexUpdate = getIndexByProductId(productId);
        if (indexUpdate >= 0) {
            System.out.println("Nhap vao trang thai moi (true | false)");
            boolean newStatus = Boolean.parseBoolean(scanner.nextLine());
            arrProduct[indexUpdate].setStatus(newStatus);
            System.out.println("Trang thai san pham da cap nhat thanh cong");
        }
        else {
            System.err.println("Ma san pham khong ton tai");
        }
    }
}
