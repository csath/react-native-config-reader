
import { NativeModules, Platform } from 'react-native';

const { RNConfigReader } = NativeModules;

export default Platform.OS === 'ios' ? RNConfigReader.BuildConfigs : RNConfigReader;
