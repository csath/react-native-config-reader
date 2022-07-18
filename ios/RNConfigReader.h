#if __has_include("RCTBridgeModule.h")
#import "React/RCTBridge.h"
#else
#import <React/RCTBridgeModule.h>
#endif

@interface RNConfigReader : NSObject <RCTBridgeModule>

@end
