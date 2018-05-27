package com.tank.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tank.entity.EnemyTank;
import com.tank.entity.PlayerTank;
import com.tank.entity.ZiDan;

public class TankMain extends JFrame {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
mypanel mb=null;
	 public  static void main(String a[]){
		 new TankMain();
	 }
	public TankMain(){
		mb=new mypanel();
		this.add(mb);
		this.addKeyListener(mb);
		Thread th=new  Thread(mb);
		th.start();
		this.setSize(600, 400);
		this.setLocation(300, 280);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}
class mypanel extends JPanel implements KeyListener,Runnable{

	
	 PlayerTank mt=null;
	 Vector<EnemyTank> dtk=null;
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_A){
			this.mt.setFx(1);
			this.mt.turnleft();
		}
		if(e.getKeyCode()==KeyEvent.VK_D){
			this.mt.setFx(3);
			this.mt.turnright();
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			this.mt.setFx(2);
			this.mt.turndown();
		}
		if(e.getKeyCode()==KeyEvent.VK_W){
			this.mt.setFx(0);
			this.mt.turnup();
		}
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(mt.zi.size()<9){
				this.mt.fashe();
			}
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	public mypanel(){
		dtk=new  Vector<EnemyTank>();
		for(int i=0;i<6;i++){
			EnemyTank e=new  EnemyTank(110*i+5, 0);
			e.setFx(2);
			Thread t=new Thread(e);
			t.start();
			ZiDan zd=new ZiDan(e.getX()+10, e.getY()+30, 2);
			Thread t1=new  Thread(zd);
			t1.start();
			e.getDzd().add(zd);
			dtk.add(e);
		}
		mt=new PlayerTank(300, 300,0);
		
		
	}
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 600, 400);
		g.setColor(Color.black);
		this.drawtank(mt.getX(), mt.getY(), g, mt.getFx(), 0);
		for (int i=0;i<dtk.size();i++){
			if(dtk.get(i).isSm()){
				this.drawtank(dtk.get(i).getX(), dtk.get(i).getY(), g, dtk.get(i).getFx(), 1);
			}
		}
		for(int i=0;i<mt.zi.size();i++){
			ZiDan zd=mt.zi.get(i);
			if(zd!=null&&zd.isSm()==true){
				g.setColor(Color.red);
				g.fill3DRect(zd.getX(), zd.getY(), 5, 5, false);
			}
	  if(zd.isSm()==false){
		mt.zi.remove(zd);
	}
		}
		for(int i=0;i<dtk.size();i++){
			EnemyTank d=dtk.get(i);
			for(int j=0;j<d.getDzd().size();j++){
				ZiDan zd=d.getDzd().get(j);
				if(zd!=null&&zd.isSm()==true){
					g.setColor(Color.white);
					g.fill3DRect(zd.getX(), zd.getY(), 5, 5, false);
					
				}
				if(zd.isSm()==false){
					d.getDzd().remove(zd);
				}
			}
		}
		
	}
	public void drawtank(int x,int y,Graphics g,int fx,int type){
		switch (type) {
		case 0:
			g.setColor(Color.yellow);
			break;
		case 1:
			g.setColor(Color.green);
			break;
			
			
		}
		switch (fx) {
		case 0:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y-3);
			break;
		case 1:
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x-3, y+10);
			break;
		case 2:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y+33);
			break;
		case 3:
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x+33, y+10);
			break;
		}
		
		
	}

	@Override
	public void run() {
         while(true){
        	 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 for(int i=0;i<mt.zi.size();i++){
        		 ZiDan zd=mt.zi.get(i);
        		 if(zd.isSm()){
        			 for (int j=0;j<dtk.size();j++){
        				 EnemyTank dt=dtk.get(j);
        				 if(dt.isSm()){
        					 this.jzdf(zd,dt);        				 }
        			 }
        		 }
        		 
        		 
        	 }
        	 this.repaint();
         }		
	}

	private void jzdf(ZiDan zd, EnemyTank dt) {
		switch (dt.getFx()) {
		case 0:
		case 2:
			if(zd.getX()>dt.getX()&&zd.getX()<dt.getX()+20&&zd.getY()>dt.getY()&&zd.getY()<dt.getY()+30){
				zd.setSm(false);
				dt.setSm(false);
			}
			break;
		case 1:
		case 3:
			if(zd.getX()>dt.getX()&&zd.getX()<dt.getX()+30&&zd.getY()>dt.getY()&&zd.getY()<dt.getY()+20){
				zd.setSm(false);
				dt.setSm(false);
			}
			break;
		}
		
		
		
	}
	
}