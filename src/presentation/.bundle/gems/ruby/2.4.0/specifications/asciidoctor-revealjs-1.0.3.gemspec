# -*- encoding: utf-8 -*-
# stub: asciidoctor-revealjs 1.0.3 ruby lib

Gem::Specification.new do |s|
  s.name = "asciidoctor-revealjs".freeze
  s.version = "1.0.3"

  s.required_rubygems_version = Gem::Requirement.new(">= 0".freeze) if s.respond_to? :required_rubygems_version=
  s.require_paths = ["lib".freeze]
  s.authors = ["Olivier Bilodeau".freeze]
  s.date = "2017-08-29"
  s.description = "Reveal.JS back-end for Asciidoctor and Asciidoctor.js. Write slides in AsciiDoc!".freeze
  s.email = ["olivier@bottomlesspit.org".freeze]
  s.executables = ["asciidoctor-revealjs".freeze]
  s.extra_rdoc_files = ["README.adoc".freeze, "LICENSE.adoc".freeze, "HACKING.adoc".freeze]
  s.files = ["HACKING.adoc".freeze, "LICENSE.adoc".freeze, "README.adoc".freeze, "bin/asciidoctor-revealjs".freeze]
  s.homepage = "https://github.com/asciidoctor/asciidoctor-reveal.js".freeze
  s.licenses = ["MIT".freeze]
  s.required_ruby_version = Gem::Requirement.new(">= 1.9.3".freeze)
  s.rubygems_version = "2.6.13".freeze
  s.summary = "Converts AsciiDoc to HTML for a Reveal.js presentation".freeze

  s.installed_by_version = "2.6.13" if s.respond_to? :installed_by_version

  if s.respond_to? :specification_version then
    s.specification_version = 4

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
      s.add_runtime_dependency(%q<asciidoctor>.freeze, ["= 1.5.4"])
      s.add_runtime_dependency(%q<slim>.freeze, ["~> 3.0.6"])
      s.add_runtime_dependency(%q<thread_safe>.freeze, ["~> 0.3.5"])
      s.add_development_dependency(%q<rake>.freeze, ["~> 10.4.2"])
    else
      s.add_dependency(%q<asciidoctor>.freeze, ["= 1.5.4"])
      s.add_dependency(%q<slim>.freeze, ["~> 3.0.6"])
      s.add_dependency(%q<thread_safe>.freeze, ["~> 0.3.5"])
      s.add_dependency(%q<rake>.freeze, ["~> 10.4.2"])
    end
  else
    s.add_dependency(%q<asciidoctor>.freeze, ["= 1.5.4"])
    s.add_dependency(%q<slim>.freeze, ["~> 3.0.6"])
    s.add_dependency(%q<thread_safe>.freeze, ["~> 0.3.5"])
    s.add_dependency(%q<rake>.freeze, ["~> 10.4.2"])
  end
end
