package in.akshatt.SecureDB;

import android.content.Context;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.util.YailList;
import in.akshatt.SecureDB.lib.Hawk;

import java.util.ArrayList;

public class SecureDB extends AndroidNonvisibleComponent {
    private Context context;
    private Hawk hawk;

    public SecureDB(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
        Hawk.init(context).build();
    }

    @SimpleFunction(description = "Returns if SecureDB is ready.")
    public boolean isReady() {
        return Hawk.isBuilt();
    }

    @SimpleFunction(description = "Destroys SecureDB instance.")
    public void DestroyDB() {
        Hawk.destroy();
    }

    @SimpleFunction(description = "Store the given value under the given tag.")
    public void StoreValue(final String tag, final Object valueToStore) {
        Hawk.put(tag, valueToStore);
    }

  /*
  Causes stack size error
   */

//  @SimpleFunction(description = "Store the given list under the given tag.")
//  public void StoreList(final String tag, final YailList list) {
//      ArrayList<Object> arraylist = new ArrayList<>();
//      for (Object o : list) {
//        arraylist.add(o);
//      }
//      Hawk.put(tag, arraylist);
//  }

//  @SimpleFunction(description = "Retrieve the list stored under the given tag.")
//  public YailList GetListWithTag(final String tag) {
//    if(Hawk.get(tag) instanceof ArrayList<?>){
//
//      ArrayList list = Hawk.get(tag);
//      YailList yailList = new YailList();
//      for (Object o : list) {
//        yailList.add(o);
//      }
//      return yailList;
//
//    }else {
//      return null;
//    }
//  }

    @SimpleFunction(description = "Retrieve the value stored under the given tag.")
    public Object GetValueWithTag(final String tag) {
        if (Hawk.get(tag) instanceof ArrayList<?>) {

            ArrayList list = Hawk.get(tag);
            YailList yailList = new YailList();
            for (Object o : list) {
                yailList.add(o);
            }

            return yailList;

        }
        return Hawk.get(tag);
    }


    @SimpleFunction(description = "Retrieve the value stored under the given tag.")
    public Object GetValue(final String tag, final Object valueIfTagNotThere) {
        return Hawk.get(tag, valueIfTagNotThere);
    }

    @SimpleFunction(description = "Clear the entry with the given tag.")
    public void ClearTag(final String tag) {
        Hawk.delete(tag);
    }

    @SimpleFunction(description = "Clear the entire data store.")
    public void ClearAll() {
        Hawk.deleteAll();
    }

    @SimpleFunction(description = "Check if any tag exists.")
    public boolean tagExist(final String tag) {
        return Hawk.contains(tag);
    }

    @SimpleFunction(description = "Check total entry count.")
    public int tagCount() {
        return (int) Hawk.count();
    }

}
