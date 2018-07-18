package fragments.homework.aca.com.viewmodelapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fragments.homework.aca.com.viewmodelapp.R;
import fragments.homework.aca.com.viewmodelapp.holder.UserViewHolder;
import fragments.homework.aca.com.viewmodelapp.item.TodoItem;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder>{

    List<TodoItem> mList;

    public UsersAdapter() {
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_view, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        TodoItem item = mList.get(position);

        holder.getName().setText(item.getName());
        holder.getSurname().setText(item.getSurname());
        holder.getAge().setText(Integer.toString(item.getAge()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addTodoItem(TodoItem item){
        mList.add(item);
        notifyDataSetChanged();
    }

}
