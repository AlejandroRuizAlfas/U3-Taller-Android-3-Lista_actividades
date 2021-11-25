package dam.androidalejandror.u3t3menuofactivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewVersiones;
    private MyAdapter adaptador;
    private ArrayList<Item> item = new ArrayList<>();
    private ArrayList<Item> itemRestore = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI() {
        recyclerViewVersiones = (RecyclerView) findViewById(R.id.recyclerVersions);
        recyclerViewVersiones.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new MyAdapter(obtenerVersiones());
        recyclerViewVersiones.setAdapter(adaptador);

        //TODO Ejericio4 Main
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeItem(adaptador));
        itemTouchHelper.attachToRecyclerView(recyclerViewVersiones);

        //TODO Ejercicio3 buttonID's / actions
        ImageView empty;
        empty = findViewById(R.id.imgEmpty);
        Button add,del,rest;
        add = findViewById(R.id.btnAdd);
        del = findViewById(R.id.btnDel);
        rest = findViewById(R.id.btnRest);

        add.setOnClickListener(view -> {
            //TODO Ejercicio4 hide image
            empty.setVisibility(View.INVISIBLE);
            item.add(new Item("Version: 13", "API: 32", "Comming Soon! Android 13", R.drawable.a13, "2022", "https://en.wikipedia.org/wiki/Android_(operating_system)"));
            adaptador.notifyDataSetChanged();
        });
        del.setOnClickListener(view -> {
            itemRestore.addAll(item);
            item.clear();
            adaptador.notifyDataSetChanged();
            //TODO Ejercicio4 show image
            empty.setVisibility(View.VISIBLE);
        });
        rest.setOnClickListener(view -> {
            empty.setVisibility(View.INVISIBLE);
            item.addAll(itemRestore);
            itemRestore.clear();
            adaptador.notifyDataSetChanged();
        });

    }

    //TODO Ejercicio2 generar 8 versiones
    public ArrayList<Item> obtenerVersiones(){
        item.add(new Item("Version: 5","API: 21","Lollipop",R.drawable.lollipop,"2014","https://es.wikipedia.org/wiki/Android_Lollipop"));
        item.add(new Item("Version: 6","API: 23","Marshmallow",R.drawable.amarsh,"2015","https://es.wikipedia.org/wiki/Android_Marshmallow"));
        item.add(new Item("Version: 7","API: 24","Nougat",R.drawable.anougat,"2016","https://es.wikipedia.org/wiki/Android_Nougat"));
        item.add(new Item("Version: 8","API: 26","Oreo",R.drawable.oreo,"2017","https://es.wikipedia.org/wiki/Android_Oreo"));
        item.add(new Item("Version: 9","API: 28","Pie",R.drawable.apie,"2018","https://es.wikipedia.org/wiki/Android_Pie"));
        item.add(new Item("Version: 10","API: 29","Android 10",R.drawable.a10,"2019","https://es.wikipedia.org/wiki/Android_10"));
        item.add(new Item("Version: 11","API: 30","Android 11",R.drawable.a11,"2020","https://es.wikipedia.org/wiki/Android_11"));
        item.add(new Item("Version: 12","API: 31","Android 12",R.drawable.a12png,"2021","https://es.wikipedia.org/wiki/Android_12"));

        return item;
    }


}