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
package dev.antonyholmes.modern;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.Box;

import org.jebtk.core.collections.CollectionUtils;

import dev.antonyholmes.modern.button.ModernButton;
import dev.antonyholmes.modern.button.ModernCheckBox;
import dev.antonyholmes.modern.button.ModernOutlineButton;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickEventProducer;
import dev.antonyholmes.modern.event.ModernClickListener;
import dev.antonyholmes.modern.event.ModernClickListeners;
import dev.antonyholmes.modern.graphics.icons.ArrowDownVectorIcon;
import dev.antonyholmes.modern.graphics.icons.ArrowUpVectorIcon;
import dev.antonyholmes.modern.graphics.icons.DeleteVectorIcon;
import dev.antonyholmes.modern.panel.HBox;
import dev.antonyholmes.modern.panel.VBox;

/**
 * Allows components, preferably horizontal flowing components such as boxes, to
 * be layed and and reordered.
 *
 * @author Antony Holmes
 */
public class ComponentTable extends ModernComponent implements Iterable<Component> {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * The Class ComponentList.
   */
  private static class ComponentList extends ModernComponent implements Iterable<Component> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The m com list. */
    private List<Component> mComList = new ArrayList<Component>();

    /** The m check all. */
    private ModernCheckBox mCheckAll = new ModernCheckBox(UI.MENU_SELECT_ALL, true);

