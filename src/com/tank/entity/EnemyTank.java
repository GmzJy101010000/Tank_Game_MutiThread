package com.tank.entity;

import java.util.Vector;

public class EnemyTank  extends  Tank implements Runnable{
     int sudu=2;
    int  time=0;
    Vector<ZiDan>  dzd=new Vector<ZiDan>();
	public EnemyTank(int x, int y) {
		super(x, y);
	}
	public int getSudu() {
		return sudu;
	}
	public void setSudu(int sudu) {
		this.sudu = sudu;
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch (this.fx) {
			case 0:
				for(int i=0;i<30;i++){
					if(y>30){
						y-=sudu;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 1:
				for(int i=0;i<30;i++){
					if(x>0){
						x-=sudu;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 2:
				for(int i=0;i<30;i++){
					if(y<400){
						y+=sudu;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 3:
				for(int i=0;i<30;i++){
					if(x<540){
						x+=sudu;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
			this.fx=(int)(Math.random()*4);
			if(this.isSm()==false){
				break;
			}
			this.time++;
			
				
				if(dzd.size()<8){
					ZiDan zd=null;
					switch (this.fx) {
					case 0:
						zd=new ZiDan(x+10, y, 0);
						dzd.add(zd);
						break;
					case 1:
						zd=new ZiDan(x+9, y+32, 2);
						dzd.add(zd);
						break;
					case 2:
						zd=new ZiDan(x+32, y+9, 3);
						dzd.add(zd);
						break;
					case 3:
						zd=new ZiDan(x+10, y, 0);
						dzd.add(zd);
						break;

					}
					Thread th=new Thread(zd);
					th.start();
				
			}
			
		}
		
	}
	public Vector<ZiDan> getDzd() {
		return dzd;
	}
	public void setDzd(Vector<ZiDan> dzd) {
		this.dzd = dzd;
	}
    
}
