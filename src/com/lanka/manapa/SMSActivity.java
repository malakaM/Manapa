package com.lanka.manapa;

import com.lanka.api.R;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends Fragment {

	@Override
	public void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.activity_sms, container, false);
	}
	
	 @Override
	    public void onActivityCreated(Bundle savedInstanceState) {
	        super.onActivityCreated(savedInstanceState);
	        
	        final Button button = (Button) getActivity().findViewById(R.id.button_send);
	        button.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	final EditText smsCount = (EditText) getActivity().findViewById(R.id.input_count);
	        		final int count = Integer.parseInt(smsCount.getText().toString());
	        		final EditText mobileNumber = (EditText) getActivity().findViewById(R.id.input_mobile_number);
	            	
	                Context context = getActivity().getApplicationContext();
	                CharSequence text = "Button clicked!";
	                int duration = Toast.LENGTH_SHORT;
	                Toast toast = Toast.makeText(context, text, duration);
	                toast.show();

	                SmsManager smsManager = SmsManager.getDefault();
	          
	                for (int i = 0; i < count; i++) {
	                	 smsManager.sendTextMessage(mobileNumber.getText().toString(), null, "Hello Naveen", null, null);				
					}
	               

	            }
	        });
	 }
}
