package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    // Shared Preferences
    static SharedPreferences pref;

    // Editor for Shared preferences
    static SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "Pref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String HELPER_NAME = "phoneHelper";
    public static final String USER_NAME = "phoneUser";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public static void createLoginSessionForUser(String phone){
        // Storing login value as TRUE


        // Storing name in pref
        editor.putString(USER_NAME, phone);

        editor.commit();
    }

    public static void createLoginSessionForHelper(String phone){
        // Storing login value as TRUE


        // Storing name in pref
        editor.putString(HELPER_NAME, phone);

        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(HELPER_NAME, pref.getString(HELPER_NAME, null));

        // user email id
       // user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // return user
        return user;
    }

    public static void startUserSesssion(String phone)
    {

    }
    public static void startHelperSesssion(String phone)
    {

    }

    public HashMap<String, String> getHelperDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(USER_NAME, pref.getString(USER_NAME, null));

        // user email id
       // user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public static void logoutHelper(){
        // Clearing all data from Shared Preferences
        editor.remove(HELPER_NAME);

        editor.commit();

        // After logout redirect user to Loing Activity

        // Closing all the Activities
       // i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
       // i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity

    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isUserLoggedIn(){
         if(pref.getString(USER_NAME,"nopes")!="nopes")
         {
             return true;
         }
         else return false;
    }
    public boolean isHelperLoggedIn(){
        if(pref.getString(HELPER_NAME,"nopes")!="nopes")
        {
            return true;
        }
        else return false;
    }
}


