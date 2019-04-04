
#import "RNConfigReader.h"

@implementation RNConfigReader

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

- (NSDictionary *)constantsToExport
{
  return @{ @"BuildConfigs": [[NSBundle mainBundle] infoDictionary] };
}

@end
  