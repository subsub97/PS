import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<StringBuilder> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("*");
        list.add(sb);

        n = sc.nextInt();

        ArrayList<StringBuilder> a = drawStar(list,1);
        for(StringBuilder row : a){
            System.out.println(row);
        }

    }

    public static ArrayList<StringBuilder> drawStar(ArrayList<StringBuilder> list,int depth) {
        if (depth == n){
            return list;
        }
        ArrayList<StringBuilder> newList = new ArrayList<>();
        // 바깥쪽 공백 그리기
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(list.get(0).length()+ 2)); // 이전 길이보다 2큰 공백을 문자열을 만든다.
        newList.add(sb); // 첫줄에 공백 추가
        for(StringBuilder row:list){
            //각 중간행들에게 양옆에 공백 추가한다.
            if(row.charAt(0) != ' ') {
                row.insert(0, " ");
                row.append(" ");
            }
            newList.add(row); // 새로운 리스트에 수정된 행 넣어주기
        }
        newList.add(sb); // 마지막 줄에 공백 추가

        // 바깥쪽 별 그리기
        ArrayList<StringBuilder> newList1 = new ArrayList<>();
        // 바깥쪽 별 그리기
        StringBuilder sb1 = new StringBuilder();
        sb1.append("*".repeat(newList.get(0).length()+ 2)); // 이전 길이보다 2큰 공백을 문자열을 만든다.
        newList1.add(sb1); // 첫줄에 별 추가
        for(StringBuilder row1: newList){
            StringBuilder modifiedRow = new StringBuilder(row1); // 복사본 생성
            modifiedRow.insert(0, "*");
            modifiedRow.append("*");

            newList1.add(modifiedRow);
        }
        newList1.add(sb1); // 마지막 줄에 별 추가


        ArrayList<StringBuilder> a = drawStar(newList1,depth+1);
        return a;

    }



}
