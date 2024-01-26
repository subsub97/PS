import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
사람들은 싸지방에 들어왔을때 가장 번호가 작은 자리에 앉는 것이 규칙
준하가 발견한 사실 ? -> 항상 정해진 시간에 사용
모두가 기다리지 않고 싸지방을 이용할 수 있는 최소 개수와 자리별로 몇명의 사람이 사용한지 구하기
이용시작 시각 P 종료 시각 Q
시작 시간이랑 종료 시각이 다른 사람과 겹치는 경우는 없다.
기다리지 않아도 되는 컴터 최소 개수 X 출력
1번 자리부터 X번 자리까지 순서대로 각 자리를 사용한 사람의 수 출력
 */
public class Main {
    public static int MAX_OPEN_TIME = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pq.add(i+1);
        }

        // 입장순,퇴장순으로 정렬하기
        List<Person> sortedStartT = new ArrayList<>(Arrays.asList(people));
        List<Person> sortedEndT = new ArrayList<>(Arrays.asList(people));

        sortedStartT.sort(Comparator.comparingInt(p -> p.startTime));
        sortedEndT.sort(Comparator.comparingInt(p -> p.endTime));


        int maxPcCount = -1; // 최대 컴퓨터 수 저장 변수

        //사용횟수 카운트 배열 생성
        int[] usedNumber = new int[n+1];
        int startIdx = 0;
        int endIdx = 0;

        //싸지방 개장
        for (int i = 0; i <= MAX_OPEN_TIME ; i++) {
            if(i == sortedStartT.get(startIdx).startTime) {
                // 입장시간과 동일한 경우 pc 사용시작
                int curSeatNumber = pq.poll();
                maxPcCount = Math.max(curSeatNumber, maxPcCount);
                sortedStartT.get(startIdx).seatNumber = curSeatNumber; // 앉은 자리 설정
                usedNumber[curSeatNumber] += 1;
                if(startIdx < n-1) startIdx++;

            }
            if(i == sortedEndT.get(endIdx).endTime){
                // 퇴장시간과 동일한 경우 pc 반납
                int closeSeatNumber = sortedEndT.get(endIdx).seatNumber;
                pq.add(closeSeatNumber); // 사용 반납
                if(endIdx < n-1) endIdx++;

            }
        }
        System.out.println(maxPcCount);
        for (int i = 1; i <= maxPcCount ; i++) {
            System.out.print(usedNumber[i] + " ");
        }
    }
}

class Person {
    int startTime;
    int endTime;
    int seatNumber;

    Person(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

