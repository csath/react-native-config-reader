
Pod::Spec.new do |s|
  s.name         = "RNConfigReader"
  s.version      = "1.0.0"
  s.summary      = "RNConfigReader"
  s.description  = <<-DESC
                  RNConfigReader
                   DESC
  s.homepage     = "https://github.com/csath/react-native-config-reader"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNConfigReader.git", :tag => "master" }
  s.source_files  = "RNConfigReader/**/*.{h,m}"
  s.requires_arc = true

  s.dependency "React"

end


