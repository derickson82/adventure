package net.derickson82.map;

import org.testng.annotations.Test;

public class GameMapTest {
  
  @Test
  public void test_load_file() {
    GameMap map = GameMap.loadMap("/test-map.txt");
    
    System.out.println(map);
  }
}
