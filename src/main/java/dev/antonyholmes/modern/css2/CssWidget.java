package dev.antonyholmes.modern.css2;

import java.awt.LayoutManager;

import dev.antonyholmes.modern.tooltip.ModernToolTipWidget;

// TODO: Auto-generated Javadoc
/**
 * Create a panel with a pill shaped border
 *
 * @author Antony Holmes
 *
 */
public abstract class CssWidget extends ModernToolTipWidget {

  private static final long serialVersionUID = 1L;

  public CssWidget() {
    init();
  }

  public CssWidget(LayoutManager layout) {
    super(layout);

    new CssHoverAnimation(this);

    init();
  }

  private void init() {
    new CssHoverAnimation(this);
    // // getAnimations().add("draw-ui");
    // //
    // getDrawStates().add(DrawUIService.getInstance().getRenderer("css-draw"));
    // // addAnimations("css-hover");
  }

  // @Override
  // public void drawAnimatedBackground(Graphics2D g2) {
  // // Run animation updates
  // super.drawAnimatedBackground(g2);
  //
  // if (mCSSMode) {
  // //CSS_DRAW.draw(this, g2);
  // }
  //
  // // Run any drawing components that may have changed from animations
  // for (DrawUI d : getDrawStates()) {
  // d.draw(this, g2);
  // }
  // }

}
