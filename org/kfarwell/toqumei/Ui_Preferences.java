/********************************************************************************
 ** Form generated from reading ui file 'Ui_Preferences.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package org.kfarwell.toqumei;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Preferences implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QSpinBox ppp;
    public QLabel ppp_label;
    public QLabel pls_restart;
    public QDialogButtonBox ok;

    public Ui_Preferences() { super(); }

    public void setupUi(QDialog Preferences)
    {
        Preferences.setObjectName("Preferences");
        Preferences.resize(new QSize(350, 110).expandedTo(Preferences.minimumSizeHint()));
        Preferences.setWindowIcon(new QIcon(new QPixmap("res/icon.png")));
        gridLayout = new QGridLayout(Preferences);
        gridLayout.setObjectName("gridLayout");
        ppp = new QSpinBox(Preferences);
        ppp.setObjectName("ppp");
        ppp.setValue(25);

        gridLayout.addWidget(ppp, 0, 0, 1, 1);

        ppp_label = new QLabel(Preferences);
        ppp_label.setObjectName("ppp_label");

        gridLayout.addWidget(ppp_label, 0, 1, 1, 1);

        pls_restart = new QLabel(Preferences);
        pls_restart.setObjectName("pls_restart");

        gridLayout.addWidget(pls_restart, 1, 0, 1, 2);

        ok = new QDialogButtonBox(Preferences);
        ok.setObjectName("ok");
        ok.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        ok.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));

        gridLayout.addWidget(ok, 2, 0, 1, 2);

        retranslateUi(Preferences);
        ok.accepted.connect(Preferences, "accept()");
        ok.rejected.connect(Preferences, "reject()");

        Preferences.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Preferences)
    {
        Preferences.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Preferences", "Preferences", null));
        ppp_label.setText(com.trolltech.qt.core.QCoreApplication.translate("Preferences", "Posts per page", null));
        pls_restart.setText(com.trolltech.qt.core.QCoreApplication.translate("Preferences", "You must restart Toqumei for changes to take effect.", null));
    } // retranslateUi

}

