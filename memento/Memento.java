package memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        editor.setText("\nEsse é o primeiro texto. Olá mundo, haha!");
        history.save(editor);
        System.out.println("\nEstado atual: " + editor.getText());

        editor.setText("\nSegundo texto. E aí, mundo.");
        history.save(editor);
        System.out.println("\nEstado atual: " + editor.getText());

        editor.setText("\nTerceiro texto. Adeus, mundo.");
        System.out.println("\nEstado atual: " + editor.getText());

        history.undo(editor);
        System.out.println("\nDesfeito para: " + editor.getText());
        
        history.undo(editor);
        System.out.println("\nDesfeito para: " + editor.getText());
    }
} 

// Imagine esta classe como se fosse uma folha de papel.
class TextMemento {
    private final String state;

    public TextMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Já esta representa as suas mãos e seus olhos.
class TextEditor {
    private String text;
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        text = memento.getState();
    }
}

// Por último, esta classe representa o empilhamento dos papéis que você preencheu.
class TextEditorHistory {
    private List<TextMemento> history = new ArrayList<>();

    public void save(TextEditor editor) {
        history.add(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            TextMemento memento = history.remove(history.size() - 1);
            editor.restore(memento);
        }
    }
}