package dev.antonyholmes.modern.collapsepane;

import java.awt.Component;
import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.event.ChangeEventProducer;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.animation.ChangeAnimation;

public class CompResizeAnimation extends ChangeAnimation {

  protected static final int STEPS = 3;
  protected int[] mSizes = new int[STEPS];
  private Component mC;
  private int mSteps;
  private int mDir = 1;

  public <T extends ModernWidget & ChangeEventProducer> CompResizeAnimation(T widget) {
    super(widget, 50);
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    // Do nothing
  }

  public void restart(Component c, int min, int max, boolean fdir) {
    stop();

    mC = c;

    mSteps = fdir ? 0 : STEPS - 1;
    mDir = fdir ? 1 : -1;

    int inc = (max - min) / (STEPS - 1);
    mSizes[0] = min;
    mSizes[mSizes.length - 1] = max;

    for (int i = 1; i < mSizes.length - 1; ++i) {
      mSizes[i] = mSizes[i - 1] + inc;
    }

    start();
  }

  @Override
  public void animate() {
    if (end()) {
      stop();
    } else {
      animateExpand();

      mSteps += mDir;
    }
  }

  public int getDim() {
    return mSizes[getStep()];
  }

  public void animateExpand() {
    // TODO Auto-generated method stub

  }

  public boolean end() {
    return (mDir == 1 && getStep() == STEPS) || (mDir == -1 && getStep() == -1);
  }

  public Component getC() {
    return mC;
  }
}
