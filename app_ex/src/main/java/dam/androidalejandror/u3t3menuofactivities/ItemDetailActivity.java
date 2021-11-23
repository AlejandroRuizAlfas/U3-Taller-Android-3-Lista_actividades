package dam.androidalejandror.u3t3menuofactivities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        setTitle("Android Detail Version");
        getSupportActionBar().setHomeButtonEnabled(true);
        setUI();
    }

    public void setUI(){
        Item item = (Item) getIntent().getSerializableExtra("version");
        TextView version, api, name, year;
        ImageView icon;
        System.out.println(item);
        version = findViewById(R.id.tvAnVersion);
        api = findViewById(R.id.tvAnAPI);
        name = findViewById(R.id.tvAnNAme);
        year = findViewById(R.id.tvAnYear);
        icon = findViewById(R.id.imgLogo);

        version.setText(item.getVersion());
        api.setText(item.getApi());
        name.setText(item.getName());
        year.setText(item.getYear());
        icon.setImageResource(item.getIcon());
    }
}