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
package dev.antonyholmes.modern.slider;

import java.awt.Color;
import java.awt.Graphics2D;

import dev.antonyholmes.modern.BorderService;
import dev.antonyholmes.modern.theme.DrawUI;
import dev.antonyholmes.modern.theme.ThemeService;

/**
 * Slider with an orb button and plus minus controls.
 *
 * @author Antony Holmes
 *
 */
public class ContinuousMacOrbSlider extends ContinuousOrbSlider {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /** The Constant HIGHLIGHT. */
  protected static final Color HIGHLIGHT = ThemeService.getInstance().getColors().getTheme32(16);

  private static final DrawUI SLIDER_UI = new ContinuousMacOrbUI();

  /** The m bar height. */
  protected int mBarHeight = 4;

  /**
   * Create a new Mac Orb Slider.
   * 
   * @param value
   * @param min
   * @param mid
   * @param max
   */
  public ContinuousMacOrbSlider(double value, double min, double mid, double max) {
    super(value, min, mid, max);

    init();
  }

  /**
   * Inits the.
   */
  private void init() {
    setRadius(6);

    setBorder(BorderService.getInstance().createLeftRightBorder(1));

    // setAnimations("continuous-orb-slider"); // getBackgroundAnimations().set(new
    // ContinuousMacOrbAnimation(this));

    addStyleClass("slider");

    setAnimations("css-hover");

    setCSSMode(false);

    getDrawStates().add(SLIDER_UI);
  }

  /**
   * Sets the bar height.
   *
   * @param h the new bar height
   */
  public void setBarHeight(int h) {
    mBarHeight = h;

    repaint();
  }

  /*
   * @Override public void drawBackgroundAA(Graphics2D g2) {
   * System.err.println("sdfsdf too much cheese " + getName() + " " + getClass());
   * 
   * //int p = (int)(getInsets().left + mSliderDiameter % 2 + vToX());
   * 
   * //drawBar(g2, p); }
   */

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.ModernWidget#drawForegroundAA(java.awt.Graphics2D)
   */
  /*
   * @Override public void drawForegroundAA(Graphics2D g2) { int p =
   * (int)(getInsets().left + mSliderDiameter % 2 + mPc * mGap);
   * 
   * drawOrb(g2, p); }
   */

  /**
   * Draw bar base.
   *
   * @param g2 the g 2
   * @param p  the p
   */
  protected void drawBarBase(Graphics2D g2, int p) {
    g2.setColor(LINE_COLOR);

    int x = getInsets().left + mSliderRadius;
    int y = (getHeight() - mBarHeight) / 2;

    g2.fillRoundRect(x, y, mInternalRect.getW() - mSliderDiameter, mBarHeight, mBarHeight, mBarHeight);
  }

  /**
   * Draw bar.
   *
   * @param g2 the g 2
   * @param p  the p
   */
  protected void drawBar(Graphics2D g2, int p) {
    drawBarBase(g2, p);

    int x = getInsets().left + mSliderRadius;
    int y = (getHeight() - mBarHeight) / 2;

    g2.setColor(HIGHLIGHT);

    g2.fillRoundRect(x, y, p - x + mSliderRadius, mBarHeight, mBarHeight, mBarHeight);
  }

  /**
   * Draw orb.
   *
   * @param g2 the g 2
   * @param p  the p
   */
  protected void drawOrb(Graphics2D g2, int p) {
    int y = getHeight() / 2;

    g2.setColor(Color.WHITE);
    g2.fillOval(p, y - mSliderRadius, mSliderDiameter, mSliderDiameter);

    g2.setColor(LINE_COLOR);
    g2.drawOval(p, y - mSliderRadius, mSliderDiameter, mSliderDiameter);
  }
}
