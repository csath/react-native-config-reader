# 🛠 react-native-config-reader [![npm](https://img.shields.io/npm/v/react-native-config-reader.svg)](https://npmjs.com/package/react-native-config-reader)  [![npm](https://img.shields.io/npm/dm/react-native-config-reader.svg)](https://npmjs.com/package/react-native-config-reader)

A native library to access all the native code's build configurations from JS.

For **react-native@0.60+** versions use **react-native-config-reader@4.0+**
(autolinking support enabled now).

🚨 Seeking help maintaining `react-native-windows` compatibility. See [below](#windows-beta).

## Installation

For **rn 0.60+ Auto Linking** will do things for you.

If not, follow these:

1. `$ npm install react-native-config-reader --save` or  `$ yarn add react-native-config-reader`

2. `$ react-native link react-native-config-reader`

3. Go to **android/app/src/main/packageName/MainApplication.java** and find line

   `new RNConfigReaderPackage()`

See [manual installation](#manual-installation) below if you have issues with `react-native link`.

## Usage

```javascript
import RNConfigReader from 'react-native-config-reader';

// access any of the defined config variables in Android build gradle or iOS info.plist
const configValue = RNConfigReader.ANY_DEFINED_CONFIG_FIELD;
```

### More examples

Create new build config field inside android `build.gradle` file **(android/app/build.gradle)**

```gradle
android {

    defaultConfig {
        applicationId "com.react-native.react-native-config-reader"
        versionCode 1
        versionName "1.0"

        buildConfigField "String", "TEST_CONFIG_FIELD", "Hello I'm your test config value"
    }
}
```

Create new field inside ios `info.plist` file

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">

<plist version="1.0">
<dict>
   <key>CFBundleDisplayName</key>
   <string>com.react-native.react-native-config-reader</string>

   <key>TEST_CONFIG_FIELD</key>
   <string>"Hello I'm your test config value"</string>
</dict>
</plist>
```

Now you can access them inside the JS code:

```javascript
import { Platform } from 'react-native';
import RNConfigReader from 'react-native-config-reader';

if (Platform.OS === 'ios') {
  const iosBundleDisplayName = RNConfigReader.CFBundleDisplayName;
  const testConfigValue = RNConfigReader.TEST_CONFIG_FIELD;
}

if (Platform.OS === 'android') {
  const androidApplicationID = RNConfigReader.applicationId;
  const testConfigValue = RNConfigReader.TEST_CONFIG_FIELD;
}
```

## Manual installation

### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-config-reader` and add `RNConfigReader.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNConfigReader.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)

### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`

  - Add `import com.reactlibrary.RNConfigReaderPackage;` to the imports at the top of the file
  - Add `new RNConfigReaderPackage()` to the list returned by the `getPackages()` method

1. Append the following lines to `android/settings.gradle`:

   ```gradle
   include ':react-native-config-reader'
   project(':react-native-config-reader').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-config-reader/android')
   ```

1. Insert the following lines inside the dependencies block in `android/app/build.gradle`:

```gradle
compile project(':react-native-config-reader')
```

#### Android advanced configurations with Multiple environments

If your app uses an `applicationIdSuffix` or a different `applicationId` depending on the build variants, you must append the following line inside the `buildTypes` block in your `android/app/build.gradle` file and specify your new package name.

```gradle
  resValue "string", "rn_config_reader_custom_package", "com.yourNewPackage"
```

Example

```gradle
buildTypes {
  ...
  debug {
    ...
    applicationIdSuffix ".dev"
    resValue "string", "rn_config_reader_custom_package", "com.yourNewPackage"
  }
}
```

### Windows (Beta)

🚨 When this project was first created in early 2019, it offered support for a beta version of [React Native for Windows](https://github.com/microsoft/react-native-windows).  Since this time, many updates have been published to both `react-native` and `react-native-windows`, with no active updates in this project to ensure compatibility.

🙏 If you're interested in using this library with `react-native-windows`, and can offer assistance maintaining it, please reach out to the maintainers by filing an issue.

1. In Visual Studio add the `RNConfigReader.sln` in `node_modules/react-native-config-reader/windows/RNConfigReader.sln` folder to their solution, reference from their app.

1. Open up your `MainPage.cs` app

  - Add `using Config.Reader.RNConfigReader;` to the usings at the top of the file
  - Add `new RNConfigReaderPackage()` to the `List<IReactPackage>` returned by the `Packages` method

## Troubleshooting

### Problems with Proguard

When Proguard is enabled (which it is by default for Android release builds), it can rename the BuildConfig Java class in the minification process and prevent `react-native-config-reader` from referencing it. To avoid this, add an exception to android/app/proguard-rules.pro:

`-keep class com.yourNewPackage.BuildConfig { *; }`

com.yourNewPackage should match the package value in your app/src/main/AndroidManifest.xml file.

If using Dexguard, the shrinking phase will remove resources it thinks are unused. It is necessary to add an exception to preserve the build config package name.

`-keepresources string/rn_config_reader_custom_package`

## License

MIT License

Copyright (c) 2019 Chanaka Athurugiriya
