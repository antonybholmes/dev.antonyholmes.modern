/**
 * Copyright 2018 Antony Holmes
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

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.ModernComponent;
import dev.antonyholmes.modern.theme.DrawUI;

/**
 * The Class DrawUI provides reusable drawing routines that can be shared by
 * multiple widgets. For example a button renderer can be used by a button or to
 * highlight the items in a list view for example.
 */
public abstract class CSSBaseUI extends DrawUI {

  @Override
  public void fill(ModernComponent c,
      Graphics2D g2,
      IntRect rect,
      Props props) {

    cssFill(c, g2, rect, props);
  }

  public static void setColor(String name, ModernComponent c, Graphics2D g2) {
    setColor(name, c, g2, null);
  }

  public static void setColor(String name,
      ModernComponent c,
      Graphics2D g2,
      Props props) {

    Color color;

    if (props != null) {
      color = props.getColor(name);
    } else {
      if (c != null) {
        color = c.getCSSProps().getColor(name);
      } else {
        color = CSSPropsService.getInstance().getToStyleClass("widget")
            .getColor(name);
      }
    }

    g2.setColor(color);
  }

  public static void cssFill(ModernComponent c,
      Graphics2D g2,
      IntRect rect,
      Props props) {
    if (g2.getColor() == null || g2.getColor().getAlpha() == 0) {
      return;
    }

    int rounding = (int) cssRounding(c, Math.min(rect.w, rect.h));

    if (rounding > 0) {
      if (rect.w == rect.h && rounding >= rect.h / 2) {
        g2.fillOval(rect.x, rect.y, rect.w - 1, rect.w - 1);
      } else {

        g2.fillRoundRect(rect.x, rect.y, rect.w, rect.h, rounding, rounding);
      }
    } else {
      g2.fillRect(rect.x, rect.y, rect.w, rect.h);
    }
  }

  @Override
  public void outline(ModernComponent c,
      Graphics2D g2,
      IntRect rect,
      Props props) {
    cssOutline(c, g2, rect, props);
  }

  public void cssOutline(ModernComponent c,
      Graphics2D g2,
      IntRect rect,
      Props props) {
    if (g2.getColor() == null || g2.getColor().getAlpha() == 0) {
      return;
    }

    int rounding = (int) cssRounding(c, Math.min(rect.w, rect.h))-1;

    if (rounding > 0) {
      if (rect.w == rect.h && rounding >= rect.h / 2) {
        g2.drawOval(rect.x + 1, rect.y + 1, rect.w - 2, rect.w - 2);
      } else {
        // radius to diameter

        g2.drawRoundRect(rect.x,
            rect.y,
            rect.w - 1,
            rect.h - 1,
            rounding,
            rounding);
      }
    } else {
      g2.drawRect(rect.x, rect.y, rect.w - 1, rect.h - 1);
    }
  }

  public static double cssRounding(ModernComponent c, double h) {
    Object p = getStyle(c).get("border-radius", 0);

    double rounding = 0;

    switch (p.getClass().getSimpleName()) {
    case "Integer":
      rounding = (int) p;
      break;
    case "CSSProp":
      CSSProp prop = (CSSProp) p;

      switch (prop.getType()) {
      case PERCENT:
        rounding = Math.round(prop.getFloat() / 100 * h);
        break;
      default:
        rounding = 0;
        break;
      }
      break;
    default:
      rounding = 0;
      break;
    }

    return Math.min(h, rounding);
  }

  /**
   * Gets the style class of the component or defaults to the widget style class
   * if the component is null.
   *
   * @param c the c
   * @return the style
   */
  public static CSSProps getStyle(ModernComponent c) {
    if (c != null) {
      return c.getCSSProps(); // getFromKeyFrame();
    } else {
      // Return the reference style class if all else fails
      return CSSPropsService.getInstance().getStyleClass("widget");
    }
  }

}
