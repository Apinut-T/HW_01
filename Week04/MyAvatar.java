import java.awt.*;
import java.applet.Applet;

public class MyAvatar extends Applet{

	public void paint(Graphics g) {
		this.setSize(600,600);
		Color skin = new Color(255,220,180);
		//face
		g.setColor(skin);
		g.fillOval(180,200,250,250);
		g.fillRect(180,190,250,140);	
		//ears
		g.fillArc(150,240,70,93,90,180);
		g.fillArc(390,240,70,93,270,180);
		//hair
		Color hair = new Color(42,22,29);
		g.setColor(hair);
		g.fillArc(230,70,50,90,130,180);
		g.fillArc(255,80,30,50,130,180);	
		g.fillArc(165,110,270,180,0,180);
		g.fillArc(165,120,250,180,20,180);
		g.fillArc(255,150,170,130,20,180);
		g.fillArc(320,145,125,130,320,180);
		g.fillArc(150,150,150,150,20,180);
		g.fillArc(410,180,40,100,290,160);
		g.fillArc(155,200,55,130,90,180);
		g.fillArc(400,200,55,130,270,180);
		//glasses
		g.setColor(Color.BLACK);
		g.fillRect(200,250,90,70);
		g.fillRect(320,250,90,70);
		g.fillRect(175,260,55,20);   
		g.fillRect(280,260,50,10);	
		g.fillRect(380,260,55,20);	
		g.setColor(skin);
		g.fillRect(210,260,70,50);	
		g.fillRect(330,260,70,50);
		//eyebrows
		g.setColor(Color.BLACK);
		g.fillArc(215,225,60,30,0,180);
		g.fillArc(335,225,60,30,0,180);
		g.setColor(skin);
		g.fillArc(215,235,60,30,0,180);
		g.fillArc(335,235,60,30,0,180);		
		//nose
		g.setColor(Color.BLACK);
		g.fillArc(288,330,35,30,180,180);
		g.setColor(skin);
		g.fillArc(290,329,30,25,180,180);	
		//mouth
		g.setColor(Color.BLACK);	
		g.fillArc(265,390,85,10,180,180);
		g.setColor(skin);
		g.fillArc(269,388,80,8,180,180);
		//eyes
		g.setColor(Color.WHITE);
		g.fillOval(220, 260, 45, 45);
		g.fillOval(340, 260, 45, 45);
		g.setColor(Color.BLACK);
		g.fillOval(250, 285, 20, 20);
		g.fillOval(370, 285, 20, 20);
		
		Font font = new Font("Arial",Font.PLAIN,18);
		g.setFont(font);
		g.drawString("Apinut T.", 500,500);		
		
		
	
	}

}
