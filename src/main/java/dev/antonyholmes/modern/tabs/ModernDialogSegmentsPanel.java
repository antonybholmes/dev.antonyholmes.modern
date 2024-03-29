/**
 * Copyright 2016 Antony Holmes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.antonyholmes.modern.tabs;

import dev.antonyholmes.modern.ModernComponent;
import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.UI;

/**
 * The Class ModernDialogSegmentsPanel provides a segments widget for dialogs
 * where the segments hovers above.
 */
public class ModernDialogSegmentsPanel extends ModernComponent {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new modern dialog segments panel.
   *
   * @param model   the model
   * @param tabSize the tab size
   */
  public ModernDialogSegmentsPanel(TabsModel model, int tabSize) {
    this(model, tabSize, false);
  }

  /**
   * Instantiates a new modern dialog segments panel.
   *
   * @param model    the model
   * @param tabSize  the tab size
   * @param centered the centered
   */
  public ModernDialogSegmentsPanel(TabsModel model, int tabSize, boolean centered) {
    this(model, tabSize, 0);
  }

  /**
   * Instantiates a new modern dialog segments panel.
   *
   * @param model       the model
   * @param tabSize     the tab size
   * @param pagePadding the page padding
   */
  public ModernDialogSegmentsPanel(TabsModel model, int tabSize, int pagePadding) {
    SegmentTabs tabs = new SegmentTabs(model, tabSize);

    UI.setSize(tabs, ModernWidget.MAX_SIZE, UI.createTopBottomBorder(pagePadding));

    setHeader(tabs); // new TextTabsTriangle(model, centered));

    TabsViewPanel panel = new TabsViewPanel(model);
    // panel.setBorder(TOP_BORDER);

    setBody(panel); // new ModernLineBorderPanel(new ModernComponent(panel,
    // LARGE_BORDER)));
  }
}
