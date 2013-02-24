import javax.swing.*;
 
import java.awt.event.*;
import java.awt.*;
 
public class ScribbleShop extends JFrame
                               implements ActionListener {
    JDesktopPane desktop;
 
    public ScribbleShop() {
        super("ScribbleShop");
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
        desktop = new JDesktopPane();
        createFrame();
        setContentPane(desktop);
        setJMenuBar(createMenuBar());
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }
 
    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
               
        JMenu fileMenu = new JMenu("File");
      	fileMenu.setMnemonic(KeyEvent.VK_F);
      	menuBar.add(fileMenu);
       	JMenuItem newAction = new JMenuItem("New");
               
        newAction.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,java.awt.Event.CTRL_MASK));
        newAction.setActionCommand("New");
        newAction.addActionListener(this);
      
        fileMenu.add(newAction);
        fileMenu.addSeparator();
        JMenuItem closeAction1 = new JMenuItem("Close");
        closeAction1.setActionCommand("Close");
        closeAction1.addActionListener(this);
        KeyStroke ctrlWKeyStroke = KeyStroke.getKeyStroke("control W");
        closeAction1.setAccelerator(ctrlWKeyStroke);
        fileMenu.add(closeAction1);
               
        JMenuItem closeAction2 = new JMenuItem("Close All");
        closeAction2.setAccelerator(ctrlWKeyStroke);
        closeAction2.setActionCommand("Closeall");
        closeAction2.addActionListener(this);
        fileMenu.add(closeAction2);
        fileMenu.addSeparator();
               
        JMenuItem exitAction1 = new JMenuItem("Exit");
        fileMenu.add(exitAction1);         
        exitAction1.addActionListener(this);
               
        JMenu aboutMenu = new JMenu("About");
        aboutMenu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(aboutMenu);
               
        JMenuItem helpAction = new JMenuItem("Help");
        helpAction.setActionCommand("Help");
        helpAction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        helpAction.addActionListener(this);
        aboutMenu.add(helpAction);
               
        JMenuItem authorAction = new JMenuItem("Author");
        authorAction.setActionCommand("Author");
        authorAction.addActionListener(this);
        aboutMenu.add(authorAction);
               
 
        return menuBar;
    }
 
 
    public void actionPerformed(ActionEvent e) {
        if ("New".equals(e.getActionCommand())) {
            createFrame();
        }else if ("Close".equals(e.getActionCommand())) {
                this.close();
        }else if("Closeall".equals(e.getActionCommand())) {
                this.closeall();
        }else if("Author".equals(e.getActionCommand())) {
                authorFrame a = new authorFrame();
                a.setVisible(true);
        }else if("Help".equals(e.getActionCommand())) {
                helpFrame a = new helpFrame();
                a.setVisible(true);
        }else quit();
    }
   
    class authorFrame extends JDialog{
        public authorFrame(){
                super(new JFrame(),"Author",true);
                this.add(new MyAvatar());
                this.setSize(700,700);
                       
        }
   
    }
   
    class helpFrame extends JDialog{
        public helpFrame(){
        	super(new JFrame(),"Help",true);
            JLabel n = new JLabel("Good bye my Valentine\'s Day");
            n.setFont(new Font("Arial", Font.BOLD, 45));
            this.add(n,BorderLayout.CENTER);
            this.setSize(700, 200);
                       
        }
   
    }
   
   
   
    protected void closeall(){
        JInternalFrame [] x = desktop.getAllFrames();
        for(int i=0 ; i<x.length ; i++){
                x[i].setVisible(false);
        }
    }
    protected void close(){
        desktop.getSelectedFrame().setVisible(false);
    }
 
 
    protected void createFrame() {
        MyInternalFrame frame = new MyInternalFrame();
        frame.setVisible(true); 
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    public static class MyInternalFrame extends JInternalFrame {
       static int openFrameCount = 0;
        static final int xOffset = 30, yOffset = 30;
 
        public MyInternalFrame() {
            super("ScribbleApplet #" + (++openFrameCount),
                  true,true,true,true);
            ScribbleApplet a = new ScribbleApplet();
            this.add(a.getContentPane());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(500,500);
            setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
        }
       
       
    }
 
    protected void quit() {
        System.exit(0);
    }
 
    private static void createAndShowGUI() {
     JFrame.setDefaultLookAndFeelDecorated(true);
     ScribbleShop frame = new ScribbleShop();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
     
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
     
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}