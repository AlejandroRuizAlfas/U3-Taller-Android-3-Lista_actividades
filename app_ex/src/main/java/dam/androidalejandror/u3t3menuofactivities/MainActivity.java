package dam.androidalejandror.u3t3menuofactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdaptador.OnItemClickListener{

    private RecyclerView recyclerViewCantante;
    private RecyclerViewAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI() {
        recyclerViewCantante = (RecyclerView) findViewById(R.id.recyclerCantante);
        recyclerViewCantante.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new RecyclerViewAdaptador(obtenerVersiones());
        recyclerViewCantante.setAdapter(adaptador);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeItem(adaptador));
        itemTouchHelper.attachToRecyclerView(recyclerViewCantante);
    }

    @Override
    public void onItemClick(String activityName) {
        Toast.makeText(this, activityName,Toast.LENGTH_LONG).show();

        String value= this.getClass().getName();
        Intent i = new Intent(this,ItemDetailActivity.class);
        i.putExtra("key",value);
        startActivity(i);
    }

    public ArrayList<Item> obtenerVersiones(){
        ArrayList<Item> item = new ArrayList<>();
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