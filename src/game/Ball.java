package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;

public class Ball {	
private double xvel,yvel,x,y;
static int score=0;
Label l1=new Label();
public Ball(){
	x=500;
	y=450;
	xvel=(getRandomSpeed()*1)*-getRandomDirection();
	yvel=(getRandomSpeed()*2)*-getRandomDirection();
}
public double getRandomSpeed()
{
	return(Math.random()+2);
}
public int getRandomDirection()
{
	int rand=(int)(Math.random()*-4);
	if(rand==1)
	{
		return 1;
	}
	else
		return -1;
}
public void draw(Graphics g){
	g.setColor(Color.green);
	g.drawOval((int)x-15,(int)y-15,30,30);
	g.setColor(Color.red);
	g.fillOval((int)x-15,(int)y-15, 30, 30);
	g.setColor(Color.black);
	g.drawOval((int)x-10,(int)y-10, 20, 20);
	g.setColor(Color.blue);
	g.drawOval((int)x-15,(int)y-15,30,30);
}
public void checkPaddleCollision(paddle p1,Paddle2 p2){
		if(x<=35){
		if(y>=p1.getY()&&y<=p1.getY()+180)
			xvel=-xvel;
		if(y>=p1.getY()&&y<=p1.getY()+180)
		{
			Ball.score++;
		   if(Ball.score>5)
		   {
			   xvel++;
			   yvel++;
		   }
		}
	}
	else if(x>=965){
		if(y>=p2.getY()&&y<=p2.getY()+180)
			xvel=-xvel;	
	}
	}
public void move(){
	x+=xvel;
	y+=yvel;
	if(y<10)
		yvel=-yvel;
		if(y>885)
			yvel=-yvel;
}	
public int getx(){
	return (int)x;	
}
public int gety(){
	return (int)y;
}
}
