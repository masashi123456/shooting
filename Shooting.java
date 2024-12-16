import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.*;
import javax.swing.*;

public class Shooting {
    public static Frame frame;
    public static Panel panel;
    public static boolean loop;
    public static int fps = 24;
    public static long gameTime = 0;
    public static int FPS = 0;
    public static int FPSC =0;
    private static Game game;
  public static void main(String[]args){
    game = new Game();
    frame = new Frame();
    panel = new Panel(game);
    frame.add(panel);
    loop = true;

    Graphics hero = frame.panel.hero.getGraphics();
    
    
    
    Movement movement = Movement.START;
  




    while(loop){
      long getStart = System.currentTimeMillis();
      game.upadate();
      if (System.currentTimeMillis()-gameTime>=1000) {
        gameTime = System.currentTimeMillis();
        FPS =FPSC;
        FPSC = 0;
        System.out.println(FPS);
      }
      FPSC++;
      getStart = System.currentTimeMillis();

      hero.setColor(Color.GRAY);
      hero.fillRect(0,0,frame.getWidth(),frame.getHeight());
      panel.repaint();



      switch(movement){
        case START:
          if(panel.gameStarted){
            movement = Movement.GAME;
          }
          // hero.setColor(Color.BLACK);
          // Font font = new Font("Calibri", Font.BOLD, 25);
          // hero.setFont(font);
          
          // FontMetrics metrics = hero.getFontMetrics(font);
          // hero.drawString("Click to Start",400, 100);
          // break;


          case GAME:
            game.upadate();
            break;
        case OVER:
        break;
      }
      
      hero.setColor(Color.WHITE);
      hero.fillRect(100,100,100,100);
      hero.drawImage(frame.panel.hero,0,0,null);


      if(frame.panel.gameStarted&&movement == Movement.START){
        movement = Movement.GAME;
      }

      game.render((Graphics2D)hero);
      frame.panel.draw();

      try{
        long elapsed = System.currentTimeMillis() - getStart;
      Thread.sleep(Math.max(0, 1000/fps-elapsed));
      }catch(InterruptedException e){
        e.printStackTrace();
      }


    
    }
    System.exit(0);


  }  
}
