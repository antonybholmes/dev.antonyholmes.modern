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
package dev.antonyholmes.modern.io;

import java.awt.Dimension;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Box;

import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.io.FileUtils;

import dev.antonyholmes.modern.AssetService;
import dev.antonyholmes.modern.BorderService;
import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.button.ModernButtonWidget;
import dev.antonyholmes.modern.dialog.ModernDialogTaskWindow;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickListener;
import dev.antonyholmes.modern.event.ModernSelectionListener;
import dev.antonyholmes.modern.graphics.icons.ComputerVectorIcon;
import dev.antonyholmes.modern.graphics.icons.OpenFolderVectorIcon;
import dev.antonyholmes.modern.list.ModernList;
import dev.antonyholmes.modern.list.ModernListModel;
import dev.antonyholmes.modern.ribbon.RibbonMenuPanel;
import dev.antonyholmes.modern.ribbon.RibbonPanelButton;
import dev.antonyholmes.modern.ribbon.RibbonPanelSideTabs;
import dev.antonyholmes.modern.scrollpane.ModernScrollPane;
import dev.antonyholmes.modern.scrollpane.ScrollBarPolicy;
import dev.antonyholmes.modern.tabs.TabsModel;
import dev.antonyholmes.modern.tabs.TabsViewPanel;
import dev.antonyholmes.modern.text.ModernColoredHeadingLabel;
import dev.antonyholmes.modern.text.ModernDialogHeadingLabel;

// TODO: Auto-generated Javadoc
/**
 * The class OpenDirectoryRibbonPanel.
 */
public class OpenDirectoryRibbonPanel extends RibbonMenuPanel implements ModernClickListener, ModernSelectionListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constant DIRECTORY_SELECTED.
   */
  public static final String DIRECTORY_SELECTED = "open_directory_selected";

  /**
   * The constant BROWSE_DIRECTORY.
   */
  public static final String BROWSE_DIRECTORY = "open_directory_browse";

  /**
   * The display count.
   */
  private int displayCount = 10;

  /**
   * The tabs model.
   */
  private TabsModel tabsModel = new TabsModel();

  /**
   * The side tabs.
   */
  private RibbonPanelSideTabs sideTabs = new RibbonPanelSideTabs(tabsModel);

  /**
   * The view panel.
   */
  private TabsViewPanel viewPanel = new TabsViewPanel(tabsModel);

  /**
   * The current directory list.
   */
  private ModernList<Path> mCurrentDirectoryList;

  /**
   * The recent directories list.
   */
  private ModernList<Path> mRecentDirectoriesList;

  /**
   * The selected directory.
   */
  private Path mSelectedDirectory = RecentFilesService.getInstance().getPwd();

  /**
   * Instantiates a new open directory ribbon panel.
   */
  public OpenDirectoryRibbonPanel() {
    super("Open");

    setup();
  }

  /**
   * Setup.
   */
  private void setup() {
    // ModernAutoSizeLabel label = new ModernTitleLabel("Open");
    // label.setBorder(BorderService.getInstance().createBottomBorder(20));
    // setHeader(label);

    sideTabs.addTab("Computer", AssetService.getInstance().loadIcon(ComputerVectorIcon.class, 32));

    UI.setSize(sideTabs, new Dimension(300, Short.MAX_VALUE));

    setLeft(sideTabs);

    //
    // Recent directory
    //

    Box box = Box.createVerticalBox();

    box.add(new ModernColoredHeadingLabel("Computer"));

    box.add(UI.createVGap(20));

    box.add(new ModernDialogHeadingLabel("Current Folder"));

    box.add(UI.createVGap(5));

    mCurrentDirectoryList = new ModernList<Path>(new ModernListRecentDirectoryRenderer());

    mCurrentDirectoryList.addSelectionListener(this);
    mCurrentDirectoryList.setRowHeight(48);

    ModernScrollPane scrollPane = new ModernScrollPane(mCurrentDirectoryList);
    scrollPane.setHorizontalScrollBarPolicy(ScrollBarPolicy.NEVER);

    UI.setSize(scrollPane, Short.MAX_VALUE, 50);

    box.add(scrollPane);

    ModernDialogTaskWindow.midSectionHeader("Recent Directories", box);

    mRecentDirectoriesList = new ModernList<Path>(new ModernListRecentDirectoryRenderer());

    mRecentDirectoriesList.addSelectionListener(this);
    mRecentDirectoriesList.setRowHeight(48);

    scrollPane = new ModernScrollPane(mRecentDirectoriesList);
    scrollPane.setHorizontalScrollBarPolicy(ScrollBarPolicy.NEVER);

    box.add(scrollPane);

    box.add(UI.createVGap(20));

    ModernButtonWidget button = new RibbonPanelButton(UI.MENU_BROWSE,
        AssetService.getInstance().loadIcon(OpenFolderVectorIcon.class, 32));

    button.setClickMessage(BROWSE_DIRECTORY);
    button.addClickListener(this);

    box.add(button);

    tabsModel.addTab("Computer", box);

    viewPanel.setBorder(BorderService.getInstance().createLeftBorder(20));

    setBody(viewPanel);

    tabsModel.changeTab(0);
  }

  /*
   * public final Table getTable() {
   * 
   * return table; }
   */

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.ribbon.RibbonMenuPanel#refresh()
   */
  @Override
  public final void refresh() {
    reload();
  }

  /**
   * Reload.
   */
  public final void reload() {

    // current dir

    ModernListModel<Path> model = new ModernListModel<Path>();
    model.addValue(RecentFilesService.getInstance().getPwd());
    mCurrentDirectoryList.setModel(model);

    // Recent folders

    model = new ModernListModel<Path>();

    int c = 0;

    Set<Path> used = new HashSet<Path>();

    for (Path file : RecentFilesService.getInstance()) {
      if (c == displayCount) {
        break;
      }

      if (FileUtils.exists(file) && !used.contains(file)) {
        model.addValue(file.getParent());
        used.add(file.getParent());
      }

      ++c;
    }

    mRecentDirectoriesList.setModel(model);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.event.ModernClickListener#clicked(org.abh.lib.ui.
   * modern .event.ModernClickEvent)
   */
  public final void clicked(ModernClickEvent e) {
    fireClicked(new ModernClickEvent(this, e.getMessage()));
  }

  /**
   * Gets the selected directory.
   *
   * @return the selected directory
   */
  public final Path getSelectedDirectory() {
    return mSelectedDirectory;
  }

  @Override
  public void selectionAdded(ChangeEvent e) {
    selectionRemoved(e);
  }

  @Override
  public void selectionRemoved(ChangeEvent e) {
    if (e.getSource().equals(mCurrentDirectoryList)) {
      int i = mCurrentDirectoryList.getSelectedIndex();

      if (i != -1) {
        mSelectedDirectory = mRecentDirectoriesList.getValueAt(i);

        fireClicked(new ModernClickEvent(this, DIRECTORY_SELECTED));
      }
    } else if (e.getSource().equals(mRecentDirectoriesList)) {
      int i = mRecentDirectoriesList.getSelectedIndex();

      if (i != -1) {
        mSelectedDirectory = mRecentDirectoriesList.getValueAt(i);

        fireClicked(new ModernClickEvent(this, DIRECTORY_SELECTED));
      }
    } else {
      // do nothing
    }
  }
}
