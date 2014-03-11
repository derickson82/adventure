/**
 * 
 */
package net.derickson82.ui;

import java.awt.Graphics2D;

/**
 * Interface for a Swing application to render a game map. Intended for ascii and tile support.
 * @author dan
 */
public interface GameMapUi {
  
  void render(Graphics2D g2d);
}
