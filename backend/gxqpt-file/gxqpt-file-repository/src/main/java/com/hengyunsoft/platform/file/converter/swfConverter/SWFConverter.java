package com.hengyunsoft.platform.file.converter.swfConverter;

public interface SWFConverter {
    String SWF_SUFFIX = ".swf";

    String convert2SWF(String inputFile, String swfFile);

    String convert2SWF(String inputFile);
}
