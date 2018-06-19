#!/bin/sh

CP=.:lib/qtjambi-4.8.7.jar

sed 's,\.\./\.\./\.\./,,g' org/kfarwell/toqumei/Ui_MainWindow.jui >org/kfarwell/toqumei/Ui_MainWindow.jui.tmp &&
mv org/kfarwell/toqumei/Ui_MainWindow.jui.tmp org/kfarwell/toqumei/Ui_MainWindow.jui &&
echo configured: org.kfarwell.toqumei.Ui_MainWindow &&

sed 's,\.\./\.\./\.\./,,g' org/kfarwell/toqumei/Ui_Preferences.jui >org/kfarwell/toqumei/Ui_Preferences.jui.tmp &&
mv org/kfarwell/toqumei/Ui_Preferences.jui.tmp org/kfarwell/toqumei/Ui_Preferences.jui &&
echo configured: org.kfarwell.toqumei.Ui_Preferences &&

sed 's,\.\./\.\./\.\./,,g' org/kfarwell/toqumei/Ui_NewPost.jui >org/kfarwell/toqumei/Ui_NewPost.jui.tmp &&
mv org/kfarwell/toqumei/Ui_NewPost.jui.tmp org/kfarwell/toqumei/Ui_NewPost.jui &&
echo configured: org.kfarwell.toqumei.Ui_NewPost &&

juic -p org.kfarwell.toqumei org/kfarwell/toqumei/Ui_MainWindow.jui &&
juic -p org.kfarwell.toqumei org/kfarwell/toqumei/Ui_Preferences.jui &&
juic -p org.kfarwell.toqumei org/kfarwell/toqumei/Ui_NewPost.jui &&

javac -cp $CP org/kfarwell/toqumei/Ui_MainWindow.java &&
echo built: org.kfarwell.toqumei.Ui_MainWindow &&
javac -cp $CP org/kfarwell/toqumei/Ui_Preferences.java &&
echo built: org.kfarwell.toqumei.Ui_Preferences &&
javac -cp $CP org/kfarwell/toqumei/Ui_NewPost.java &&
echo built: org.kfarwell.toqumei.Ui_NewPost &&
javac -cp $CP org/kfarwell/toqumei/Toqumei.java &&
echo built: org.kfarwell.toqumei.Toqumei &&

echo Successfully built Toqumei.
