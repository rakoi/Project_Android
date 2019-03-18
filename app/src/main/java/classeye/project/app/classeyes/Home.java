package classeye.project.app.classeyes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;

import org.w3c.dom.Text;

import java.util.Calendar;

import classeye.project.app.classeyes.Contracts.CurrentLessonContract;
import classeye.project.app.classeyes.Dao.Lesson;
import classeye.project.app.classeyes.Presenter.CurrentLessonPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements CurrentLessonContract.View{

    public int REQUESTCODE = 1;
    public int RESULT_CANCELED = 0;
    public IntentIntegrator intentIntegrator;
    public Lesson currentLesson=new Lesson();
    public CurrentLessonContract.Presenter presenter;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter=new CurrentLessonPresenter(this,getContext());
        presenter.getLesson();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        Button checkInBtn=view.findViewById(R.id.checkIn);

        presenter=new CurrentLessonPresenter(this,getContext());
        presenter.getLesson();
        TextView lecuturer=view.findViewById(R.id.Lecturer);
        TextView Lecture=view.findViewById(R.id.Lecture);
        TextView Time=view.findViewById(R.id.Time);
        TextView unitCode=view.findViewById(R.id.UnitCode);




        TextView timeView=view.findViewById(R.id.time);
        timeView.setText(Calendar.getInstance().getTime().toString());


        checkInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //try passing context incase of error
                intentIntegrator=new IntentIntegrator(getActivity());
                intentIntegrator.setPrompt("Scan to Check Into Class");
                intentIntegrator.setCameraId(0);  // Use a specific camera of the device
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setBarcodeImageEnabled(true);
                intentIntegrator.initiateScan();

            }

        });


        return view;

    }

    @Override
    public void ShowLesson(final Lesson lesson) {
            if(lesson!=null) {
                TextView unitCode=(TextView)getView().findViewById(R.id.UnitCode);
                TextView lessonName=(TextView)getView().findViewById(R.id.Lecture);
                TextView time=(TextView)getView().findViewById(R.id.Time);
                TextView lecturer=(TextView)getView().findViewById(R.id.Lecturer);
                lecturer.setText("Lecturer 1");

                time.setText(lesson.getLtime());

                unitCode.setText(lesson.getUnitcode());
                lessonName.setText(lesson.getName());
            }
}

    @Override
    public void failure(Throwable t) {
        Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
    }



}
