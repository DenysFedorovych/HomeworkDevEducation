package com.github.simple_paint.swing.formats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.simple_paint.swing.models.Line;

import java.util.List;

public class CsvFormat implements IFormat{

    private ObjectMapper csvMapper = new ObjectMapper();

    @Override
    public String toFormat(List<Line> lines) {
        try {
            return csvMapper.writeValueAsString(lines);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Line> fromFormat(String input) {
        List<Line> list = null;
        try {
            list = csvMapper.readValue(input, csvMapper.getTypeFactory().constructCollectionType(List.class, Line.class));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
