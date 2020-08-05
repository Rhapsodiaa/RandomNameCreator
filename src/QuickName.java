import java.io.IOException;
import java.util.*;

public class QuickName {

    static Random random = new Random();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int answer = 0;
        while(answer!=3) {
            List<String> vowel = new ArrayList<>(List.of("a","e","i","o","u","y"));
            List<String> consonants = new ArrayList<>(List.of("sh","tr","st","lk","kl","br","ch","jt","fr","gr","hn","pr","vn","rf"));
            List<String> letters = new ArrayList<>(List.of("b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","w","x","z","v"));

            System.out.print("Name length: ");
            int nameLength = s.nextInt();

            List<String> generatedName = new ArrayList<>();
            List<String> chosenConsonants = new ArrayList<>();
            List<String> chosenVowels = new ArrayList<>();

            for(int i = 0; i < nameLength; i++){
                generatedName.add(randomString(letters));
                generatedName.add(randomString(consonants));
                generatedName.add(randomString(vowel));
                generatedName.add(randomString(vowel));
            }

            for(int i = 0; i < nameLength; i++){
            }

    /*        generatedName.addAll(chosenConsonants);
            generatedName.addAll(chosenVowels);*/
            generatedName.remove(randomIntFromArray(generatedName));

            Collections.shuffle(generatedName);

            String result = "";
            for(String s : generatedName){
                result+=s;
            }

            String finalResult = makeFirstLetterUppercase(result);

            System.out.println("Result: " + finalResult);

            System.out.println("Do you want to save this name?\n1. Yes 2. No 3. Exit");

            answer = s.nextInt();
            if (answer == 1) {
                SaveName.saveNameToFile(finalResult);
                System.out.println("Zapisano");
            } else {
            }
        }
        System.out.println("Goodbye");
    }

    public static int randomIntFromArray(List<String> array){
        return random.nextInt((array.size() - 1) - 0 + 1) - 0;
    }

    public static String randomString(List<String> list){
        return list.get(randomIntFromArray(list));
    }

    public static String makeFirstLetterUppercase(String result){
        return result.substring(0,1).toUpperCase() + result.substring(1);
    }
}
