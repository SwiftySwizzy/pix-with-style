package com.gmail.mihailernandes.impl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.gmail.mihailernandes.abstr.AbstractFilter;

public class Negative extends AbstractFilter {

	public Negative() {
	}

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
					int red = 255 - (int) (c.getRed());
					int green = 255 - (int) (c.getGreen());
					int blue = 255 - (int) (c.getBlue());
					Color newColor = new Color(red, green, blue);
					image.setRGB(j, i, newColor.getRGB());
				}
			}

			String name = path.substring(0, path.length() - 4);
			name += "_negative.jpg";
			File output = new File(name);
			ImageIO.write(image, "jpg", output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
