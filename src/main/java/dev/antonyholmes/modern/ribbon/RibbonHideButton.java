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
package dev.antonyholmes.modern.ribbon;

import dev.antonyholmes.modern.AssetService;
import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.graphics.icons.CheveronUpVectorIcon;

/**
 * Button to allow users to hide the ribbon.
 * 
 * @author Antony Holmes
 *
 */
public class RibbonHideButton extends RibbonButton {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new ribbon hide button.
   */
  public RibbonHideButton() {
    super(AssetService.getInstance().loadIcon(CheveronUpVectorIcon.class, 12));

    addToStyleClass("dialog-button");
    setAnimations("circle-fill"); // new RibbonButtonHighlightAnimation(this,
    // "circle"));

    UI.setSize(this, 24);
  }

}
