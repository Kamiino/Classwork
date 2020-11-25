public class FirstClass {
    public static void main(String[] args) {
        String name = "Jet";
        System.out.println("Dark theme is for cool kids");
        System.out.println("Hello " + name + "!");

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        String[] people = {"bill", "billy", "billo", "billa", "bille", "billi", "billu"};
        for (String i : people) {
            System.out.println(i);
        }

        int[][] numbers = {{1,2,3,4},{5,6,7}};
        for (int[] number : numbers) {
            for (int i : number) {
                if (i == 5) {
                    continue;
                }
                System.out.println(i);
            }
        }

        int day = 1;
        switch (day) {
            case 1:
                System.out.println("A Advisory B Lunch EF");
            case 2:
                System.out.println("C Advisory D Lunch G");
        }

    }
}


/*
Entry Point in Java:
if __name__ == "__main__":
    main()
 */