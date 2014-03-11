/**
 * 
 */
package net.derickson82.map;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author dan
 *
 */
public class GameMap {
  
  public static int WIDTH = 64;
  public static int HEIGHT = 16;
  private char[][] map;
  
  private Player player;

  public static GameMap loadMap(String fileName) {
    
    GameMap gameMap = new GameMap();
    
    gameMap.map = new char[HEIGHT][WIDTH];
    
    InputStream stream = GameMap.class.getResourceAsStream(fileName);
    
    Reader reader = new InputStreamReader(stream);
    
    try {
      for (int y = 0; y < HEIGHT; y++) {
        for (int x = 0; x < WIDTH; x++) {
          gameMap.map[y][x] = (char)reader.read();
          if (gameMap.map[y][x] == Player.CHAR) {
            gameMap.player = new Player();
            gameMap.player.setX(x);
            gameMap.player.setY(y);
          }
        }
        reader.read(); // pull out the newline?
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return gameMap;
  }
  
  private GameMap() {
  }
  
  public char[][] getRawData() {
    return map;
  }
  
  public boolean left() {
    return move(-1, 0);
  }
  
  public boolean right() {
    return move(1, 0);
  }
  
  public boolean up() {
    return move(0, -1);
  }
  
  public boolean down() {
    return move(0, 1);
  }
  
  private boolean move(int deltaX, int deltaY) {
    int newX = player.getX() + deltaX;
    int newY = player.getY() + deltaY;
    if (movementAllowed(newX, newY)) {
      char standingOn = player.getStandingOn();
      player.setStandingOn(map[newY][newX]);
      
      map[newY][newX] = map[player.getY()][player.getX()];
      map[player.getY()][player.getX()] = standingOn;
      
      player.setX(newX);
      player.setY(newY);
      return true;
    }
    return false;
  }
  
  private boolean movementAllowed(int x, int y) {
    return withinBoundaries(x, y) && !isBarrier(x, y);
  }
  
  private boolean withinBoundaries(int x, int y) {
    return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
  }
  
  private boolean isBarrier(int x, int y) {
    return map[y][x] == '#';
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int y = 0; y < HEIGHT; y++) {
      for (int x = 0; x < WIDTH; x++) {
        builder.append(map[y][x]);
      }
      builder.append("\n");
    }
    return builder.toString();
  }
}
