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
package dev.antonyholmes.modern.animation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.jebtk.core.collections.CollectionUtils;
import org.jebtk.core.collections.DefaultHashMap;
import org.jebtk.core.collections.EntryCreator;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.button.ButtonFillAnimation;
import dev.antonyholmes.modern.button.ButtonOutlineAnimation;
import dev.antonyholmes.modern.button.CheckBoxAnimation;
import dev.antonyholmes.modern.button.CheckBoxHighlightAnimation;
import dev.antonyholmes.modern.button.CheckBoxSelectedAnimation;
import dev.antonyholmes.modern.button.CheckBoxTickAnimation;
import dev.antonyholmes.modern.button.CheckSwitchAnimation;
import dev.antonyholmes.modern.button.CheckSwitchChangeAnimation;
import dev.antonyholmes.modern.button.CircleFillAnimation;
import dev.antonyholmes.modern.button.CircleOutlineAnimation;
import dev.antonyholmes.modern.button.DropDownButtonAnimation;
import dev.antonyholmes.modern.button.DropDownButtonAnimation2;
import dev.antonyholmes.modern.button.PillOutlineAnimation;
import dev.antonyholmes.modern.button.RadioAnimation;
import dev.antonyholmes.modern.button.RadioOutlineAnimation;
import dev.antonyholmes.modern.button.RadioSelectedAnimation;
import dev.antonyholmes.modern.button.UrlTextLinkHighlightAnimation;
import dev.antonyholmes.modern.collapsepane.CollapsePaneCardAnimation;
import dev.antonyholmes.modern.collapsepane.CollapsePaneDividerAnimation;
import dev.antonyholmes.modern.collapsepane.CollapsePaneExpandAnimation;
import dev.antonyholmes.modern.collapsepane.CollapsePaneHighlightAnimation;
import dev.antonyholmes.modern.combobox.ComboBoxAnimation;
import dev.antonyholmes.modern.combobox.ComboBoxArrowAnimation;
import dev.antonyholmes.modern.combobox.ComboBoxArrowAnimation2;
import dev.antonyholmes.modern.combobox.ComboBoxHighlightAnimation;
import dev.antonyholmes.modern.combobox.ComboBoxHighlightAnimation2;
import dev.antonyholmes.modern.contentpane.ModernHContentPaneAnimation;
import dev.antonyholmes.modern.css.CSSHoverAnimation;
import dev.antonyholmes.modern.dialog.ColorDialogButtonAnimation;
import dev.antonyholmes.modern.dialog.DialogButtonAnimation;
import dev.antonyholmes.modern.dialog.DialogButtonHighlightAnimation;
import dev.antonyholmes.modern.dialog.FlatButtonAnimation;
import dev.antonyholmes.modern.list.ListAnimation;
import dev.antonyholmes.modern.list.ListChangeAnimation;
import dev.antonyholmes.modern.list.ListHighlightAnimation;
import dev.antonyholmes.modern.listpanel.ListPanelItemAnimation;
import dev.antonyholmes.modern.listpanel.ListPanelItemPressedAnimation;
import dev.antonyholmes.modern.ribbon.RibbonAnimation;
import dev.antonyholmes.modern.ribbon.RibbonBackAnimation;
import dev.antonyholmes.modern.ribbon.RibbonBackHighlightAnimation;
import dev.antonyholmes.modern.ribbon.RibbonChangeAnimation;
import dev.antonyholmes.modern.ribbon.RibbonDropDownButtonAnimation;
import dev.antonyholmes.modern.ribbon.RibbonDropDownButtonAnimation2;
import dev.antonyholmes.modern.ribbon.RibbonHighlightTextAnimation;
import dev.antonyholmes.modern.ribbon.RibbonLargeOptionalDropDownHighlightAnimation;
import dev.antonyholmes.modern.ribbon.RibbonLargeOptionalDropDownHighlightAnimation2;
import dev.antonyholmes.modern.ribbon.RibbonMenuHighlightAnimation;
import dev.antonyholmes.modern.ribbon.RibbonMenuPressedAnimation;
import dev.antonyholmes.modern.ribbon.RibbonPressedAnimation;
import dev.antonyholmes.modern.ribbon.RibbonSegmentAnimation;
import dev.antonyholmes.modern.ribbon.RibbonSegmentHighlightAnimation;
import dev.antonyholmes.modern.ribbon.RibbonSegmentPressedAnimation;
import dev.antonyholmes.modern.ribbon.RibbonSegmentSelectedAnimation;
import dev.antonyholmes.modern.slider.ContinuousMacOrbAnimation;
import dev.antonyholmes.modern.spinner.SpinnerAnimation;
import dev.antonyholmes.modern.splitpane.ModernHSplitPaneLineAnimation;
import dev.antonyholmes.modern.splitpane.ModernVSplitPaneLineAnimation;
import dev.antonyholmes.modern.tabs.BlockVertHighlightAnimation;
import dev.antonyholmes.modern.tabs.BlockVertPressedAnimation;
import dev.antonyholmes.modern.tabs.BlockVertSelectedAnimation;
import dev.antonyholmes.modern.tabs.IconTabsAnimation;
import dev.antonyholmes.modern.tabs.IconTabsHighlightAnimation;
import dev.antonyholmes.modern.tabs.IconTabsIconAnimation;
import dev.antonyholmes.modern.tabs.OrbTabsAnimation;
import dev.antonyholmes.modern.tabs.OrbTabsChangeAnimation;
import dev.antonyholmes.modern.tabs.SegmentAnimation;
import dev.antonyholmes.modern.tabs.SegmentChangeAnimation;
import dev.antonyholmes.modern.tabs.SegmentTextAnimation;
import dev.antonyholmes.modern.tabs.vert.IconTabsVertChangeAnimation;
import dev.antonyholmes.modern.tabs.vert.IconTabsVertIconAnimation;
import dev.antonyholmes.modern.theme.PillContentAnimation;
import dev.antonyholmes.modern.tree.TreeHighlightAnimation;

