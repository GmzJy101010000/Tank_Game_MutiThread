package com.tank.entity;

public class Tank {
  int x;
  int y;
  int fx;
  boolean sm=true;
public boolean isSm() {
	return sm;
}
public void setSm(boolean sm) {
	this.sm = sm;
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
public int getFx() {
	return fx;
}
public void setFx(int fx) {
	this.fx = fx;
}


  public Tank (int x,int y){
	  this.x=x;
	  this.y=y;
  }
}
