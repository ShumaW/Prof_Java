import java.io.*;

public class Main {
    public static void main(String[] args){

        /*
        1. Создайте файл, используя FileOutputStream,
        с текстом: "This is my first experience when
        I myself work with IO API. I can do everything!"
         */


        // create & input text in file
        try (FileOutputStream fos = new FileOutputStream("myFirstOutputFile.txt")){

            fos.write(("This is my first experience when I myself work with IO API. I can do everything!")
                    .getBytes());


        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

        // read file & output
        try (InputStream fis = new FileInputStream("myFirstOutputFile.txt")) {
            Reader reader1 = new InputStreamReader(fis);

            int data = reader1.read();

            while (data != -1) {
                System.out.print((char) data);
                data = reader1.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}