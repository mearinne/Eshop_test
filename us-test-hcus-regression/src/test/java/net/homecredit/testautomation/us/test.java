package net.homecredit.testautomation.us;

import java.util.ArrayList;
import java.util.List;

public class test {


    public static void main(String[] args) {

        int maxVal = 100;
        int minVal = 1;

        for (int i = maxVal; i > minVal - 1; i--) {

            if (i % 5 == 0) {
                System.out.println("Agile");
            }
            if (i % 3 == 0) {
                System.out.println("Software");
            }
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Testing");
            }
            if (i % 5 != 0 && i % 3 != 0 && (i % 3 != 0 && i % 5 != 0)) {
                System.out.println(i);
            }

        }

    }

}
