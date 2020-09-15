package br.edu.fasam.mobile.nomecomercialdoaplicativo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.fasam.mobile.nomecomercialdoaplicativo.R;

public class PostActivity extends AppCompatActivity {

    EditText txtUserId;
    EditText txtTitle;
    EditText txtBody;
    ListView listViewPost;

    List<HashMap<String, String>> lista = new ArrayList<>(); //pega lista do usuário

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    public void adicionarPost(View view) {

        //Entrada
        txtUserId = findViewById(R.id.txtUserId);
        txtTitle = findViewById(R.id.txtTitle);
        txtBody = findViewById(R.id.txtBody);

        //Processamento
        String userId, title, body;
        userId = txtUserId.getText().toString();
        title = txtTitle.getText().toString();
        body = txtBody.getText().toString();

        //Agora vamos inicar os trabalhos para o SimpleAdapter
        //SimpleAdapter precisa de um List<?> extends Map<Spring. ?>

        /*List<String> bla = new ArrayList<>();
        bla.add("");
        bla.add("");
        bla.add("");
        bla.add("");
        bla.add("");

        HashMap<String,String> map = new HashMap<>();

        map.put("index1","valor1");
        map.put("index2","valor2");
        map.put("index3","valor3");
        map.put("index4","valor4");*/

        HashMap<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("title", title);
        map.put("body", body);

        lista.add(map);

        //Saída

        String[] from = {"userId", "title", "body"}; //chaves do map
        int[] to = {R.id.txtItemUserId, R.id.txtItemTitle, R.id.txtItemBody};//ids do layout do tipo "Item"
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lista, R.layout.item_post, from, to);

        listViewPost = findViewById(R.id.listViewPost);
        listViewPost.setAdapter(simpleAdapter);

    }
}