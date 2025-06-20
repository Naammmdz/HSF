package org.naammm.learn.ioc.v1scan;

import org.springframework.stereotype.Component;

@Component //nghĩa là : đây là 1 object, 1 bean, sẽ được tu dong new boi thu vien Spring, Spring Context
public class PdfGenerator {
    public void generatePdf(String content) {
        // Simulate PDF generation
        System.out.println("V1 -> Generating PDF with content: " + content);
    }
}
