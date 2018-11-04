package skillUP_static;

public class Chicken {

	static int chickenCount = 0;
	static int chicFootCnt = 0;
	
	public int chicCnt() {
		return chickenCount++;
	}
	
	static int chicFoot() {
		return chicFootCnt++;
	}
}
