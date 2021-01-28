package diiage.potherat.demo.demoapp3.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import dagger.hilt.android.AndroidEntryPoint;
import diiage.potherat.demo.demoapp3.R;
import diiage.potherat.demo.demoapp3.model.Quote;


@AndroidEntryPoint
public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this,getDefaultViewModelProviderFactory()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }
    @Override
    public void onStart() {
        super.onStart();
        //homeViewModel.addQuote();
       homeViewModel.getCount().observe(getViewLifecycleOwner(), count->{
         TextView textViewNumber =  this.getView().findViewById(R.id.txtNumberOfQuotes);
           textViewNumber.setText(count.toString());
       } );
        homeViewModel.getLastQuote().observe(getViewLifecycleOwner(), count->{
            Quote test = new Quote();
            test.setQuote("Bla Bla test");
            test.setSource("Moi");

            TextView textViewNumber =  this.getView().findViewById(R.id.txtQuote);
            TextView TextViewSource =  this.getView().findViewById(R.id.txtSource);
            //textViewNumber.setText(count.getQuote());
            //TextViewSource.setText(count.getSource());

            textViewNumber.setText(test.getQuote());
            TextViewSource.setText(test.getSource());
        } );
        homeViewModel.getDistinct().observe(getViewLifecycleOwner(), count->{
            TextView textViewNumber =  this.getView().findViewById(R.id.txtDistinctSources);
            textViewNumber.setText(count.toString());
        } );
    }
}