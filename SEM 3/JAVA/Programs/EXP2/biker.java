package EXP2;

import java.util.Scanner;

class Em {
    public static void main(String[] args) {
        float DA, HRA, PF, gr_sal, net_sal;
        float CCA = 240f, PT = 100f;
        Scanner a = new Scanner(System.in);
        System.out.print("enter employee no: ");
        int r = a.nextInt();
        System.out.print("enter your basic: ");
        float f = a.nextFloat();
        System.out.print("enter employee name:");
        String w = a.next();

        DA = (0.7f) * f;
        HRA = (0.3f) * f;
        PF = (0.1f) * f;

        gr_sal = (f + DA + HRA);
        net_sal = (gr_sal - CCA - PT - PF);
        System.out.println("Name: " + w);
        System.out.println("your Gross Salary : " + gr_sal);
        System.out.println("your Net Salary : " + net_sal);
    }
}
