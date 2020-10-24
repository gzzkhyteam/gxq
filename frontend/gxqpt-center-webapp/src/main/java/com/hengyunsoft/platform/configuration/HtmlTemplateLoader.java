package com.hengyunsoft.platform.configuration;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import freemarker.cache.TemplateLoader;
import org.apache.commons.io.IOUtils;

/**
 * This is a Description
 *
 * @author tangyh
 * @date 2019/07/08
 */
public class HtmlTemplateLoader implements TemplateLoader {

    private static final String HTML_ESCAPE_PREFIX = "<#escape x as x?html>";
    private static final String HTML_ESCAPE_SUFFIX = "</#escape>";

    private final TemplateLoader delegate;

    public HtmlTemplateLoader(TemplateLoader delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object findTemplateSource(String name) throws IOException {
        return delegate.findTemplateSource(name);
    }

    @Override
    public long getLastModified(Object templateSource) {
        return delegate.getLastModified(templateSource);
    }

    @Override
    public Reader getReader(Object templateSource, String encoding) throws IOException {
        Reader reader = delegate.getReader(templateSource, encoding);
        String templateText = IOUtils.toString(reader);
        return new StringReader(HTML_ESCAPE_PREFIX + templateText + HTML_ESCAPE_SUFFIX);
    }

    @Override
    public void closeTemplateSource(Object templateSource) throws IOException {
        delegate.closeTemplateSource(templateSource);
    }

}