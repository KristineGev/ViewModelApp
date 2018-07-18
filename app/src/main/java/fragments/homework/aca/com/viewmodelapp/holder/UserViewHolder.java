package fragments.homework.aca.com.viewmodelapp.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fragments.homework.aca.com.viewmodelapp.R;

public class UserViewHolder  extends RecyclerView.ViewHolder {

    TextView mName;
    TextView mSurname;
    TextView mAge;

    public UserViewHolder(View itemView) {
        super(itemView);

        mName = itemView.findViewById(R.id.name);
        mSurname = itemView.findViewById(R.id.surname);
        mAge = itemView.findViewById(R.id.age);
    }

    public TextView getName() {
        return mName;
    }

    public void setName(TextView name) {
        mName = name;
    }

    public TextView getSurname() {
    return mSurname;
}

    public void setSurname(TextView surname) {
        mSurname = surname;
    }

    public TextView getAge() {
        return mAge;
    }

    public void setAge(TextView age) {
        mAge = age;
    }
}
