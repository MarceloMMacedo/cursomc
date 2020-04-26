package com.digital.cursomc.domain.enums.converters;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;
 
@Component
public class DateConverter implements ConverterFactory<String,Date> {

	@Override
	public <T extends Date> Converter<String, T> getConverter(Class<T> targetType) {
		// TODO Auto-generated method stub
		return null;
	}

	 

	 

}
