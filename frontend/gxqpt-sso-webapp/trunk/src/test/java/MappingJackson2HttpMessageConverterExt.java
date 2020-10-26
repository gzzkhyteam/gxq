

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;

public class MappingJackson2HttpMessageConverterExt extends
		MappingJackson2HttpMessageConverter {
	
	@Override
	protected void writeInternal(Object object, Type type,
			HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {
		JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
		JsonGenerator generator = this.objectMapper.getFactory().createGenerator(outputMessage.getBody(), encoding);
		try {
			writePrefix(generator, object);
			Class<?> serializationView = null;
			Object value = object;
			if (value instanceof MappingJacksonValue) {
				MappingJacksonValue container = (MappingJacksonValue) object;
				value = container.getValue();
				serializationView = container.getSerializationView();
			}
			if (serializationView != null) {
				this.objectMapper.writerWithView(serializationView).writeValue(generator, value);
			}
			else {
				this.objectMapper.writeValue(generator, value);
			}
			writeSuffix(generator, object);
			generator.flush();

		}
		catch (JsonProcessingException ex) {
			throw new HttpMessageNotWritableException("Could not write content: " + ex.getMessage(), ex);
		}
	}
}
