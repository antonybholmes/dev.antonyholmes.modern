package dev.antonyholmes.modern.animation;

public interface TransitionTimer {
  /**
   * Given the current time, return how much to increment the normalized time by.
   * 
   * @param ms
   * @param t
   * @return
   */
  public double nextT(boolean forward);
}
