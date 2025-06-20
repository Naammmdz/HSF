package org.naammm.learn.ioc.v4di.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    private PdfGenerate pdfGenerator;

    // Setter injection
    @Autowired
    public void setPdfGenerator(PdfGenerate pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    public void processContract() {
        if (pdfGenerator != null) {
            pdfGenerator.generatePdf("Contract details here");
        } else {
            System.out.println("PdfGenerator is not set!");
        }
    }
}
