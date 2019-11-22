
package com.csath;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.lang.ClassNotFoundException;
import java.lang.IllegalAccessException;
import java.lang.reflect.Field;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;

import java.util.Map;
import java.util.HashMap;

public class RNConfigReaderModule extends ReactContextBaseJavaModule {
  public RNConfigReaderModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "RNConfigReader";
  }

  @Override
  public Map<String, Object> getConstants() {
      final Map<String, Object> constants = new HashMap<>();
      try {
        Context context = getReactApplicationContext();
        int resId = context.getResources().getIdentifier("build_config_package", "string", context.getPackageName());
        String className;
        try {
          className = context.getString(resId);
        } catch (Resources.NotFoundException e) {
          className = getReactApplicationContext().getApplicationContext().getPackageName();
        }
        Class clazz = Class.forName(className + ".BuildConfig");
        Field[] fields = clazz.getDeclaredFields();
        for(Field f: fields) {
          try {
            constants.put(f.getName(), f.get(null));
          }
          catch (IllegalAccessException e) {
            Log.d("ReactNative", "RNConfigReader: Could not access BuildConfig field " + f.getName());
          }
        }
      }
      catch (ClassNotFoundException e) {
        Log.d("ReactNative", "RNConfigReader: Could not find BuildConfig class");
      }
      return constants;
  }
}