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
package dev.antonyholmes.modern.search;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import org.jebtk.core.NameGetter;
import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.ChangeListener;

import dev.antonyholmes.modern.AssetService;
import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.button.ModernButtonGroup;
import dev.antonyholmes.modern.button.ModernButtonWidget;
import dev.antonyholmes.modern.button.ModernCheckRadioButton;
import dev.antonyholmes.modern.button.ModernClickWidget;
import dev.antonyholmes.modern.combobox.ModernComboBox2;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickListener;
import dev.antonyholmes.modern.graphics.icons.ListVectorIcon;
import dev.antonyholmes.modern.graphics.icons.TreeVectorIcon;
import dev.antonyholmes.modern.menu.ModernCheckBoxMenuItem;
import dev.antonyholmes.modern.menu.ModernIconMenuItem;
import dev.antonyholmes.modern.menu.ModernScrollPopupMenu2;
import dev.antonyholmes.modern.panel.HBox;
import dev.antonyholmes.modern.panel.ModernPanel;
import dev.antonyholmes.modern.ribbon.RibbonSubSectionSeparator;
import dev.antonyholmes.modern.text.ModernAutoSizeLabel;
import dev.antonyholmes.modern.theme.ColorStyle;
import dev.antonyholmes.modern.view.ViewModel;
import dev.antonyholmes.modern.window.ModernWindow;

// TODO: Auto-generated Javadoc
/**
 * Allows user to sort samples.
 *
 * @author Antony Holmes
 * @param <T> the generic type
 */
