package org.kfarwell.toqumei;

import java.util.*;

/* net io */
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* file io */
import java.io.File;
import java.io.PrintWriter;

/* qt jambi */
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Toqumei extends QMainWindow {
    public static void main(String[] args) {
        QApplication.initialize(args);
        Toqumei toqumei = new Toqumei();
        toqumei.show();
        QApplication.execStatic();
        QApplication.shutdown();
    }

    private String tInstance = new String("https://tokumei.co/"); // tokumei server instance to use

    private QTextBrowser[] posts;
    private QTextBrowser[][] replies;

    private int numposts = Integer.parseInt(httpGet(tInstance +
                                                    "postnum").trim());
    private int ppp = Integer.parseInt(readFile("ppp").trim()); // posts per page

    /* data for on_ok_clicked()'s post submission */
    private String npMessage = new String();
    private String npTags = new String();
    private String npPassword = new String();

    public Toqumei() {
        Ui_MainWindow ui = new Ui_MainWindow();
        ui.setupUi(this);

        posts = new QTextBrowser[ppp];
        replies = new QTextBrowser[ppp][];
        for(int i = 0; i < ppp; i++) {
            posts[i] = new QTextBrowser(ui.index);
            posts[i].setObjectName("post" + i);

            /* get the post's text, or display how many times the post has */
            /* been flagged as spam (if it has been) */
            String spam = httpGet(tInstance + "p/" +
                                  Integer.toString(numposts-i) +
                                  "_werc/spam").trim();
            String postText = new String();
            if(spam.matches("\\d+"))
                postText = "This post has been flagged as spam " + spam +
                           " times.\n";
            else
                postText = httpGet(tInstance + "p/" +
                                   Integer.toString(numposts-i) + ".txt");

            /* size the QTextBrowser to fit however many lines the post */
            /* contains. caveat: the QTextBrowser will be too small in the */
            /* case of very long lines that soft wrap */
            int lines = 1;
            int pos = 0;
            while((pos = postText.indexOf("\n", pos) + 1) != 0)
                lines++;
            posts[i].setMinimumHeight(lines * 14 + 10);

            postText = postText.replaceAll("\n", "<br />");

            posts[i].setHtml(com.trolltech.qt.core.QCoreApplication.translate(
                             "MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
                             "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
                             "p, li { white-space: pre-wrap; }\n"+
                             "</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
                             "<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">\n"+
                             postText+"\n"+ // the important bit
                             "</p></body></html>", null));

            ui.index_contents.addWidget(posts[i]);

            /* if there are replies to post i, get them */
            String r = httpGet(tInstance + "p/" + Integer.toString(numposts-i) +
                               "_werc/postnum").trim();
            if(r.matches("\\d+")) {
                int numreplies = Integer.parseInt(r) + 1;
                replies[i] = new QTextBrowser[numreplies];
                for(int j = 0; j < numreplies; j++) {
                    replies[i][j] = new QTextBrowser(ui.index);
                    replies[i][j].setObjectName("reply" + j);

                    String replyText = new String(httpGet(tInstance + "p/" +
                                                  Integer.toString(numposts-i) +
                                                  "_werc/replies/" + j));

                    /* size the QTextBrowser to fit however many lines the reply */
                    /* contains. caveat: the QTextBrowser will be too small in the */
                    /* case of very long lines that soft wrap */
                    lines = 1;
                    pos = 0;
                    while((pos = replyText.indexOf("\n", pos) + 1) != 0)
                        lines++;
                    replies[i][j].setMinimumHeight(lines * 14 + 10);

                    replyText = replyText.replaceAll("\n", "<br />");

                    replies[i][j].setHtml(com.trolltech.qt.core.QCoreApplication.translate(
                                          "MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
                                          "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
                                          "p, li { white-space: pre-wrap; }\n"+
                                          "</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
                                          "<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">\n"+
                                          replyText+"\n"+ // the important bit
                                          "</p></body></html>", null));
                    replies[i][j].setStyleSheet("margin-left: 2em;");

                    ui.index_contents.addWidget(replies[i][j]);
                }
            }
        }
    }

    public String httpGet(String u) {
        try {
            URL url = new URL(u);
            URLConnection conn = url.openConnection();

            InputStream is = conn.getInputStream();
            Scanner s = new Scanner(is).useDelimiter("\\A");
            return(s.hasNext() ? s.next() : "");
        } catch(Exception e) {
            return("This post has been deleted.");
        }
    }

    public String httpPost(String u, String a) {
        try {
            URL url = new URL(u);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            OutputStreamWriter out = new OutputStreamWriter(
                                     conn.getOutputStream());
            out.write(a);
            out.close();

            BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return(response.toString());
        } catch(Exception e) {
            return("Post creation failed.");
        }
    }

    public boolean writeFile(String f, String d) {
        try {
            PrintWriter out = new PrintWriter(f);
            out.println(d);
            out.close();
            return(true);
        } catch(Exception e) {
            return(false);
        }
    }

    public String readFile(String f) {
        try {
            File file = new File(f);
            Scanner in = new Scanner(file);
            return(in.useDelimiter("\\Z").next());
        } catch(Exception e) {
            return("25");
        }
    }

    public void on_logo_clicked() {
        dialogNewPost();
    }
    public void on_compose_clicked() {
        dialogNewPost();
    }
    public void on_action_newpost_triggered() {
        dialogNewPost();
    }

    public void on_action_preferences_triggered() {
        dialogPreferences();
    }

    public void on_action_quit_triggered() {
        QApplication.quit();
    }

    /* update data for on_ok_clicked()'s post submission */
    public void on_message_textChanged(String t) {
        npMessage = t;
    }
    public void on_tags_textChanged(String t) {
        npTags = t;
    }
    public void on_password_textChanged(String t) {
        npPassword = t;
    }

    /* POST new post */
    public void on_ok_clicked(QAbstractButton b) {
        httpPost(tInstance + "p/", "comment=" + npMessage +
                                   "&tags=" + npTags +
                                   "&password=" + npPassword);
    }

    /* new post composition form */
    public void dialogNewPost() {
        Ui_NewPost postui = new Ui_NewPost();
        QDialog dialog = new QDialog(this);
        postui.setupUi(dialog);
        postui.message.textChanged.connect(this, "on_message_textChanged(String)");
        postui.tags.textChanged.connect(this, "on_tags_textChanged(String)");
        postui.password.textChanged.connect(this, "on_password_textChanged(String)");
        postui.ok.clicked.connect(this, "on_ok_clicked(QAbstractButton)");
        dialog.show();
    }

    public void dialogPreferences() {
        Ui_Preferences prefui = new Ui_Preferences();
        QDialog dialog = new QDialog(this);
        prefui.setupUi(dialog);
        prefui.ppp.valueChanged.connect(this, "setPpp(int)");
        dialog.show();
    }

    public void setPpp(int n) {
        writeFile("ppp", Integer.toString(n));
    }
}
