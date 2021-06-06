
package chatting.application;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
/**
 *
 * @author webcom
 */
public class Server implements ActionListener{
    JPanel p1;
    JTextField t1;//textarea
    JButton b1;//send button
    static JPanel a1;
    static JFrame f1=new JFrame();
    
    static Box vertical=Box.createVerticalBox();
    
    
    static ServerSocket skt;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    Boolean typing;
    
    
    Server()
    {
        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        p1=new JPanel();
        
    p1.setLayout(null);
    p1.setBackground(new Color(7,94,84));
    p1.setBounds(0,0,600,70);//To get jpanel element at top
        f1.add(p1);
        
        
        //Adding Back Button Image
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
      Image img1=img.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);//change image size
      ImageIcon img2 =new ImageIcon(img1);
      JLabel  l1=new JLabel(img2);
       l1.setBounds(5,18,32,32);//set image position
       p1.add(l1);
       
       //adding mouseevent to back the window when click on back button
       l1.addMouseListener(new MouseAdapter()
               {
                   public void mouseClicked(MouseEvent ae)
                   {
                       System.exit(0);
                   }
               });
       
        //Adding profile Image
        ImageIcon img3=new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/1.png"));
      Image img4=img3.getImage().getScaledInstance(62, 62, Image.SCALE_DEFAULT);
      ImageIcon img5 =new ImageIcon(img4);
      JLabel  l2=new JLabel(img5);
       l2.setBounds(42,5,62,62);
       p1.add(l2);
       
       //Adding video Icon
        ImageIcon img6=new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
      Image img7=img6.getImage().getScaledInstance(40, 38, Image.SCALE_DEFAULT);
      ImageIcon img8 =new ImageIcon(img7);
      JLabel  l5=new JLabel(img8);
       l5.setBounds(430,20,30,30);
       p1.add(l5);
       
       
       
       //Adding call Image
        ImageIcon img9=new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
      Image img10=img9.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
      ImageIcon img11 =new ImageIcon(img10);
      JLabel  l6=new JLabel(img11);
       l6.setBounds(490,20,35,30);//set image position
       p1.add(l6);
       
       
       
       //Adding 3 Icon image
        ImageIcon img12=new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
      Image img13=img12.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);//change image size
      ImageIcon img14 =new ImageIcon(img13);
      JLabel  l7=new JLabel(img14);
       l7.setBounds(550,22,25,25);
       p1.add(l7);
       
       
       //Adding Name of User
       JLabel l3=new JLabel("Gaitonde");
       l3.setFont(new Font("SAN_SERIF",Font.BOLD,19));
       l3.setForeground(Color.white);
       l3.setBounds(115,16,100,18);
       p1.add(l3);
       
       //Adding status of the User
       JLabel l4=new JLabel("Active Now");
       l4.setFont(new Font("SAN_SERIF",Font.PLAIN,13));
       l4.setForeground(Color.white);
       l4.setBounds(115,32,100,30);
       p1.add(l4);
       Timer t=new Timer(1,new ActionListener()
       {
           public void actionPerformed(ActionEvent ae)
           {
               if(!typing)
               {
                   l4.setText("Active Now");
                   
               }
           }
       });
       t.setInitialDelay(2000);
       
       //text area or messege area
       a1=new JPanel();
      // a1.setBounds(5,75,585,465);
       
       a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
       
       
      // f1.add(a1);
       
       //Adding scroll bar
       JScrollPane sb=new JScrollPane(a1);
       sb.setBounds(5,75,585,465);
       sb.setBorder(BorderFactory.createEmptyBorder());
       
       
       ScrollBarUI ui=new BasicScrollBarUI(){
           protected JButton createDecreaseButton(int orientation)
           {
               JButton button=super.createDecreaseButton(orientation);
               button.setBackground(new Color(7,94,84));
               button.setForeground(Color.WHITE);
                this.thumbColor=new Color(7,94,84);
                
               return button;
           }
           
           protected JButton createIncreaseButton(int orientation)
           {
               JButton button=super.createDecreaseButton(orientation);
               button.setBackground(new Color(7,94,84));
               button.setForeground(Color.WHITE);
               this.thumbColor=new Color(7,94,84);
               return button;
           }
       };
       sb.getVerticalScrollBar().setUI(ui);
       f1.add(sb);
       
       
       //text field
       t1=new JTextField();
       t1.setBounds(5,550,480,40);
       t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
       f1.add(t1);
       //typing and active now changing
       t1.addKeyListener(new KeyAdapter()
       {
           public void keyPressed(KeyEvent ke)
           {
               l4.setText("typing...");
               t.stop();
               typing=true;
           }
           public void keyReleased(KeyEvent ke)
           {
               typing=false;
               if(!t.isRunning())
               {
                   t.start();
               }
           }
       });
       
       
       //send buton
       b1=new JButton("Send");
       b1.setBounds(495,550,95,40);
       b1.setBackground(new Color(7,94,84));
       b1.setForeground(Color.white);//to change text color
       b1.addActionListener(this);
       f1.add(b1);
       
       
       
       //getContentPane().setBackground(Color.YELLOW);
       //Adding size and location of outer frame
        f1.setLayout(null);
        f1.setSize(600, 600);//frame size
        f1.setLocation(200,200);
        
        f1.setUndecorated(true);//to don't show the top header
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)//to close the window on back button
    {
        try{
        String out=t1.getText();
        sendTextToFile(out);
        
        JPanel p2=formatLabel(out);
        a1.setLayout(new BorderLayout());
        
        JPanel right=new JPanel(new BorderLayout());
        right.add(p2,BorderLayout.LINE_END);
        vertical.add(right);
        
            vertical.add(Box.createVerticalStrut(15));
        a1.add(vertical,BorderLayout.PAGE_START);
        
        
                //a1.add(p2);
        
        dout.writeUTF(out);
        t1.setText("");
        }
        catch(Exception e)
        {}
    }
    
    public void sendTextToFile(String mess) throws FileNotFoundException
    {
        try(FileWriter f=new FileWriter("chat.txt");
                PrintWriter p=new PrintWriter(new BufferedWriter(f));)
        {
            p.println("Gaitonde: "+mess);
        }
        catch(Exception e){
        e.printStackTrace();}
    }
    
    public static JPanel formatLabel(String out)
    {
        JPanel p3=new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
       
        JLabel l11=new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
        l11.setFont(new Font("Tahoma",Font.PLAIN,16));
        l11.setBackground(new Color(37,211,102));
        l11.setOpaque(true);
        l11.setBorder(new EmptyBorder(15,15,15,50));
        
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        
        JLabel l22=new JLabel();
        l22.setText(sdf.format(cal.getTime()));
        
        p3.add(l11);
        p3.add(l22);
        return p3;
        
    }
    
    public static void main(String[] args)
    {
        new Server().f1.setVisible(true);
        String msginput="";
        try
        {
            skt=new ServerSocket(4000);
            while(true)
            {
            s=skt.accept();
            din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            
            while(true)
            {
            msginput=din.readUTF();
            
            JPanel p2=formatLabel(msginput);
            JPanel left=new JPanel(new BorderLayout());
            left.add(p2,BorderLayout.LINE_START);
            vertical.add(left);
            f1.validate();
            
            }
        }
        }
        catch(Exception e){}
    }
}
