import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    public ArrayList<Monster> monsters;

    public Game(){
        monsters = new ArrayList<>();
       Random rndm = new Random();
       for(int i =0; i<5; i++){
        monsters.add(new Monster(rndm.nextInt(800), rndm.nextInt(600)));
       }
    }

    public void upadate(){
        for(Monster monster : monsters){
            monster.move();
        }
    }

    public void render(Graphics2D g){
        for(Monster monster:monsters){
            monster.draw(g);
        }
    }

    class Monster{
        private int x,y;
        public Monster(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void move(){
            x +=2;
            y+=1;
        }
        public void draw(Graphics2D g){
            g.setColor(Color.RED);
            g.fillRect(x,y,40,40);
        }
    }
}
