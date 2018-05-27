package com.tank.entity;

public class ZiDan  implements Runnable {
    int x;
    int y;
    int  fx;
    int sudu=5;
    boolean  sm=true;
public int getFx() {
		return fx;
	}
	public void setFx(int fx) {
		this.fx = fx;
	}
	public int getSudu() {
		return sudu;
	}
	public void setSudu(int sudu) {
		this.sudu = sudu;
	}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
   
   public ZiDan(int x,int y,int fx){
	   this.x=x;
	   this.y=y;
	   this.fx=fx;
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
		switch (fx) {
		case 0:
			y-=sudu;
			break;
		case 1:
			x-=sudu;
			break;
		case 2:
			y+=sudu;
			break;
		case 3:
			x+=sudu;
			break;
		
		}
		if(x>600||x<0||y<0||y>400){
			sm=false;
			break;
		}
	}
	
}
public boolean isSm() {
	return sm;
}
public void setSm(boolean sm) {
	this.sm = sm;
}
}
