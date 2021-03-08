package com.github.simple_paint.swing.formats;

import com.github.simple_paint.swing.models.Line;

import java.util.List;

public interface IFormat {
    String toFormat(List<Line> lines);
    List<Line> fromFormat(String input);
}
