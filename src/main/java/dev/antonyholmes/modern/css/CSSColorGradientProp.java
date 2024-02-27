package dev.antonyholmes.modern.css;

import dev.antonyholmes.modern.theme.ColorGradient;

public class CSSColorGradientProp extends CSSProp {

  protected final ColorGradient mV;

  public CSSColorGradientProp(ColorGradient v) {
    mV = v;
  }

  @Override
  public ColorGradient getGradient() {
    return mV;
  }

  @Override
  public CSSPropType getType() {
    return CSSPropType.COLOR_GRADIENT;
  }

}
