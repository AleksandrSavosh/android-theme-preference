package com.aleksandr.settings.theme;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ThemeHelper {

    private static HashMap<String, Integer> stringColorPrimaryMap = new HashMap<>();
    public static HashMap<String, Integer> getStringColorPrimaryMap(Context context) {
        if(stringColorPrimaryMap.isEmpty()){
            stringColorPrimaryMap.put(context.getString(R.string._red),         ContextCompat.getColor(context, R.color.md_red_500));
            stringColorPrimaryMap.put(context.getString(R.string._pink),        ContextCompat.getColor(context, R.color.md_pink_500));
            stringColorPrimaryMap.put(context.getString(R.string._purple),      ContextCompat.getColor(context, R.color.md_purple_500));
            stringColorPrimaryMap.put(context.getString(R.string._deep_purple), ContextCompat.getColor(context, R.color.md_deep_purple_500));
            stringColorPrimaryMap.put(context.getString(R.string._indigo),      ContextCompat.getColor(context, R.color.md_indigo_500));
            stringColorPrimaryMap.put(context.getString(R.string._light_blue),  ContextCompat.getColor(context, R.color.md_light_blue_500));
            stringColorPrimaryMap.put(context.getString(R.string._cyan),        ContextCompat.getColor(context, R.color.md_cyan_500));
            stringColorPrimaryMap.put(context.getString(R.string._teal),        ContextCompat.getColor(context, R.color.md_teal_500));
            stringColorPrimaryMap.put(context.getString(R.string._green),       ContextCompat.getColor(context, R.color.md_green_500));
            stringColorPrimaryMap.put(context.getString(R.string._light_green), ContextCompat.getColor(context, R.color.md_light_green_500));
            stringColorPrimaryMap.put(context.getString(R.string._lime),        ContextCompat.getColor(context, R.color.md_lime_500));
            stringColorPrimaryMap.put(context.getString(R.string._yellow),      ContextCompat.getColor(context, R.color.md_yellow_500));
            stringColorPrimaryMap.put(context.getString(R.string._amber),       ContextCompat.getColor(context, R.color.md_amber_500));
            stringColorPrimaryMap.put(context.getString(R.string._orange),      ContextCompat.getColor(context, R.color.md_orange_500));
            stringColorPrimaryMap.put(context.getString(R.string._deep_orange), ContextCompat.getColor(context, R.color.md_deep_orange_500));
            stringColorPrimaryMap.put(context.getString(R.string._brown),       ContextCompat.getColor(context, R.color.md_brown_500));
            stringColorPrimaryMap.put(context.getString(R.string._grey),        ContextCompat.getColor(context, R.color.md_grey_500));
            stringColorPrimaryMap.put(context.getString(R.string._blue_grey),   ContextCompat.getColor(context, R.color.md_blue_grey_500));
        }
        return stringColorPrimaryMap;
    }

    private static HashMap<String, Integer> stringColorAccentMap = new HashMap<>();
    public static HashMap<String, Integer> getStringColorAccentMap(Context context) {
        if(stringColorAccentMap.isEmpty()){
            stringColorAccentMap.put(context.getString(R.string._red),         ContextCompat.getColor(context, R.color.md_red_A400));
            stringColorAccentMap.put(context.getString(R.string._pink),        ContextCompat.getColor(context, R.color.md_pink_A400));
            stringColorAccentMap.put(context.getString(R.string._purple),      ContextCompat.getColor(context, R.color.md_purple_A400));
            stringColorAccentMap.put(context.getString(R.string._deep_purple), ContextCompat.getColor(context, R.color.md_deep_purple_A400));
            stringColorAccentMap.put(context.getString(R.string._indigo),      ContextCompat.getColor(context, R.color.md_indigo_A400));
            stringColorAccentMap.put(context.getString(R.string._light_blue),  ContextCompat.getColor(context, R.color.md_light_blue_A400));
            stringColorAccentMap.put(context.getString(R.string._cyan),        ContextCompat.getColor(context, R.color.md_cyan_A400));
            stringColorAccentMap.put(context.getString(R.string._teal),        ContextCompat.getColor(context, R.color.md_teal_A400));
            stringColorAccentMap.put(context.getString(R.string._green),       ContextCompat.getColor(context, R.color.md_green_A400));
            stringColorAccentMap.put(context.getString(R.string._light_green), ContextCompat.getColor(context, R.color.md_light_green_A400));
            stringColorAccentMap.put(context.getString(R.string._lime),        ContextCompat.getColor(context, R.color.md_lime_A400));
            stringColorAccentMap.put(context.getString(R.string._yellow),      ContextCompat.getColor(context, R.color.md_yellow_A400));
            stringColorAccentMap.put(context.getString(R.string._amber),       ContextCompat.getColor(context, R.color.md_amber_A400));
            stringColorAccentMap.put(context.getString(R.string._orange),      ContextCompat.getColor(context, R.color.md_orange_A400));
            stringColorAccentMap.put(context.getString(R.string._deep_orange), ContextCompat.getColor(context, R.color.md_deep_orange_A400));
        }
        return stringColorAccentMap;
    }

    private static HashMap<String, Integer> stringColorBackgroundMap = new HashMap<>();
    public static HashMap<String, Integer> getStringColorBackgroundMap(Context context) {
        if(stringColorBackgroundMap.isEmpty()){
            stringColorBackgroundMap.put(context.getString(R.string._black), ContextCompat.getColor(context, R.color.md_grey_900));
            stringColorBackgroundMap.put(context.getString(R.string._white), ContextCompat.getColor(context, R.color.md_grey_100));
        }
        return stringColorBackgroundMap;
    }


    public static Map<Integer, String> getColorStringPrimaryMap(Context context) {
        Map<String, Integer> stringColorPrimaryMap = getStringColorPrimaryMap(context);
        return swapKeyValue(stringColorPrimaryMap);
    }

    public static Map<Integer, String> getColorStringAccentMap(Context context) {
        Map<String, Integer> stringColorAccentMap = getStringColorAccentMap(context);
        return swapKeyValue(stringColorAccentMap);
    }

    public static Map<Integer, String> getColorStringBackgroundMap(Context context){
        Map<String, Integer> stringColorBackgroundMap = getStringColorBackgroundMap(context);
        return swapKeyValue(stringColorBackgroundMap);
    }

    private static Map<Integer, String> swapKeyValue(Map<String, Integer> src){
        Map<Integer, String> res = new HashMap<>();
        for(Map.Entry<String, Integer> entry : src.entrySet()){
            res.put(entry.getValue(), entry.getKey());
        }
        return res;
    }

    private static Map<String, Integer> stringStylePrimaryMap = new HashMap<>();
    public static Map<String, Integer> getStringStylePrimaryMap(Context context){
        if(stringStylePrimaryMap.isEmpty()){
            stringStylePrimaryMap.put(context.getString(R.string._red), R.style.ColorPrimary_Red);
            stringStylePrimaryMap.put(context.getString(R.string._pink), R.style.ColorPrimary_Pink);
            stringStylePrimaryMap.put(context.getString(R.string._purple), R.style.ColorPrimary_Purple);
            stringStylePrimaryMap.put(context.getString(R.string._deep_purple), R.style.ColorPrimary_DeepPurple);
            stringStylePrimaryMap.put(context.getString(R.string._indigo), R.style.ColorPrimary_Indigo);
            stringStylePrimaryMap.put(context.getString(R.string._blue), R.style.ColorPrimary_Blue);
            stringStylePrimaryMap.put(context.getString(R.string._light_blue), R.style.ColorPrimary_LightBlue);
            stringStylePrimaryMap.put(context.getString(R.string._cyan), R.style.ColorPrimary_Cyan);
            stringStylePrimaryMap.put(context.getString(R.string._teal), R.style.ColorPrimary_Teal);
            stringStylePrimaryMap.put(context.getString(R.string._green), R.style.ColorPrimary_Green);
            stringStylePrimaryMap.put(context.getString(R.string._light_green), R.style.ColorPrimary_LightGreen);
            stringStylePrimaryMap.put(context.getString(R.string._lime), R.style.ColorPrimary_Lime);
            stringStylePrimaryMap.put(context.getString(R.string._yellow), R.style.ColorPrimary_Yellow);
            stringStylePrimaryMap.put(context.getString(R.string._amber), R.style.ColorPrimary_Amber);
            stringStylePrimaryMap.put(context.getString(R.string._orange), R.style.ColorPrimary_Orange);
            stringStylePrimaryMap.put(context.getString(R.string._deep_orange), R.style.ColorPrimary_DeepOrange);
            stringStylePrimaryMap.put(context.getString(R.string._brown), R.style.ColorPrimary_Brown);
            stringStylePrimaryMap.put(context.getString(R.string._grey), R.style.ColorPrimary_Grey);
            stringStylePrimaryMap.put(context.getString(R.string._blue_grey), R.style.ColorPrimary_BlueGrey);
        }
        return stringStylePrimaryMap;
    }

    private static Map<String, Integer> stringStyleAccentMap = new HashMap<>();
    public static Map<String, Integer> getStringStyleAccentMap(Context context){
        if(stringStyleAccentMap.isEmpty()){
            stringStyleAccentMap.put(context.getString(R.string._red), R.style.ColorAccent_Red);
            stringStyleAccentMap.put(context.getString(R.string._pink), R.style.ColorAccent_Pink);
            stringStyleAccentMap.put(context.getString(R.string._purple), R.style.ColorAccent_Purple);
            stringStyleAccentMap.put(context.getString(R.string._deep_purple), R.style.ColorAccent_DeepPurple);
            stringStyleAccentMap.put(context.getString(R.string._indigo), R.style.ColorAccent_Indigo);
            stringStyleAccentMap.put(context.getString(R.string._blue), R.style.ColorAccent_Blue);
            stringStyleAccentMap.put(context.getString(R.string._light_blue), R.style.ColorAccent_LightBlue);
            stringStyleAccentMap.put(context.getString(R.string._cyan), R.style.ColorAccent_Cyan);
            stringStyleAccentMap.put(context.getString(R.string._teal), R.style.ColorAccent_Teal);
            stringStyleAccentMap.put(context.getString(R.string._green), R.style.ColorAccent_Green);
            stringStyleAccentMap.put(context.getString(R.string._light_green), R.style.ColorAccent_LightGreen);
            stringStyleAccentMap.put(context.getString(R.string._lime), R.style.ColorAccent_Lime);
            stringStyleAccentMap.put(context.getString(R.string._yellow), R.style.ColorAccent_Yellow);
            stringStyleAccentMap.put(context.getString(R.string._amber), R.style.ColorAccent_Amber);
            stringStyleAccentMap.put(context.getString(R.string._orange), R.style.ColorAccent_Orange);
            stringStyleAccentMap.put(context.getString(R.string._deep_orange), R.style.ColorAccent_DeepOrange);
        }
        return stringStyleAccentMap;
    }

    private static Set<String> lightPrimaryColors = new HashSet<>();
    public static Set<String> getLightPrimaryColors(Context context){
        if(lightPrimaryColors.isEmpty()){
            lightPrimaryColors.add(context.getString(R.string._blue));
            lightPrimaryColors.add(context.getString(R.string._light_blue));
            lightPrimaryColors.add(context.getString(R.string._cyan));
            lightPrimaryColors.add(context.getString(R.string._light_green));
            lightPrimaryColors.add(context.getString(R.string._lime));
            lightPrimaryColors.add(context.getString(R.string._yellow));
            lightPrimaryColors.add(context.getString(R.string._amber));
        }
        return lightPrimaryColors;
    }

    private static int getTheme(boolean isLight, boolean useLightToolbar){
        if(isLight && useLightToolbar){
            return R.style.AppTheme;
        }
        if(isLight){
            return R.style.AppTheme_DarkActionBar;
        }
        if(useLightToolbar){
            return R.style.AppTheme_Dark_LightActionBar;
        }
        return R.style.AppTheme_Dark;
    }

    public static void configureTheme(Activity act){
        String key = act.getString(R.string.pref_theme_key);
        String value = PreferenceManager.getDefaultSharedPreferences(act).getString(key, "");
        if(value.length() == 0){
            throw new RuntimeException("Init default preferences before setContentView() " +
                    "'PreferenceManager.setDefaultValues(this, R.xml.preference, false);' ");
        }

        String[] values = value.split(" - ");
        String primaryColorName = values[0];
        String accentColorName = values[1];
        String backgroundColorName = values[2];

        int primaryStyle = getStringStylePrimaryMap(act).get(primaryColorName);
        int accentStyle = getStringStyleAccentMap(act).get(accentColorName);

        boolean isLight = backgroundColorName.equals(act.getString(R.string._white));
        boolean useLightToolbar = getLightPrimaryColors(act).contains(primaryColorName);
        int theme = getTheme(isLight, useLightToolbar);

        act.setTheme(theme);
        act.getTheme().applyStyle(primaryStyle, true);
        act.getTheme().applyStyle(accentStyle, true);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getColorFromThemeByAttr(act, R.attr.colorPrimaryDark));
        }

    }

    private static int getColorFromThemeByAttr(Context context, int attrId){
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(attrId, typedValue, true);
        return typedValue.data;
    }



}
