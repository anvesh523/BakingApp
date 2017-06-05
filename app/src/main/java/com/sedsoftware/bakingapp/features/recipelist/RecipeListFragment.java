package com.sedsoftware.bakingapp.features.recipelist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sedsoftware.bakingapp.R;
import com.sedsoftware.bakingapp.data.model.Recipe;
import java.util.List;
import timber.log.Timber;


public class RecipeListFragment extends Fragment implements RecipeListContract.View {

  private RecipeListContract.Presenter presenter;

  public RecipeListFragment() {
  }

  public static RecipeListFragment newInstance() {
    return new RecipeListFragment();
  }

  @Override
  public void onResume() {
    super.onResume();
    presenter.subscribe();
  }

  @Override
  public void onPause() {
    super.onPause();
    presenter.unsubscribe();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    return inflater.inflate(R.layout.fragment_recipe_list, container, false);
  }

  @Override
  public void setPresenter(@NonNull RecipeListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void showRecipeList(List<Recipe> recipeList) {
    for (Recipe recipe : recipeList) {
      Timber.d(" --- RECIPE: " + recipe.name());
    }
  }

  @Override
  public void showLoadingIndicator(boolean show) {

  }

  @Override
  public void showErrorMessage() {

  }
}
