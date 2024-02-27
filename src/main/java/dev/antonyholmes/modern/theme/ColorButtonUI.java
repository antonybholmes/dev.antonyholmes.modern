package dev.antonyholmes.modern.theme;

import java.awt.Color;

import dev.antonyholmes.modern.theme.DrawUI;
import dev.antonyholmes.modern.theme.ThemeService;

public abstract class ColorButtonUI extends DrawUI {
  public static final Color HIGHLIGHTED_FILL_COLOR = ThemeService.getInstance().getColors().getTheme32(6);

  public static final Color SELECTED_FILL_COLOR = ThemeService.getInstance().getColors().getTheme32(8);
}
