package anam.com.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        registerForContextMenu(findViewById(R.id.myView));
        registerForContextMenu(findViewById(R.id.my));

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Button clickView = (Button) findViewById(R.id.myView);
        clickView.setOnLongClickListener(

                new View.OnLongClickListener() {


                    // Called when the user long-clicks on someView
                    public boolean onLongClick(View view) {

                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "Clicked Item Number 2", Toast.LENGTH_LONG);
                                                toast1.show();


                        AM b = new AM();
                        startActionMode(b);
                        view.setSelected(true);
                        return true;
                    }
                });



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        int id=v.getId();
        if(id==R.id.my) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu2, menu);
        }
        else if(id==R.id.myView) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu3, menu);
        }
    }



    public void showPopUp(View view)
{
    PopupMenu popup = new PopupMenu(this, view);
    MenuInflater inflater = popup.getMenuInflater();
    inflater.inflate(R.menu.menu_main, popup.getMenu());


        final Context context = this;
        PopupMenu.OnMenuItemClickListener listener = new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                //your corresponding code comes here
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        // Do item1 relevant stuff here
                        Toast.makeText(context, "pop", Toast.LENGTH_SHORT).show();

                        return true;
                    default: return false;
                }  }
        };
        popup.setOnMenuItemClickListener(listener);
    popup.show();


}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);






        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            showPopUp(findViewById(R.id.fab));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
