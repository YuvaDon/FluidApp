package yuva_dondapati.demos.android.fluidbookshelf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import yuva_dondapati.demos.android.fluidbookshelf.adapter.ImageAdapter;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView tv;
    GridView gridView;
    int counter =0;
    public Integer[] mThumbIds = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6, R.drawable.pic7,
            R.drawable.pic8, R.drawable.pic9, R.drawable.pic10
    };
    public Integer[] mThumbIds2 = {};
     List<Integer> imageList;
    ImageAdapter adapter;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv = findViewById(R.id.toolbar_title);
        setUpToolBar();
        setUpGridView();
    }

    private void setUpGridView() {
        gridView = findViewById(R.id.grid_view);
        imageList = new ArrayList<Integer>(Arrays.asList(mThumbIds2));
        adapter = new ImageAdapter(this, imageList);
        gridView.setAdapter(adapter);
    }

    private void setUpToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv.setText(R.string.app_name);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_button:
              if(counter ==10 ){
                  counter =0;
              }
                imageList.add(imageList.size(),mThumbIds[counter]);
                adapter.notifyDataSetChanged();
                counter++;
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }
}

