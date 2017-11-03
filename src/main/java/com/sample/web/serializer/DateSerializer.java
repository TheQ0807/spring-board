package com.sample.web.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date>{

	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		String strDate = formatter.format(value);
		gen.writeString(strDate);
	};
}
