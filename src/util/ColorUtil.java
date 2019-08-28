package util;

import java.awt.Color;

public class ColorUtil {
	public static final Color blueColor=Color.decode("#4169E1");
	public static final Color grayColor=Color.decode("#808080");
	public static final Color backgroundColor=Color.decode("#6495ED");
	public static final Color warningColor=Color.decode("#FF0000");
	
	 public static Color getByPercentage(int per) {
	        if (per > 100)
	            per = 100;
	        int r = 51;
	        int g = 255;
	        int b = 51;
	        float rate = per / 100f;
	        r = (int) ((255 - 51) * rate + 51);
	        g = 255 - r + 51;
	        Color color = new Color(r, g, b);
	        return color;
	    }
	
	
}
