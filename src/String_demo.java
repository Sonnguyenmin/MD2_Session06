public class String_demo {
    public static void main(String[] args) {
        //1Khoi tao chuoi bang string literal (primitive - immutable)
        String str = "Hello World3";
        String str2 = "Hello World2";
        String str3 = "Hello World3";
        //2. Khoi tao bang chuoi constructor cua lop String( reference)
        String str4 = new String("Hello World3");
//        String str5 = new String("Hello World2");
        String str6 = new String("Hello World1");

        //3. So sanh chuoi voi equals - boolean str1.equals(st2) chir so sanh gia tri
        System.out.println("Ket qua so sanh str1 va str2 voi equals:" + str.equals(str2));
        System.out.println("Ket qua so sanh str1 va str3 voi equals:" + str.equals(str3));
        System.out.println("Ket qua so sanh str1 va str4 voi equals:" + str.equals(str4));
        System.out.println("Ket qua so sanh st4 voi str6 voi equals:" + str4.equals(str6));
        //4. So sanh chuoi voi toan tu == so sanh ca dia chi tham chieu va ca gia tri
        System.out.println("ket qua so sanh str == st3" +(str == str3));
        System.out.println("ket qua so sanh str == st4" +(str == str4));
        //5. int length: do dai chuoi
        System.out.println("Do dai chuoi str1:" + str.length());
        //6. char str.charAt(index) tra ve ki tu tai chi so index
        System.out.println("Ki tu co chi so 1 trong chuoi str2:" + str2.charAt(2));
        //7. String str.concat(str2) Noi chuoi str1 voi st2 va tra ve chuoi moi
        String str7 = "- Hoc vien dao tao CNTT";
        System.out.println("Noi chuoi str1 va str7" + str.contains(str7));
        //8. String str.toUpperCase(): tra ve chuoi viet hoa tat ca cac ki tu
        System.out.println("tra ve chuoi viet hoa tat ca cac ki tu: " + str.toUpperCase());
        //9. String str.toLowerCase(): tra ve chuoi viet thuong tat ca cac ki tu
        System.out.println("tra ve chuoi viet hoa tat ca cac ki tu: " + str.toLowerCase());
        //10. String str.trim(): Tra ve chuoi moi va cat cac khoang trang 2 dau
        String str8 = "                  Hello World          ";
        System.out.println("Tra ve chuoi moi va cat cac khoang trang 2 dau:" + str8.trim());
        //11. boolean Str.equalsIngoreCase(str2) :So sanh khong phan biet hoa thuong
        System.out.println("So sanh khong phan biet hoa thuong: " + str.equalsIgnoreCase(str2));
        //12. int str.compareTo(str2) : Tra lai do chenh lech giua chuoi str1 va str2
        System.out.println("Tra lai do chenh lech giua chuoi str1 va str2: " + str.compareTo(str2));
        //13. boolean str1.contains(st2) : Kiem tra chuoi str2 co trong str1 hay khong
        String str13 = "Rikkei Academy - Học viện CNTT của Rikkei";
        System.out.println("Thay thế chuỗi Rikkei thành chuỗi RK trong str13: "
                + str13.replace("Rikkei", "RK"));
        //14. int str1.indexOf(str2): Trả ra chỉ số của chuỗi str2 trong chuỗi str1
        System.out.println("Chỉ số chuỗi str12 trong str1 là: " + str.indexOf(str8));
        //15. String str.replace("old","new"): Thay thế chuỗi old thành new trong str
        String str12 = "Rikkei Academy - Học viện CNTT của Rikkei";
        System.out.println("Thay thế chuỗi Rikkei thành chuỗi RK trong str13: "
                + str12.replace("Rikkei", "RK"));
        //16. boolean str.startWith("prefix"): Kiểm tra chuỗi str bắt đầu là chuỗi prefix không
        System.out.println("Kiểm tra chuỗi str13 có phải bắt đầu là Rikkei không: "
                + str12.startsWith("Rikkei"));
        //17. boolean str.endWith("suffix"): Kiểm tra chuỗi str kết thúc là chuỗi suffix không
        System.out.println("Kiểm tra chuỗi str13 có phải kết thúc là Rikkei không: "
                + str12.endsWith("Rikkei"));
        //18. String[] split(String delimiter): Cắt chuỗi thành mảng theo chuỗi delimiter
        String str14 = "Rikkei Academy Happy";
        String[] arrString = str14.split(" ");
        for (String a : arrString) {
            System.out.println(a);
        }
    }
}
