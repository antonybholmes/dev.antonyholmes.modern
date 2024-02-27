package org.jebtk.modern.animation;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.jebtk.core.ColorUtils;
import org.jebtk.modern.css.CSSColor;

public class CSSColorService {

  /**
   * The Class UIServiceLoader.
   */
  private static class CSSColorServiceLoader {

    /** The Constant INSTANCE. */
    private static final CSSColorService INSTANCE = new CSSColorService();
  }

  /**
   * Gets the single instance of SettingsService.
   *
   * @return single instance of SettingsService
   */
  public static CSSColorService getInstance() {
    return CSSColorServiceLoader.INSTANCE;
  }

  private Map<String, CSSColor[]> mColorMap = new HashMap<String, CSSColor[]>();

  private CSSColorService() {
    // Do nothing
  }

  /**
   * Returned a named creator for generating animations from classes.
   * 
   * @param name
   * @return
   */
  public CSSColor[] get(String color) {
    if (!mColorMap.containsKey(color)) {
      mColorMap.put(color, new CSSColor[] {CSSColor.create(ColorUtils.decodeHtmlColor(color))});
    }
    
    return mColorMap.get(color);
  }

  public CSSColor[] get(String color1, String color2) {
    String key = color1 + color2;
    
    if (!mColorMap.containsKey(key)) {
      mColorMap.put(key, 
          createTwoColorMap(ColorUtils.decodeHtmlColor(color1), ColorUtils.decodeHtmlColor(color2)));
    }
    
    return mColorMap.get(key);
  }
  
  
  public static CSSColor[] createTwoColorMap(Color color1, Color color2) {
    CSSColor[] ret = new CSSColor[AnimationTimer.STEPS];
    ret[0] = new CSSColor(color1);
    ret[ret.length - 1] = new CSSColor(color2);
    
    double f;
    
    int R = color1.getRed();
    int G = color1.getGreen();
    int B = color1.getBlue();
    int A = color1.getAlpha();
    
    int diffR = color2.getRed() - R;
    int diffG = color2.getGreen() - G;
    int diffB = color2.getBlue() - B;
    int diffA = color2.getAlpha() - A;
    
    CSSColor c;
    
    for (int i = 1; i < AnimationTimer.STEPS; ++i) {
      f = EasingAnimation.BEZ_T[i];
      
      c = new CSSColor(R + (int)(diffR * f), 
          G + (int)(diffG * f), 
          B + (int)(diffB * f), 
          A + (int)(diffA * f));
      
      ret[i] = c;
    }
    
    return ret;
  }
}
