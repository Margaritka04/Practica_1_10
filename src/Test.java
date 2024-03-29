import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Стетюха Маргарита, РИБО-04-22, Вариант 1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество файлов для склейки: ");
        String k = scanner.nextLine();
        System.out.println("Введите путь к 1-му файлу :");
        File file = new File(scanner.nextLine());
        Test test = new Test();
        String newFile = test.workLine(Integer.parseInt(k), file);
        test.save(newFile, file);
    }

    public String workLine (int k, File file){
        Scanner scanner = new Scanner(System.in);
        String buffer = "";
        try{
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String text = reader.readLine();
            while (text != null) {
                buffer += text;
                text = reader.readLine();
            }
            buffer += ", ";
            for ( int i=2; i<=k; i++){
                System.out.println("Введите путь к " + i + "-му файлу: ");
                String dir = scanner.nextLine();
                reader = new BufferedReader(new FileReader(dir));
                text = reader.readLine();
                while (text != null) {
                    buffer = buffer + text;
                    text = reader.readLine();
                }
                if (i != k) {
                    buffer += ", ";
                }
            }
            System.out.println(buffer);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return buffer;
    }

    public void save(String newFile, File file){
        BufferedWriter writer;
        try{
            File fileAnswer = new File(file.getAbsoluteFile().getParent() + "/NewText.txt");
            writer = new BufferedWriter(new FileWriter(fileAnswer.getAbsoluteFile()));
            writer.write(newFile);
            writer.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
