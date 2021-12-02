package com.mycompany;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;


public class ImageMetaInfo {

    public static void main(String[] args) throws IOException {
        
        System.out.println("JDK/JRE vendor: " + System.getProperty("java.vendor"));
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Java runtime version: " + System.getProperty("java.runtime.version"));
        System.out.println("JVM implementation: " + System.getProperty("java.vm.name"));
        System.out.println("JVM implementation vendor: " + System.getProperty("java.vm.vendor"));
        
        
        FileImageInputStream imgStream = new FileImageInputStream(new File(args[0]));
        
        Iterator iter = ImageIO.getImageReaders(imgStream);
        while (iter.hasNext()) {
            ImageReader reader = (ImageReader) iter.next();
            System.out.println(reader.getClass().getName());
            reader.setInput(imgStream, false, false);
            BufferedImage image = reader.read(0, reader.getDefaultReadParam());
            System.out.println(reader);
        }

    }
}
