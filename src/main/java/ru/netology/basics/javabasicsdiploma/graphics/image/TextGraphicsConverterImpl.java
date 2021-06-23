package ru.netology.basics.javabasicsdiploma.graphics.image;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class TextGraphicsConverterImpl implements TextGraphicsConverter {

    private int maxWidth = -1;
    private int maxHeight = -1;
    private double maxRatio = -1.0;

    private TextColorSchema schema = new TextColorSchemaImpl();

    @Override
    public String convert(String url) throws IOException, BadImageSizeException {
        BufferedImage img = ImageIO.read(new URL(url));

        int imgWidth = img.getWidth();
        int imgHeight = img.getHeight();
        double imgRatio = imgWidth / imgHeight;

        if (maxRatio > 0 && imgRatio != maxRatio) {
            throw new BadImageSizeException(imgRatio, maxRatio);
        }

        boolean isImageLargerMax = (maxWidth > 0 && maxWidth < imgWidth) || (maxHeight > 0 && maxHeight < imgHeight);
        int max = Math.max(imgWidth / maxWidth, imgHeight / maxHeight);

        int newWidth = isImageLargerMax ? (imgWidth / max) : imgWidth;
        int newHeight = isImageLargerMax ? (imgHeight / max) : imgHeight;

        Image scaledImage = img.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);
        BufferedImage bwImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D graphics = bwImg.createGraphics();
        graphics.drawImage(scaledImage, 0, 0, null);
        var bwRaster = bwImg.getRaster();

        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < newHeight; h++) {
            for (int w = 0; w < newWidth; w++) {
                int color = bwRaster.getPixel(w, h, new int[3])[0];
                char c = schema.convert(color);
                sb.append(c).append(c);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public void setMaxWidth(int width) {
        this.maxWidth = width;
    }

    @Override
    public void setMaxHeight(int height) {
        this.maxHeight = height;
    }

    @Override
    public void setMaxRatio(double maxRatio) {
        this.maxRatio = maxRatio;
    }

    @Override
    public void setTextColorSchema(TextColorSchema schema) {
        this.schema = schema;
    }
}