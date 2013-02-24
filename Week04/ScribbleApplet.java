import java.awt.*;

import java.applet.Applet;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class ScribbleApplet extends JApplet {
	JPanel southPanel;
	JPanel centerPanel;
	JFrame frame;
	Button erase;
	final MyCanvas c1 = new MyCanvas();
	
	
	public void init(){
		c1.setSize(new Dimension(400,400));
		Dimension d = new Dimension(400,500);
		setSize(d);
		
		setLayout(new BorderLayout());
		 
		
		Label l = new Label("Draw your Scribble below:");	
		add(l);
		
		add(c1);
	
		
		southPanel = new JPanel();
		add(southPanel,BorderLayout.SOUTH);
		BottomPanel bPanel = new BottomPanel();
		southPanel.add(bPanel);
		
		
		setVisible(true);
		
	}

	class BottomPanel extends JPanel{
		
		public BottomPanel(){
		
			
			
			erase = new Button("--Erase--");
		
			setLayout(new GridLayout(5,4,1,1));	
			JSlider Red = new JSlider(JSlider.HORIZONTAL,0,255,0);
			JSlider Green = new JSlider(JSlider.HORIZONTAL,0,255,0);
			JSlider Blue = new JSlider(JSlider.HORIZONTAL,0,255,0);
	
		
			final Label r = new Label("R =  "+Red.getValue());
			final Label g = new Label("G =  "+Green.getValue());
			final Label b = new Label("B =  "+Blue.getValue());
		
			this.add(r);
			this.add(Red);
		
			this.add(g);
			this.add(Green);
		
			this.add(b);
			this.add(Blue);
		
			this.add(erase);
			
				Red.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						JSlider source = (JSlider) e.getSource();
						if (!source.getValueIsAdjusting()) {
							c1.rValue = (int) source.getValue();
							r.setText("R =  "+c1.rValue);
						}
					}
			
				});
				Green.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e) {
						JSlider source = (JSlider) e.getSource();
			        	if (!source.getValueIsAdjusting()) {
			        		c1.gValue= (int) source.getValue();
			        		g.setText("G =  "+c1.gValue);
			        	}
					}
				
				});
				Blue.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e) {
						JSlider source = (JSlider) e.getSource();
						if (!source.getValueIsAdjusting()) {
							c1.bValue = (int) source.getValue();
							b.setText("B =  "+c1.bValue);
						}
					}
			
				});
				
				erase.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						c1.clearCanvas();
					}
				});
		}	
				
	}		
	
	static class MyCanvas extends JComponent{
		
		Image image;
	    Graphics2D graphics2D;
	    int cX, cY, oX, oY;
	    int rValue,gValue,bValue;
	    
	    public MyCanvas() {
	      
	    	setDoubleBuffered(false);
	    	
	    	addMouseListener(new MouseAdapter() {
	    		public void mousePressed(MouseEvent e) {
	    			oX = e.getX();
	    			oY = e.getY();
		
	          }
	    	});
	    	addMouseMotionListener(new MouseMotionAdapter() {
	            public void mouseDragged(MouseEvent e) {
	              cX = e.getX();
	              cY = e.getY();
	             graphics2D.setStroke(new BasicStroke(10));
	             graphics2D.setColor(new Color(rValue,gValue,bValue));
	              if (graphics2D != null)
	            	  graphics2D.drawLine(oX,oY, cX, cY);
	              repaint();
	              oX = cX;
	              oY = cY;
	            }
	         });
	    	
	    }
	    public void paintComponent(Graphics g) {
	        if (image == null) {
	          image = createImage(getSize().width, getSize().height);
	          graphics2D = (Graphics2D) image.getGraphics();
	          graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	              RenderingHints.VALUE_ANTIALIAS_ON);
	          graphics2D.setPaint(Color.white);
	          
	          graphics2D.fillRect(0, 0, getSize().width, getSize().height);
	          graphics2D.setPaint(Color.black);
	          repaint();
	        }
	  
	        g.drawImage(image, 0, 0, null);
	   }
	   
	    public void clearCanvas(){
	    	graphics2D.setPaint(Color.white);
		    graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		    graphics2D.setPaint(Color.black);
		    repaint();	
	    }

	}
	
	
		
}	

	


