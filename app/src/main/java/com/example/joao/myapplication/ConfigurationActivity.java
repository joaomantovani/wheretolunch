package com.example.joao.myapplication;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import java.util.zip.Inflater;

public class ConfigurationActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
    }


}
