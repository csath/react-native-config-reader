
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
  s.author       = { "author" => "author@domain.cn" }
  s.platforms    = { :ios => "7.0", :tvos => "9.2" }
  s.source       = { :git => "https://github.com/author/RNConfigReader.git", :tag => "master" }
  s.source_files = 'ios/**/*'
  s.requires_arc = true

  s.dependency "React"

end


