import java.io.IOException;
import java.util.*;

public class QuickName {

    static Random random = new Random();
    static Scanner s = new Scanner(System.in);
    static boolean exit = true;

    public static void main(String[] args) throws IOException {
        String finalResult = "";
        while(exit==true) {
            menu(finalResult);
        }
        System.out.println("Goodbye");
    }

    public static void generateName(){
        List<String> vowel = new ArrayList<>(List.of("a","e","i","o","u","y"));
        List<String> consonants = new ArrayList<>(List.of("sh","tr","st","lk","kl","br","ch","jt","fr","gr","hn","pr","vn","rf"));
        List<String> letters = new ArrayList<>(List.of("b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","w","x","z","v"));

        System.out.print("Name length: ");
        int nameLength = 0;
        nameLength = s.nextInt();
        while(nameLength <= 0) {
            System.out.print("Length cant be 0 or lower. Type again: ");
            nameLength = s.nextInt();
        }

        List<String> generatedName = new ArrayList<>();

        for(int i = 0; i < nameLength; i++){
            generatedName.add(randomString(letters));
            generatedName.add(randomString(letters));
            generatedName.add(randomString(vowel));
            generatedName.add(randomString(vowel));
        }

        generatedName.remove(randomIntFromArray(generatedName));
        Collections.shuffle(generatedName);
        showFinalResult(generatedName);
    }

    public static void menu(String finalResult) throws IOException {
        int answer = 0;
        List<String> generatedName = new ArrayList<>();
        System.out.println("What do you want to do?\n1. Save name 2. Shuffle letters 3. Generate name 4. Exit");
        answer = s.nextInt();

        if (answer == 1) {
            SaveName.saveNameToFile(finalResult);
            System.out.println("Zapisano");
        } else if(answer == 2) {
            shuffleLetters(generatedName);
            showFinalResult(generatedName);
            menu(finalResult);
        } else if(answer == 3){
            generateName();
            showFinalResult(generatedName);
        }else{
            exit = false;
        }
    }

    public static void shuffleLetters(List<String> generatedName){
        Collections.shuffle(generatedName);
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

    public static void showFinalResult(List<String> generatedName){
        String result = "";
        for(String s : generatedName){
            result+=s;
        }

        String finalResult = makeFirstLetterUppercase(result);
        //String finalResult = result;

        System.out.println("Result: " + finalResult);
    }
}
