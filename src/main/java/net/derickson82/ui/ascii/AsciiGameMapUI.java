/**
 * 
 */
package net.derickson82.ui.ascii;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import net.derickson82.map.GameMap;
import net.derickson82.ui.GameMapUi;

/**
 * @author dan
 */
public class AsciiGameMapUI implements GameMapUi {
  private static final Font gameFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
  
  private final GameMap gameMap;
  
  private Double charWidth = null;
  private Double charHeight = null;
  

  public AsciiGameMapUI(GameMap gameMap) {
    this.gameMap = gameMap;
  }
  
  public void render(Graphics2D g2d) {
    g2d.setFont(gameFont);

    Font monoFont = g2d.getFont();
    
    System.out.println(monoFont);
    if (charWidth == null && charHeight == null) {
      Rectangle2D bounds = monoFont.getStringBounds("@", g2d.getFontRenderContext());
      
      charWidth = bounds.getWidth();
      charHeight = bounds.getHeight();
    }
    
    for (int y = 0; y < GameMap.HEIGHT; y++) {
      
      int yVal = (int)((y + 1) * charHeight);
      
      g2d.drawChars(gameMap.getRawData()[y], 0, GameMap.WIDTH, 0, yVal);
    }
 
  }
}
