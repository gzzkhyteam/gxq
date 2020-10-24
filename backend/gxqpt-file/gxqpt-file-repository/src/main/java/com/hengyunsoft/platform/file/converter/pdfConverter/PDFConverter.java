package com.hengyunsoft.platform.file.converter.pdfConverter;

public interface PDFConverter {
    String PDF_SUFFIX = ".pdf";
    void convert2PDF(String inputFile, String pdfFile);

    void convert2PDF(String inputFile);
}
