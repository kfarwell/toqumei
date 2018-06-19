/********************************************************************************
 ** Form generated from reading ui file 'Ui_MainWindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package org.kfarwell.toqumei;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction action_quit;
    public QAction action_preferences;
    public QAction action_newpost;
    public QWidget centralwidget;
    public QGridLayout gridLayout;
    public QScrollArea index_scroll;
    public QWidget index;
    public QVBoxLayout index_contents;
    public QFrame nav;
    public QHBoxLayout horizontalLayout;
    public QPushButton logo;
    public QSpacerItem logo_margin;
    public QPushButton compose;
    public QMenuBar menubar;
    public QMenu menu_file;
    public QStatusBar statusbar;

    public Ui_MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(673, 554).expandedTo(MainWindow.minimumSizeHint()));
        MainWindow.setWindowIcon(new QIcon(new QPixmap("res/icon.png")));
        MainWindow.setStyleSheet("background-color: #FFF;\n"+
"border: none;");
        MainWindow.setToolButtonStyle(com.trolltech.qt.core.Qt.ToolButtonStyle.ToolButtonIconOnly);
        action_quit = new QAction(MainWindow);
        action_quit.setObjectName("action_quit");
        action_preferences = new QAction(MainWindow);
        action_preferences.setObjectName("action_preferences");
        action_newpost = new QAction(MainWindow);
        action_newpost.setObjectName("action_newpost");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        centralwidget.setStyleSheet("");
        gridLayout = new QGridLayout(centralwidget);
        gridLayout.setSpacing(0);
        gridLayout.setMargin(0);
        gridLayout.setObjectName("gridLayout");
        index_scroll = new QScrollArea(centralwidget);
        index_scroll.setObjectName("index_scroll");
        index_scroll.setStyleSheet("QScrollBar, QScrollBar::add-line, QScrollBar::sub-line {\n"+
"    border: none;\n"+
"    background-color: transparent;\n"+
"    color: transparent;\n"+
"}\n"+
"QScrollBar::handle {\n"+
"    background-color: #D3D3D3;\n"+
"    border-radius: 8px;\n"+
"}");
        index_scroll.setWidgetResizable(true);
        index = new QWidget();
        index.setObjectName("index");
        index.setGeometry(new QRect(0, 0, 673, 455));
        index.setStyleSheet("QTextBrowser {\n"+
"    border: 1px solid #D3D3D3;\n"+
"}");
        index_contents = new QVBoxLayout(index);
        index_contents.setObjectName("index_contents");
        index_scroll.setWidget(index);

        gridLayout.addWidget(index_scroll, 1, 0, 1, 1);

        nav = new QFrame(centralwidget);
        nav.setObjectName("nav");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(nav.sizePolicy().hasHeightForWidth());
        nav.setSizePolicy(sizePolicy);
        nav.setMinimumSize(new QSize(0, 61));
        nav.setMaximumSize(new QSize(16777215, 61));
        nav.setStyleSheet("background-color: #E91E63;");
        nav.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        nav.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        horizontalLayout = new QHBoxLayout(nav);
        horizontalLayout.setObjectName("horizontalLayout");
        logo = new QPushButton(nav);
        logo.setObjectName("logo");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(logo.sizePolicy().hasHeightForWidth());
        logo.setSizePolicy(sizePolicy1);
        logo.setMaximumSize(new QSize(120, 39));
        logo.setIcon(new QIcon(new QPixmap("res/logo.png")));
        logo.setIconSize(new QSize(120, 39));

        horizontalLayout.addWidget(logo);

        logo_margin = new QSpacerItem(39, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(logo_margin);

        compose = new QPushButton(nav);
        compose.setObjectName("compose");
        compose.setMinimumSize(new QSize(39, 39));
        compose.setMaximumSize(new QSize(39, 39));
        compose.setStyleSheet("QPushButton#compose:hover {\n"+
"    background-color: #D11B59;\n"+
"}");
        compose.setIcon(new QIcon(new QPixmap("res/pencil.png")));
        compose.setIconSize(new QSize(64, 64));

        horizontalLayout.addWidget(compose);


        gridLayout.addWidget(nav, 0, 0, 1, 1);

        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 673, 19));
        menubar.setStyleSheet("background-color: #E91E63;\n"+
"color: #FFF;");
        menu_file = new QMenu(menubar);
        menu_file.setObjectName("menu_file");
        menu_file.setStyleSheet("background-color: #FFF;\n"+
"color: #000;");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);

        menubar.addAction(menu_file.menuAction());
        menu_file.addAction(action_newpost);
        menu_file.addAction(action_preferences);
        menu_file.addAction(action_quit);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Toqumei", null));
        action_quit.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quit", null));
        action_quit.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ctrl+Q", null));
        action_preferences.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Preferences", null));
        action_preferences.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ctrl+P", null));
        action_newpost.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "New Post", null));
        action_newpost.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ctrl+N", null));
        logo.setText("");
        compose.setText("");
        menu_file.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "File", null));
    } // retranslateUi

}

