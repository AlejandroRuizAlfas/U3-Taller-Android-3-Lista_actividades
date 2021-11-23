package dam.androidalejandror.u3t3menuofactivities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(item.getWiki()));
                startActivity(browserIntent);
            }
        });

        version.setText(item.getVersion());
        api.setText(item.getApi());
        name.setText(item.getName());
        year.setText(item.getYear());
        icon.setImageResource(item.getIcon());
    }
}