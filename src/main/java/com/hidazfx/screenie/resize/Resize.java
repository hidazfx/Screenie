package com.hidazfx.screenie.resize;

import javax.imageio.ImageIO;

import com.hidazfx.screenie.Screenie.Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Resize {

    public static void resize() throws IOException {

        File input = new File("screenie." + Main.fileformat);
        BufferedImage image = ImageIO.read(input);

        BufferedImage resized = resize(image, 180, 516);

        File output = new File("resize_screenie." + Main.fileformat);
        ImageIO.write(resized, Main.fileformat, output);

    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}