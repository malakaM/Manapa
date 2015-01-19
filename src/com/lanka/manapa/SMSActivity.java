package com.lanka.manapa;

import android.app.Fragment;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lanka.api.R;

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
	            	final EditText mSmsCount = (EditText) getActivity().findViewById(R.id.input_count);
	        		final EditText mMobileNumber = (EditText) getActivity().findViewById(R.id.input_mobile_number);
	        		final EditText mMessageBody = (EditText) getActivity().findViewById(R.id.input_message_body);
	        		
	        		int count = 0;
	        		String countValue = mSmsCount.getText().toString();
	        		String mobileNumber = mMobileNumber.getText().toString();
	        		String messageBody = mMessageBody.getText().toString();
	            	
	        		if( messageBody.length() == 0 ){
	        			mMessageBody.setError( "Message is required" );
	        			return;
	        		}
	        		
	        		if( countValue.length() == 0 ){
	        			mSmsCount.setError( "Count is required" );
	        			return;
	        		}else{
	        			count = Integer.parseInt(countValue);
	        		}
	        		
	        		if( mobileNumber.length() == 0 ){
	        			mMobileNumber.setError( "Number is required" );
	        			return;
	        		}
	        		
	                SmsManager smsManager = SmsManager.getDefault();
	          
	                for (int i = 0; i < count; i++) {
	                	 smsManager.sendTextMessage(mobileNumber, null, messageBody , null, null);				
					}
	               

	            }
	        });
	 }
}
