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
    }
}


/*
Entry Point in Java:
if __name__ == "__main__":
    main()
 */