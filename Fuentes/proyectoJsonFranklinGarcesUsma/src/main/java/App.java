import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {

    static Gson gson=new Gson();
    private File fileJson;
    private static final String jsonFilePath="src/main/resources/User.json";
    public static void main(String[] args) {
        User userTransformation=new App()
                .JsonToUserT();

        System.out.println(String.format("El objeto User *\n%s \n", userTransformation));
        String newJsont = gson.toJson(userTransformation);
        System.out.println(String.format("Tran hacia Json \n%s \n", newJsont));
    }

    public User JsonToUserT(){
        try{
            fileJson=new File(jsonFilePath);
            BufferedReader buffer=new BufferedReader(new FileReader(fileJson));
            String json="";
            String line="";
            while((line=buffer.readLine())!=null){
                json=json+line;
            }
            buffer.close();

            User user=gson.fromJson(json, User.class);
            System.out.println();
            return user;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


}