LibExtractor — a simplified CLI application to parse all the .so files.

Created for BlueStacks Hiring Challenge. Organized by HackerEarth.com

To run the app:

1. javac LibExtractor.java
2. java LibExtractor {apkfilepath1} {apkfilepath2} ..

Sample output:
```
Parsing file : /home/testing/Desktop/test-apk.apk
1: /lib/armeabi-v7a/libBreakpad.so 		 ArchType: armeabi-v7a 
2: /lib/armeabi-v7a/libLocalPreview.so 		 ArchType: armeabi-v7a 
3: /lib/armeabi-v7a/libphotoeffect.so 		 ArchType: armeabi-v7a 
Number of Libs: 3

Parsing file : /home/testing/Desktop/opera.apk
1: /lib/mips/libom.so 		 ArchType: mips 
Number of Libs: 1
```
