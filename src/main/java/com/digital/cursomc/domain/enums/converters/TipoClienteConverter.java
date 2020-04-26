package com.digital.cursomc.domain.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.digital.cursomc.domain.enums.TipoCliente;

@Converter
public class TipoClienteConverter  implements AttributeConverter<String, Integer>  {

	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		if (attribute == null) {
			return 0;
		}
		return TipoCliente.findById(attribute);

	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		if (dbData == null) {
			return "";
		}
		return TipoCliente.getById(dbData);
	}

}
