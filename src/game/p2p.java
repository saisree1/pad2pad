package game;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class p2p extends Applet implements Runnable,KeyListener{
final int WIDTH=1000,HEIGHT=900;
Thread thread;
boolean start;
Font f;
Paddle1 p1;

Paddle2 p2;
Ball b1;
 Graphics gfx;
Label l1;
 Image img;
	public void init(){
		resize(WIDTH,HEIGHT);
		this.addKeyListener(this);
		p1=new Paddle1(1);
		b1=new Ball();
		p2=new Paddle2(2,b1);
		img=createImage(WIDTH,HEIGHT);
		gfx=img.getGraphics();
		thread=new Thread(this);
		thread.start();
		}
	public void paint(Graphics g){
		super.paint(g);
		gfx.setColor(Color.orange);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		gfx.setColor(Color.black);
		gfx.setFont(new Font("",Font.BOLD,25));
		gfx.drawString("PLAYER",7,25);
		gfx.drawLine(7,26,106,26);
		gfx.drawString("CPU", 935,25);
		gfx.drawLine(935,26,985,26);
		gfx.setColor(Color.gray);
		gfx.drawRect(0, 0, WIDTH, HEIGHT);
		gfx.drawLine(500, 900, 500, 0);
		gfx.drawLine(50, 900, 50, 0);
		gfx.drawLine(950, 900, 950, 0);
		gfx.drawLine(50,50,950,50);
		gfx.drawLine(50,850, 950,850);
		gfx.drawOval(440,390, 120, 120);
		if(b1.getx()<-35 || b1.getx()>1015){
			gfx.setColor(Color.BLUE);
            gfx.setFont(new Font("",Font.BOLD,80));
			gfx.drawString("GAME OVER", 250,370);
			gfx.drawString("Score:"+Ball.score, 340,610);
			thread.stop();
		}
		else{
			p1.draw(gfx);
			b1.draw(gfx);
			p2.draw(gfx);
			}
		if(!start)
		{
			gfx.setColor(Color.BLACK);
			gfx.setFont(new Font("",Font.ITALIC,150));
			gfx.drawString("Pad2Pad",210,300);
			gfx.setFont(new Font("",Font.BOLD,30));
			gfx.drawString("PRESS 'ENTER' TO BEGIN",330, 650);

		}
		g.drawImage(img, 0,0,WIDTH,HEIGHT,this);
	}
	public void update(Graphics g){
		paint(g);
	}
	@Override
	public void run() {
		for(;;){
			if(start)
			{
			p1.move();
			p2.move();
			b1.move();
			b1.checkPaddleCollision(p1, p2);
			}
			repaint();
			try{
			Thread.sleep(10);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_UP){
			p1.setupaccel(true);
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			p1.setdownaccel(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			start=true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
if(e.getKeyCode()==KeyEvent.VK_UP){
	p1.setupaccel(false);
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			p1.setdownaccel(false);
		}
      }
	public void keyTyped(KeyEvent arg0) {
		}
		}

