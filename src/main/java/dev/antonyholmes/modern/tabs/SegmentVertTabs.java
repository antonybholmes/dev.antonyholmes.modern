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
package dev.antonyholmes.modern.tabs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;

import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.theme.DrawUIService;

// TODO: Auto-generated Javadoc
/**
 * Mac Style tabs.
 *
 * @author Antony Holmes
 */
public class SegmentVertTabs extends SegmentTabs {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The Constant TAB_SIZE. */
  private static final int TAB_SIZE = 32;

  /** The Constant ICON_SIZE. */
  private static final int ICON_SIZE = 16;

  // private static final int ICON_SIZE = 24;

  /**
   * Instantiates a new text tabs.
   *
   * @param model   the model
   * @param tabSize the tab size
   */
  public SegmentVertTabs(TabsModel model, int tabSize) {
    this(model, tabSize, true);
  }

  /**
   * Instantiates a new segment vert tabs.
   *
   * @param model    the model
   * @param tabSize  the tab size
   * @param centered the centered
   */
  public SegmentVertTabs(TabsModel model, int tabSize, boolean centered) {
    super(model, tabSize, centered);

    // UI.setSize(this, ModernWidget.MAX_SIZE_32);

    // setFont(SUB_HEADING_FONT);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.ModernWidget#drawForegroundAA(java.awt.Graphics2D)
   */
  @Override
  public void drawForegroundAA(Graphics2D g2) {

    int x = getInsets().left;
    int y = getInsets().top;

    int n = getTabsModel().getTabCount();

    int h = n * TAB_SIZE;

    int y1;

    int w = mInternalRect.getW();

    int selectedIndex = getTabsModel().getSelectedIndex();

    createEndShapes();

    // getWidgetRenderer().drawBackground(g2, x, y, w, h);
    DrawUIService.getInstance().getRenderer("content").draw(g2, new IntRect(x, y, w, h));

    //
    // Draw if highlighted
    //

    if (mHighlight > -1 && mHighlight < n) {
      y += mHighlight * TAB_SIZE;

      // getWidgetRenderer().buttonFillPaint(g2,
      // x,
      // y,
      // w,
      // mTabSize,
      // RenderMode.HIGHLIGHT,
      // hasFocus());

      DrawUIService.getInstance().getRenderer("button-fill").draw(g2, new IntRect(x, y, w, mTabSize));

      if (mHighlight == 0) {
        g2.fill(mLeftEnd);
      } else if (mHighlight == n - 1) {
        g2.fill(mRightEnd);
      } else {
        g2.fillRect(x, y, w, TAB_SIZE);
      }
    }

    //
    // Draw the outlines
    //

    g2.setColor(LIGHT_LINE_COLOR); // getRenderer().getOutlineColor());

    y1 = y + TAB_SIZE;

    for (int i = 1; i < getTabsModel().getTabCount(); ++i) {
      g2.drawLine(x, y1, x + w - 1, y1);

      y1 += TAB_SIZE;
    }

    DrawUIService.getInstance().getRenderer("button-outline").draw(g2, new IntRect(x, y, w, h), LIGHT_LINE_COLOR);

    //
    // Draw the selected tab
    //

    /*
     * GradientPaint paint = new GradientPaint(0, getInsets().top,
     * TEXT_TAB_SELECTED_COLOR_1, 0, getInsets().top + h,
     * TEXT_TAB_SELECTED_COLOR_2);
     * 
     * g2.setPaint(paint);
     */

    g2.setColor(TEXT_TAB_SELECTED_COLOR_1);

    y1 = y + selectedIndex * TAB_SIZE;

    if (selectedIndex == 0) {
      g2.fill(mLeftEnd);
    } else if (selectedIndex == n - 1) {
      g2.fill(mRightEnd);
    } else {
      g2.fillRect(x, y1, w, TAB_SIZE);
    }

    g2.setColor(TEXT_TAB_SELECTED_OUTLINE_COLOR);

    if (selectedIndex == 0) {
      g2.draw(mLeftEnd);
    } else if (selectedIndex == n - 1) {
      g2.draw(mRightEnd);
    } else {
      g2.drawRect(x, y1, w - 1, TAB_SIZE);
    }

    //
    // Draw the labels
    //

    y1 = y;

    int textY = getTextYPosCenter(g2, TAB_SIZE);
    int iconY = (TAB_SIZE - ICON_SIZE) / 2;
    int tabX = TAB_SIZE / 2;
    // int textX = tabX + ICON_SIZE + ICON_SIZE / 2;

    for (int i = 0; i < n; ++i) {
      boolean selected = i == selectedIndex;

      g2.setColor(selected ? Color.WHITE : TEXT_COLOR);

      String s = getTabsModel().getTab(i).getName();

      int textX;

      if (getTabsModel().getTab(i).getIcon() != null) {
        getTabsModel().getTab(i).getIcon().drawIcon(g2, tabX, iconY, TAB_SIZE);
        textX = tabX + ICON_SIZE + ICON_SIZE / 2;
      } else {
        textX = getTextXPosCenter(g2, s, w);
      }

      g2.drawString(s, textX, textY);

      y1 += TAB_SIZE;
      iconY += TAB_SIZE;
      textY += TAB_SIZE;
    }

    // g2.drawRoundRect(getInsets().left, getInsets().top, mInternalRect.getW()
    // - 1,
    // mInternalRect.getH(), ModernWidget.ROUNDING, ModernWidget.ROUNDING);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.tabs.SegmentTabs#createEndShapes()
   */
  @Override
  protected void createEndShapes() {
    if (mCreateEndShapes) {
      int x = getInsets().left;
      int y = getInsets().top;
      int w = mInternalRect.getW() - 1;
      int h = TAB_SIZE;

      mLeftEnd = new GeneralPath();
      mLeftEnd.moveTo(x, getInsets().top + ROUNDING);
      mLeftEnd.append(new Arc2D.Double(x, y, ROUNDING, ROUNDING, 180, -90, Arc2D.OPEN), true);
      mLeftEnd.lineTo(x + w - ROUNDING, y);
      mLeftEnd.append(new Arc2D.Double(x + w - ROUNDING, y, ROUNDING, ROUNDING, 90, -90, Arc2D.OPEN), true);
      mLeftEnd.lineTo(x + w, y + h);
      mLeftEnd.lineTo(x, y + h);
      // mLeftEnd.lineTo(getInsets().left, getInsets().top + ROUNDING);
      mLeftEnd.closePath();

      y += (getTabsModel().getTabCount() - 1) * h;

      mRightEnd = new GeneralPath();
      mRightEnd.moveTo(x, y);
      mRightEnd.lineTo(x + w, y);
      mRightEnd.lineTo(x + w, y + h - ROUNDING);
      mRightEnd.append(new Arc2D.Double(x + w - ROUNDING, y + h - ROUNDING, ROUNDING, ROUNDING, 0, -90, Arc2D.OPEN),
          true);
      mRightEnd.lineTo(x + ROUNDING, y + h);
      mRightEnd.append(new Arc2D.Double(x, y + h - ROUNDING, ROUNDING, ROUNDING, 270, -90, Arc2D.OPEN), true);
      mRightEnd.closePath();

      mCreateEndShapes = false;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.tabs.SegmentTabs#getTab(int, int)
   */
  @Override
  protected int getTab(int x, int y) {
    return (y - getInsets().top) / TAB_SIZE;
  }
}
