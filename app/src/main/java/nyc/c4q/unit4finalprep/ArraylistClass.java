package nyc.c4q.unit4finalprep;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.unit4finalprep.model.BookModel;

/**
 * Created by joannesong on 1/10/18.
 */

public class ArraylistClass {
    List<String> stringList = new ArrayList<>();
    public void ArrayListMethod(){

        stringList.add("hello");
        stringList.add("dello");
        stringList.add("aello");
        stringList.add("zello");
        stringList.add("tello");
    }
    public void sortAlphabetical(){
        int j;
        boolean is = true;
        String temp;

        while (is) {
            is = false;
            for (j = 0; j < stringList.size()-1; j++) {
                if (stringList.get(j).compareToIgnoreCase(stringList.get(j+1)) > 0) {
                    temp = stringList.get(j);
                    stringList.get(j) = stringList.get(j+!);
                    stringList.get(j+1) = temp;
                    is = true;
                }
            }
        }
    }


}
