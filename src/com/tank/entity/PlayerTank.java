package com.tank.entity;

import java.util.Vector;

public class PlayerTank  extends Tank{
	int  sudu=5;
     public  ZiDan zd=null;
   public Vector<ZiDan> zi=new Vector<ZiDan>();
	public PlayerTank(int x, int y,int fx) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.fx=fx;
	}
   public void turnleft(){
	   x-=this.sudu;
   }
   public void turnright(){
	   x+=this.sudu;
   }
   public void turnup(){
	   y-=this.sudu;
   }
   public void turndown(){
	   y+=this.sudu;
   }
   
   public  void fashe(){
	   switch (this.fx) {
	case 0:
		zd=new ZiDan(x+9, y-6,0);
		zd.setSudu(8);
		zi.add(zd);
		break;
	case 1:
		zd=new ZiDan(x-6, y+9,1);
		zd.setSudu(8);
		zi.add(zd);
		break;
	case 2:
		zd=new ZiDan(x+9, y+32,2);
		zd.setSudu(8);
		zi.add(zd);
		break;
	case 3:
		zd=new ZiDan(x+32, y+10,3);
		zd.setSudu(8);
		zi.add(zd);
		break;

	}
	   Thread t=new Thread(zd);
	   t.start();
   }
public ZiDan getZd() {
	return zd;
}
public void setZd(ZiDan zd) {
	this.zd = zd;
}
}
