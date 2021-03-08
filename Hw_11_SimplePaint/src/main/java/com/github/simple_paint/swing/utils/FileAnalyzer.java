package com.github.simple_paint.swing.utils;

import com.github.simple_paint.swing.formats.*;
import com.github.simple_paint.swing.models.Line;

import java.io.*;
import java.util.List;

import static com.github.simple_paint.swing.utils.Extension.*;

public class FileAnalyzer {

    private List<Line> lines = null;

    public FileAnalyzer(File file) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();
        Extension extension = getValue(file.getName().substring(file.getName().lastIndexOf('.')));

        switch (extension) {
            case JSON: {
                JsonFormat jsonFormat = new JsonFormat();
                lines = jsonFormat.fromFormat(currentLine);
            }
            break;
            case YML: {
                YmlFormat ymlFormat = new YmlFormat();
                lines = ymlFormat.fromFormat(currentLine);
            }
            break;
            case BIN: {
                BinFormat binFormat = new BinFormat();
                lines = binFormat.fromFormat(currentLine);
            }
            break;
            case XML: {
                XmlFormat xmlFormat = new XmlFormat();
                lines = xmlFormat.fromFormat(currentLine);
            }
            break;
            case CSV: {
                CsvFormat csvFormat = new CsvFormat();
                lines = csvFormat.fromFormat(currentLine);
            }
            break;
        }

    }

    public List<Line> getLines() {
        return lines;
    }

}
