package org.naammm.learn.noioc;

public class MainNoIoC {

    //nơi tạo ra object, tạo ra dependency, tiêm chích vào object cần sử dụng
    //IoC container - Inversion of Control container
    //kiểm soát những đứa phụ thuộc, tiêm chích chúng vào
    //IOC HANDMADE, CHƯA PHỈA HANG XỊN ĐẾN TỪ SPRING
    public static void main(String[] args) {
        // Tạo đối tượng PdfGenerator
        PdfGenerator pdfGenerator = new PdfGenerator();

        // Tạo đối tượng ContractService và tiêm PdfGenerator vào nó
        ContractService contractService = new ContractService(pdfGenerator);

        // Xử lý hợp đồng
        contractService.processContract();

    }
}
