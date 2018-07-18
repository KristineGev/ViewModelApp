package fragments.homework.aca.com.viewmodelapp.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import fragments.homework.aca.com.viewmodelapp.item.TodoItem;

public class MyViewModel extends ViewModel{

    private final MutableLiveData<TodoItem> mItem = new MutableLiveData<>();

    public LiveData<TodoItem> getItem() {
        return mItem;
    }

    public void setItem(TodoItem item) {
        mItem.setValue(item);
    }
}