    /**
     * Instantiates a new component list.
     */
    public ComponentList() {
      setLayout(null);

      add(mCheckAll);

      mCheckAll.addClickListener(new ModernClickListener() {
        @Override
        public void clicked(ModernClickEvent e) {
          for (Component c : mComList) {
            if (c instanceof CContainer) {
              ((CContainer) c).setSelected(mCheckAll.isSelected());
            }
          }
        }
      });

      addComponentListener(new ComponentListener() {

        @Override
        public void componentHidden(ComponentEvent arg0) {
          // TODO Auto-generated method stub

        }

        @Override
        public void componentMoved(ComponentEvent arg0) {
          // TODO Auto-generated method stub

        }

        @Override
        public void componentResized(ComponentEvent arg0) {
          updateLayout();
        }

        @Override
        public void componentShown(ComponentEvent arg0) {
          // TODO Auto-generated method stub

        }
      });

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.Container#add(java.awt.Component)
     */
    @Override
    public Component add(Component c) {
      super.add(c);

      if (c instanceof CContainer) {
        mComList.add(c);
      }

      updateLayout();

      return c;
    }

    /**
     * Update layout.
     */
    private void updateLayout() {
      int w = mInternalRect.getW();
      int x = getInsets().left;
      int y = getInsets().top;

      int h = mCheckAll.getPreferredSize().height;

      mCheckAll.setBounds(x, y, w, h);

      y += h + PADDING;

      for (Component c : mComList) {
        h = c.getPreferredSize().height;

        c.setBounds(x, y, w, h);

        y += h + PADDING;
      }

      Dimension dim = new Dimension(getWidth(), y + getInsets().bottom);

      setPreferredSize(dim);
      setMinimumSize(dim);

      revalidate();
      repaint();
    }

    /**
     * Clear.
     */
    public void clear() {
      removeAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.Container#removeAll()
     */
    @Override
    public void removeAll() {
      mComList.clear();

      super.removeAll();

      add(mCheckAll);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.Container#remove(java.awt.Component)
     */
    @Override
    public void remove(Component c) {
      mComList.remove(c);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<Component> iterator() {
      return mComList.iterator();
    }

    /**
     * Gets the.
     *
     * @param i the i
     * @return the component
     */
    public Component get(int i) {
      return mComList.get(i);
    }
  }

  /**
   * The Class CContainer.
   */
  private static class CContainer extends ModernComponent implements ModernClickListener, ModernClickEventProducer {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The m C. */
    private Component mC;

    /** The m check selected. */
    private ModernCheckBox mCheckSelected = new ModernCheckBox(true);

    /** The m delete button. */
    private ModernButton mDeleteButton = new ModernOutlineButton(
        AssetService.getInstance().loadIcon(DeleteVectorIcon.class, 16));

    /** The m listeners. */
    private ModernClickListeners mListeners = new ModernClickListeners();

    /**
     * Instantiates a new c container.
     *
     * @param c the c
     */
    public CContainer(Component c) {
      mC = c;

      setBody(c);

      Box box = HBox.create();
      box.add(mCheckSelected);
      // box.add(UI.createHGap(PADDING));
      setLeft(box);

      box = HBox.create();
      box.add(UI.createHGap(PADDING));
      box.add(mDeleteButton);
      setRight(box);

      mDeleteButton.addClickListener(this);

      // UI.setSize(this, ModernWidget.MAX_SIZE);
    }

    /**
     * Sets the selected.
     *
     * @param selected the new selected
     */
    public void setSelected(boolean selected) {
      mCheckSelected.setSelected(selected);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.abh.common.ui.ModernComponent#getComponent()
     */
    public Component getComponent() {
      return mC;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.abh.common.ui.event.ModernClickListener#clicked(org.abh.common.ui.
     * event. ModernClickEvent)
     */
    @Override
    public void clicked(ModernClickEvent e) {
      fireClicked(new ModernClickEvent(this));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.abh.common.ui.event.ModernClickEventProducer#addClickListener(org.
     * abh. common.ui.event.ModernClickListener)
     */
    @Override
    public void addClickListener(ModernClickListener l) {
      mListeners.addClickListener(l);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.abh.common.ui.event.ModernClickEventProducer#removeClickListener(org.
     * abh. common.ui.event.ModernClickListener)
     */
    @Override
    public void removeClickListener(ModernClickListener l) {
      mListeners.removeClickListener(l);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.abh.common.ui.event.ModernClickEventProducer#fireClicked(org.abh.
     * common. ui.event.ModernClickEvent)
     */
    @Override
    public void fireClicked(ModernClickEvent e) {
      mListeners.fireClicked(e);
    }

    /**
     * Checks if is selected.
     *
     * @return true, if is selected
     */
    public boolean isSelected() {
      return mCheckSelected.isSelected();
    }
  }

  /** The m order map. */
  private Map<Integer, CContainer> mOrderMap = new HashMap<Integer, CContainer>();

  /** The m C map. */
  private Map<CContainer, Integer> mCMap = new HashMap<CContainer, Integer>();

  /** The m box. */
  private ComponentList mBox = new ComponentList();

  /** The m move up button. */
  private ModernButton mMoveUpButton = new ModernOutlineButton(
      AssetService.getInstance().loadIcon(ArrowUpVectorIcon.class, 16));

  /** The m move down button. */
  private ModernButton mMoveDownButton = new ModernOutlineButton(
      AssetService.getInstance().loadIcon(ArrowDownVectorIcon.class, 16));

  /**
   * Instantiates a new component table.
   */
  public ComponentTable() {
    // setBody(new ModernContentPanel(new ModernScrollPane(mBox)
    // .setHorizontalScrollBarPolicy(ScrollBarPolicy.NEVER)));

    setBody(mBox);

    Box box = VBox.create();

    box.add(mMoveUpButton);
    box.add(UI.createVGap(PADDING));
    box.add(mMoveDownButton);
    box.setBorder(LEFT_BORDER);

    setRight(box);

    mMoveUpButton.addClickListener(new ModernClickListener() {
      @Override
      public void clicked(ModernClickEvent e) {
        moveUp();
      }
    });

    mMoveDownButton.addClickListener(new ModernClickListener() {
      @Override
      public void clicked(ModernClickEvent e) {
        moveDown();
      }
    });
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.Container#add(java.awt.Component)
   */
  @Override
  public Component add(Component c) {
    CContainer container = new CContainer(c);

    int index = mOrderMap.size();

    mOrderMap.put(index, container);
    mCMap.put(container, index);

    container.addClickListener(new ModernClickListener() {

      @Override
      public void clicked(ModernClickEvent e) {
        int index = mCMap.get(e.getSource());

        mCMap.remove(e.getSource());
        mOrderMap.remove(index);

        layoutComponents();
      }
    });

    layoutComponents();

    return c;
  }

  /**
   * Layout components.
   */
  private void layoutComponents() {
    mBox.clear();

    for (int index : CollectionUtils.sortKeys(mOrderMap)) {
      mBox.add(mOrderMap.get(index));
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator<Component> iterator() {
    List<Component> ret = new ArrayList<Component>();

    for (Component c : mBox) {
      CContainer container = (CContainer) c;

      ret.add(container.mC);
    }

    return ret.iterator();
  }

  /**
   * Allow multiple checked items to be deleted.
   */
  public void delete() {
    List<CContainer> ret = new ArrayList<CContainer>();

    for (Component c : mBox) {
      CContainer container = (CContainer) c;

      if (container.isSelected()) {
        ret.add(container);
      }
    }

    for (CContainer c : ret) {
      int index = mCMap.get(c);

      mCMap.remove(c);
      mOrderMap.remove(index);
    }

    layoutComponents();
  }

  /**
   * Move up.
   */
  private void moveUp() {
    List<List<Integer>> groups = new ArrayList<List<Integer>>();

    int c = 0;

    List<Integer> group = new ArrayList<Integer>();

    for (Component comp : mBox) {
      CContainer container = (CContainer) comp;

      if (container.isSelected()) {
        group.add(c);
      } else {
        if (group.size() > 0) {
          groups.add(group);
        }

        group = new ArrayList<Integer>();
      }

      ++c;
    }

    if (group.size() > 0) {
      groups.add(group);
    }

    for (List<Integer> g : groups) {
      int i = g.get(0);

      // If the group is at the start, there is no where to move to
      if (i == 0) {
        continue;
      }

      Map<Integer, CContainer> newMap = new HashMap<Integer, CContainer>();

      // first move the item before the group to the end
      newMap.put(i - 1 + g.size(), (CContainer) mBox.get(i - 1));

      // Now update the others

      for (int index : g) {
        // System.err.println("move up " + index + " to " + (index - 1));

        newMap.put(index - 1, (CContainer) mBox.get(index));
      }

      // Now update the ordering

      for (int index : newMap.keySet()) {
        CContainer container = newMap.get(index);

        mOrderMap.put(index, container);
        mCMap.put(container, index);
      }
    }

    layoutComponents();
  }

  /**
   * Move down.
   */
  private void moveDown() {
    List<List<Integer>> groups = new ArrayList<List<Integer>>();

    int c = 0;

    List<Integer> group = new ArrayList<Integer>();

    for (Component comp : mBox) {
      CContainer container = (CContainer) comp;

      if (container.isSelected()) {
        group.add(c);
      } else {
        if (group.size() > 0) {
          groups.add(group);
        }

        group = new ArrayList<Integer>();
      }

      ++c;
    }

    if (group.size() > 0) {
      groups.add(group);
    }

    for (List<Integer> g : groups) {
      int i = g.get(g.size() - 1);

      // If the group is at the end, there is no where to move to
      if (i == mOrderMap.size() - 1) {
        continue;
      }

      Map<Integer, CContainer> newMap = new HashMap<Integer, CContainer>();

      // first move the item before the group to the end
      newMap.put(i + 1 - g.size(), (CContainer) mBox.get(i + 1));

      // Now update the others

      for (int index : g) {
        // System.err.println("move up " + index + " to " + (index - 1));

        newMap.put(index + 1, (CContainer) mBox.get(index));
      }

      // Now update the ordering

      for (int index : newMap.keySet()) {
        CContainer container = newMap.get(index);

        mOrderMap.put(index, container);
        mCMap.put(container, index);
      }
    }

    layoutComponents();
  }
}
