package com.biz.grade.service;

import java.util.Random;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_01 implements ScoreService {

	
	
	
	
	
	ScoreVO[] scArray;
	Random rnd;
	
	public ScoreServiceImp_01() {
		scArray=new ScoreVO[10];
		rnd =new Random();
	}
	
	
	public ScoreServiceImp_01(int arrLen) {
		scArray=new ScoreVO[arrLen];
		rnd=new Random();
	}
	

	@Override
	public boolean inputScore(int number) throws NumberFormatException {

		// 난수를 만들어서 3개의 성적을 생성
		// 1번 방법
		// 	vo를 하나 생성하고, 값을 setting 한다음
		// 	배열의 number번째에 대입하는 방법
		ScoreVO vo=new ScoreVO();
		int intKor=rnd.nextInt(50)+51;
		int intEng=rnd.nextInt(50)+51;
		int intMath=rnd.nextInt(50)+51;
		vo.setNumber(number+1);
		vo.setKor(intKor);
		vo.setEng(intEng);
		vo.setMatn(intMath);
		scArray[number]=vo;
		
		// 2번 방법
		//  number번째 배열을 ScoreVO로 초기화 하고
		//  각 요소를 setting 하는 방법
		scArray[number]=new ScoreVO();
		scArray[number].setNumber(number+1);
		scArray[number].setKor(intKor);
		scArray[number].setEng(intEng);
		scArray[number].setMatn(intMath);
		
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
