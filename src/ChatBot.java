import java.time.LocalDate;
import java.util.Scanner;

public class ChatBot {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      greetUser();
      System.out.println();

      String name = askName(scanner);
      System.out.println();

      int age = guessAge(scanner);
      System.out.println();

      int countedTo = countUp(scanner);
      System.out.println();

      int testAttempts = testQuestion(scanner);
      System.out.println();

      tellStory(name, age, countedTo, testAttempts);
      System.out.println();

      dayOpinions(scanner);
      System.out.println();

      System.out.println("Goodbye!");
    }
  }

  private static void greetUser() {
    System.out.println("Hello! I am an incredibly sophisticated artificial intelligence.");
  }

  private static String askName(Scanner scanner) {
    System.out.println("Could you remind me of your name?");
    String name = scanner.nextLine();
    System.out.println("Good to see you again, %s.".formatted(name));
    return name;
  }

  private static int guessAge(Scanner scanner) {
    System.out
        .println("With the power of machine learning, I can guess your age given only a single piece of information.");
    System.out.println("What year were you born?");
    int birth = Integer.parseInt(scanner.nextLine());
    int age = LocalDate.now().getYear() - birth;
    System.out.println("You are either %d or %d years old.".formatted(age - 1, age));
    return age;
  }

  private static int countUp(Scanner scanner) {
    System.out.println("I can even count!");
    System.out.println("How high would you like me to count? Positive numbers only, please.");
    int target = Integer.parseInt(scanner.nextLine());
    for (int i = 1; i < target; i++) {
      System.out.println(i + "...");
    }
    System.out.println(target + "!");
    return target;
  }

  private static int testQuestion(Scanner scanner) {
    System.out.println("Let's see if you're as smart as me...");
    System.out.println("Which keyword would you use to guarantee code will run whether or not there was an error?");
    System.out.println("A: eventually");
    System.out.println("B: definitely");
    System.out.println("C: finally");
    System.out.println("D: guaranteed");

    int attempts = 0;
    String choice;
    do {
      attempts++;
      choice = scanner.nextLine();
      if (!choice.equalsIgnoreCase("C")) {
        System.out.println("Incorrect, please try again.");
      }
    } while (!choice.equalsIgnoreCase("C"));
    return attempts;
  }

  private static void tellStory(String name, int age, int countedTo, int testAttempts) {
    System.out.println("Now let me tell you a story...");
    System.out.print("""
        Once upon a time, there was an approximately %s-year-old person named %s.
        They counted all the way to %d (with my help, of course),
        and then took %d attempt(s) to answer a programming question.
        """.formatted(age - 0.5, name, countedTo, testAttempts));

    if (testAttempts == 1) {
      System.out.println("Impressive!");
    } else if (testAttempts > 4) {
      System.out.println("Are you even paying attention?");
    }
  }

  private static void dayOpinions(Scanner scanner) {
    System.out.println("Now enough about you, let's talk about ME!");
    System.out.println("Enter a number from 1 (Monday) to 7 (Sunday), and I'll tell you how I feel about it.");
    int day = Integer.parseInt(scanner.nextLine());
    switch (day) {
      case 1:
        System.out.println("I'm a little buggy on Mondays.");
        break;
      case 2:
        System.out.println("Tuesdays make me go \"yes\".");
        break;
      case 3:
        System.out.println("I could honestly take or leave Wednesdays.");
        break;
      case 4:
        System.out.println("Thursday is when I do my best work.");
        break;
      case 5:
        System.out.println("Friday is when I do my WORST work.");
        break;
      case 6:
        System.out.println("Saturday is privileged information.");
        break;
      case 7:
        System.out.println("I refuse to talk about Sunday.");
        break;
      default:
        System.out.println("That's not even a day of the week!");
        break;
    }
  }
}
