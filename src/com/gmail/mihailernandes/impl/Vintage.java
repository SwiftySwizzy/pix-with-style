package com.gmail.mihailernandes.impl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.gmail.mihailernandes.abstr.AbstractFilter;

public class Vintage extends AbstractFilter {

	public Vintage() {}

	@Override
	public void filter(String path) {

		try {
			File input = new File(path);
			BufferedImage image = ImageIO.read(input);
			int width = image.getWidth();
			int height = image.getHeight();

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {

					Color c = new Color(image.getRGB(j, i));
					int red = (int) (c.getRed());
					int green = (int) (c.getGreen());
					int blue = (int) (c.getBlue());
					red = (int) ((red * 0.393) + (green * 0.769) + (blue * 0.189));
					green = (int) ((red * 0.349) + (green * 0.686) + (blue * 0.168));
					blue = (int) ((red * 0.272) + (green * 0.534) + (blue * 0.131));
					if (red > 255) {
						red = 255;
					}
					if (green > 255) {
						green = 255;
					}
					if (blue > 255) {
						blue = 255;
					}
					Color newColor = new Color(red, green, blue);
					image.setRGB(j, i, newColor.getRGB());
				}
			}

			String name = path.substring(0, path.length() - 4);
			name += "_vintage.jpg";
			File output = new File(name);
			ImageIO.write(image, "jpg", output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
