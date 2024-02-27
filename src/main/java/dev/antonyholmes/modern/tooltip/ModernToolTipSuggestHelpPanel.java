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
package dev.antonyholmes.modern.tooltip;

import dev.antonyholmes.modern.tooltip.ModernBasicToolTipPanel;
import dev.antonyholmes.modern.tooltip.ModernToolTip;

/**
 * Extension of the basic tooltip that also suggests the user presses F1 to get
 * more help.
 * 
 * @author Antony Holmes
 *
 */
public class ModernToolTipSuggestHelpPanel extends ModernBasicToolTipPanel {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constant SIZE.
   */
  // private static final Dimension SIZE = new Dimension(240, 100);

  /**
   * Instantiates a new modern tool tip suggest help panel.
   *
   * @param tooltip the tooltip
   */
  public ModernToolTipSuggestHelpPanel(ModernToolTip tooltip) {
    super(tooltip);

    // add(new ModernMenuDivider());
    // add(ModernTheme.createVerticalGap());
    // Box box = new HBoxPanel();
    // box.setAlignmentX(LEFT_ALIGNMENT);
    // box.add(new ModernImagePanel(ModernVectorIcon.HELP_ICON, 16));
    // //(Resources.getInstance().loadIcon("help", Resources.ICON_SIZE_16)));
    // box.add(Ui.createHorizontalGap(10));
    // box.add(new ModernBoldLabel("Press F1 for more help."));
    // Ui.setSize(box, new Dimension(400, 24));
    // add(box);

    // setPreferredSize(SIZE);
  }
}