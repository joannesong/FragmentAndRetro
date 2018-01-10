package nyc.c4q.unit4finalprep.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.unit4finalprep.R;
import nyc.c4q.unit4finalprep.model.BookModel;
import nyc.c4q.unit4finalprep.view.BookView;

/**
 * Created by joannesong on 1/10/18.
 */

public class BookAdapter extends RecyclerView.Adapter<BookView> {
    List<BookModel> bookModelList = new ArrayList<>();

    public BookAdapter(List<BookModel> bookModelList) {
        this.bookModelList = bookModelList;
    }

    @Override
    public BookView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_layout, parent, false);
        return new BookView(view);
    }

    @Override
    public void onBindViewHolder(BookView holder, int position) {
        holder.onBind(bookModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return bookModelList.size();
    }
}
