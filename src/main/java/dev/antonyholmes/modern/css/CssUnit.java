package dev.antonyholmes.modern.css;

public enum CssUnit {
  NONE, CM, MM, IN, PX, EM, REM, PC, PERCENT;

  public static CssUnit parse(String unit) {
    switch (unit.toLowerCase()) {
    case "cm":
      return CM;
    case "in":
      return IN;
    case "mm":
      return MM;
    case "px":
      return PX;
    case "pc":
      return PC;
    case "percent":
    case "%":
      return PERCENT;
    default:
      return NONE;
    }
  }
}
