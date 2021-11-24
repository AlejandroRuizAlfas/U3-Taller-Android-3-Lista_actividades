package dam.androidalejandror.u3t3menuofactivities;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
// TODO Ejericico4 - Clase Swipe
public class SwipeItem extends ItemTouchHelper.SimpleCallback {

    RecyclerViewAdaptador adaptador;

    SwipeItem(RecyclerViewAdaptador adaptador){
        super(0, ItemTouchHelper.RIGHT);
        this.adaptador = adaptador;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        this.adaptador.deleteItem(position);
    }
}
