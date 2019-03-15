package com.tareas.tarea_03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tareas.tarea_03.beans.ItemProduct;
import com.tareas.tarea_03.tools.Constants;

public class ActivityProduct extends AppCompatActivity {

    EditText title, code, store, location, phone;
    ImageView image;
    Button save, cancel;
    ItemProduct itemProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        title = findViewById(R.id.activity_product_product_title);
        code = findViewById(R.id.activity_product_product_code);
        store = findViewById(R.id.activity_product_product_store);
        location = findViewById(R.id.activity_product_product_location);
        phone = findViewById(R.id.activity_product_product_phone);
        image = findViewById(R.id.activity_product_product_image);
        save = findViewById(R.id.activity_product_save);
        cancel = findViewById(R.id.activity_product_cancel);

        itemProduct = getIntent().getParcelableExtra(Constants.ITEM);

        title.setText(itemProduct.getTitle());
        code.setText(Integer.toString(itemProduct.getCode()));
        store.setText(itemProduct.getStore());
        location.setText(itemProduct.getLocation());
        phone.setText(itemProduct.getPhone());
        image.setImageResource(R.drawable.mac);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemProduct.setTitle(title.getText().toString());
                itemProduct.setCode(Integer.parseInt(code.getText().toString()));
                itemProduct.setStore(store.getText().toString());
                itemProduct.setLocation(location.getText().toString());
                itemProduct.setPhone(phone.getText().toString());

                Intent intent =  new Intent(ActivityProduct.this, MainActivity.class);
                intent.putExtra(Constants.ITEM, itemProduct);
                startActivity(intent);
                finish();
            }
        });


    }
}
