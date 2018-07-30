package observerexample.com.example.adrian.observerexample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ObserverFragment extends Fragment implements Observer {
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final
    Bundle savedInstanceState) {
        textView = (TextView)
                view.findViewById(R.id.textview);
    }

    @Override
    public void update(boolean checked) {
        if (checked) {
            textView.setText("ON");
        } else {
            textView.setText("OFF");
        }
    }
}
