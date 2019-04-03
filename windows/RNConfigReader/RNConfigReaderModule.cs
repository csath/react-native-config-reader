using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Config.Reader.RNConfigReader
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNConfigReaderModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNConfigReaderModule"/>.
        /// </summary>
        internal RNConfigReaderModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNConfigReader";
            }
        }
    }
}
