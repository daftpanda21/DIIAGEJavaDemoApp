package diiage.potherat.demo.demoapp3.ui.home;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagingSource;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicReference;

import javax.inject.Inject;

import diiage.potherat.demo.demoapp3.dal.repository.QuoteRepository;
import diiage.potherat.demo.demoapp3.model.Quote;

public class HomeViewModel extends ViewModel {

   // private final MutableLiveData<> count;
    private MutableLiveData<String> mText;

    private final QuoteRepository _quoteRepository;

    @Inject
    @ViewModelInject
    public HomeViewModel(QuoteRepository quoteRepository) {
        _quoteRepository = quoteRepository;
        Log.v("AM", String.valueOf(_quoteRepository.getCount()));

       // this.count = new MutableLiveData<>();
        //this.getItems().observe(this, this::updateHeader);

       //Log.v("AM" );
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

    }
    public void addQuote()
    {  Quote test = new Quote();
        test.setQuote("Bla Bla test");
        test.setSource("Moi");
        _quoteRepository.create(test);
    }
    public LiveData<String> getCount()
    {
        return Transformations.map(_quoteRepository.getCount(), quote -> quote.toString());
        //return this._quoteRepository.getCount().observe();
    }
    public LiveData<String> getDistinct()
    {
        return Transformations.map(_quoteRepository.getDistinct(), quote -> quote.toString());
        //return this._quoteRepository.getCount().observe();
    }
    public LiveData<Quote> getLastQuote()
    {
        Quote test = new Quote();
        test.setQuote("Bla Bla test");
        test.setSource("Moi");
       return _quoteRepository.getLastQuote();
    }


    /*
       private void updateHeader(List<Quote> list) {
           Log.v("AM", list.get(0).getQuote());
       }

       private LiveData<List<Quote>> getItems() {
           return _quoteRepository.getAllAgain();
       }
        */
    public LiveData<String> getText() {
        return mText;
    }

}