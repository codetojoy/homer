Homer
=====

Simple utility to create a simple HTML home page, instead of using bookmarks. 

Useful when using multiple browsers on a project.

To build:
    - download and install Gradle
    - type: gradle myBuild

To run:
    - unzip ~/staging/homer.zip to a working area
    - edit links.txt as desired
    - download jQuery and jQuery UI
    - set resources/homer.properties to point to jQuery installs
    - type: java -jar homer.jar links.txt resources/homer.properties
