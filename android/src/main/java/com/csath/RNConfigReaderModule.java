
package com.csath;

import java.lang.reflect.*;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;

import java.util.Map;
import java.util.HashMap;

public class RNConfigReaderModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private final Class buildConfigClass;

  public RNConfigReaderModule(ReactApplicationContext reactContext, Class buildConfigClass) {
    super(reactContext);
    this.reactContext = reactContext;
    this.buildConfigClass = buildConfigClass;
  }

  @Override
  public String getName() {
    return "RNConfigReader";
  }

  @Override
  public Map<String, Object> getConstants() {
      final Map<String, Object> constants = new HashMap<>();
      Field[] fields = this.buildConfigClass.getDeclaredFields();
      for (Field f : fields) {
          if (Modifier.isStatic(f.getModifiers())) {
              Object value = null;
              try{
                  value = f.get(null);
              }
              catch(Exception e){

              }
              finally {
                  constants.put(f.getName(), value);
              }
          } 
      }
      return constants;
  }
}