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

import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.text.TextUtils;

import dev.antonyholmes.modern.AssetService;
import dev.antonyholmes.modern.button.ModernButtonGroup;
import dev.antonyholmes.modern.dialog.ArrangeWindowsDialog;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickListener;
import dev.antonyholmes.modern.graphics.icons.ArrangeWindows32VectorIcon;
import dev.antonyholmes.modern.graphics.icons.SwitchWindows32VectorIcon;
import dev.antonyholmes.modern.menu.ModernCheckBoxMenuItem;
import dev.antonyholmes.modern.menu.ModernScrollPopupMenu2;
import dev.antonyholmes.modern.ribbon.Ribbon;
import dev.antonyholmes.modern.ribbon.RibbonLargeButton;
import dev.antonyholmes.modern.ribbon.RibbonLargeDropDownButton2;
import dev.antonyholmes.modern.ribbon.RibbonSection;

/**
 * Standardized ribbon menu section for providing basic cut, copy and paste
 * functionality to the currently highlighted control that supports clipboard
 * operations.
 *
 * @author Antony Holmes
 *
 */
public class WindowRibbonSection extends RibbonSection implements ModernWindowListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constant MAX_CHARS.
   */
  private static final int MAX_CHARS = 30;

 
  /**
   * The member window menu.
   */
  private ModernScrollPopupMenu2 mWindowMenu = new ModernScrollPopupMenu2();

  /**
   * The member arrange window button.
   */
  private RibbonLargeButton mArrangeWindowButton = new RibbonLargeButton("Arrange All",
      AssetService.getInstance().loadIcon(ArrangeWindows32VectorIcon.class, 32));

  /**
   * The member switch window button.
   */
  private RibbonLargeDropDownButton2 mSwitchWindowButton = new RibbonLargeDropDownButton2(
      AssetService.getInstance().loadIcon(SwitchWindows32VectorIcon.class, 32), mWindowMenu);

  /**
   * The member current window.
   */
  private ModernWindow mCurrentWindow;

  /**
   * The class ArrangeEvents.
   */
  private class ArrangeEvents implements ModernClickListener {

    /*
     * (non-Javadoc)
     * 
     * @see org.abh.lib.ui.modern.event.ModernClickListener#clicked(org.abh.lib.ui.
     * modern .event.ModernClickEvent)
     */
    @Override
    public void clicked(ModernClickEvent e) {
      ArrangeWindowsDialog window = new ArrangeWindowsDialog(mCurrentWindow);

      window.setVisible(true);
    }
  }

  /**
   * Instantiates a new window ribbon section2.
   *
   * @param currentWindow the current window
   * @param ribbon        the ribbon
   */
  public WindowRibbonSection(ModernWindow currentWindow, Ribbon ribbon) {
    super(ribbon, "Window");

    mCurrentWindow = currentWindow;

    mArrangeWindowButton.setToolTip("Arrange All", "Arrange all the windows.");

    mSwitchWindowButton.setToolTip("Switch Window", "Switch between the different windows of the application.");

    add(mArrangeWindowButton);
    add(mSwitchWindowButton);

    mArrangeWindowButton.addClickListener(new ArrangeEvents());

    WindowService.getInstance().addWindowListener(this);

    windowChanged();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.window.ModernWindowListener#windowAdded(org.abh.lib.
   * event.ChangeEvent)
   */
  @Override
  public void windowAdded(ChangeEvent e) {
    windowChanged();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.window.ModernWindowListener#windowRemoved(org.abh.
   * lib. event.ChangeEvent)
   */
  @Override
  public void windowRemoved(ChangeEvent e) {
    windowChanged();
  }

  /**
   * Window changed.
   */
  private void windowChanged() {
    mWindowMenu.clear();

    String name;

    ModernCheckBoxMenuItem menuItem;

    int counter = 1;

    ModernButtonGroup group = new ModernButtonGroup();

    for (ModernWindow window : WindowService.getInstance()) {
      name = TextUtils.truncateCenter(window.getTitle(), MAX_CHARS);

      menuItem = new SwitchWindowMenuItem(counter, name, window.equals(mCurrentWindow));
      menuItem.addClickListener(new WindowRegistryListener(window));

      // UI.setSize(menuItem, new Dimension(MENU_WIDTH, WIDGET_HEIGHT));

      mWindowMenu.addScrollMenuItem(menuItem);
      group.add(menuItem);

      ++counter;
    }
  }
}
