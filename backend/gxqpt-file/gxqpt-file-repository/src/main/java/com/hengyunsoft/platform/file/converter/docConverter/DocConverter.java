package com.hengyunsoft.platform.file.converter.docConverter;


import com.hengyunsoft.platform.file.converter.pdfConverter.PDFConverter;
import com.hengyunsoft.platform.file.converter.swfConverter.SWFConverter;
import com.hengyunsoft.platform.file.converter.utils.FileUtils;

public class DocConverter {

    private PDFConverter pdfConverter;
    private SWFConverter swfConverter;


    public DocConverter(PDFConverter pdfConverter, SWFConverter swfConverter) {
        super();
        this.pdfConverter = pdfConverter;
        this.swfConverter = swfConverter;
    }


    public void convert(String inputFile, String swfFile) {
        this.pdfConverter.convert2PDF(inputFile);
        String pdfFile = FileUtils.getFilePrefix(inputFile) + PDFConverter.PDF_SUFFIX;
        this.swfConverter.convert2SWF(pdfFile, swfFile);
    }

    public void convert(String inputFile) {
        String pdfFile = inputFile;
        if (!inputFile.toLowerCase().endsWith(PDFConverter.PDF_SUFFIX)) {
            this.pdfConverter.convert2PDF(inputFile);
            pdfFile = FileUtils.getFilePrefix(inputFile) + PDFConverter.PDF_SUFFIX;
        }
        this.swfConverter.convert2SWF(pdfFile);
    }

}
