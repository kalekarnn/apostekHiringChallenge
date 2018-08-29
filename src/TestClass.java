import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {

    String input;

    public TestClass(String input) {
        this.input = input;
    }

    int getNearestRightIndex(int index) {

        if (index == input.length())
            return -1;

        for (int i = index + 1; i < input.length(); i++) {
            if (input.charAt(i) == '1')
                return i;
        }

        return -1;
    }

    int getNearestLeftIndex(int index) {

        for (int i = index - 1; i >= 0; i--) {
            if (input.charAt(i) == '1')
                return i;
        }
        return -1;
    }

    void updateForQuery1(int index) {
        if (index != 0 && input.charAt(index - 1) == '0') {
            input = input.substring(0, index) + "1" + input.substring(index + 1);
        }
    }

    public static void main(String args[]) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN

        // Write your code here

        int noOfQuries = Integer.parseInt(line.split(" ")[1]);

        line = br.readLine();
        TestClass testClass = new TestClass(line.replaceAll(" ", ""));

        for (int i = 0; i < noOfQuries; i++) {
            line = br.readLine();
            if (Integer.parseInt(line.split(" ")[0]) == 0) {
                int right = testClass.getNearestRightIndex(Integer.parseInt(line.split(" ")[1]));
                int left = testClass.getNearestLeftIndex(Integer.parseInt(line.split(" ")[1]));
                System.out.println(left + " " + right);
            } else {
                testClass.updateForQuery1(Integer.parseInt(line.split(" ")[1]));
            }
        }
    }
}