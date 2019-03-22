package com.example.myapplication;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Debug;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    int numberOfPresses;
    String[] list = {"Test"};

    static final int PICK_CONTACT = 1;
    String NumberToCall;
    final private int REQUEST_MULTIPLE_PERMISSIONS = 124;

    ArrayList<String> StoreContacts ;


    public static final String EXTRA_MESSAGE = "Hello World!";
    int[] soundCollection = {R.raw.faiz1, R.raw.faiz2, R.raw.faiz3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfPresses = 0;
        NumberToCall = "";


        AccessContact();

        StoreContacts = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if(cursor!=null && cursor.getCount() > 0)
        {
            while(cursor.moveToNext())
            {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                StoreContacts.add(name + " "  + ":" + " " + phoneNumber.replace("-",""));
            }
            cursor.close();
        }

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, StoreContacts);
        //AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        //textView.setAdapter(adapter);

    }

    public String CheckForMatch(String comp)
    {
        for (String contact: StoreContacts
             ) {
            if(contact.toLowerCase().contains(comp.toLowerCase()))
            {
                return contact;
            }

        }
        return comp;
    }

    public void setNumber( View view)
    {
        TextView numberToCall = (TextView) findViewById(R.id.Preview);
        TextView numberAutoComplete = (TextView) findViewById(R.id.editText);
        numberToCall.setText(numberAutoComplete.getText());
    }

    public void sendMessage(View view){

        TextView phoneNumber = (TextView)findViewById(R.id.Preview);
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


        }

        TextView editText = (TextView) findViewById(R.id.editText);
        editText.setText(CheckForMatch(NumberToCall));
        if(NumberToCall.length()<=0)
            editText.setText("");

        //SoundPoolPlayer soundPoolPlayer = new SoundPoolPlayer(this);
        Log.d("test","Hello");
        //soundPoolPlayer.playShortResource(R.raw.faiz1);



        MediaPlayer mp = MediaPlayer.create(this,soundCollection[numberOfPresses > 2 ? 2 : numberOfPresses < 0 ? 0 : numberOfPresses]);
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

    public void makeCall(Context context){
        try
        {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);

                return;
            }
            TextView editText = (TextView) findViewById(R.id.Preview);
            Log.d("number" , editText.getText().toString());
            if(editText.getText().toString().equals("555"))
                {
                    NumberToCall = "";
                    editText.setText(NumberToCall);
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

    public void PlayCompleteSound(View view)
    {
        TextView editText = (TextView) findViewById(R.id.Preview);
        Log.d("number" , editText.getText().toString());
        if(editText.getText().toString().equals(""))
        {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.exceedcharge);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
            mp.start();
            return;

        }


        MediaPlayer mp = MediaPlayer.create(this, R.raw.complete);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                makeCall(getApplicationContext());
            }
        });
        mp.seekTo(2500);
        mp.start();



    }

    public void Enter(View view) // deprecated
    {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.faizenter);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                PlaySecondSound();
            }
        });
        mp.start();

    }

    public void PlaySecondSound() // deprecated
    {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.faizcomplete);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mp.start();


        try
        {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);

                return;
            }

            TextView editText = (TextView) findViewById(R.id.Preview);
            if(editText.getText().toString() == "555")
            {
                editText.setText("");
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


    private void AccessContact()
    {
        List<String> permissionsNeeded = new ArrayList<String>();
        final List<String> permissionsList = new ArrayList<String>();
        if (!addPermission(permissionsList, Manifest.permission.READ_CONTACTS))
            permissionsNeeded.add("Read Contacts");
        //if (!addPermission(permissionsList, Manifest.permission.WRITE_CONTACTS))
            //permissionsNeeded.add("Write Contacts");
        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                String message = "You need to grant access to " + permissionsNeeded.get(0);
                for (int i = 1; i < permissionsNeeded.size(); i++)
                    message = message + ", " + permissionsNeeded.get(i);
                showMessageOKCancel(message,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                        REQUEST_MULTIPLE_PERMISSIONS);
                            }
                        });
                return;
            }
            requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                    REQUEST_MULTIPLE_PERMISSIONS);
            return;
        }
    }


    private boolean addPermission(List<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);

            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }
        return true;
    }


    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

}
