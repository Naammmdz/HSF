package org.naammm.learn.noioc;

public class ContractService {

    private PdfGenerator pdfGenerator;

    public ContractService(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    public void processContract() {
        //TODO LOGIC XỬI LÍ HỢP ĐỒNG

        pdfGenerator.generatePdf("Hợp đồng mẫu");
    }
}
