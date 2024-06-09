package ra.entity;

import ra.imp.ProductImp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Products {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String description;
    private boolean status;

    public Products() {
    }


    public Products(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String description, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        this.productId = inputProductId(scanner);
        this.productName = inputProductName(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.profit = inputProfit();
        this.quantity = inputQuantity(scanner);
        this.description = inputDescription(scanner);
        this.status = inputStatus(scanner);
    }

    public String inputProductId(Scanner scanner) {
        String productIdRegex = "^P\\w{3}$";
        System.out.println("Nhap vao ma san pham: ");
        do {
            String productId = scanner.nextLine();
            if(Pattern.matches(productIdRegex, productId)) {
                boolean isExit = false;
                for (int i = 0; i <ProductImp.indexProducts; i++) {
                    if(ProductImp.arrProduct[i].getProductId().equals(productId)) {
                        isExit = true;
                        break;
                    }
                }
                if(isExit) {
                    System.err.println("Ma san pham da ton tai, vui long nhap lai");
                }
                else {
                    return productId;
                }
            }
            else  {
                System.err.println("Ma san pham gom 4 ky tu bat dau la P, vui long nhap lai");
            }
        } while (true);
    }

    public  String inputProductName(Scanner scanner) {
        System.out.println("Nhap vao ten san pham:");
        do{
            String productName = scanner.nextLine();
            if(productName.length() >= 6 && productName.length() <= 50) {
                boolean isExit = false;
                for (int i = 0; i < ProductImp.indexProducts; i++) {
                    if(ProductImp.arrProduct[i].getProductName().equals(productName)) {
                        isExit = true;
                        break;
                    }
                }
                if(isExit) {
                    System.err.println("Ten san pham da ton tai , vui long nhap lai");
                }
                else {
                    return productName;
                }
            }
            else {
                System.err.println("Ten san pham cos tu 6-50 ky tu, vui long nhap lai");
            }
        }
        while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        System.out.println("Moi ban nhap vao gia nhap: ");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if(importPrice > 0) {
                return importPrice;
            }
            else {
                System.err.println("Gia nhap san pham phai lon hon 0, vui long nhap lai");
            }
        } while (true);
    }

    public float inputExportPrice(Scanner scanner) {
        System.out.println("Moi ban nhap vao gia xuat lon hon 20% gia nhap: ");
        do {
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice > importPrice * 1.2) {
                return exportPrice;
            }
            else {
                System.err.println("Giá xuất có giá trị lơn hơn ít nhất 20% so với giá nhập, vui long nhap lai");
            }
        }while (true);
    }

    public float inputProfit () {
        profit = exportPrice - importPrice;
        return profit;
    }

    public int inputQuantity(Scanner scanner) {
        System.out.println("Moi nhap vao so luong san pham: ");
        do {
             int quantity = Integer.parseInt(scanner.nextLine());
             if(quantity > 0) {
                 return quantity;
             }
             else {
                 System.err.println("Số lượng sản phẩm có giá trị lớn hơn 0, vui long nhap lai");
             }
        } while (true);
    }

    public String inputDescription (Scanner scanner) {
        System.out.println("Moi nhap vao mo ta san pham");
        return scanner.nextLine();
    }

    public boolean inputStatus (Scanner scanner) {
        System.out.println("Moi ban nhap trang thai san pham");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trang thai chi nhan gia tri true | false, vui long nhap lai");
            }
        } while (true);
    }

    public  void displayData() {
        System.out.printf("Ma san pham: %s - Ten san pham: %s - Trang thai: %s\n", this.productId, this.productName, this.status ? "Hoat dong" :"Khong hoat dong");
        System.out.printf("Gia nhap: %f - Gia xuat: %f - Loi nhuan: %f - So luong: %d \n", this.importPrice, this.exportPrice, this.profit, this.quantity);
    }
}
