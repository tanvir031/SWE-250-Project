package com.example.oneblood;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static androidx.core.content.ContextCompat.startActivity;


public class Database extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;


    Context ctx;
    Database(Context ctx){
     this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {

        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information....");
    }

    @Override
    protected String  doInBackground(String... params) {
        String reg_url = "http://192.168.0.107/OneBlood/register.php";
        String login_url = "http://192.168.0.107/OneBlood/login.php";

        String method  = params[0];
        if(method.equals("register"))
        {
            String name = params[1];
            String username = params[2];
            String password = params[3];
            String email = params[4];
            String phone_no = params[5];
            String location = params[6];
            String bloodGroup = params[7];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(OS,"UTF-8")));

                String data = URLEncoder.encode("name","UTF-8") + "=" + URLEncoder.encode(name,"UTF-8") + "&"+
                        URLEncoder.encode("username","UTF-8") + "=" + URLEncoder.encode(username,"UTF-8") + "&"+
                        URLEncoder.encode("password","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8") + "&"+
                        URLEncoder.encode("email","UTF-8") + "=" + URLEncoder.encode(email,"UTF-8") + "&"+
                        URLEncoder.encode("phone_no","UTF-8") + "=" + URLEncoder.encode(phone_no,"UTF-8") + "&"+
                        URLEncoder.encode("location","UTF-8") + "=" + URLEncoder.encode(location,"UTF-8") + "&"+
                        URLEncoder.encode("bloodGroup","UTF-8") + "=" + URLEncoder.encode(bloodGroup,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Suceess...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(method.equals("login"))
        {

           String login_name = params[1];
           String login_pass = params[2];
           try {
               URL url = new URL(login_url);
               HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
               httpURLConnection.setRequestMethod("POST");
               httpURLConnection.setDoOutput(true);
               httpURLConnection.setDoInput(true);
               OutputStream outputStream = httpURLConnection.getOutputStream();
               BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

               String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                       URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
               bufferedWriter.write(data);
               bufferedWriter.flush();
               bufferedWriter.close();
               outputStream.close();

               InputStream inputStream = httpURLConnection.getInputStream();
               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
               String response = "";
               String line = "";

               if((line = bufferedReader.readLine())!=null)
               {
                   response+= line;

               }

               bufferedReader.close();
               inputStream.close();
               httpURLConnection.disconnect();

               if(response.equals("OK")){
                    Intent intent=new Intent(ctx,Activity2.class);
                   ctx.startActivity(intent);
                   ((Activity)ctx).finish();
               }
               else{
                   System.out.println("Hello foga");
               }


               return response;

           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }


        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }



    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Suceess..."))
        {
            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();


        }
       else
        {
            alertDialog.setMessage(result);
            alertDialog.show();

        }
    }


}
