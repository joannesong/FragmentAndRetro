package nyc.c4q.unit4finalprep;

import java.util.List;

import nyc.c4q.unit4finalprep.model.BookModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by joannesong on 1/10/18.
 */

public interface BookInterface {

    @GET("tamingtext/book/master/apache-solr/example/exampledocs/books.json")
    Call<List<BookModel>> getBooks();
}
