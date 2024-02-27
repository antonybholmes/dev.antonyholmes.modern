package dev.antonyholmes.modern.theme;

import java.awt.Color;

import dev.antonyholmes.modern.theme.DrawUI;
import dev.antonyholmes.modern.theme.MaterialService;

public abstract class ButtonUI extends DrawUI {
  public static final Color HIGHLIGHTED_FILL_COLOR = MaterialService.instance().getColor("gray-highlight");

  public static final Color SELECTED_FILL_COLOR = MaterialService.instance().getColor("gray-selected");
}
