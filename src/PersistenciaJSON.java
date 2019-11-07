import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaJSON {

    private String nome;

    public PersistenciaJSON(String nome) {
        this.nome = nome;
    }

    public boolean gravarVetor(int[] vetor) {
        try {
            File arq = new File(nome + ".json");
            Gson gson = new Gson();
            gson = new GsonBuilder().create();
            FileWriter writer = new FileWriter(nome + ".json");

            String strJson = gson.toJson(vetor);
            writer.write(strJson);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public int[] ler() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        BufferedReader br = new BufferedReader(new FileReader(nome + ".json"));
        JsonElement jsonElement = jsonParser.parse(br);

        Type type = new TypeToken<int[]>() {
        }.getType();
        return gson.fromJson(jsonElement, type);
    }

}


