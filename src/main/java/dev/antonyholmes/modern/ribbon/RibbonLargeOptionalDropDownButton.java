/**
 * Copyright (C) 2016, Antony Holmes
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. Neither the name of copyright holder nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package dev.antonyholmes.modern.ribbon;

import java.awt.Graphics2D;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.button.ModernOptionalDropDownMenuButton;
import dev.antonyholmes.modern.graphics.icons.ModernIcon;
import dev.antonyholmes.modern.graphics.icons.RasterIcon;
import dev.antonyholmes.modern.menu.ModernPopupMenu;

// TODO: Auto-generated Javadoc
/**
 * Drop down button for showing menu items.
 *
 * @author Antony Holmes
 *
 */
public class RibbonLargeOptionalDropDownButton extends ModernOptionalDropDownMenuButton implements RibbonModeProperty {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /** The m compact icon. */
  protected ModernIcon mCompactIcon;

  /** The m mode. */
  private RibbonSize mMode;

  /** The m text 2. */
  private String mText2;

  /** The m text. */
  private String mText;

  /** The m show text. */
  private boolean mShowText = true;

  /**
   * Instantiates a new ribbon large drop down menu button2.
   *
   * @param icon the icon
   * @param menu the menu
   */
  public RibbonLargeOptionalDropDownButton(ModernIcon icon, ModernPopupMenu menu) {
    super(icon, menu);

    setup();
  }

  /**
   * Instantiates a new ribbon large drop down menu button2.
   *
   * @param text1 the text 1
   * @param icon  the icon
   * @param menu  the menu
   */
  public RibbonLargeOptionalDropDownButton(String text1, ModernIcon icon, ModernPopupMenu menu) {
    super(text1, icon, menu);

    mText = text1;

    setup();
  }

  public RibbonLargeOptionalDropDownButton(String text1, ModernPopupMenu menu) {
    super(text1, menu);

    mText = text1;

    setup();
  }

  /**
   * Instantiates a new ribbon large optional drop down button.
   *
   * @param text1 the text 1
   * @param text2 the text 2
   * @param icon  the icon
   * @param menu  the menu
   */
  public RibbonLargeOptionalDropDownButton(String text1, String text2, ModernIcon icon, ModernPopupMenu menu) {
    super(text1, icon, menu);

    mText2 = text2;

    mText = mText1 + " " + mText2;

    setClickMessage(mText);

    setup();
  }

  /**
   * Setup.
   */
  private void setup() {
    if (mIcon != null) {
      mCompactIcon = new RasterIcon(mIcon, Ribbon.COMPACT_ICON_SIZE);
    }

    setSize(RibbonSize.COMPACT);

    addToStyleClass("ribbon-button");

    setAnimations("ribbon-optional-dropdown-button");
  }

  /**
   * Sets the show text.
   *
   * @param show the new show text
   */
  public void setShowText(boolean show) {
    mShowText = show;

    setSize(mMode);
  }

  /**
   * Gets the show text.
   *
   * @return the show text
   */
  public boolean getShowText() {
    return mShowText;
  }

  /**
   * Gets the compact icon.
   *
   * @return the compact icon
   */
  public ModernIcon getCompactIcon() {
    return mCompactIcon;
  }

  /**
   * Gets the disabled mIcon.
   *
   * @return the disabled mIcon
   */
  public ModernIcon getCompactDisabledIcon() {
    return mCompactIcon.getDisabledIcon();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.ribbon.RibbonModeProperty#setSize(org.abh.common.ui.
   * ribbon. RibbonSize)
   */
  @Override
  public void setSize(RibbonSize mode) {
    mMode = mode;

    int w = DOUBLE_PADDING;
    int h;

    if (mMode == RibbonSize.LARGE) {
      if (mText1 != null) {
        if (mText2 == null || mText1.length() > mText2.length()) {
          w += ModernWidget.getStringWidth(mText1);
        } else {
          w += ModernWidget.getStringWidth(mText2);
        }
      }

      w = Math.max(w, Ribbon.MIN_BUTTON_WIDTH);

      h = Ribbon.LARGE_BUTTON_HEIGHT;
    } else {
      if (mCompactIcon != null) {
        w += Ribbon.COMPACT_ICON_SIZE;
      }

      w += TRIANGLE_ICON.getWidth();

      if (mShowText && mText != null) {
        w += ModernWidget.getStringWidth(mText) + PADDING;
      }

      // w = Math.max(w, Ribbon.MIN_COMPACT_BUTTON_WIDTH);

      h = Ribbon.COMPACT_BUTTON_HEIGHT;
    }

    UI.setSize(this, w, h);
  }

