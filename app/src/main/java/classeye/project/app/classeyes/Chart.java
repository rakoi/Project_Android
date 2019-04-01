package classeye.project.app.classeyes;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classeye.project.app.classeyes.Contracts.ChartContract;
import classeye.project.app.classeyes.Presenter.ChartPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chart extends Fragment implements ChartContract.View {

    public RelativeLayout relativeLayout;
    //public String[] xdata=new String[7];//={"OOP","System Analysis","GIS","Systems Programming","Applications Programming","Web Development"};
    //public int[] ydata=new int[7];//={12,6,6,4,6,7,4};

    public ArrayList<String> xdata=new ArrayList<>();
    public ArrayList<Integer> ydata=new ArrayList<>();
    public PieChart mChart;
    public ChartContract.Presenter presenter;


    public Chart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        SharedPreferences sharedPreferences=getContext().getSharedPreferences("classeye", Context.MODE_PRIVATE);
        this.presenter=new ChartPresenter(this,sharedPreferences);
        presenter.passRecords();
        View view=inflater.inflate(R.layout.fragment_extrapage, container, false);



        return view;
    }

    @Override
    public void showRecords(HashMap<String, Integer> records) {

        for (String lessonNames:records.keySet()){
             xdata.add(lessonNames);
            ydata.add(records.get(lessonNames));
        }



        relativeLayout=getView().findViewById(R.id.pieChartLayout);
        mChart=new PieChart(getContext());
        relativeLayout.addView(mChart,600,800);
        mChart.setUsePercentValues(false);
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.rgb(255,239,183));
        mChart.setHoleRadius(3);
        mChart.highlightValue(null);

        ArrayList<PieEntry> entries=new ArrayList<>();
        for(int i=0;i<ydata.size();i++){
           //entries.add(new PieEntry(ydata.get(i),xdata.get(i)));
            if (ydata.get(i)>0){
                entries.add(new PieEntry(ydata.get(i),xdata.get(i)));
            }

        }

        ArrayList<Integer> colors=new ArrayList<>();
        colors.add(Color.rgb(66,133,244));//blue

        colors.add(Color.rgb(219,68,55) );//red
        colors.add(Color.rgb(244,160,0));//yellow
        colors.add(Color.rgb(15,157,88));//green
        colors.add(Color.LTGRAY);

        colors.add(Color.rgb(255,165,0));//orange

        colors.add(Color.MAGENTA);


        PieDataSet dataSet=new PieDataSet(entries,"Attendance");
        dataSet.setColors(colors);
        dataSet.setValueTextSize(11);
        PieData data=new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        mChart.setEntryLabelColor(Color.WHITE);
        mChart.setData(data);
        mChart.getLegend().setWordWrapEnabled(true);
        mChart.invalidate();

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();

    }
}
