package classeye.project.app.classeyes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecordRecyclerView extends RecyclerView.Adapter<RecordRecyclerView.ViewHolder> {


    public ArrayList<AttendanceRecord> records;
    public Context context;

    public RecordRecyclerView(Context context,ArrayList<AttendanceRecord> records) {
        this.records=records;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_record,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.unitCodeTextView.setText(records.get(position).getUnitCode());
        holder.unitNameTextView.setText(records.get(position).getUnitName());
        holder.lectureName.setText(records.get(position).getLecturer());
        holder.attendance.setText(records.get(position).getAttendance());

    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView unitCodeTextView;
        public TextView unitNameTextView;
        public TextView lectureName;
        public TextView attendance;

        public ViewHolder(View itemView) {
            super(itemView);
            unitCodeTextView=(TextView) itemView.findViewById(R.id.UnitCodeR);
            unitNameTextView=(TextView)itemView.findViewById(R.id.unitNameRecordR);
            lectureName=(TextView)itemView.findViewById(R.id.LecturerNameR);
            attendance=(TextView)itemView.findViewById(R.id.attendanceR);


        }
    }
}
