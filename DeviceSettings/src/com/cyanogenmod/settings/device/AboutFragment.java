/*
 * Copyright (C) 2015 SlimRoms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyanogenmod.settings.device;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.cyanogenmod.settings.device.R;

public class AboutFragment extends Fragment {

    private static final String PREF_ENABLED = "1";
    private static final String TAG = "GalaxyTab2Settings_About";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, root, savedInstanceState);

        View view = inflater.inflate(R.layout.about_fragment, root, false);
        Button transSumm = (Button) view.findViewById(R.id.about_translation_summary);
        transSumm.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent("android.intent.action.VIEW",
                        Uri.parse("https://crowdin.com/project/slimroms")));

            }
        });
        return view;
    }
}
