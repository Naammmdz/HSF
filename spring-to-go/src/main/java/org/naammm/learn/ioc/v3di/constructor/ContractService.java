package org.naammm.learn.ioc.v3di.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    private PdfGenerator pdfGenerator;

//    @Autowired
    public ContractService(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    public void processContract() {
        pdfGenerator.generatePdf("Contract details here");
    }
}
