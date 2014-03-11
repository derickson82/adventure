package net.derickson82.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import net.derickson82.map.GameMap;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game {

  private GameMap gameMap;
  
  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Game window = new Game();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Game() {
    gameMap = GameMap.loadMap("/test-map.txt");
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 638, 474);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    GameMapPanel gameMapPanel = new GameMapPanel(gameMap);
    frame.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent arg0) {

        boolean changed = false;
        int keyCode = arg0.getKeyCode();
        if (KeyEvent.VK_LEFT == keyCode) {
          changed = gameMap.left();
        } else if (KeyEvent.VK_RIGHT == keyCode) {
          changed = gameMap.right();
        } else if (KeyEvent.VK_UP == keyCode) {
          changed = gameMap.up();
        } else if (KeyEvent.VK_DOWN == keyCode) {
          changed = gameMap.down();
        }
        
        if (changed) {
          frame.getContentPane().repaint();
        }
      }
    });
    
    frame.getContentPane().add(gameMapPanel, BorderLayout.CENTER);
    
    frame.getContentPane().addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent arg0) {
        System.out.println("Pressed here: " + arg0.getKeyChar());
        super.keyPressed(arg0);
      }
    });
    
  }

}
