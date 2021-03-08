package com.github.simple_paint.swing.formats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.simple_paint.swing.models.Line;

import java.util.List;

public class XmlFormat implements IFormat{

    private XmlMapper xmlMapper = new XmlMapper();

    @Override
    public String toFormat(List<Line> lines) {
        try {
            return xmlMapper.writeValueAsString(lines);
        } catch (JsonProcessingException ignore) {}
        return null;
    }

    @Override
    public List<Line> fromFormat(String input) {
        List<Line> list = null;
        try {
            list = xmlMapper.readValue(input, xmlMapper.getTypeFactory().constructCollectionType(List.class, Line.class));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
