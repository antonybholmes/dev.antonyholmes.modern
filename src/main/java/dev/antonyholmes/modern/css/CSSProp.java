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

  public CSSColor getColor() {
    return null;
  }

  public abstract CSSPropType getType();

  public CSSUnit getUnit() {
    return CSSUnit.NONE;
  }

  public Font getFont() {
    return null;
  }

  public ColorGradient getGradient() {
    return null;
  }
}
