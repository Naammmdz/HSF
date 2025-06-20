package org.naammm.learn.ioc.v2bean;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {
    public void generatePdf(String content) {
        // Simulate PDF generation
        System.out.println("V2 -> Generating PDF with content: " + content);
    }
}
