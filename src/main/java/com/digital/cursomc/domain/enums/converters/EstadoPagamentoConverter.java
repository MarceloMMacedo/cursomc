package com.digital.cursomc.domain.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.digital.cursomc.domain.enums.EstadoPagamento;

@Converter
public class EstadoPagamentoConverter  implements AttributeConverter<String, Integer>  {

	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		if (attribute == null) {
			return 0;
		}
		return EstadoPagamento.findById(attribute);

	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		if (dbData == null) {
			return "";
		}
		return EstadoPagamento.getById(dbData);
	}

}
