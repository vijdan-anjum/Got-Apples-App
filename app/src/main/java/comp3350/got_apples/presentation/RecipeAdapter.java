package comp3350.got_apples.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import comp3350.got_apples.R;
import comp3350.got_apples.logic.RecipeHandler;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.objects.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    Context context;
    String[] title;
    int[] image;
    RecipeHandler recipeHandler = new RecipeHandler(true);
    CurrentUser currentUser;
    ArrayList<ArrayList<Recipe>> matchedLists;

    public RecipeAdapter(Context ct, String[] recipeTitles, int[] img, CurrentUser currentUser, ArrayList<ArrayList<Recipe>> matchedLists) {
        context = ct;
        title = new String[0];
        title = new String[recipeTitles.length];
        title = recipeTitles;
        image = img;
        this.currentUser = currentUser;
        this.matchedLists = matchedLists;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rows, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {

            //it will set the text to the screen from the array
            holder.title1.setText(title[position]);
            //it will set the images to the screen from the image array
            holder.img.setImageResource(image[position]);

            holder.cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), RecipeDescriptionActivity.class);
                    Recipe intentRecipe = recipeHandler.getRecipe(holder.title1.getText().toString(),matchedLists);
                    intent.putExtra(CurrentUser.USER_TAG,intentRecipe);
                    v.getContext().startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    //this will be view holder to show the things on the screen.
    public class RecipeViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title1;
        RecyclerView recycle;
        CardView cv;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.recipe_image);
            title1 = (TextView) itemView.findViewById(R.id.recipe_title);
            recycle = itemView.findViewById(R.id.recycler_list_holder);
            cv = itemView.findViewById(R.id.recycler_cardView);
        }
    }
}
