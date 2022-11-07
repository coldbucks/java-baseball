package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.create();
        application.plyerNuber();
        application.check();
    }

    //컴퓨터 임의의 숫자 3개
    public List<Integer> create() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("컴퓨터 숫자= " + computer);
        return computer;
    }

    // 플레이어 입력값
    public List<Integer> plyerNuber() {
        System.out.println("숫자를 입력하세요");
        String userNum = Console.readLine();
        String[] s = userNum.split("");
        List<Integer> playerNum = new ArrayList<>();
        for (int i = 0; i < userNum.length(); i++) {
            playerNum.add(Integer.parseInt(s[i]));
        }
        System.out.println("내 숫자= " + playerNum);
        return playerNum;
    }
    public int check(List<Integer> computer, List<Integer> plyerNuber) {
        int result = 0;
        for (int i = 0; i < plyerNuber.size(); i++) {
            if (computer.contains(plyerNuber.get(i))) {
                result += 1;
            }
        }
        return result;
    }
}









