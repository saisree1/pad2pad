package game;
import java.awt.Color;
import java.awt.Graphics;
public class Paddle1 implements paddle{
double y,yvel;
boolean up,down;
final double t=0.94;
int Player,x;
public  Paddle1(int player){
	up = false;down=false;
	y=210;yvel=0;
	if(player == 1)
		x=1;
	else 
		x=680;
}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRoundRect(x, (int)y, 20, 180,100,20);
		g.setColor(Color.green);
		g.drawRoundRect(x, (int)y, 20, 180,100,20);
	
	}

	@Override
	public void move() {
		if(up){
			yvel-=4;
		}
		else if(down){
			yvel+=4;
		}
		else if(!up && !down){
			yvel*=t;
		}
		if(yvel>=7)
			yvel=7;
			else if(yvel<=-7)
				yvel=-7;
		y+=yvel;
		if(y < 0)
			y=0;
		else if(y>720)
		y=720;
	}
public void setupaccel(boolean input){
	up=input;
}
public void setdownaccel(boolean input){
	down=input;
}
	@Override
	public int getY() {
		return (int)y;
	}
}
