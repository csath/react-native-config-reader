
# react-native-config-reader

## Getting started

`$ npm install react-native-config-reader --save`

### Mostly automatic installation

`$ react-native link react-native-config-reader`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-config-reader` and add `RNConfigReader.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNConfigReader.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNConfigReaderPackage;` to the imports at the top of the file
  - Add `new RNConfigReaderPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-config-reader'
  	project(':react-native-config-reader').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-config-reader/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-config-reader')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNConfigReader.sln` in `node_modules/react-native-config-reader/windows/RNConfigReader.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Config.Reader.RNConfigReader;` to the usings at the top of the file
  - Add `new RNConfigReaderPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNConfigReader from 'react-native-config-reader';

// TODO: What to do with the module?
RNConfigReader;
```
  