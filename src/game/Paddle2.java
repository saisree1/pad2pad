package game;
import java.awt.Color;
import java.awt.Graphics;
public class Paddle2 {
double y,yvel;
int Player,x;
Ball b1;
public  Paddle2(int player,Ball b){
	b1=b;
	y=400;yvel=0;
	if(player == 1)
		x=0;
	else 
		x=980;
}
public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRoundRect(x, (int)y, 20, 180,100,20);
		g.setColor(Color.green);
		g.drawRoundRect(x, (int)y, 20, 180,100,20);
	}
public void move() {
		y=b1.gety()-60;
		if(y < 0)
			y=0;
		else if(y>720)
		y=720;
	}
	public int getY() {
		return (int)y;
	}
}
