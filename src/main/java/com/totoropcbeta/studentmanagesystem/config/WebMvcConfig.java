package com.totoropcbeta.studentmanagesystem.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.TimeZone;

/**
 * @author yuanhang08
 * @date 2022年11月23日
 */
@Configuration
@EnableWebMvc
/**
 * Spring 5.0后, WebMvcConfigurerAdapter被废弃,取代的方法有两种:
 * ①implements WebMvcConfigurer(官方推荐)
 * ②extends WebMvcConfigurationSupport
 * @link https://blog.csdn.net/sdname/article/details/109718768
 */
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 统一输出风格
     * See {@link PropertyNamingStrategy.SnakeCaseStrategy} for details.
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (int i = 0; i < converters.size(); i++) {
            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                ObjectMapper objectMapper = new ObjectMapper();
                // 统一返回数据的输出风格
                objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategy.SnakeCaseStrategy());
                objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS); // 默认全部字段参与序列化 NON-NULL null字段不参与序列化
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8")); // 统一时间字段返回格式
                MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
                converter.setObjectMapper(objectMapper);
                converters.set(i, converter);
                break;
            }
        }
    }
}