public class SortPanel<T extends NameGetter> extends HBox implements ModernClickListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constant SORTER_CHANGED.
   */
  public static final String SORTER_CHANGED = "sorter_changed";

  /**
   * The constant MENU_SIZE.
   */
  private static final Dimension MENU_SIZE = new Dimension(250, ModernIconMenuItem.HEIGHT);

  // private static final ModernIcon UP_ICON =
  // Resources.getInstance().loadIcon("up_scroll", Resources.ICON_SIZE_16);
  // private static final ModernIcon DOWN_ICON =
  // Resources.getInstance().loadIcon("down_scroll", Resources.ICON_SIZE_16);

  /**
   * The member popup.
   */
  private ModernScrollPopupMenu2 mPopup;

  /**
   * The member sort field menu button.
   */
  private ModernComboBox2 mSortFieldMenuButton;

  /**
   * The member sort direction button.
   */
  private SortDirectionButton mSortDirectionButton = new SortDirectionButton(true);

  /**
   * The member list button.
   */
  private ModernButtonWidget mListButton = new ModernCheckRadioButton(
      AssetService.getInstance().loadIcon(ListVectorIcon.class, 16), "List view", "Display data in a list.")
          .setColorStyle(ColorStyle.RIBBON);

  /**
   * The member tree button.
   */
  private ModernClickWidget mTreeButton = new ModernCheckRadioButton(
      AssetService.getInstance().loadIcon(TreeVectorIcon.class, 16), "Tree view", "Display data in a tree.")
          .setColorStyle(ColorStyle.RIBBON);

  /**
   * The member filter button.
   */
  // private FilterButton mFilterButton;

  /**
   * The member sort model.
   */
  private SortModel<T> mSortModel;

  /**
   * The member button sort map.
   */
  private Map<String, ModernClickWidget> mButtonSortMap = new HashMap<String, ModernClickWidget>();

  /**
   * The member view model.
   */
  private ViewModel mViewModel;

  /**
   * The class SortEvents.
   */
  private class SortEvents implements ChangeListener {

    /*
     * (non-Javadoc)
     * 
     * @see org.abh.lib.event.ChangeListener#changed(org.abh.lib.event.ChangeEvent)
     */
    @Override
    public void changed(ChangeEvent e) {
      // mSortFieldMenuButton.setText("Sort by " +
      // mSortModel.getSorter().getName());

      mSortDirectionButton.setAscending(mSortModel.getSortAscending());

      mButtonSortMap.get(mSortModel.getSorter().getName()).setSelected(true);
    }
  }

  /**
   * Instantiates a new sort panel.
   *
   * @param parent      the parent
   * @param sortModel   the sort model
   * @param filterModel the filter model
   * @param viewModel   the view model
   */
  public SortPanel(ModernWindow parent, SortModel<T> sortModel, FilterModel filterModel, ViewModel viewModel) {
    mSortModel = sortModel;
    mViewModel = viewModel;

    ModernButtonGroup group = new ModernButtonGroup();

    group.add(mTreeButton);
    group.add(mListButton);

    add(mTreeButton);
    add(mListButton);

    add(new RibbonSubSectionSeparator());

    add(ModernPanel.createHGap());

    group = new ModernButtonGroup();

    // mFilterButton = new FilterButton(parent, filterModel);
    // add(mFilterButton);
    // add(new RibbonSubSectionSeparator());

    add(new ModernAutoSizeLabel("Sort by"));

    add(ModernPanel.createHGap());

    mPopup = new ModernScrollPopupMenu2(); // parentFrame);

    ModernClickWidget menuItem;

    // menuItem = new ModernTitleMenuItem("Common Properties");
    // Ui.setSize(menuItem, MENU_SIZE);
    // popup.add(menuItem);

    for (Sorter<T> sorter : sortModel) {
      menuItem = new ModernCheckBoxMenuItem(sorter.getName());
      menuItem.addClickListener(this);
      UI.setSize(menuItem, MENU_SIZE);
      mPopup.add(menuItem);
      group.add(menuItem);
      mButtonSortMap.put(sorter.getName(), menuItem);
    }

    // expandButton.addClickListener(this);
    // expandButton.setToolTip(new ModernToolTip("Expand Groups",
    // "Expand the groups so you can see all samples."));
    // add(expandButton);

    // sortFieldMenuButton = new ModernHiddenComboBox("Array Design", popup);
    // mSortFieldMenuButton = new ModernDropDownMenuLabelButton("Sort by",
    // popup);
    mSortFieldMenuButton = new ModernComboBox2(mPopup);
    mSortFieldMenuButton.addClickListener(this);
    UI.setSize(mSortFieldMenuButton, 250, ModernWidget.WIDGET_HEIGHT);

    add(mSortFieldMenuButton);

    // add(ModernTheme.createHorizontalGap());

    // add(new RibbonSubSectionSeparator());

    // add(ModernTheme.createHorizontalGap());

    add(ModernPanel.createHGap());

    add(mSortDirectionButton);

    // add(ModernTheme.createHorizontalGap());

    // addMouseListener(this);

    UI.setSize(this, ModernWidget.MAX_SIZE_24, ModernWidget.TOP_BOTTOM_BORDER);

    // addMouseListener(this);
    mSortDirectionButton.addClickListener(this);

    mListButton.addClickListener(this);
    mTreeButton.addClickListener(this);

    if (mViewModel.getView().equals("tree")) {
      mTreeButton.setSelected(true);
    } else {
      mListButton.setSelected(true);
    }

    mSortFieldMenuButton.setText(mSortModel.getSorter().getName());

    sortModel.addChangeListener(new SortEvents());
  }

  /*
   * public void paintComponent(Graphics g) { super.paintComponent(g);
   * 
   * Graphics2D g2 = (Graphics2D)g;
   * 
   * int x = getWidth() - Resources.ICON_SIZE_16 -
   * ModernTheme.getInstance().getClass("widget").getInt("padding"); int y =
   * (getHeight() - Resources.ICON_SIZE_16) / 2;
   * 
   * // paint arrows so the user can see the sort order
   * 
   * if (ascending) { DOWN_ICON.paintIcon(this, g2, x, y); } else {
   * UP_ICON.paintIcon(this, g2, x, y); }
   * 
   * //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, //
   * RenderingHints.VALUE_ANTIALIAS_OFF); }
   */

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.event.ModernClickListener#clicked(org.abh.lib.ui.
   * modern .event.ModernClickEvent)
   */
  public final void clicked(ModernClickEvent e) {
    if (e.getSource().equals(mSortDirectionButton)) {
      mSortModel.setSortAscending(!mSortModel.getSortAscending());
    } else if (e.getSource().equals(mListButton)) {
      mViewModel.setView("list");
    } else if (e.getSource().equals(mTreeButton)) {
      mViewModel.setView("tree");
    } else {
      mSortModel.setSorter(e.getMessage());
    }
  }

}
