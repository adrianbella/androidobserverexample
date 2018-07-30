package observerexample.com.example.adrian.observerexample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class SubjectFragment extends Fragment implements Subject {
    private List<Observer> observers;
    private ToggleButton button;

    public SubjectFragment() {
        observers = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final
    Bundle savedInstanceState) {
        button = (ToggleButton)
                view.findViewById(R.id.toggle_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                notifyObservers();
            }
        });
    }

    @Override
    public void notifyObservers() {
        for (final Observer observer : observers) {
            observer.update(button.isChecked());
        }
    }

    @Override
    public void register(final Observer observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void unregister(final Observer observer) {
        for(final Observer obs : observers){
            obs.update(button.isChecked());
        }
    }
}
