package dev.antonyholmes.modern.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.tooltip.ModernToolTipWidget;

// TODO: Auto-generated Javadoc
/**
 * Create a panel with a pill shaped border
 *
 * @author Antony Holmes
 *
 */
public class ModernRoundedBorderPanel extends ModernToolTipWidget {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new modern line border panel.
   */
  public ModernRoundedBorderPanel() {
    init();
  }

  /**
   * Instantiates a new modern line border panel.
   *
   * @param layout the layout
   */
  public ModernRoundedBorderPanel(LayoutManager layout) {
    super(layout);

    init();
  }

  /**
   * Instantiates a new modern line border panel.
   *
   * @param component the component
   */
  public ModernRoundedBorderPanel(Component component) {
    add(component, BorderLayout.CENTER);

    init();
  }

  /**
   * Instantiates a new modern line border panel.
   *
   * @param component the component
   * @param dimension the dimension
   */
  public ModernRoundedBorderPanel(Component component, Dimension dimension) {
    this(component);

    UI.setSize(this, dimension);

    init();
  }

  /**
   * Inits the.
   */
  private void init() {
    setBorder(ModernWidget.TWO_PIXEL_BORDER); // BorderService.getInstance().createBorder(2));

    addStyleClass("content", "content-outline", "rounded-rect");

    getAnimations().add("button-outline");
  }
}
