package com.javarush.task.task16.task1631;


import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){
        ImageReader Ir;
        if (type == ImageTypes.BMP) {
            Ir= new BmpReader();
        }else if (type == ImageTypes.JPG) {
            Ir=new JpgReader();
        }else if (type == ImageTypes.PNG) {
            Ir=new PngReader();
        }else {
            throw new IllegalArgumentException();
        }
        return Ir;

    }
}
