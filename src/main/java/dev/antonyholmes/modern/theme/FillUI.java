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
package dev.antonyholmes.modern.theme;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.ModernComponent;

/**
 * The Class ModernRoundedWidgetRenderer.
 */
public class FillUI extends ButtonUI {

  @Override
  public String getName() {
    return "fill";
  }

  @Override
  public void fill(ModernComponent c, Graphics2D g2, IntRect rect, Props props) {
    g2.fillRect(rect.x, rect.y, rect.w, rect.h);
  }
}
