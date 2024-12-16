import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

public class Panel extends JPanel{
    
    public BufferedImage hero;
    private int rectX = 100, rectY = 100;
    public boolean gameStarted = false;
    private Game game;

    public Panel(Game game){
        super();
        this.game = game;
        this.hero = new BufferedImage(900,900,BufferedImage.TYPE_INT_RGB);
        

        addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            if(!gameStarted){
                gameStarted = true;
                repaint();
            }
        }
    });

    addMouseMotionListener(new MouseMotionAdapter(){
        @Override
        public void mouseMoved(MouseEvent e){
            if(gameStarted){
                rectX = e.getX() -50;
                rectY = e.getY()-50;
                repaint();
            }
        }

    });
}







    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d =(Graphics2D) g;

        g2d.setColor(Color.GRAY);
        g2d.fillRect(0,0,getWidth(),getHeight());

        if(!gameStarted){
            g2d.setColor(Color.BLACK);
            Font font = new Font("Calibri", Font.BOLD,25);
            g2d.setFont(font);
            FontMetrics metrics = g2d.getFontMetrics(font);
            g2d.drawString("Click to Start",400, 100);

        }else{
            g2d.setColor(Color.WHITE);
            g2d.fillRect(rectX,rectY,100,100);
            game.render(g2d);
        }




        
    }
    public void draw(){
        this.repaint();
    }
    public void setGame(Game game){
        this.game = game;
    }



}






