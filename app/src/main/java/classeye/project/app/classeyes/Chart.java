package classeye.project.app.classeyes;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chart extends Fragment {

    public RelativeLayout relativeLayout;
    public String[] xdata={"OOP","System Analysis","GIS","Systems Programming","Applications Programming","Web Development"};
    public float[] ydata={5,12,12,4,10,11};
    public PieChart mChart;


    public Chart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_extrapage, container, false);

        relativeLayout=view.findViewById(R.id.pieChartLayout);
        mChart=new PieChart(getContext());

        relativeLayout.addView(mChart,700,700);

        mChart.setUsePercentValues(true);
        mChart.setHoleRadius(3);

        ArrayList<PieEntry> entries=new ArrayList<>();

        for(int i=0;i<ydata.length;i++){
            entries.add(new PieEntry(ydata[i],xdata[i]));
        }

        PieDataSet dataSet=new PieDataSet(entries,"Attendance");

        PieData data=new PieData(dataSet);
        dataSet.setSliceSpace(2);
        mChart.setData(data);
        mChart.invalidate();

        return view;
    }

}
