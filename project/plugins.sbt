// Pulling this from https://github.com/siasia/xsbt-web-plugin/wiki/

// Do I need this?
// resolvers += "Web plugin repo" at "http://siasia.github.com/maven2"    

libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % (v+"-0.2.10"))
