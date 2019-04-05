package classeye.project.app.classeyes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordRecyclerView extends RecyclerView.Adapter<RecordRecyclerView.ViewHolder> {


    //public ArrayList<AttendanceRecord> records;
    public HashMap<String,Integer>records;
    public Context context;
    public ArrayList<String>unitNames=new ArrayList<>();
    public ArrayList <Integer>attendance=new ArrayList<>();
    public RecordRecyclerView(Context context,HashMap<String,Integer> records) {
        this.records=records;
        this.context=context;
        for (String name : records.keySet()){
            unitNames.add(name);
            attendance.add(records.get(name));
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_record,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Object[] keys=records.keySet().toArray();
        holder.unitNameTextView.setText(unitNames.get(position));

        holder.attendance.setText(attendance.get(position).toString()+" Out of "+12);

    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView unitNameTextView;
        public TextView attendance;

        public ViewHolder(View itemView) {
            super(itemView);
            unitNameTextView=(TextView)itemView.findViewById(R.id.unitNameRecordR);
            attendance=(TextView)itemView.findViewById(R.id.attendanceR);


        }
    }
}
