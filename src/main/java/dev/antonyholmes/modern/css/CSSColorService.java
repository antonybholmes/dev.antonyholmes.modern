package dev.antonyholmes.modern.css;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.jebtk.core.ColorUtils;

import dev.antonyholmes.modern.animation.AnimationTimer;
import dev.antonyholmes.modern.animation.EasingAnimation;

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

  private Map<String, CssColor[]> mColorMap = new HashMap<String, CssColor[]>();

  private CSSColorService() {
    // Do nothing
  }

  /**
   * Returned a named creator for generating animations from classes.
   * 
   * @param name
   * @return
   */
  public CssColor[] get(String color) {
    if (!mColorMap.containsKey(color)) {
      mColorMap.put(color, new CssColor[] {CssColor.from(ColorUtils.decodeHtmlColor(color))});
    }
    
    return mColorMap.get(color);
  }

  public CssColor[] get(String color1, String color2) {
    String key = color1 + color2;
    
    if (!mColorMap.containsKey(key)) {
      mColorMap.put(key, 
          createTwoColorMap(ColorUtils.decodeHtmlColor(color1), ColorUtils.decodeHtmlColor(color2)));
    }
    
    return mColorMap.get(key);
  }
  
  
  public static CssColor[] createTwoColorMap(Color color1, Color color2) {
    CssColor[] ret = new CssColor[AnimationTimer.STEPS];
    ret[0] = new CssColor(color1);
    ret[ret.length - 1] = new CssColor(color2);
    
    double f;
    
    int R = color1.getRed();
    int G = color1.getGreen();
    int B = color1.getBlue();
    int A = color1.getAlpha();
    
    int diffR = color2.getRed() - R;
    int diffG = color2.getGreen() - G;
    int diffB = color2.getBlue() - B;
    int diffA = color2.getAlpha() - A;
    
    CssColor c;
    
    for (int i = 1; i < AnimationTimer.STEPS; ++i) {
      f = EasingAnimation.BEZ_T[i];
      
      c = new CssColor(R + (int)(diffR * f), 
          G + (int)(diffG * f), 
          B + (int)(diffB * f), 
          A + (int)(diffA * f));
      
      ret[i] = c;
    }
    
    return ret;
  }
}
