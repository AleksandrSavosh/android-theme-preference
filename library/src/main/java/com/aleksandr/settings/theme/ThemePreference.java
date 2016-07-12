package com.aleksandr.settings.theme;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;


import uz.shift.colorpicker.LineColorPicker;

public class ThemePreference extends DialogPreference {

    private static final String TAG = "THEME_PREFERENCE";


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ThemePreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ThemePreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ThemePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ThemePreference(Context context) {
        super(context);
    }

    @Override
    protected void onSetInitialValue(boolean restore, Object defaultValue) {
        persistString(getPersistedString((String) defaultValue));
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getString(index);
    }

    LineColorPicker primaryPicker;
    LineColorPicker accentPicker;
    LineColorPicker lightDarkPicker;

    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        primaryPicker = (LineColorPicker) view.findViewById(R.id.dialog_primary_color_picker);
        accentPicker = (LineColorPicker) view.findViewById(R.id.dialog_accent_color_picker);
        lightDarkPicker = (LineColorPicker) view.findViewById(R.id.dialog_light_dark_picker);

        String initValue = getPersistedString("");
        if(initValue != null && initValue.length() > 0){
            String[] values = initValue.split(" - ");
            String primaryColorName = values[0];
            String accentColorName = values[1];
            String backgroundColorName = values[2];

            int primaryColor = ThemeHelper
                    .getStringColorPrimaryMap(view.getContext())
                    .get(primaryColorName);

            int accentColor = ThemeHelper
                    .getStringColorAccentMap(view.getContext())
                    .get(accentColorName);

            int backgroundColor = ThemeHelper
                    .getStringColorBackgroundMap(view.getContext())
                    .get(backgroundColorName);

            primaryPicker.setSelectedColor(primaryColor);
            accentPicker.setSelectedColor(accentColor);
            lightDarkPicker.setSelectedColor(backgroundColor);
        }
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);
        if(positiveResult) {
            int primaryColor = primaryPicker.getColor();
            int accentColor = accentPicker.getColor();
            int backgroundColor = lightDarkPicker.getColor();

            String primaryColorName = ThemeHelper
                    .getColorStringPrimaryMap(getContext())
                    .get(primaryColor);
            String accentColorName = ThemeHelper
                    .getColorStringAccentMap(getContext())
                    .get(accentColor);
            String backgroundColorName = ThemeHelper
                    .getColorStringBackgroundMap(getContext())
                    .get(backgroundColor);

            String value = primaryColorName + " - " + accentColorName + " - " + backgroundColorName;
            persistString(value);
        }
    }
}
