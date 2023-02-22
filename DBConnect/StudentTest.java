package HwangJeongHwan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Control c = new Control();
        Simuate simuate = new Simuate(c);

        simuate.start(0);
        c.closeConnection();
    }
}