/**
 * Represents a vector icon that uses graphics primitives to create a scalable
 * image. Since vector icons require more computation, the RastorIcon class can
 * cache the vector icon as a bitmapped image at a particular size so it can be
 * used repeated on a GUI for greater efficiency.
 * 
 * This class contains multiple static icon constants that can be shared amongst
 * multiple classes.
 * 
 * @author Antony Holmes
 * @param <T>
 *
 */
public class AnimationService {

  /**
   * The Class UIServiceLoader.
   */
  private static class AnimationServiceLoader {

    /** The Constant INSTANCE. */
    private static final AnimationService INSTANCE = new AnimationService();
  }

  /**
   * Gets the single instance of SettingsService.
   *
   * @return single instance of SettingsService
   */
  public static AnimationService getInstance() {
    return AnimationServiceLoader.INSTANCE;
  }

  private Map<String, AnimationCreator> mCreatorMap = DefaultHashMap.create(new EntryCreator<AnimationCreator>() {
    @Override
    public AnimationCreator newEntry() {
      return new AnimationCreator();
    }
  });

  private AnimationService() {

    //
    // Load the default animations
    //

    get("css-hover").add(CSSHoverAnimation.class);

    get("button-fill").add(ButtonFillAnimation.class); // .add(DrawUIAnimation.class);

    get("draw-ui").add(DrawUIAnimation.class);

    get("button-outline").add(ButtonOutlineAnimation.class);
    // get("button-selected").add(ButtonSelectedAnimation.class);

    // get("pill-fill").add(PillFillAnimation.class);
    get("pill-outline").add(PillOutlineAnimation.class);
    get("pill-content").add(PillContentAnimation.class);

    // get("button").add(DialogButtonHighlightAnimation.class);

    get("circle-fill").add(CircleFillAnimation.class);
    get("circle-outline").add(CircleOutlineAnimation.class);

    get("dropdown-button").add(DropDownButtonAnimation.class);
    get("dropdown-button-2").add(DropDownButtonAnimation2.class);

    // get("chip-button").add(ChipButtonHighlightAnimation.class)
    // .add(ChipButtonAnimation.class);

    get("dialog-flat-button").add(FlatButtonAnimation.class);

    get("ribbon").add(RibbonAnimation.class).add(RibbonPressedAnimation.class).add(RibbonChangeAnimation.class)
        .add(RibbonHighlightTextAnimation.class);

    get("segment-tabs")
        // .add(SegmentHighlightAnimation.class)
        // .add(SegmentPressedAnimation.class)
        .add(SegmentChangeAnimation.class).add(SegmentTextAnimation.class);

    get("bottom-tabs").add(SegmentAnimation.class).add(SegmentTextAnimation.class);

    get("orb-tabs").add(OrbTabsChangeAnimation.class).add(OrbTabsAnimation.class); // .add(OrbTabsHighlightAnimation.class)

    get("icon-tabs").add(IconTabsAnimation.class)
        // .add(IconTabsSelectedAnimation.class)
        .add(IconTabsHighlightAnimation.class).add(IconTabsIconAnimation.class);
    // .add(IconTabsChangeAnimation.class);

    get("icon-vert-tabs")
        // .add(IconTabsAnimation.class)
        // .add(IconTabsVertHighlightAnimation.class)
        .add(IconTabsVertChangeAnimation.class).add(IconTabsVertIconAnimation.class);

    get("block-vert-tabs").add(BlockVertHighlightAnimation.class).add(BlockVertSelectedAnimation.class)
        .add(BlockVertPressedAnimation.class); // .add(BlockVertChangeAnimation.class);

    get("spinner").add(SpinnerAnimation.class); // .add(SpinnerHighlightAnimation.class);

    // get("help-button").add(HelpButtonHighlightAnimation.class);

    get("dialog-button").add(DialogButtonAnimation.class).add(DialogButtonHighlightAnimation.class);

    // get("dialog-material-button")
    // .add(DialogMaterialButtonHighlightAnimation.class);

    get("primary-dialog-button").add(ColorDialogButtonAnimation.class);
    // .add(ColorDialogButtonHighlightAnimation.class);

    get("checkbox").add(CheckBoxAnimation.class).add(CheckBoxHighlightAnimation.class)
        .add(CheckBoxSelectedAnimation.class).add(CheckBoxTickAnimation.class);

    get("continuous-orb-slider").add(ContinuousMacOrbAnimation.class);

    get("radio-button").add(RadioAnimation.class).add(RadioOutlineAnimation.class).add(RadioSelectedAnimation.class);

    // get("menu").add(MenuItemHighlightAnimation.class);

    // get("color-menu").add(MenuItemColorHighlightAnimation.class);
    // get("color-menu-fade").add(MenuItemColorHighlightFadeAnimation.class);

    get("sub-collapse-pane").add(CollapsePaneHighlightAnimation.class).add(CollapsePaneExpandAnimation.class);

    get("collapse-pane").add(CollapsePaneCardAnimation.class).add(CollapsePaneHighlightAnimation.class)
        .add(CollapsePaneDividerAnimation.class).add(CollapsePaneExpandAnimation.class);

    // get("ribbon-button").add(RibbonButtonHighlightAnimation.class);

    get("ribbon-dropdown-button").add(RibbonDropDownButtonAnimation.class);

    get("ribbon-dropdown-button-2").add(RibbonDropDownButtonAnimation2.class);

    get("ribbon-optional-dropdown-button").add(RibbonLargeOptionalDropDownHighlightAnimation.class);

    get("ribbon-optional-dropdown-button-2").add(RibbonLargeOptionalDropDownHighlightAnimation2.class);

    get("ribbon-segments").add(RibbonSegmentHighlightAnimation.class).add(RibbonSegmentSelectedAnimation.class)
        .add(RibbonSegmentPressedAnimation.class).add(RibbonSegmentAnimation.class);

    get("tree").add(TreeHighlightAnimation.class);

    get("list").add(ListHighlightAnimation.class).add(ListChangeAnimation.class).add(ListAnimation.class);

    get("combobox").add(ComboBoxAnimation.class).add(ComboBoxHighlightAnimation.class)
        .add(ComboBoxArrowAnimation.class);

    get("combobox2").add(ComboBoxAnimation.class).add(ComboBoxHighlightAnimation2.class)
        .add(ComboBoxArrowAnimation2.class);

    // .add(DialogButtonHighlightAnimation.class);

    // get("button-outline").add(TextBorderAnimation.class);

    get("ribbon-menu").add(RibbonMenuHighlightAnimation.class).add(RibbonMenuPressedAnimation.class);

    get("ribbon-back-button").add(RibbonBackHighlightAnimation.class).add(RibbonBackAnimation.class);

    get("hoz-content-pane").add(ModernHContentPaneAnimation.class);

    get("url-text-button").add(UrlTextLinkHighlightAnimation.class);

    get("splitpane-vert-line").add(ModernVSplitPaneLineAnimation.class);
    get("splitpane-hoz-line").add(ModernHSplitPaneLineAnimation.class);

    get("check-switch").add(CheckSwitchAnimation.class).add(CheckSwitchChangeAnimation.class);

    get("listpanel").add(ListPanelItemPressedAnimation.class).add(ListPanelItemAnimation.class);

  }

  /**
   * Returned a named creator for generating animations from classes.
   * 
   * @param name
   * @return
   */
  public AnimationCreator get(String name) {
    return mCreatorMap.get(name);
  }

  /**
   * Create the animations and bind then to a specific widget.
   * 
   * @param name   The name of the animation block.
   * @param widget The widget to bind the animations to.
   * @return The animations so that they can either be assigned to a widget's
   *         foreground or background.
   */
  public List<Animation> create(String name, ModernWidget widget) {

    AnimationCreator creator = mCreatorMap.get(name);

    if (creator == null) {
      return Collections.emptyList();
    }

    WidgetAnimation animation = null;

    List<Animation> ret = new ArrayList<Animation>();

    for (Class<?> c : creator) {
      try {
        Constructor<?> cons = c.getConstructor(ModernWidget.class);

        // System.err.println("Creating animation " + c);

        animation = (WidgetAnimation) cons.newInstance(widget);

        ret.add(animation);
      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (SecurityException e) {
        e.printStackTrace();
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    }

    return ret;
  }

  /**
   * Return a list of the available animations.
   * 
   * @return The available animations by name.
   */
  public List<String> listAnimations() {
    return CollectionUtils.sort(mCreatorMap.keySet());
  }
}
