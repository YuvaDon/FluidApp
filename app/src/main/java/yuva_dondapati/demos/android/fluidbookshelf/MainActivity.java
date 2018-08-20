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
import yuva_dondapati.demos.android.fluidbookshelf.adapter.ImageAdapter;
import yuva_dondapati.demos.android.fluidbookshelf.model.ImageModel;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView tv;
    GridView gridView;
    int counter =0;
    ArrayList<ImageModel> imageListModel, imageListModel2;
    //images list
    public Integer[] mThumbIds = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6, R.drawable.pic7,
            R.drawable.pic8, R.drawable.pic9, R.drawable.pic10
    };
    //titles list
    public String[] titles = {"Sample NoteBook 01", "Sample NoteBook 02","Sample NoteBook 03","Sample NoteBook 04","Sample NoteBook 05"
            ,"Sample NoteBook 06","Sample NoteBook 07","Sample NoteBook 08","Sample NoteBook 09", "Sample NoteBook 10"
    };
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
         setUpImages();
         setUpToolBar();
         setUpGridView();
    }

    private void setUpImages() {
        imageListModel = new ArrayList();
       for(int i=0; i<10;i++){
           imageListModel.add(new ImageModel(titles[i], mThumbIds[i]));
        }
    }

    private void setUpGridView() {
        gridView = findViewById(R.id.grid_view);
        imageListModel2 = new ArrayList<>();
        adapter = new ImageAdapter(this, imageListModel2);
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
                imageListModel2.add(imageListModel.get(counter));
                adapter.notifyDataSetChanged();
                counter++;
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}

