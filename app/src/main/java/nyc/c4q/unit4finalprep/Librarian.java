package nyc.c4q.unit4finalprep;

import android.util.Log;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.List;

import nyc.c4q.unit4finalprep.model.BookModel;

/**
 * Created by joannesong on 1/10/18.
 */

public class Librarian {

    JSONObject jsonObject = new JSONObject();

    public void parseJSONObject(List jsonArr){

        for (int i = 0; i < jsonArr.size(); i++) {
            jsonArr.get(i);
            Log.e("JSON", jsonArr.get(i).toString());

        }
    }
}
