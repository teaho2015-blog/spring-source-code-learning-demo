package net.teaho.demo.spring.mvc.insideout.support;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import net.teaho.demo.spring.mvc.insideout.config.BeanConfiguration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class Jackson2BodyHttpMessageConverter extends AbstractHttpMessageConverter<JsonNode> {

    private final BeanConfiguration beanConfiguration;

    public Jackson2BodyHttpMessageConverter(BeanConfiguration beanConfiguration) {
        super(StandardCharsets.UTF_8, MediaType.APPLICATION_FORM_URLENCODED);
        this.beanConfiguration = beanConfiguration;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return JsonNode.class == clazz;
    }

    @Override
    protected JsonNode readInternal(Class<? extends JsonNode> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return MissingNode.getInstance();
    }

    @Override
    protected void writeInternal(JsonNode jsonNode, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //do nothing
    }

}
