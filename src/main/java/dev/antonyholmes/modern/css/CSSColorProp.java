package dev.antonyholmes.modern.css;

public class CSSColorProp extends CSSProp {

  protected final CssColor mV;

  public CSSColorProp(CssColor v) {
    mV = v;
  }

  @Override
  public CssColor getColor() {
    return mV;
  }

  @Override
  public CSSPropType getType() {
    return CSSPropType.COLOR;
  }

}
