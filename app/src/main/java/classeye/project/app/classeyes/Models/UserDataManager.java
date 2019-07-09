package classeye.project.app.classeyes.Models;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import classeye.project.app.classeyes.Contracts.LoginContract;
import classeye.project.app.classeyes.Dao.User;
import classeye.project.app.classeyes.MainActivity;
import classeye.project.app.classeyes.MySingleton;

public class UserDataManager implements LoginContract.Model {

    public User user;
    String message="";
    public String loginUlr = "http://68.183.73.119:8081/api/student/login";
    SharedPreferences sharedPreferences;
    Context context;

    public UserDataManager(SharedPreferences sharedPreferences,Context context) {
        this.sharedPreferences=sharedPreferences;
        this.context=context;
    }

    @Override
    public void saveCredentials(String admNo, String password) {
        user=new User();
        user.setAdmNo(admNo);
        user.setPassword(password);
        //save credentials in a shared prefrences
        sharedPreferences.edit().putString("admnumber",admNo).apply();
        sharedPreferences.edit().putString("password",password).apply();
       // sharedPreferences.edit().putInt("id",0).apply();
    }

    @Override
    public void login() {

        JSONObject requestParams=new JSONObject();
        try {
            requestParams.put("admnumber",user.getAdmNo());
            requestParams.put("password",user.getPassword());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonRequest=new JsonObjectRequest(
                Request.Method.POST, loginUlr, requestParams,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                         try{
                            saveCredentials(response.getString("admnumber").toString(),response.getString("password").toString());
                             sharedPreferences.edit().putInt("id",response.getInt("id")).apply();
                             sharedPreferences.edit().putString("firstname",response.getString("firstname")).apply();
                             sharedPreferences.edit().putString("lastname",response.getString("lastname")).apply();
                            Toast.makeText(context,"Welcome",Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context, MainActivity.class));

                         }catch (Exception ex){
                             Toast.makeText(context,ex.toString(),Toast.LENGTH_SHORT).show();

                         }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );


        MySingleton.getInstance(context).addToRequestQue(jsonRequest);
    }


    @Override
    public HashMap<String, String> SavedCredentials() {
        HashMap<String,String> credentials=new HashMap<>();

        credentials.put("admnumber",sharedPreferences.getString("admnumber",""));
        credentials.put("password",sharedPreferences.getString("password",""));
        credentials.put("id",String.valueOf(sharedPreferences.getInt("id",0)));
        return credentials;
    }




}
