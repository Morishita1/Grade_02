package com.biz.grade.service;

import java.util.Random;
import java.util.Scanner;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_02 implements ScoreService {

	
	
	
	
	
	ScoreVO[] scArray;
	Random rnd;
	Scanner scan;
	
	/*
	 * 생성자가 매개변수를 달리해서
	 * 중복되어 만들어지고 있다.
	 * 이렇게 되면
	 * 생성자에서 실행할 코드들이
	 * 같은코드가 반복되는 불편한 상황이 된다.
	 * 
	 * 매개변수가 없는 생성자에서
	 * 매개변수(배열의 개수)가 있는 생성자를 호출할수 있는
	 * 방법이 있으면 좋겠다!!!
	 */
	
	public ScoreServiceImp_02() {
//		scArray=new ScoreVO[10];
//		scan=new Scanner(System.in);
//		rnd =new Random();
		// 나자신에게 10이란 값을 전달하는 생성자를 호출하라
		// 매개변수가 있는 생성자를 호출하는 코드
		this(10);
	}
	
	
	// 배열의 개수를 매개변수로 받는 생성자
	public ScoreServiceImp_02(int arrLen) {
		scArray=new ScoreVO[arrLen];
		for(int i=0;i<scArray.length;i++) {
			scArray[i]=new ScoreVO();
		}
		scan=new Scanner(System.in);
		rnd=new Random();
	}
	
	/*
	 * 키보드에서 성적을 입력받아서 scArray추가
	 * --END 문자열을 입력받으면 입력 종료
	 */

	@Override
	public boolean inputScore(int number) throws NumberFormatException {
			System.out.println("국어점수>(종료--END)");
			String strKor=scan.nextLine();
			if(strKor.equals("--END"))return true;
			int intKor=Integer.valueOf(strKor);
			System.out.println("영어점수>");
			String strEng=scan.nextLine();
			int intEng=Integer.valueOf(strEng);
			System.out.println("수학점수>");
			String strMath=scan.nextLine();
			int intMath=Integer.valueOf(strMath);
			
			ScoreVO vo= new ScoreVO();
			vo.setKor(intKor);
			vo.setEng(intEng);
			vo.setMatn(intMath);
		
			scArray[number]=vo;
		
		return false;
	}

	@Override
	public void total() {

		for(ScoreVO vo:scArray) {
			int intTotal=vo.getKor();
			intTotal+=vo.getEng();
			intTotal+=vo.getMatn();
			vo.setTotal(intTotal);
			vo.setAcerage(intTotal/3);
		}
		
		
	}

	@Override
	public void rank() {

		// 총점을 기준으로 내림차순 정렬을 수행
		// rank 값을 대입해준다.
		
		for(int i=0;i<scArray.length;i++) {
			for(int j=i+1;j<scArray.length;j++) {
				if(scArray[i].getTotal() < scArray[j].getTotal()) {
					ScoreVO _t=scArray[i];
					scArray[i]=scArray[j];
					scArray[j]=_t;
				}
			}
			
		}

		int rank=0;
		for(ScoreVO vo: scArray) {
			vo.setRank(++rank);
		}
	}
	@Override
	public void viewList() {

		System.out.println("빅데이터반 성적표");
		System.out.println("=====================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t석차");
		for(ScoreVO vo:scArray) {
			
			System.out.print(vo.getNumber()+"\t");
			System.out.print(vo.getKor()+"\t");
			System.out.print(vo.getEng()+"\t");
			System.out.print(vo.getMatn()+"\t");
			System.out.print(vo.getTotal()+"\t");
			System.out.print(vo.getAcerage()+"\t");
			
			// 한줄을 표시한 마지막 출력문은 끝에 \n을붙이거나
			// println()을 사용한다
			System.out.println(vo.getRank()+"\t");
		}
		System.out.println("=====================================================");
	}

	@Override
	public int deptAvg() {

		// 전체학생의 반 평균을 계산
		int avg=0;
		for(ScoreVO vo:scArray) {
			avg+=vo.getAcerage();
		}
		avg/=scArray.length;
		return avg;
	}

	@Override
	public void depAvgView() {
		// TODO Auto-generated method stub

	}



}
