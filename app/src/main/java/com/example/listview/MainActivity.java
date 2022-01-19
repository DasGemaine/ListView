package com.example.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Warhammer of Sealed Souls", "Whisper of Dark", "Whistle", "Sandworm", "Thunder Sword", "Varkolyn Assault Rifle"};
    String sTitle[] = {"When fully charged, it consumes energy and creates a large laser which swings 120° in front of the player and damages enemies caught in the area of effect at the rate of 3 times per second.",
    "Laser-based explosion, May spawn a Skeleton mercenary", "Changes mercenaries' behaviors", "Shockwave attack",
    "When the blade hits a target, it will summon a lightning strike that hits the target. The lightning can bounce from enemy to enemy in a certain range until up to 5 times.",
    "This weapon has two modes which can be switched using the extra button."};
    int images[] = {R.drawable.warhammer, R.drawable.whisperofdark, R.drawable.peluit, R.drawable.wormsand,
            R.drawable.thundersword, R.drawable.varkolyn};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         listView = findViewById(R.id.listView);

         MyAdapter adapter = new MyAdapter(this, mTitle, sTitle, images);
         listView.setAdapter(adapter);



         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 if (i == 0){
                     Toast.makeText(MainActivity.this, "When fully charged, it consumes energy and creates a large laser which swings 120° in front of the player and damages enemies caught in the area of effect at the rate of 3 times per second.", Toast.LENGTH_SHORT).show();
                 }

                 if (i == 0){
                     Toast.makeText(MainActivity.this, "Laser-based explosion, May spawn a Skeleton mercenary", Toast.LENGTH_SHORT).show();
                 }

                 if (i == 0){
                     Toast.makeText(MainActivity.this, "Changes mercenaries' behaviors", Toast.LENGTH_SHORT).show();
                 }

                 if (i == 0){
                     Toast.makeText(MainActivity.this, "Shockwave attack", Toast.LENGTH_SHORT).show();
                 }

                 if (i == 0){
                     Toast.makeText(MainActivity.this, "When the blade hits a target, it will summon a lightning strike that hits the target. The lightning can bounce from enemy to enemy in a certain range until up to 5 times.", Toast.LENGTH_SHORT).show();
                 }

                 if (i == 0){
                     Toast.makeText(MainActivity.this, "This weapon has two modes which can be switched using the extra button.", Toast.LENGTH_SHORT).show();
                 }
             }
         });
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String name[];
        String effects[];
        int Imgs[];

        MyAdapter(Context c, String title[], String subTitle[], int imgs[]){
            super(c, R.layout.row, R.id.mTitle, title);
            this.context = c;
            this.name = title;
            this.effects = subTitle;
            this.Imgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent,false);
            ImageView itemimages = row.findViewById(R.id.image);
            TextView itemname = row.findViewById(R.id.mTitle);
            TextView itemeffect = row.findViewById(R.id.sTitle);

            itemimages.setImageResource(Imgs[position]);
            itemname.setText(name[position]);
            itemeffect.setText(effects[position]);

            return row;
        }
    }
}