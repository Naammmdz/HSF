package org.naammm.learn.ioc.v4di.setter;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerate {

    public void generatePdf(String content) {
        // Simulate PDF generation
        System.out.println("V2 -> Generating PDF with content: " + content);
    }
}
