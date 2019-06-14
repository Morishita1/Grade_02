package com.biz.grade.model;

public class ScoreVO {

	private int number;
	private int kor;
	private int eng;
	private int matn;
	
	private int total;
	private int acerage;
	private int rank;
	
	
	
	
	
	
	
	public ScoreVO(int number, int kor, int eng, int matn) {
		super();
		this.number = number;
		this.kor = kor;
		this.eng = eng;
		this.matn = matn;
	}
	public ScoreVO(int number, int kor, int eng, int matn, int total, int acerage, int rank) {
		super();
		this.number = number;
		this.kor = kor;
		this.eng = eng;
		this.matn = matn;
		this.total = total;
		this.acerage = acerage;
		this.rank = rank;
	}
	public ScoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMatn() {
		return matn;
	}
	public void setMatn(int matn) {
		this.matn = matn;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAcerage() {
		return acerage;
	}
	public void setAcerage(int acerage) {
		this.acerage = acerage;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "ScoreVO [number=" + number + ", kor=" + kor + ", eng=" + eng + ", matn=" + matn + ", total=" + total
				+ ", acerage=" + acerage + ", rank=" + rank + "]";
	}
	
	
	
	
	
	
}
