/**
 * Copyright 2017 Antony Holmes
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
import dev.antonyholmes.modern.UI;

/**
 * The Class SegmentTabsPanel.
 */
public class IconTabsPanel extends ModernComponent {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new segment tabs panel.
   *
   * @param model    the model
   * @param tabSize  the tab size
   * @param iconSize The icon size
   */
  public IconTabsPanel(TabsModel model, int tabSize, int iconSize) {

    TabsViewPanel panel = new TabsViewPanel(model);
    // panel.setBorder(0);

    setBody(panel);

    IconTabs tabs = new IconTabs(model, tabSize, iconSize);
    UI.setSize(tabs, Short.MAX_VALUE, tabSize);
    setFooter(tabs); // new TextTabsTriangle(model, centered));

  }
}
