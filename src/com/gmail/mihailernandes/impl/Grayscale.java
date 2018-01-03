package com.gmail.mihailernandes.impl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.gmail.mihailernandes.abstr.AbstractFilter;

public class Grayscale extends AbstractFilter {

	public Grayscale(double red, double green, double blue) {
		super(red, green, blue);
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
					int red = (int) (c.getRed() * super.getRed());
					int green = (int) (c.getGreen() * super.getGreen());
					int blue = (int) (c.getBlue() * super.getBlue());
					Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);

					image.setRGB(j, i, newColor.getRGB());
				}
			}
			
			String name = path.substring(0, path.length() - 4);
			name += "_grayscale.jpg";
			File output = new File(name);
			ImageIO.write(image, "jpg", output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
