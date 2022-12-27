import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean ischecked = false;

        boolean isPassed = true;
        // boolean isLast=true;
        int[] degisken = new int[2];
        Scanner sc = new Scanner(System.in);

        while (!ischecked) {
            int n;
            System.out.println("*********************************");
            System.out.println("Kare Matris Boyutunu Giriniz....");
            System.out.println("*********************************");
            System.out.print("Matris Boyutu: ");
            n = sc.nextInt();
            int[][] dm = new int[n][n];
            System.out.println();
            System.out.println();
            System.out.println("*********************************");
            System.out.println("Matrisi Degerlerinizi Giriniz: ");
            System.out.println("*********************************");
            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(String.format("%d.satir --- %d.sutun degeri => ", i + 1, j + 1));
                    dm[i][j] = sc.nextInt();
                }
            }
            System.out.println();
            System.out.println();
            System.out.println("*********************************");
            System.out.println("Olusan matrisimiz.....");
            System.out.println("*********************************");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("  " + dm[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            isPassed = true;
            while (isPassed) {
                System.out.println("******************************************************");
                System.out.println("Matriste degistirmek istediginiz bir yer var mi? ");
                System.out.println("******************************************************");
                System.out.println();
                System.out.println("Evet  icin ' y '");
                System.out.println("Hayir icin ' n '");
                System.out.println();
                System.out.print("Cevap: ");
                String ch = sc.next();
                System.out.println();
                if (ch.equals("Y") || ch.equals("y")) {
                    isPassed = true;
                    ischecked = true;

                    System.out.println("Degistirmek istediginiz satir sutunu sirasiyla giriniz");

                    for (int j = 0; j < 2; j++) {
                        if (j == 0) {
                            System.out.println();
                            System.out.println("*****************************");
                            System.out.print("Satir Degerini Giriniz: ");
                            int i = sc.nextInt();
                            System.out.println("*****************************");
                            if (i <= n) {
                                degisken[j] = i;
                            } else {
                                System.out.print("Boyle Bir satir degeri yok !!!");
                            }
                        } else if (j == 1) {
                            System.out.println();
                            System.out.println("*****************************");
                            System.out.print("Sutun Degerini Giriniz: ");
                            int i = sc.nextInt();
                            System.out.println("*****************************");
                            if (i <= n) {
                                degisken[j] = i;
                            } else {
                                System.out.print("Boyle Bir sutun degeri yok !!!");
                            }
                        }
                    }
                    int i = degisken[0];
                    int k = degisken[1];
                    System.out.println("*********************************");
                    System.out.print("Yeni degeri giriniz: ");
                    dm[i - 1][k - 1] = sc.nextInt();
                    System.out.println("*********************************");
                    // System.out.println(dm[1][1]);
                    System.out.println();
                    System.out.println();
                    System.out.println("*********************************");
                    System.out.println("Olusan matrisimiz.....");
                    System.out.println("*********************************");
                    for (int utku = 0; utku < n; utku++) {
                        for (int tutku = 0; tutku < n; tutku++) {
                            System.out.print("  " + dm[utku][tutku]);
                        }
                        System.out.println();
                    }

                } else if (ch.equals("n") || ch.equals("N")) {
                    ischecked = false;
                    isPassed = false;
                    long time = System.currentTimeMillis();
                    Hungarian hungarian = new Hungarian(dm);
                    System.out.println(String.format("Total time: %dms\n", System.currentTimeMillis() - time));

                    int[] result = hungarian.getResult();
                    for (int i = 0; i < result.length; i++)
                        System.out
                                .println(String.format("Satır(%d) => Sütun(%d) (%d)", i + 1, result[i] + 1,
                                        dm[i][result[i]]));
                    // Rowi
                    // =>
                    // Colj
                    // (value)

                    System.out.println(String.format("\nTotal: %d", hungarian.getTotal()));

                }
            }
        }
        sc.close();

    }
}