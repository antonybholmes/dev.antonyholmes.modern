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
package dev.antonyholmes.modern.css;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.ModernComponent;

/**
 * The Class ModernRoundedWidgetRenderer.
 */
public class CSSOutlineUI extends CSSBaseUI {

  @Override
  public String getName() {
    return "css-outline";
  }

  @Override
  public void draw(ModernComponent c, Graphics2D g2, IntRect rect, Props props) {
    setColor("border-color", c, g2, props);

    outline(c, g2, rect, props);
  }
}
