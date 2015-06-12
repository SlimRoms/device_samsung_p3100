/*
 * Copyright (C) 2012 The CyanogenMod Project
 *               2015 The OmniROM Project
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

import android.app.ActivityManagerNative;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.preference.SwitchPreference;
import android.util.AttributeSet;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;

import com.cyanogenmod.settings.device.R;

public class DockAudio extends SwitchPreference implements OnPreferenceChangeListener {

    public static final String KEY_USE_DOCK_AUDIO = "dock_audio";
    private static String DOCK_INTENT_ACTION = null;

    public DockAudio(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnPreferenceChangeListener(this);
        DOCK_INTENT_ACTION = context.getResources().getString(R.string.dock_intent_action);
    }

    public static boolean isSupported(Context context) {
        if (DOCK_INTENT_ACTION == null) {
            DOCK_INTENT_ACTION = context.getResources().getString(R.string.dock_intent_action);
        }

        // It seems there is no way to determine if there is a receiver for the intent.
        // PackageManager.queryBroadcastReceivers() only returns receivers defined in xml

        return true;
    }

    public static void restore(Context context) {
        if (!isSupported(context)) { // also sets DOCK_INTENT_ACTION
            return;
        }

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        setDockAudio(sharedPrefs.getBoolean(KEY_USE_DOCK_AUDIO, false));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        setDockAudio((Boolean) newValue);
        return true;
    }

    private static void setDockAudio(boolean enable) {
        Intent i = new Intent(DOCK_INTENT_ACTION);
        i.putExtra("data", enable);
        ActivityManagerNative.broadcastStickyIntent(i, null, UserHandle.USER_ALL);
    }
}

