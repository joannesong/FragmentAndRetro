package nyc.c4q.unit4finalprep.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.unit4finalprep.R;
import nyc.c4q.unit4finalprep.model.BookModel;

/**
 * Created by joannesong on 1/10/18.
 */

public class BookView extends RecyclerView.ViewHolder {
    TextView title;
    TextView author;
    TextView price;
    TextView id;

    public BookView(View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        author = itemView.findViewById(R.id.author);
        price = itemView.findViewById(R.id.price);
        id = itemView.findViewById(R.id.id);
    }
    public void onBind(BookModel bookModel){
        title.setText(bookModel.getName());
        author.setText(bookModel.getAuthor());
        price.setText(String.valueOf(bookModel.getPrice()));
        id.setText(bookModel.getId());
    }
}
