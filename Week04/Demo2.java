import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Demo2 extends JFrame
{
	JMenuBar menuBar;
	JMenu file,about;
	JMenuItem newItem,closeItem,closeAllItem,exitItem,helpItem,authorItem;
	JDesktopPane desktop;
	static int offsetMultiplier = 0;
	Font font = new Font("TimesRoman",Font.BOLD,36);
	
	public Demo2()
	{
		super("Scribble Shop");
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // get screen size
		Dimension screensize = toolkit.getScreenSize(); // get screen size
		desktop = new JDesktopPane();
		desktop.setBackground(Color.WHITE);
		setContentPane(desktop);
		setJMenuBar(setGUI());
		setPreferredSize(screensize);
		addListeners();
		desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE); 
	}
	
	public static void main(String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
            public void run() 
            {
                createAndShowGUI();
            }
        });
	}
	protected JMenuBar setGUI()
	{
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		about = new JMenu("About");
		
		newItem = new JMenuItem("New");
		closeItem = new JMenuItem("Close");
		closeAllItem = new JMenuItem("Close All");
		exitItem = new JMenuItem("Exit");
		helpItem = new JMenuItem("Help");
		authorItem = new JMenuItem("Author");
		
		file.add(newItem);
		file.addSeparator();
		file.add(closeItem);
		file.add(closeAllItem);
		file.addSeparator();
		file.add(exitItem);
		about.add(helpItem);
		about.add(authorItem);
		
		menuBar.add(file);
		menuBar.add(about);
		
		return menuBar;
	}
	
	protected static void createAndShowGUI()
	{
		Demo2 initialFrame = new Demo2();
		initialFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialFrame.pack();
		initialFrame.setVisible(true);
	}
	protected void createFrame()
	{
		MyInternalFrame frame = new MyInternalFrame();
		ScribbleApplet pad = new ScribbleApplet();
		frame.add(pad.getContentPane());
        frame.setVisible(true);
        desktop.add(frame);
        try 
        {
            frame.setSelected(true);
        } 
        catch (java.beans.PropertyVetoException e) {}
	}
	
	private void addListeners()
	{
		newItem.setMnemonic(KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				createFrame();
			}
		});
		closeItem.setMnemonic(KeyEvent.VK_W);
        closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		closeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					desktop.getSelectedFrame().setClosed(true);
				}
				catch(java.beans.PropertyVetoException v) {}
				offsetMultiplier -= 1;
			}
		});
		closeAllItem.setMnemonic(KeyEvent.VK_W);
        closeAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
		closeAllItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JInternalFrame[] frame;
				frame = desktop.getAllFrames();
				for(int i=0;i<frame.length;i++)
				{
					try
					{
						frame[i].setClosed(true);
					}
					catch(java.beans.PropertyVetoException v) {}
				}
				offsetMultiplier = 0;
			}
		});
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		helpItem.setMnemonic(KeyEvent.VK_F1);
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
		helpItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFrame help = new JFrame("Help");
				JPanel panel = new JPanel();
				JLabel help_text = new JLabel();
				help_text.setFont(font);
				help_text.setText("... --- ...");
				help.setLayout(new BorderLayout());
				panel.add(help_text);
				help_text.setAlignmentX(JComponent.CENTER_ALIGNMENT);
				help.add(panel);
				help.setPreferredSize(new Dimension(600,600));
				help.pack();
				help.setVisible(true);
				
			}
		});
		authorItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MyAvatar avatar = new MyAvatar();
				JFrame author = new JFrame("Author");
				JPanel panel = new JPanel();
				JLabel author_text = new JLabel("Application Programming Class");
				author.setLayout(new BorderLayout());
				panel.add(author_text);
				author_text.setAlignmentX(JComponent.CENTER_ALIGNMENT);
				author.add(panel,BorderLayout.NORTH);
				author.add(avatar,BorderLayout.CENTER);
				author.setPreferredSize(new Dimension(600,600));
				author.pack();
				author.setVisible(true);
			}		
		}
		);
	}
	
	public static class MyInternalFrame extends JInternalFrame
	{
	    static int openFrameCount = 0;
	    static final int xOffset = 30, yOffset = 30;
	 
	    public MyInternalFrame() 
	    {
	        super("Untitled-"+(++openFrameCount),true,true,true,true);
	        setSize(800,800);
	        ++offsetMultiplier;
	        setLocation(xOffset*offsetMultiplier, yOffset*offsetMultiplier);
	    }
	}

}

