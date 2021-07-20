package searchCodingTst.jickbang;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class First {
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * 테스트 대상으로 주어지는 사람 들의 친구관계가 주어질때 서로 친구가 아니면서 함께아는 친구가 가장많은 사람 입력 : 사람수 _ 친구 관계수
	 * 사람 종류 관계 ( 관계수만큼 ) 출력 : 서로 친구가 아니면서 함께아는 사람이 많은 사람 공통친구 수 ㅌ₩
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int maxVal = 0;
		// 1. 입력받기( n 테스트 대상,m 친구관계수 )
		String nm = scanner.nextLine();
		int n = nm.charAt(0) - '0';
		int m = nm.charAt(2) - '0';
		String a = "";
		String b = "";
		

		// 2. 이름 입력받기
		String[] names = scanner.nextLine().split(" ");

		LinkedList<Friend> frs = new LinkedList<Friend>();

		// 3. list 생성
		for (int i = 0; i < names.length; i++) {
			frs.add(new Friend(names[i]));
		}
		// 4. input 친구관계입력, 잔여 친구관계 입력
		while ((m--) > 0) {
			String[] relation = scanner.nextLine().split(" ");
			for (Friend f : frs) {
				if (f.name.equals(relation[0])) {
					Friend temp = new Friend(relation[1]);
					temp.friends.push(new Friend(f.name));
					f.friends.push(temp);
				} else if (f.name.equals(relation[1])) {
					Friend temp = new Friend(relation[0]);
					temp.friends.push(new Friend(f.name));
					f.friends.push(temp);
				}
			}
		}

		// 5. 잔여 친구관계입력
		// System.out.print(fr.get(5).friends.size() +" : "+ fr.get(2).friends.size());
		int value = 1;

		while (value++ <= frs.size()) {
			// 친구인가?
			for (int i = 0; i < names.length; i++) {
				for (int j = i + 1; j < names.length; j++) {
					Friend x = getFriend(frs, names[i]);
					Friend y = getFriend(frs, names[j]);
					if (!isFriends(frs, x, y)) {
						int tempVal = checkKnownPerson(frs, x, y);
						if (tempVal > maxVal) {
							maxVal = tempVal;
							a = x.name;
							b = y.name;
						}
					}
				}
			}
		}
		//사전순으로 
		if(b.compareTo(a) > 0)
			System.out.println(a+" "+b);
		else
			System.out.println(b+" "+a);
		System.out.print(maxVal);
	}

	public static boolean isFriends(LinkedList<Friend> frs, Friend f1, Friend f2) {

		for (Friend fj : f1.friends) {
			if (fj.name.equals(f2))
				return true;
		}

		return false;
	}

	public static int checkKnownPerson(LinkedList<Friend> frs, Friend f1, Friend f2) {
		int result = 0;
		for( Friend a : f1.friends )
			for( Friend b : f2.friends)
				if(a.name.equals(b.name)) {
					result++;
				}
		return result;
	}

	public static Friend getFriend(LinkedList<Friend> frs, String f1) {

		for (Friend fi : frs) {
			if (fi.name.equals(f1))
				return fi;
		}
		return null;
	}
}

class Friend {
	String name;
	LinkedList<Friend> friends;

	Friend(String name) {
		this.name = name;
		this.friends = new LinkedList<Friend>();
	}
}
