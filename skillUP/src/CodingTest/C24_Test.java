package CodingTest;

public class C24_Test {

/*    SELECT RANK() OVER (ORDER BY TOTAL DESC, LAST_SOLVED_TIME) RANKING,
    T.*
    FROM (
            SELECT 	U.NAME,
            SUM(Q.SCORE) TOTAL,
    MAX(SUB_SL.SOLVED_DATE) LAST_SOLVED_TIME
    FROM 	SOLVE_LOGS SL
    INNER JOIN (
            SELECT ID, IDX, MAX(SOLVED_DATE) SOLVED_DATE
    FROM SOLVE_LOGS
    WHERE HOUR(SOLVED_DATE) BETWEEN 8 AND 12
    GROUP BY ID, IDX
	) SUB_SL
    ON SL.ID = SUB_SL.ID
    AND SL.IDX = SUB_SL.IDX
    AND SL.SOLVED_DATE = SUB_SL.SOLVED_DATE
    LEFT JOIN USERS U
    ON 			U.ID = SL.ID
    LEFT JOIN QUIZZES Q
    ON 			Q.IDX = SL.IDX
    WHERE SL.SOLVED = 1
    GROUP BY SL.ID, U.NAME
) T
    ORDER BY RANKING*/

    //////////////////////////////////////////////////////////////////////////////////////////////////

/*    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] inputArr = input.split(" ");

    String a = inputArr[0].toUpperCase();
    String b = inputArr[1].toUpperCase();

    String result = "YES";
        for(int i = 0; i < b.length(); i++) {
        if(!a.contains(String.valueOf(b.charAt(i)))) {
            result = "NO";
            break;
        }
    }
        System.out.println(result);*/

    //////////////////////////////////////////////////////////////////////////////////////////////////



}
