package Baitap_16_5_26;

import java.util.ArrayList;
import java.util.Scanner;

public class Invoicetest {
    static ArrayList<Invoice> listInvoice = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========= MENU QUẢN LÝ INVOICE =========");
            System.out.println("1. Tạo dữ liệu giả (Mock data - ít nhất 10 Invoice)");
            System.out.println("2. Xuất thông tin danh sách Invoice");
            System.out.println("3. Sắp xếp danh sách (Tăng dần theo Mã MH -> Số lượng)");
            System.out.println("4. Tìm kiếm Invoice theo Mã mặt hàng");
            System.out.println("5. Xóa một Invoice theo Mã mặt hàng");
            System.out.println("0. Thoát chương trình");
            System.out.print("=> Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    createMockData();
                    break;
                case 2:
                    displayInvoices();
                    break;
                case 3:
                    sortInvoicesBubbleSort();
                    break;
                case 4:
                    searchInvoice();
                    break;
                case 5:
                    deleteInvoice();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    // 1. Nhập danh sách Mock Data (ít nhất 10 Invoices phần cứng, không trùng mã)
    public static void createMockData() {
        listInvoice.clear();
        addInvoice(new Invoice("PC01", "CPU Intel Core i5", 10, 4500000));
        addInvoice(new Invoice("PC02", "Mainboard ASUS B560", 5, 2500000));
        addInvoice(new Invoice("PC03", "RAM 8GB DDR4 Kingston", 20, 700000));
        addInvoice(new Invoice("PC04", "RAM 16GB DDR4 Corsair", 15, 1500000));
        addInvoice(new Invoice("PC05", "SSD 512GB Samsung", 12, 1200000));
        addInvoice(new Invoice("PC06", "HDD 1TB WD Blue", 8, 900000));
        addInvoice(new Invoice("PC07", "VGA RTX 3060", 3, 8500000));
        addInvoice(new Invoice("PC08", "Nguồn (PSU) 650W", 7, 1100000));
        addInvoice(new Invoice("PC09", "Vỏ Case Xigmatek", 10, 650000));
        addInvoice(new Invoice("PC10", "Tản nhiệt nước AIO", 4, 1800000));
        addInvoice(new Invoice("PC10", "Test trùng mã", 1, 50000)); // Dữ liệu này sẽ bị chặn vì trùng mã
        addInvoice(new Invoice("PC11", "Chuột Logitech G102", -5, -200000)); // Test số âm -> SL và giá sẽ về 0
        
        System.out.println("=> Đã tạo Mock Data thành công!");
    }

    // Hàm phụ trợ thêm Invoice có kiểm tra trùng mã
    private static void addInvoice(Invoice newInv) {
        for (Invoice inv : listInvoice) {
            if (inv.getPartNumber().equalsIgnoreCase(newInv.getPartNumber())) {
                System.out.println("Lỗi: Mã mặt hàng " + newInv.getPartNumber() + " bị trùng. Không thêm vào danh sách!");
                return;
            }
        }
        listInvoice.add(newInv);
    }

    // 2. Xuất thông tin danh sách
    public static void displayInvoices() {
        if (listInvoice.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("\n--- DANH SÁCH INVOICE ---");
        for (Invoice inv : listInvoice) {
            System.out.println(inv.toString());
        }
    }

    // 3. Vận dụng thuật toán Bubble Sort (Sắp xếp nổi bọt)
    public static void sortInvoicesBubbleSort() {
        if (listInvoice.isEmpty()) {
            System.out.println("Danh sách trống, không thể sắp xếp!");
            return;
        }
        int n = listInvoice.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Invoice inv1 = listInvoice.get(j);
                Invoice inv2 = listInvoice.get(j + 1);

                // So sánh Mã mặt hàng (Tăng dần)
                int compareCode = inv1.getPartNumber().compareToIgnoreCase(inv2.getPartNumber());
                
                // Nếu mã MH đứng trước > mã MH đứng sau HOẶC (trùng mã và SL đứng trước > SL đứng sau)
                if (compareCode > 0 || (compareCode == 0 && inv1.getQuantity() > inv2.getQuantity())) {
                    // Đổi chỗ
                    listInvoice.set(j, inv2);
                    listInvoice.set(j + 1, inv1);
                }
            }
        }
        System.out.println("=> Đã sắp xếp danh sách (Dùng Bubble Sort). Vui lòng chọn 2 để xem lại!");
    }

    // 4. Tìm kiếm tuyến tính theo Mã mặt hàng
    public static void searchInvoice() {
        System.out.print("Nhập Mã mặt hàng cần tìm: ");
        String code = sc.nextLine();
        boolean isFound = false;

        for (Invoice inv : listInvoice) {
            if (inv.getPartNumber().equalsIgnoreCase(code)) {
                System.out.println("=> Đã tìm thấy:");
                System.out.println(inv.toString());
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Không tìm thấy Invoice có mã: " + code);
        }
    }

    // 5. Xoá Invoice theo Mã mặt hàng
    public static void deleteInvoice() {
        System.out.print("Nhập Mã mặt hàng cần xóa: ");
        String code = sc.nextLine();
        
        for (int i = 0; i < listInvoice.size(); i++) {
            if (listInvoice.get(i).getPartNumber().equalsIgnoreCase(code)) {
                listInvoice.remove(i);
                System.out.println("=> Đã xóa thành công Invoice mã: " + code);
                return;
            }
        }
        System.out.println("Không tìm thấy mã mặt hàng để xóa!");
    }
}
