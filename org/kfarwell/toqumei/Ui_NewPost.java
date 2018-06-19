/********************************************************************************
 ** Form generated from reading ui file 'Ui_NewPost.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package org.kfarwell.toqumei;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_NewPost implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QDialogButtonBox ok;
    public QLineEdit message;
    public QLabel message_label;
    public QLineEdit tags;
    public QLabel tags_label;
    public QLineEdit password;
    public QLabel password_label;

    public Ui_NewPost() { super(); }

    public void setupUi(QDialog NewPost)
    {
        NewPost.setObjectName("NewPost");
        NewPost.resize(new QSize(420, 120).expandedTo(NewPost.minimumSizeHint()));
        NewPost.setWindowIcon(new QIcon(new QPixmap("res/icon.png")));
        gridLayout = new QGridLayout(NewPost);
        gridLayout.setObjectName("gridLayout");
        ok = new QDialogButtonBox(NewPost);
        ok.setObjectName("ok");
        ok.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        ok.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));

        gridLayout.addWidget(ok, 4, 1, 1, 1);

        message = new QLineEdit(NewPost);
        message.setObjectName("message");
        message.setStyleSheet("border: 1px solid #D3D3D3;");

        gridLayout.addWidget(message, 1, 1, 1, 1);

        message_label = new QLabel(NewPost);
        message_label.setObjectName("message_label");

        gridLayout.addWidget(message_label, 1, 0, 1, 1);

        tags = new QLineEdit(NewPost);
        tags.setObjectName("tags");
        tags.setStyleSheet("border: 1px solid #D3D3D3;");

        gridLayout.addWidget(tags, 2, 1, 1, 1);

        tags_label = new QLabel(NewPost);
        tags_label.setObjectName("tags_label");

        gridLayout.addWidget(tags_label, 2, 0, 1, 1);

        password = new QLineEdit(NewPost);
        password.setObjectName("password");
        password.setStyleSheet("border: 1px solid #D3D3D3;");

        gridLayout.addWidget(password, 3, 1, 1, 1);

        password_label = new QLabel(NewPost);
        password_label.setObjectName("password_label");

        gridLayout.addWidget(password_label, 3, 0, 1, 1);

        retranslateUi(NewPost);
        ok.accepted.connect(NewPost, "accept()");
        ok.rejected.connect(NewPost, "reject()");

        NewPost.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog NewPost)
    {
        NewPost.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("NewPost", "New Post", null));
        message_label.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPost", "Message", null));
        tags_label.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPost", "Tags (space separated)", null));
        password_label.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPost", "Deletion password", null));
    } // retranslateUi

}

