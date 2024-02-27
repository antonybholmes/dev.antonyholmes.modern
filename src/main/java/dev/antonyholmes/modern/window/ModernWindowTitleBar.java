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
package dev.antonyholmes.modern.window;

import dev.antonyholmes.modern.window.ModernTitleBar;
import dev.antonyholmes.modern.window.ModernWindow;
import dev.antonyholmes.modern.window.ModernWindowTitleBarExitButton;
import dev.antonyholmes.modern.window.ModernWindowTitleBarExitRoundButton;
import dev.antonyholmes.modern.window.ModernWindowTitleBarMaxButton;
import dev.antonyholmes.modern.window.ModernWindowTitleBarMaxRoundButton;
import dev.antonyholmes.modern.window.ModernWindowTitleBarMinButton;
import dev.antonyholmes.modern.window.ModernWindowTitleBarMinRoundButton;
import dev.antonyholmes.modern.window.ModernWindowTitleBarStyle;

import dev.antonyholmes.modern.UI;

/**
 * The class ModernWindowTitleBar.
 */
public class ModernWindowTitleBar extends ModernTitleBar {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new modern window title bar.
   *
   * @param window the window
   */
  public ModernWindowTitleBar(ModernWindow window) {
    this(window, UI.TITLE_BUTTONS_ON_LEFT, UI.WINDOW_TITLE_STYLE);
  }

  /**
   * Instantiates a new modern window title bar.
   *
   * @param window the window
   * @param style  the style
   */
  public ModernWindowTitleBar(ModernWindow window, ModernWindowTitleBarStyle style) {
    this(window, UI.TITLE_BUTTONS_ON_LEFT, style);
  }

  /**
   * Instantiates a new modern window title bar.
   *
   * @param window the window
   * @param onLeft the on left
   */
  public ModernWindowTitleBar(ModernWindow window, boolean onLeft) {
    this(window, onLeft, UI.WINDOW_TITLE_STYLE);
  }

  /**
   * Creates a new title bar.
   *
   * @param window Parent window.
   * @param onLeft the on left
   * @param style  The button style.
   */
  public ModernWindowTitleBar(ModernWindow window, boolean onLeft, ModernWindowTitleBarStyle style) {
    if (onLeft) {
      if (style == ModernWindowTitleBarStyle.MAC) {
        _addLeft(new ModernWindowTitleBarExitRoundButton(window));
        _addLeft(new ModernWindowTitleBarMinRoundButton(window));
        _addLeft(new ModernWindowTitleBarMaxRoundButton(window));
      } else {
        _addLeft(new ModernWindowTitleBarExitButton(window));
        _addLeft(new ModernWindowTitleBarMinButton(window));
        _addLeft(new ModernWindowTitleBarMaxButton(window));
      }
    } else {
      if (style == ModernWindowTitleBarStyle.MAC) {
        _addRight(new ModernWindowTitleBarMinRoundButton(window));
        _addRight(new ModernWindowTitleBarMaxRoundButton(window));
        _addRight(new ModernWindowTitleBarExitRoundButton(window));
      } else {
        _addRight(new ModernWindowTitleBarMinButton(window));
        _addRight(new ModernWindowTitleBarMaxButton(window));
        _addRight(new ModernWindowTitleBarExitButton(window));
      }
    }
  }

}