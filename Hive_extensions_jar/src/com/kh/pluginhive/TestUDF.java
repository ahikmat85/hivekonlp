package com.kh.pluginhive;


public class TestUDF {

	public static void main(String[] args) {
		String st= "2탄) 문재인이 제일 한심스러웠던적은\n지가 모두 감수하고 국가기록원에\n넘겼다는 NLL기록이 귀신같이\n사라진것이었지 ㅋㅋㅋ\n봉하능참봉이 제격인데\n비서실장 왕수석을 했으니\n그 기본이 드러날 밖에";
		String out =JNHelper.getInstance().extractNouns(FilterHelper.filter(st));
		
		//String out = ;
		System.out.println("result:"+out);

	}
}
