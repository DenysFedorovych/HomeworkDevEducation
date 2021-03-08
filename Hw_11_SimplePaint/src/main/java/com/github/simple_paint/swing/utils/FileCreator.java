package com.github.simple_paint.swing.utils;

import com.github.simple_paint.swing.formats.*;
import com.github.simple_paint.swing.models.Line;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileCreator {

    public FileCreator(Extension extension, String fileName, List<Line> lines) throws IOException {

        String resultFileName = "/Users/denisfedorovich/IdeaProjects/home-works-dev-education/Hw_11_SimplePaint/src/main/java/com/github/simple_paint/swing/storage/" + fileName + extension.getValue();
        File file = new File(resultFileName);
        FileWriter fileWriter = new FileWriter(file);
        String inputString = "";
        switch (extension) {
            case JSON: {
                JsonFormat jsonFormat = new JsonFormat();
                inputString = jsonFormat.toFormat(lines);
            }
            break;
            case YML: {
                YmlFormat ymlFormat = new YmlFormat();
                inputString = ymlFormat.toFormat(lines);
            }
            break;
            case BIN: {
                BinFormat binFormat = new BinFormat();
                inputString = binFormat.toFormat(lines);
            }
            break;
            case XML: {
                XmlFormat xmlFormat = new XmlFormat();
                inputString = xmlFormat.toFormat(lines);
            }
            break;
            case CSV: {
                CsvFormat csvFormat = new CsvFormat();
                inputString = csvFormat.toFormat(lines);
            }
            break;
        }
        fileWriter.write(inputString);
        fileWriter.close();
    }

}
