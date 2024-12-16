import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Frame extends JFrame{

    public static Panel panel;
    public static Game game;

    public Frame(){
        game = new Game();
        panel = new Panel(game);
       

        this.add(panel);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                super.windowClosed(e);
                Shooting.loop=false;
            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("game");
        this.setSize(900, 900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}