  @Override
  public void drawBackgroundAA(Graphics2D g2) {
    super.drawAnimatedBackground(g2);
  }

  /*
   * @Override public void drawBackgroundAA(Graphics2D g2) { IntRect rect = new
   * IntRect(0, 0, getWidth(), getHeight());
   * 
   * int x = 0; int y = mRect.getY(); int h = mRect.getH(); int w = 0;
   * 
   * if (mPrimaryButton || mPopupShown) { x = mRect.getX(); w = mDividerLocation -
   * mRect.getX(); } else if (mHighlight) { x = mDividerLocation; w = mRect.getW()
   * - mDividerLocation; } else { // do nothing }
   * 
   * if (isSelected() || mPopupShown) { //paintHighlighted(g2, rect);
   * 
   * getWidgetRenderer().drawRibbonButton(g2, rect, RenderMode.SELECTED);
   * 
   * } else if (mHighlight) { getWidgetRenderer().drawRibbonButtonOutline(g2,
   * rect, RenderMode.SELECTED); getWidgetRenderer().drawRibbonButton(g2, x, y, w,
   * h, RenderMode.SELECTED);
   * 
   * //paintHighlightedBorder(g2, rect); //paintHighlighted(g2, x, y, w, h); }
   * else {
   * 
   * }
   * 
   * }
   */

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.button.ModernDropDownButton#drawForegroundAA(java.
   * awt. Graphics2D)
   */
  @Override
  public void drawForegroundAA(Graphics2D g2) {
    int x;
    int y;

    if (isEnabled()) {
      g2.setColor(ModernWidget.TEXT_COLOR);
    } else {
      g2.setColor(ModernWidget.ALT_TEXT_COLOR);
    }

    if (mMode == RibbonSize.LARGE) {
      if (mShowText && mText1 != null) {
        y = mRect.getH() - PADDING - ModernWidget.getStringHeight();
        x = (mRect.getW() - g2.getFontMetrics().stringWidth(mText1)) / 2;
        g2.drawString(mText1, x, y);

        if (mText2 != null) {
          y += ModernWidget.getStringHeight();
          x = (mRect.getW() - g2.getFontMetrics().stringWidth(mText2)) / 2;
          g2.drawString(mText2, x, y);
        }

        x = (mRect.getW() - mIcon.getWidth()) / 2;
        y = PADDING;

        if (isEnabled()) {
          mIcon.drawIcon(g2, x, y, 32);
        } else {
          mIcon.getDisabledIcon().drawIcon(g2, x, y, 32);
        }
      } else {
        x = (mRect.getW() - mCompactIcon.getWidth()) / 2;
        y = (mRect.getH() - mCompactIcon.getHeight()) / 2;

        if (isEnabled()) {
          mIcon.drawIcon(g2, x, y, 32);
        } else {
          mIcon.getDisabledIcon().drawIcon(g2, x, y, 32);
        }
      }
    } else {
      x = PADDING;

      if (mCompactIcon != null) {
        y = (getHeight() - mCompactIcon.getHeight()) / 2;

        if (isEnabled()) {
          mCompactIcon.drawIcon(g2, x, y, 24);
        } else {
          mCompactIcon.getDisabledIcon().drawIcon(g2, x, y, 24);
        }

        x += DOUBLE_PADDING + mCompactIcon.getWidth();
      }

      if (mShowText && mText != null) {
        y = ModernWidget.getTextYPosCenter(g2, mRect.getH());

        g2.drawString(mText, x, y);
      }
    }

    if (mMode == RibbonSize.LARGE) {
      x = (getWidth() - TRIANGLE_ICON.getWidth()) / 2;
      y = getHeight() - TRIANGLE_ICON.getHeight() - PADDING;
    } else {
      x = getWidth() - (mSecondaryButtonWidth - TRIANGLE_ICON.getWidth()) / 2 - TRIANGLE_ICON.getWidth();
      y = (getHeight() - TRIANGLE_ICON.getHeight()) / 2;
    }

    TRIANGLE_ICON.drawIcon(g2, x, y, 16);
  }

}
