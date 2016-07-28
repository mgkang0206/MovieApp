package info.androidhive.retrofit.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import info.androidhive.retrofit.R;
import info.androidhive.retrofit.adapter.MoviesAdapter;
import info.androidhive.retrofit.model.Movie;
import info.androidhive.retrofit.model.MoviesResponse;
import info.androidhive.retrofit.rest.ApiClient;
import info.androidhive.retrofit.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mgkan on 2016-07-28.
 */
public class DirectorFragment extends Fragment {
  private final static String API_KEY = "066b5be21681680d625cfc96bd6c77af";
  private final static String sort = "vote_average.desc";
  LinearLayoutManager layoutManager;
  Context context;
  private int id;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    context = getActivity();
    id = getArguments().getInt("directorId");

    View inflatedView = inflater.inflate(R.layout.activity_main, container, false);
    if (API_KEY.isEmpty()) {
      Toast.makeText(context, "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
    }

    final RecyclerView recyclerView = (RecyclerView) inflatedView.findViewById(R.id.movies_recycler_view);
    layoutManager =new LinearLayoutManager(context);
    recyclerView.setLayoutManager(layoutManager);

    ApiInterface apiService =
      ApiClient.getClient().create(ApiInterface.class);

    Call<MoviesResponse> call = apiService.getSpielberg(API_KEY,""+id, sort);
    call.enqueue(new Callback<MoviesResponse>() {
      @Override
      public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
        int statusCode = response.code();
        List<Movie> movies = response.body().getResults();
        recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, context));
      }

      @Override
      public void onFailure(Call<MoviesResponse> call, Throwable t) {
        // Log error here since request failed
//        Log.e(TAG, t.toString());
      }
    });
    return inflatedView;
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setRetainInstance(true);
  }
}
