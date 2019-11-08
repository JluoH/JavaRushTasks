package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        this.resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        try {
            view.selectHtmlTab();
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new HTMLFileFilter());
            if (chooser.showOpenDialog(view) == 0) {
                currentFile = chooser.getSelectedFile();
                this.resetDocument();
                view.setTitle(currentFile.getName());
                FileReader reader = new FileReader(currentFile);
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.read(reader, document, 0);
                view.resetUndo();
                int[] mass = new int[]{1, 2, 3};
                System.out.println(mass.length);
            }
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void saveDocument() {
        if (currentFile == null) {
            saveDocumentAs();
        } else {
            try {
                view.selectHtmlTab();
                view.setTitle(currentFile.getName());
                HTMLEditorKit kit = new HTMLEditorKit();
                FileWriter writer = new FileWriter(currentFile);
                kit.write(writer, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        try {
            view.selectHtmlTab();
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new HTMLFileFilter());
            if (chooser.showSaveDialog(view) == 0) {
                currentFile = chooser.getSelectedFile();
                view.setTitle(currentFile.getName());
                HTMLEditorKit kit = new HTMLEditorKit();
                FileWriter writer = new FileWriter(currentFile);
                kit.write(writer, document, 0, document.getLength());
            }
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter writer = null;
        try {
            writer = new StringWriter();
            HTMLEditorKit kit = new HTMLEditorKit();
            kit.write(writer, document, 0, document.getLength());
            return writer.toString();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        } finally {
            return writer.toString();
        }
    }

    public void setPlainText(String text) {
        try {
            this.resetDocument();
            StringReader reader = new StringReader(text);
            HTMLEditorKit kit = new HTMLEditorKit();
            kit.read(reader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        HTMLEditorKit kit = new HTMLEditorKit();
        document = (HTMLDocument) kit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    public void exit() {
        System.exit(0);
    }

    public void init() {
        this.createNewDocument();
    }
}
