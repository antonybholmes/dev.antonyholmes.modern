package dev.antonyholmes.modern.css;

import java.awt.Font;

import dev.antonyholmes.modern.theme.ColorGradient;

public abstract class CSSProp {
  public int getInt() {
    return Integer.MIN_VALUE;
  }

  public double getFloat() {
    return Double.MIN_VALUE;
  }

  public CssColor getColor() {
    return null;
  }

  public abstract CSSPropType getType();

  public CssUnit getUnit() {
    return CssUnit.NONE;
  }

  public Font getFont() {
    return null;
  }

  public ColorGradient getGradient() {
    return null;
  }
}
