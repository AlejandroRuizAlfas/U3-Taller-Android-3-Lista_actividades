package dam.androidalejandror.u3t3menuofactivities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(String activityName);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView version, api, name;
        ImageView icon;


        public ViewHolder(View itemView, ArrayList<Item> versionList) {
            super(itemView);
            version = (TextView) itemView.findViewById(R.id.tvVersion);
            api = (TextView) itemView.findViewById(R.id.tvAPI);
            name = (TextView) itemView.findViewById(R.id.tvName);
            icon = (ImageView) itemView.findViewById(R.id.logo);

            //TODO Ejericicio1 sendIntentOnCLick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    int clickPosition = getAdapterPosition();
                    Item item = versionList.get(clickPosition);
                    intent.putExtra("version", item);
                    context.startActivity(intent);
                }
            });
        }


    }

    public ArrayList<Item> versionList;


    public MyAdapter(ArrayList<Item> versionList) {
        this.versionList = versionList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_version,parent,false);
        ViewHolder viewHolder = new ViewHolder(view,versionList);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.version.setText(versionList.get(position).getVersion());
        holder.api.setText(versionList.get(position).getApi());
        holder.name.setText(versionList.get(position).getName());
        holder.icon.setImageResource(versionList.get(position).getIcon());
    }

    @Override
    public int getItemCount(){
        return versionList.size();
    }

    //TODO Ejercicio4 deleteItem
    public void deleteItem(int position){
        this.versionList.remove(position);
        notifyItemRemoved(position);
    }
}
