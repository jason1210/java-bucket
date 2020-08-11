package com.jason.demo.http.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        //记录请求和响应的标头，正文和元数据
        return Logger.Level.FULL;
    }

    /**
     * 如果远程接口由于各种问题没有在响应中设置content-type，
     * 导致FeignClient接收的时候contentType为null，HttpMessageConverterExtractor将其设置为MediaType.APPLICATION_OCTET_STREAM
     * 此时MessageConverter需要增加MediaType.APPLICATION_OCTET_STREAM支持
     */
    @Bean
    public Decoder feignDecoder() {
        MappingJackson2HttpMessageConverter hmc = new MappingJackson2HttpMessageConverter(customObjectMapper());
        List<MediaType> unModifiedMediaTypeList = hmc.getSupportedMediaTypes();
        List<MediaType> mediaTypeList = new ArrayList<>(unModifiedMediaTypeList.size() + 1);
        mediaTypeList.addAll(unModifiedMediaTypeList);
        mediaTypeList.add(MediaType.APPLICATION_OCTET_STREAM);
        hmc.setSupportedMediaTypes(mediaTypeList);
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(hmc);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    private ObjectMapper customObjectMapper() {
        return new ObjectMapper();
    }
}