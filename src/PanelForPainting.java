import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public class PanelForPainting extends JPanel{
    ConcurrentHashMap<Integer, MyComponent> components = new ConcurrentHashMap<>();
    Commands commands;
        
        public PanelForPainting(Commands commands){
            this.commands = commands;
            setBackground(Color.white);
              addMouseListener(new MouseAdapter() 
    {
        
        
      @Override
      public void mouseClicked(MouseEvent e)
      {
          components.forEach((k,v) -> v.transparentBorder());
          boolean click = false;
          for (Map.Entry<Integer, MyComponent> entry : components.entrySet()) {
        if(entry.getValue().checkCoordinate(e.getX(), e.getY())){
                    commands.setCurrentObject(entry.getValue().id);
                    commands.setValues();
                    click = true;
                  break;
                }         
            }
            commands.setButtons(click);
          repaint();
      }      
    });
        }
        
        public void addAlice(Pair<Integer, Three<String, Integer, Alice>> element){
            components.put(element.getKey(),new MyComponent(element.getKey(), element.getValue().getValue(), element.getValue().getElement(), this));
            repaint();
        }
        
        public void addAlices(HashMap<Integer, Three<String, Integer, Alice>> collection){
            collection.forEach((k,v)->{
                components.put(k, new MyComponent(k, v.getValue(), v.getElement(), this));
                repaint();
            });
        }
        
        public void removeAlice(Integer id){
            components.remove(id);
            repaint();
        }
        
        public void removeAlices(ArrayList<Integer> list){
            list.forEach(e -> removeAlice(e));
        }
        
        public void changeAlice(Integer id, Alice element){
            components.get(id).changeComponent(element.getX(), element.getY(), element.getSize());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            components.forEach((k,v)->{
                v.paintComponent(g);
            });
            repaint();
        }
        
        class MyComponent {
        
        int size;
        int constshift = 4;
        int x;
        int y;
        int maxX;
        int maxY;
        Integer id;
        Alice alice;
        PanelForPainting panel;
        boolean animation = true;
        Rectangle2D borderRectangle;
        Color borderColor = Color.BLACK;
        boolean needBorder = false;
        Color skinColor = new Color(255, 220, 177);
        Color dressColor;
        Color bootsColor = new Color(134, 85, 37);
        Color cupColor = new Color(191,156,126);
        int[] mouthX = new int[]{14,18};
        int[] mouthY = new int[]{12,12};
        Polygon mouth = new Polygon();
        int[] neckX = new int[]{12,20,20,12};
        int[] neckY = new int[]{12,12,20,20};
        Polygon neck = new Polygon();
        int[] leftArmX = new int[]{0,0,8,8,4,0};
        int [] leftArmY = new int[]{24,32,40,36,28,24};
        Polygon leftArm = new Polygon();
        int [] rightArmX0 = new int[]{32,32,28,20,20,28,32};
        int [] rightArmY0 = new int[]{24,28,32,31,29,28,24};
        int [] rightArmX = new int[]{32,32,28,20,20,28,32};
        int [] rightArmY = new int[]{24,28,32,31,29,28,24};
        Polygon rightArm = new Polygon();
        int [] headX = new int[]{12,10,10,12,20,22,22,20,12};
        int [] headY = new int[]{16,12,8,4,4,8,12,16,16};
        Polygon head = new Polygon();
        int [] hairX = new int[]{12,20,26,26,6,6,12};
        int [] hairY = new int[]{0,0,4,12,12,4,0};
        Polygon hair = new Polygon();
        int [] cupX0 = new int[]{12,12,16,16,12};
        int [] cupY0 = new int[]{32,26,26,32,32};
        int [] cupX = new int[]{12,12,16,16,12};
        int [] cupY = new int[]{32,26,26,32,32};
        Polygon cup = new Polygon();
        int [] wristX0 = new int[]{16,18,20,20,18,16,16};
        int [] wristY0 = new int[]{28,28,29,31,32,32,28};
        int [] wristX = new int[]{16,18,20,20,18,16,16};
        int [] wristY = new int[]{28,28,29,31,32,32,28};
        Polygon wrist = new Polygon();
        int [] dressX = new int[]{0,4,8,8,0,32,24,24,8,0};
        int [] dressY = new int[]{24,28,24,36,52,52,36,20,20,24};
        Polygon dress = new Polygon();
        int [] sleeveX0 = new int[]{24,24,32,32,24};
        int [] sleeveY0 = new int[]{20,24,28,24,20};
        int [] sleeveX = new int[]{24,24,32,32,24};
        int [] sleeveY = new int[]{20,24,28,24,20};
        Polygon sleeve = new Polygon();
        int [] leftLegX = new int[]{8,12,12,8,8};
        int [] leftLegY = new int[]{52,52,60,60,52};
        Polygon leftLeg = new Polygon();
        int [] rightLegX = new int[]{20,24,24,20,20};
        int [] rightLegY = new int[]{52,52,60,60,52};
        Polygon rightLeg = new Polygon();
        int [] leftBootX = new int[]{12,8,0,12,12};
        int [] leftBootY = new int[]{60,60,64,64,60};
        Polygon leftBoot = new Polygon();
        int [] rightBootX = new int[]{20,24,32,20,20};
        int [] rightBootY = new int[]{60,60,64,64,60};
        Polygon rightBoot = new Polygon();
        
        int [] cupX1 = new int []{14,18,18,14,14};
        int [] cupY1 = new int []{18,18,24,24,18};
        int [] wristX1 = new int []{18,20,20,18,18};
        int [] wristY1 = new int []{20,21,22,24,20};
        int [] rightArmX1 = new int []{20,24,24,20,20};
        int [] rightArmY1 = new int[]{21,20,24,22,21};
        int [] sleeveX1 = new int[]{24,28,28,24,24};
        int [] sleeveY1 = new int[]{20,19,25,24,20};
        
        int [] cupX2 = new int[]{14,18,18,14,14};
        int [] cupY2 = new int[]{12,12,18,18,12};
        int [] wristX2 = new int[]{18,20,20,18,18};
        int [] wristY2 = new int[]{14,15,17,18,14};
        int [] rightArmX2 = new int []{24,24,20,20,24};
        int [] rightArmY2 = new int []{20,24,17,15,20};
        
        private void initPolygon(int [] x, int [] y, Polygon polygon){
            polygon.reset();
            for(int i =0; i < x.length; i++){
                int x1 = x[i]*size/4 + constshift;
                int y1 = y[i]*size/4 + constshift;
                if(x1>maxX) maxX = x1;
                if(y1>maxY) maxY = y1;
                polygon.addPoint(x[i]*size/4 + constshift + this.x, y[i]*size/4 + constshift + this.y);
            }
        }
        
        public boolean checkCoordinate(int x, int y){
            if(x>=this.x&&x<=maxX&&y>=this.y&&y<=maxY){
               needBorder = true;
                return true;
            } else {
           return false;
            }
        }
        
        public void transparentBorder(){
           needBorder = false;
        }
        
        public void changeComponent(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
            maxX = 32*size/4 + constshift*2 + x;
            maxY = 64*size/4 + constshift*2 + y;
            if(!animation){
                new Thread(() -> {
                    animation = true;
                    int i = 0;
                    while(i < 4){
                        set1();

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        set2();
                        panel.repaint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        set1();
                        panel.repaint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        set0();
                        panel.repaint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        i++;
                    }
                    set0();
                    panel.repaint();
                    animation = false;
                }).start();
            }
        }
        
        public int createDressColor(int color, int ownerID){
            int rowColor = color*ownerID;
            while(rowColor > 256){
                rowColor-=50;
            }
            return rowColor;
        }
        
        
        
        public MyComponent(Integer id, Integer ownerID, Alice alice, PanelForPainting panel){
            this.x = alice.getX();
            this.y = alice.getY();
            if(x>100) x = 100;
            if(y>100) y = 100;
            this.size = alice.getSize();
            if(size>10) size = 10;
            this.id = id;
            this.panel = panel;
            this.alice = alice;
            dressColor = new Color(createDressColor(13, ownerID), createDressColor(53, ownerID), createDressColor(93, ownerID));
            maxX = 32*size/4 + constshift*2 + x;
            maxY = 64*size/4 + constshift*2 + y;
            borderRectangle = new Rectangle2D.Double();
         new Thread()
            {
                public void run() {
                    animation = true;
                    int i = 0;
                    while(i < 4){
                        set1();
                        
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        set2();
                        panel.repaint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        set1();
                        panel.repaint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        set0();
                        panel.repaint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        i++;
                    }
                    set0();
                    panel.repaint();
                    animation = false;
                }
            }.start();
      }
        
        public void set0(){
         cupX = cupX0;
         cupY = cupY0;
         wristX = wristX0;
         wristY = wristY0;
         rightArmX = rightArmX0;
         rightArmY = rightArmY0;
         sleeveX = sleeveX0;
         sleeveY = sleeveY0;
        }
        
        public void set1(){
         cupX = cupX1;
         cupY = cupY1;
         wristX = wristX1;
         wristY = wristY1;
         rightArmX = rightArmX1;
         rightArmY = rightArmY1;
         sleeveX = sleeveX1;
         sleeveY = sleeveY1;
        }
        
        public void set2(){
        cupX = cupX2;
         cupY = cupY2;
         wristX = wristX2;
         wristY = wristY2;
         rightArmX = rightArmX2;
         rightArmY = rightArmY2;
        }
        
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setComposite(AlphaComposite.SrcOver);
             borderRectangle.setRect(x,y,32*size/4 + constshift*2,64*size/4 + constshift*2);
            initPolygon(leftArmX, leftArmY, leftArm);
            g2.draw(leftArm);
            g2.setColor(skinColor);
            g2.fill(leftArm);
            g2.setColor(Color.BLACK);
            initPolygon(dressX, dressY, dress);
            g2.draw(dress);
            g2.setColor(dressColor);
            g2.fill(dress);
            g2.setColor(Color.BLACK);
            initPolygon(sleeveX, sleeveY, sleeve);
            g2.draw(sleeve);
            g2.setColor(dressColor);
            g2.fill(sleeve);
            g2.setColor(Color.BLACK);
            initPolygon(neckX, neckY, neck);
            g2.draw(neck);
            g2.setColor(skinColor);
            g2.fill(neck);
            g2.setColor(Color.BLACK);
            initPolygon(hairX, hairY, hair);
            g2.draw(hair);
            g2.setColor(Color.BLACK);
            g2.fill(hair);
            g2.setColor(Color.BLACK);
            initPolygon(headX, headY, head);
            g2.draw(head);
            g2.setColor(skinColor);
            g2.fill(head);
            g2.setColor(Color.BLACK);
            initPolygon(leftLegX, leftLegY, leftLeg);
            g2.draw(leftLeg);
            g2.setColor(skinColor);
            g2.fill(leftLeg);
            g2.setColor(Color.BLACK);
            initPolygon(rightLegX, rightLegY, rightLeg);
            g2.draw(rightLeg);
            g2.setColor(skinColor);
            g2.fill(rightLeg);
            g2.setColor(Color.BLACK);
            initPolygon(leftBootX, leftBootY, leftBoot);
            g2.draw(leftBoot);
            g2.setColor(bootsColor);
            g2.fill(leftBoot);
            g2.setColor(Color.BLACK);
            initPolygon(rightBootX, rightBootY, rightBoot);
            g2.draw(rightBoot);
            g2.setColor(bootsColor);
            g2.fill(rightBoot);
            g2.setColor(Color.BLACK);
            Ellipse2D leftEyeD = new Ellipse2D.Double(headX[1]*size/4 + constshift + this.x + 2*size/4, headY[3]*size/4 + constshift + this.y+ 2*size/4, 1*size/4, 1*size/4);
            g2.draw(leftEyeD);
            g2.fill(leftEyeD);
            Ellipse2D rightEyeD = new Ellipse2D.Double(headX[5]*size/4 + constshift + this.x - 2*size/4, headY[3]*size/4 + constshift + this.y+ 2*size/4, 1*size/4, 1*size/4);
            g2.draw(rightEyeD);
            g2.fill(rightEyeD);
            initPolygon(mouthX, mouthY, mouth);
            g2.draw(mouth);
            initPolygon(rightArmX, rightArmY, rightArm);
            g2.draw(rightArm);
            g2.setColor(skinColor);
            g2.fill(rightArm);
            g2.setColor(Color.BLACK);
            initPolygon(wristX, wristY, wrist);
            g2.draw(wrist);
            g2.setColor(skinColor);
            g2.fill(wrist);
            g2.setColor(Color.BLACK);
            initPolygon(cupX, cupY, cup);
            g2.draw(cup);
            g2.setColor(cupColor);
            g2.fill(cup);
            g2.setColor(Color.BLACK);
            g2.setColor(borderColor);
            if(needBorder) g2.draw(borderRectangle);
            g2.setColor(Color.BLACK);
        }
    }
}
