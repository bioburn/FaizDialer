package com.example.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FaizDialerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FaizDialerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FaizDialerFragment extends Fragment implements  View.OnClickListener{

    int numberOfPresses;

    static final int PICK_CONTACT = 1;
    String NumberToCall;
    final private int REQUEST_MULTIPLE_PERMISSIONS = 124;

    ArrayList<String> StoreContacts ;


    public static final String EXTRA_MESSAGE = "Hello World!";
    int[] soundCollection = {R.raw.faiz1, R.raw.faiz2, R.raw.faiz3};



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private ArrayList<String> mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FaizDialerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FaizDialerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FaizDialerFragment newInstance(ArrayList<String> param1, String param2) {
        FaizDialerFragment fragment = new FaizDialerFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            StoreContacts = getArguments().getStringArrayList(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_faiz_dialer, container, false);

        //set onclicks for EVERY BUTTON
        Button one = layout.findViewById(R.id.One);
        Button two = layout.findViewById(R.id.Two);
        Button three = layout.findViewById(R.id.Three);
        Button four = layout.findViewById(R.id.Four);
        Button six = layout.findViewById(R.id.Six);
        Button seven = layout.findViewById(R.id.Seven);
        Button eight = layout.findViewById(R.id.Eight);
        Button nine = layout.findViewById(R.id.Nine);
        Button zero = layout.findViewById(R.id.Zero);
        Button star = layout.findViewById(R.id.Star);
        Button pound = layout.findViewById(R.id.Pound);
        Button enter = layout.findViewById(R.id.Enter);
        Button delete = layout.findViewById(R.id.Delete);

        Button five = layout.findViewById(R.id.Five);
        five.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        six.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        star.setOnClickListener(this);
        pound.setOnClickListener(this);
        seven.setOnClickListener(this);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayCompleteSound(v);
            }
        });
        delete.setOnClickListener(this);

        layout.findViewById(R.id.editText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber();
            }
        });


        numberOfPresses = 0;
        NumberToCall = "";



        return layout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            default:
                sendMessage(v);
                Log.d("Hello","Test");
                break;
        }

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void setNumber( )
    {

        TextView numberToCall = (TextView) getView().findViewById(R.id.Preview);
        TextView numberAutoComplete = (TextView) getView().findViewById(R.id.editText);
        numberToCall.setText(numberAutoComplete.getText());
    }

    public void sendMessage(View view){

        TextView phoneNumber = (TextView)getView().findViewById(R.id.Preview);
        int button = view.getId();

        switch(button)
        {
            case R.id.One:
                NumberToCall += "1";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Two:
                NumberToCall += "2";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Three:
                NumberToCall += "3";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Four:
                NumberToCall += "4";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Five:
                NumberToCall += "5";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Six:
                NumberToCall += "6";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Seven:
                NumberToCall += "7";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Eight:
                NumberToCall += "8";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Nine:
                NumberToCall += "9";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Delete:
                NumberToCall = NumberToCall.substring(0 ,NumberToCall.length() <= 1 ? 0 : NumberToCall.length()-1);
                phoneNumber.setText(NumberToCall);
                numberOfPresses = -1;
                break;
            case R.id.Zero:
                NumberToCall += "0";
                phoneNumber.setText((NumberToCall));
                break;
            case R.id.Pound:
                NumberToCall += "#";
                phoneNumber.setText(NumberToCall);
                break;
            case R.id.Star:
                NumberToCall += "*";
                phoneNumber.setText(NumberToCall);
                break;


        }
        TextView editText = (TextView) getView().findViewById(R.id.editText);
        editText.setText(CheckForMatch(NumberToCall));
        if(NumberToCall.length()<=0)
            editText.setText("");

        //SoundPoolPlayer soundPoolPlayer = new SoundPoolPlayer(this);
        Log.d("test","Hello");
        //soundPoolPlayer.playShortResource(R.raw.faiz1);



        MediaPlayer mp = MediaPlayer.create(getContext(),soundCollection[numberOfPresses > 2 ? 2 : numberOfPresses < 0 ? 0 : numberOfPresses]);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mp.start();
        numberOfPresses ++;
        if(numberOfPresses > 2){
            numberOfPresses = 0;
        }
        /*
        try
        {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);

                return;
            }






            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:6268318739"));
            startActivity(i);

        }
        catch(Exception ex)
        {

            Log.d("test",ex.toString());
        }
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity((intent));


    */
    }

    public String CheckForMatch(String comp)
    {
        //Next time :
        //return array of matches
        for (String contact: StoreContacts
        ) {
            if(contact.toLowerCase().contains(comp.toLowerCase()))
            {
                return contact;
            }

        }
        return comp;
    }

    public void PlayCompleteSound(View view)
    {
        TextView editText = (TextView) getView().findViewById(R.id.Preview);
        Log.d("number" , editText.getText().toString());
        if(editText.getText().toString().equals(""))
        {
            MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.exceedcharge);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
            mp.start();
            return;

        }


        MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.complete);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                makeCall(getContext().getApplicationContext());
            }
        });
        mp.seekTo(2500);
        mp.start();



    }

    public void makeCall(Context context){
        try
        {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling

                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 101);

                return;
            }
            TextView editText = (TextView) getView().findViewById(R.id.Preview);
            Log.d("number" , editText.getText().toString());
            if(editText.getText().toString().equals("555"))
            {
                NumberToCall = "";
                editText.setText(NumberToCall);
                TextView preview = getView().findViewById(R.id.editText);
                preview.setText("HENSHIN");
                return;
            }
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:" + editText.getText().toString()));
            startActivity(i);

        }
        catch(Exception ex)
        {

            Log.d("test",ex.toString());
        }
    }



}
