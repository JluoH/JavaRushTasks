package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.awt.*;
import java.io.Reader;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes ir) {
        try {
            if (ir.equals(ImageTypes.BMP)) return new BmpReader();
            else if (ir.equals(ImageTypes.JPG)) return new JpgReader();
            else if (ir.equals(ImageTypes.PNG)) return new PngReader();
            else return null;
        } catch (Exception e) {
            throw (new IllegalArgumentException("Неизвестный тип картинки"));
        }
    }
}
