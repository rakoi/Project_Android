package classeye.project.app.classeyes;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    public int REQUESTCODE = 1;
    public int RESULT_CANCELED = 0;
    public IntentIntegrator intentIntegrator;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        Button checkInBtn=view.findViewById(R.id.checkIn);

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



}
