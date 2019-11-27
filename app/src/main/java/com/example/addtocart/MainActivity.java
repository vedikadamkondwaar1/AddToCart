package com.example.addtocart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProductAdapter.CallBackUs, ProductAdapter.HomeCallBack {

        public static ArrayList<ProductModel> arrayList = new ArrayList<>();
        public static int cart_count = 0;
        ProductAdapter productAdapter;
        RecyclerView productRecyclerView;
        int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extra=getIntent().getExtras();

        if(extra!=null)
        {
            key=extra.getInt("type");
        }
        switch (key) {
            case 1:
                addJuiceProduct();
                break;
            case 2:
                addMilkShake();
                break;
        }
        productAdapter = new ProductAdapter(arrayList, this,  this);
        productRecyclerView = findViewById(R.id.product_recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1, LinearLayoutManager.VERTICAL, false);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        productRecyclerView.setAdapter(productAdapter);

    }

    private void addMilkShake() {
        ProductModel productModem = new ProductModel("Chikoo", "60", "20", R.drawable.apple);
        arrayList.add(productModem);
        ProductModel productModem1 = new ProductModel("Apple", "60", "10", R.drawable.allfrouit);
        arrayList.add(productModem1);
        ProductModel productModem2 = new ProductModel("Rose", "60", "10", R.drawable.apple2);
        arrayList.add(productModem2);
        ProductModel productModem3 = new ProductModel("Vanilla", "60", "20", R.drawable.broccoli);
        arrayList.add(productModem3);
        ProductModel productModelm2 = new ProductModel("chacolate", "60", "10", R.drawable.cabbage);
        arrayList.add(productModelm2);
        ProductModel productModelm3 = new ProductModel("Mixfruit", "70", "10", R.drawable.carrot);
        arrayList.add(productModelm3);


    }


    private void addJuiceProduct() {
        ProductModel productModel = new ProductModel("apple", "70", "20", R.drawable.apple);
        arrayList.add(productModel);
        ProductModel productModel1 = new ProductModel("orange", "60", "10", R.drawable.carrot);
        arrayList.add(productModel1);
        ProductModel productModel2 = new ProductModel("grapes", "70", "10", R.drawable.cabbage);
        arrayList.add(productModel2);

        ProductModel productModel3 = new ProductModel("pineapple", "70", "20", R.drawable.broccoli);
        arrayList.add(productModel3);
        ProductModel productModel12 = new ProductModel("strawberry", "80", "10", R.drawable.apple2);
        arrayList.add(productModel12);
        ProductModel productModel23 = new ProductModel("papaya", "70", "10", R.drawable.allfrouit);
        arrayList.add(productModel23);

        ProductModel productModel4 = new ProductModel("mango", "70", "20", R.drawable.cauliflower);
        arrayList.add(productModel4);

    }
    @Override
    public void addCartItemView() {
        //addItemToCartMethod();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(MainActivity.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.cart_action:
                if (cart_count < 1) {
                    Toast.makeText(this, "there is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, CartActivity.class));
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }

    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();
    }

}

