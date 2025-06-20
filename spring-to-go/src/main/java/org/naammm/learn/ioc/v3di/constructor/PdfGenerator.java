package org.naammm.learn.ioc.v3di.constructor;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {
    public void generatePdf(String content) {
        // Simulate PDF generation
        System.out.println("V3 -> Generating PDF with content: " + content);
    }
}
