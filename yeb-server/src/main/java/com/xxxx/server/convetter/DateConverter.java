package com.xxxx.server.convetter;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * 日期转换
 */
@Component
public class DateConverter implements Converter<String, LocalDate> {


    @Override
    public LocalDate convert(String source) {

        try {
            return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

//Resolved [org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'java.time.LocalDate[]'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type [java.lang.String] to type [java.time.LocalDate] for value '2015-05-05'; nested exception is java.lang.IllegalArgumentException: Parse attempt failed for value [2015-05-05]]
//字符串无法转为Date类型
//引起原因是大部分人使用Date格式作为controller接口的参数，导致springmvc无法将String转为Date，已知springmvc内置了一系列的转换，不过都是基本类型到包装类以及String到包装类，和List、Set、Map等。但是对类似String转Date还是无能为力的。
//解决办法：
//1. 参数改为String类型，在后端处理String到Date的转换，而不是交给SpringMVC来处理。
//2 写转换类实现org.springframework.core.convert.converter.Converter，并在SpringMVC中注册。