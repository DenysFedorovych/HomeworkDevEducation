package com.github.simple_paint.swing.formats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.simple_paint.swing.models.Line;

import java.util.List;

public class JsonFormat implements IFormat{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String toFormat(List<Line> lines){
        try {
            return mapper.writeValueAsString(lines);
        } catch (JsonProcessingException ignore) {}
        return null;
    }

    @Override
    public List<Line> fromFormat(String input) {
        List<Line> list = null;
        try {
            list = mapper.readValue(input, mapper.getTypeFactory().constructCollectionType(List.class, Line.class));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
