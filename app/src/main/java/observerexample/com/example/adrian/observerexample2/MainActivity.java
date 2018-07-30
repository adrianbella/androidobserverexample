package observerexample.com.example.adrian.observerexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            SubjectFragment thirdFragment = new SubjectFragment();
            ObserverFragment secondFragment = new ObserverFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            thirdFragment.setArguments(getIntent().getExtras());
            secondFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, thirdFragment).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, secondFragment).commit();

            //register the observer to catch toggle button state changes
            thirdFragment.register(secondFragment);
        }
    }
}
