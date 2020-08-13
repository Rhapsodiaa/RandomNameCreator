import java.io.IOException;
import java.util.*;

public class QuickName {

    static Random random = new Random();
    static Scanner s = new Scanner(System.in);
    static boolean exit = true;

    public static void main(String[] args) throws IOException {

        while(exit==true) {
            menu();
        }
        System.out.println("Goodbye");

    }

    public static void menu() throws IOException {
        int answer = 0;
        List<String> generatedName = new ArrayList<>();
        System.out.println("What do you want to do?\n1. Generate name 2. Exit");
        answer = s.nextInt();

        if (answer == 1) {
            String name = makeName();
            System.out.println("Do you want to save " + name +"? 1. Yes 2. No");
            answer = s.nextInt();
            if(answer==1){
                SaveName.saveNameToFile(name);
                System.out.println("Saved");
            }else {
                menu();
            }
        } else{
            exit = false;
        }
    }

    public static String makeName() {
        List<String> vowel = new ArrayList<>(List.of("a","e","i","o","u","y"));
        List<String> syllables = new ArrayList<>(List.of("sh","tr","st","lk","kl","br","ch","jt","fr","gr","hn","pr","vn","rf"));
        List<String> consonants = new ArrayList<>(List.of("b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","w","x","z","v"));

        System.out.print("Name length: ");
        int nameLength = 0;
        nameLength = s.nextInt();
        while(nameLength <= 0) {
            System.out.print("Length cant be 0 or lower. Type again: ");
            nameLength = s.nextInt();
        }


        List<String> generatedName = new ArrayList<>();
        for(int i = 0; i < nameLength; i++) {
            generatedName.add(randomString(vowel));
        }

        for(int i = 0; i < nameLength; i++) {
            generatedName.add(randomString(consonants));
        }

        for(int i = 0; i < nameLength; i++) {
            generatedName.remove(randomIntFromArray(generatedName));
        }

        Collections.shuffle(generatedName);

        return showFinalResult(generatedName);
    }

    public static String shuffleLetters(List<String> generatedName){
        Collections.shuffle(generatedName);
        return showFinalResult(generatedName);
    }

    public static int randomIntFromArray(List<String> array){
        return random.nextInt((array.size() - 1) - 0 + 1) - 0;
    }

    public static String randomString(List<String> list){
        return list.get(randomIntFromArray(list));
    }

    public static String makeFirstLetterUppercase(String result){
        try {
            return result.substring(0,1).toUpperCase() + result.substring(1);
        } catch(IndexOutOfBoundsException e){
            return result;
        }
    }

    public static String showFinalResult(List<String> generatedName){
        String result = "";
        for(String s : generatedName){
            result+=s;
        }

        String finalResult = makeFirstLetterUppercase(result);

        System.out.println("Result: " + finalResult);
        return finalResult;
    }
}
