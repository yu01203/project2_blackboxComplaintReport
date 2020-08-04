package com.ssafy.domain;

public class Situation {
	private int no;
	private String date;
	private int accident;
	private int report;
	private int handling;

	public Situation() {}
	public Situation(int no, String date, int accident, int report, int handling) {
		this.no = no;
		this.date = date;
		this.accident = accident;
		this.report = report;
		this.handling = handling;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAccident() {
		return accident;
	}

	public void setAccident(int accident) {
		this.accident = accident;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public int getHandling() {
		return handling;
	}

	public void setHandling(int handling) {
		this.handling = handling;
	}

	@Override
	public String toString() {
		return "Situation [no=" + no + ", date=" + date + ", accident=" + accident + ", report=" + report
				+ ", handling=" + handling + "]";
	}
}
