package com.itext.Service;

import com.itextpdf.io.IOException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;


public class Itext {
    public static final String DEST = "src/main/resources/hello.pdf";

    public static void main(String[] args) throws IOException, java.io.IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
        Document document = new Document(pdf);
        String line = "Hello! Welcome to iTextPdf";
        Image imageData = new Image(ImageDataFactory.create("src/main/resources/a-guide-to-qr-codes-and-how-to-scan-qr-codes-2.png"));
        Paragraph p = new Paragraph();
        p.add(imageData);
//        document.add(p);
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(font);
// Add ListItem objects
        list.add(new ListItem("Never gonna give you up"))
                .add(new ListItem("Never gonna let you down"))
                .add(new ListItem("Never gonna run around and desert you"))
                .add(new ListItem("Never gonna make you cry"))
                .add(new ListItem("Never gonna say goodbye"))
                .add(new ListItem("Never gonna tell a lie and hurt you"));
        document.add(new Paragraph(line));
        document.add(list);
        document.close();

        System.out.println("Awesome PDF just got created.");
    }
}
