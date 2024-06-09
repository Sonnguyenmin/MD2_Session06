public class StringBuider {
    public static void main(String[] args) {
        //1. Khởi tạo chuỗi  StringBuilder
        StringBuilder strBuilder = new StringBuilder("Rikkei Academy");
        //2. Nối chuỗi: append
        StringBuilder strAcademy = new StringBuilder("Học viện ");
        System.out.println("Nỗi chuỗi strBuilder với Học viện: " + strAcademy.append(strBuilder));
        //3. insert(int offset, String str): Chèn chuỗi str vào vị trí offset
        System.out.println("Chèn chuỗi soft vào vị trí 6 trong strBuilder: "
                + strBuilder.insert(6, "soft"));
        //4. delete(int beginIndex, int endIndex): xóa từ chỉ số beginIndex đến endIndex-1
        System.out.println("Xóa từ ký tự 6 đến 10 trong strBuilder: " + strBuilder.delete(6, 10));
        //5. reverse(): Đảo ngược chuỗi
        System.out.println("Đảo ngược chuỗi strBuilder: " + strBuilder.reverse());
    }
}
