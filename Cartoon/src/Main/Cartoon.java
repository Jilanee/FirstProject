package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Cartoon extends JPanel 
{
 GeneralPath  mountain = new GeneralPath();
 GeneralPath vane = new GeneralPath(); 
 int number;  
 float size;   
 double [] limits = new double[] {0,7,4,-1};//{0,7,4,-1};

 public Cartoon() 
 {
   setPreferredSize(new Dimension(720,500));   
   mountain.moveTo(0,-1); // mountain draw 
   mountain.lineTo(0,0.7); 
   mountain.lineTo(1.5,1.60);
   mountain.lineTo(1.8,1.3);  
   mountain.lineTo(3,2.1);  
   mountain.lineTo(4.7,0.7);   
   mountain.lineTo(6.1,1.2);    
   mountain.lineTo(14,3.8);  
   mountain.lineTo(9,-1);   
   mountain.closePath();
   vane.moveTo(0,0);       //wind will in placed in centre if value is (0,0) 
   vane.lineTo(0.5,0.5);  
   vane.lineTo(1.5,0);   
   vane.lineTo(0.5,-0.1);  
   vane.closePath();
   
   new Timer(30,new ActionListener() 
   {
     public void actionPerformed(ActionEvent evt) 
     {
       number++;      
      repaint();     
     }
      }).start();
   }
   
  protected void paintComponent(Graphics g) 
   {
      Graphics2D g2D = (Graphics2D)g;
      g2D.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);     
      control_limits(g2D, getWidth(), getHeight(), limits);     
      g2D.fillRect(0,0,7,4);
      g2D.setColor( new Color(151,204,51) );      
      g2D.fill(mountain);
      g2D.setColor(new Color(119,119,165));      
      g2D.fill(new Rectangle2D.Double(0,-0.5,7,0.9));
      g2D.setStroke( new BasicStroke(0.2F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 2,new float[] { 0.2F, 0.4F }, 1) );
      g2D.setColor(Color.WHITE);
      g2D.drawLine(0,0,7,0);
      g2D.setStroke( new BasicStroke(size));
      AffineTransform transform = g2D.getTransform();     
      g2D.translate(6,3.3);// coordinate of sun     
      paint_sun(g2D);      
      g2D.setTransform(transform);     
      g2D.translate(10 *(number % 300) / 300.0, 0);      
      g2D.scale(0.3,0.3);
      paint_cars_plane(g2D);      
      g2D.setTransform(transform);
      g2D.translate(0.9,1);
      g2D.scale(0.6,0.6);      
      paint_windmill(g2D);
      g2D.setTransform(transform);
      g2D.translate(2.3,1.5);
      g2D.scale(0.4,0.4);
      paint_windmill(g2D);
      g2D.setTransform(transform);
      g2D.translate(4.0,0.8);
      g2D.scale(0.7,0.7);
      paint_windmill(g2D); 
      g2D.drawLine(0,250,400,250);
      }
   
    void control_limits(Graphics2D g2D, int width, int height, double [] limits) 
   {
      double pixel_width = Math.abs(( limits[1] - limits[0] ) / width);
      double pixel_height = Math.abs(( limits[3] - limits[2] ) / height);
      size = (float) Math.min(pixel_width,pixel_height);
      g2D.scale( width / (limits[1]-limits[0]), height / (limits[3]-limits[2]) );
      g2D.translate( -limits[0], -limits[2] );
   }

   void paint_sun(Graphics2D g2D) 
   {
      g2D.setColor(Color.YELLOW);
      for (int i = 1; i <=40; i++) 
      { 
         g2D.rotate( 2*Math.PI /40 );   
         g2D.draw( new Line2D.Double(0,0,1.75,0) ); 
      }
      g2D.fill( new Ellipse2D.Double(-0.5,-0.5,1,1) );    
      }
     
  void paint_windmill(Graphics2D g2D) 
  {
      g2D.setColor(Color.BLACK);
      g2D.fill(new Rectangle2D.Double(-0.05,0.2,0.1,2.8));//(-0.05,0.2,0.1,2.8)
      g2D.translate(0,3);
      g2D.rotate(-number);
      g2D.setColor(new Color(13, 43, 226 ));
      for (int i = 1; i <=6; i++) 
      {
         g2D.rotate(Math.PI/3);       
         g2D.fill(vane); 
      }
   }
    
  void paint_cars_plane(Graphics2D g2D) 
  {
      AffineTransform transform = g2D.getTransform();
      g2D.translate(-1.5,-0.1);
      g2D.scale(0.8,0.8);
      paint_wheel(g2D);
      g2D.setTransform(transform);
      g2D.translate(4.5,-0.1);
      g2D.scale(0.8,0.8);
      paint_wheel(g2D);
      g2D.setTransform(transform);

      g2D.setColor(Color.CYAN);
      g2D.fill(new Rectangle2D.Double(-2.5,0,7,3.2) );
      g2D.fill(new Rectangle2D.Double(4,0,2,2) );
      g2D.fill(new Rectangle2D.Double(-20,0,5,2.5) );//new car

      g2D.setColor(Color.MAGENTA);
      g2D.fill(new Rectangle2D.Double(-2.0,1.5,2,1) );
      g2D.fill(new Rectangle2D.Double(1.5,1.5,2,1) );
      g2D.fill(new Rectangle2D.Double(-19.0,1.0,3,1) );//new car

      g2D.translate(-8.5,-0.1);
      g2D.scale(0.8,0.8);
      paint_wheel(g2D);
      g2D.setTransform(transform);
      g2D.translate(-11.5,-0.1);
      g2D.scale(0.8,0.8);
      paint_wheel(g2D);
      g2D.setTransform(transform); 
      g2D.translate(-16.0,-0.1);//*
      g2D.scale(0.8,0.8);
      paint_wheel(g2D);
      g2D.setTransform(transform);
      g2D.translate(-19.0,-0.1);
      g2D.scale(0.8,0.8);
      paint_wheel(g2D);
      g2D.setTransform(transform);//*
      g2D.setColor(Color.BLUE);
      g2D.fill(new Rectangle2D.Double(-10.5,1,2,1.5) );
      g2D.fill(new Rectangle2D.Double(-12.5,0,5,1.5) );
      //g2D.fill(new Rectangle2D.Double(-14.5,0,5,1.5) );//new car
      g2D.setColor(Color.WHITE);
      g2D.fill(new Rectangle2D.Double(-9.7,1,0.8,1) );
    //  g2D.fill(new Rectangle2D.Double(-15.7,1,0.8,1) );//new car
      g2D.setColor(new Color(0,0,128));
      }
   
   void paint_wheel(Graphics2D g2D) 
   {
      g2D.setColor(Color.BLACK);
      g2D.fill( new Ellipse2D.Double(-1,-1,2,2) );//tyer
      g2D.setColor(Color.LIGHT_GRAY);
      g2D.fill( new Ellipse2D.Double(-0.8,-0.8,1.6,1.6) ); //middle of tyer     
      g2D.setColor(Color.BLACK);
      g2D.fill( new Ellipse2D.Double(-0.2,-0.2,0.4,0.4) );//centre of chaka
      g2D.rotate( number );
       for (int i = 1; i <=20; i++) {
         g2D.rotate(2*Math.PI/20);        
         g2D.draw( new Rectangle2D.Double(0,0.1,1,0.2) );//(0,0.1,1,0.2)
      }
   }

   public static void main(String[] args) 
   {
      JFrame window = new JFrame();
      window.setContentPane(new Cartoon());
      window.pack();     
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
      window.setLocationRelativeTo(null);      
      window.setVisible(true);
   }
}