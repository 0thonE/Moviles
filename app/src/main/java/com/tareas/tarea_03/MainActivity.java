package com.tareas.tarea_03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tareas.tarea_03.beans.ItemProduct;
import com.tareas.tarea_03.tools.Constants;

public class MainActivity extends AppCompatActivity {

    CardView cardView ;
    TextView title, code, store, location, phone;
    ImageView image;

    ItemProduct itemProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.activity_main_product_title);
        code = findViewById(R.id.activity_main_product_code);
        store = findViewById(R.id.activity_main_product_store);
        location = findViewById(R.id.activity_main_product_location);
        phone = findViewById(R.id.activity_main_product_phone);
        image = findViewById(R.id.activity_main_product_image);

        if(getIntent().getParcelableExtra(Constants.ITEM)!=null){
            itemProduct = getIntent().getParcelableExtra(Constants.ITEM);

        }else{
            itemProduct = new ItemProduct();

            itemProduct.setTitle("MacBook Pro 17\"");
            itemProduct.setCode(36517);
            itemProduct.setStore("BestBuy");
            itemProduct.setLocation("Zapopan, Jalisco");
            itemProduct.setPhone("33 12345678");
            itemProduct.setImage(0);
        }

        title.setText(itemProduct.getTitle());
        code.setText(Integer.toString(itemProduct.getCode()));
        store.setText(itemProduct.getStore());
        location.setText(itemProduct.getLocation());
        phone.setText(itemProduct.getPhone());
        image.setImageResource(R.drawable.mac);

        cardView = findViewById(R.id.activity_main_card_view);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, ActivityProduct.class);
                intent.putExtra(Constants.ITEM, itemProduct);
                startActivity(intent);
            }
        });



    }
}
