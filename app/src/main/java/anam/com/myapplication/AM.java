package anam.com.myapplication;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;

/**
 * Created by Anam Sadiq on 22-02-2016.
 */
public class AM implements ActionMode.Callback  {

    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
// TODO Auto-generated method stub
        return false;
    }

    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
// TODO Auto-generated method stub
        mode.getMenuInflater().inflate(R.menu.context, menu);

        return true;
    }

    public void onDestroyActionMode(ActionMode mode) {
// TODO Auto-generated method stub

    }

   public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
// TODO Auto-generated method stub
        return false;
    }

    public void onItemCheckedStateChanged(ActionMode arg0, int arg1, long arg2,
                                          boolean arg3) {
// TODO Auto-generated method stub

    }

}
