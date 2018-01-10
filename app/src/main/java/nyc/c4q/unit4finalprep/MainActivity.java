package nyc.c4q.unit4finalprep;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.unit4finalprep.controller.BookAdapter;
import nyc.c4q.unit4finalprep.model.BookModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<BookModel> bookListResponse = new ArrayList<>();
    Librarian librarian = new Librarian();
    BookAdapter bookAdapter;
    Button buttonFragment;
    FrameLayout fragmentContainer;

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retroStuff();

        fragmentContainer = findViewById(R.id.fragment_container);

        AdFragment adFragment = new AdFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, adFragment);
        fragmentTransaction.commit();

        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);



    }
    public void retroStuff(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookInterface bookInterface = retrofit.create(BookInterface.class);
        Call<List<BookModel>> bookModelCall = bookInterface.getBooks();
        bookModelCall.enqueue(new Callback<List<BookModel>>() {
            @Override
            public void onResponse(Call<List<BookModel>> call, Response<List<BookModel>> response) {
                bookListResponse = response.body();
                Log.e("onRESPONSE!!!!!", bookListResponse.toString());
                bookAdapter = new BookAdapter(bookListResponse);
                recyclerView.setAdapter(bookAdapter);

            }

            @Override
            public void onFailure(Call<List<BookModel>> call, Throwable t) {
                Log.e("Fail", "fail" + t.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.alphabetical:
                sortAlphabetical();
                return true;
            case R.id.cart:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void sortAlphabetical(){
        for (int i = bookListResponse.size(); i > 0; i--) {

            int lastObject = 0;

            for (int j = 0; j < i; j++) {

                if(bookListResponse.get(j).getName().compareTo(bookListResponse.get(lastObject).getName()) > 0){
                    lastObject = j;
                }
            }
            BookModel temp = bookListResponse.get(lastObject);
            bookListResponse.set(lastObject, bookListResponse.get(i - 1));
            bookListResponse.set(i-1, temp);
            bookAdapter.notifyDataSetChanged();
        }
    }
    public void VisibilityButton(View view){
        buttonFragment = findViewById(R.id.fragment_button);
        fragmentContainer.setVisibility(View.GONE);
    }


}
