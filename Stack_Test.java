package java0225_Stack_Tr;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Stack_Test {
	private String calEX = "2*3/4-2";
	// 3 12 15 + * 6 2 / -
	private ArrayList<String> newS = new ArrayList<>();
	private Stack mys = new Stack();

	Stack_Test() {
		StringTokenizer st = new StringTokenizer(calEX, "+-*/()", true);
		while (st.hasMoreElements()) {
			String nowToken = st.nextToken();
			switch (nowToken) {
			case "*":
			case "/":
			case "+":
			case "-":
				chkOper(nowToken);
				break;
			case "(":
				mys.push(nowToken);
				break;
			case ")":
				popOper();
				break;
			default:
				newS.add(nowToken);
			}
		}
		popOper();
		System.out.println(Cal_ex);
	}

	private void popOper() {
		while (true) {
			String nowStack = mys.pop();
			if (nowStack.equals("(") || nowStack.equals("Stack empty")) {
				break;
			}
			newS.add(nowStack);
		}
	}

	private void chkOper(String nowToken) { // 연산자 크기 비교로 스택 안에 있는 연산자와 비교 해서 스택 안에 있는 모든 연산자 와 비교 하는 메소드.
		String stackData = mys.pop();
		if (priority(stackData) >= priority(nowToken)) {
			newS.add(stackData);
		} else {
			mys.push(stackData);
		}
		mys.push(nowToken);
	}

	private int priority(String nowToken) { // 우선 순위
		switch (nowToken) {
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 1;
		default:
			return -1;
		}
	}
// 연산자 비교 하는게 
}
