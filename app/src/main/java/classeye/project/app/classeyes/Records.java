package classeye.project.app.classeyes;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import classeye.project.app.classeyes.Contracts.CurrentLessonContract;
import classeye.project.app.classeyes.Contracts.RecordsContract;
import classeye.project.app.classeyes.Models.RecordsDataManager;
import classeye.project.app.classeyes.Presenter.RecordsPresenter;
import classeye.project.app.classeyes.root.MyApp;


/**
 * A simple {@link Fragment} subclass.
 */
public class Records extends Fragment  implements RecordsContract.View{

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecordRecyclerView adapter;
    //public ArrayList<AttendanceRecord> recordList;
    public HashMap<String,Integer> recordList=new HashMap<>();

    @Inject
    public RecordsContract.Presenter presenter;

    public Records() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_records, container, false);

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("classeye", Context.MODE_PRIVATE);
       // presenter=new RecordsPresenter(sharedPreferences);

        MyApp.getMyApp().getRecordsComponent().inject(this);

        presenter.setView(this);
        presenter.passRecords();


        recyclerView=view.findViewById(R.id.recordsRecyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        adapter=new RecordRecyclerView(getContext(),recordList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }



    public void setRecordList(HashMap<String, Integer> recordList) {
        this.recordList = recordList;
    }

    @Override
    public void showRecords(HashMap<String, Integer> hashMap) {
        setRecordList(hashMap);
        recyclerView=getView().findViewById(R.id.recordsRecyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        adapter=new RecordRecyclerView(getContext(),recordList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String t) {
        Toast.makeText(getContext(),t,Toast.LENGTH_SHORT).show();
    }
}
