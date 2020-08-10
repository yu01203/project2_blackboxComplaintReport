package com.ssafy.domain;

public class Test {


	private int month;
	private long count;
	
	public Test(int month, long count) {
		this.month = month;
		this.count = count;
	}
	
	
	
	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}



	public long getCount() {
		return count;
	}



	public void setCount(long count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "test [month=" + month + ", count=" + count + "]";
	}
	


}
