package dev.antonyholmes.modern.css;

public class CSSUnitProp extends CSSNumProp {

  private CssUnit mUnit = CssUnit.MM;

  public CSSUnitProp(double v, CssUnit unit) {
    super(v);

    mUnit = unit;
  }

  public CssUnit getUnit() {
    return mUnit;
  }

  @Override
  public CSSPropType getType() {
    return CSSPropType.MEASUREMENT;
  }
}
