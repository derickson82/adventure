/**
 * 
 */
package net.derickson82.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import net.derickson82.map.GameMap;
import net.derickson82.ui.ascii.AsciiGameMapUI;

/**
 * @author dan
 *
 */
public class GameMapPanel extends JPanel {

  private final GameMapUi gameMapUi;
  
  /**
   * 
   */
  public GameMapPanel(GameMap gameMap) {
    gameMapUi = new AsciiGameMapUI(gameMap);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
  
    Graphics2D g2d = (Graphics2D)g;

    gameMapUi.render(g2d);
  }

}
