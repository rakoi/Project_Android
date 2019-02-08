package classeye.project.app.classeyes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Records extends Fragment {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecordRecyclerView adapter;
    public ArrayList<AttendanceRecord> recordList;
    public Records() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_records, container, false);
        recordList=new ArrayList<AttendanceRecord>();
        for (int i=0;i<10;i++){
            recordList.add(new AttendanceRecord("BIT 1121","B.M Kyenge","Systems Programming","1/12"));
        }

        recyclerView=view.findViewById(R.id.recordsRecyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        adapter=new RecordRecyclerView(getContext(),recordList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

}
