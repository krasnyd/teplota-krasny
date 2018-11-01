package sample;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField
{

    @Override
    public void replaceText(int start, int end, String text)
    {
        if (validate(text))
        {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text)
    {
        if (validate(text))
        {
            super.replaceSelection(text);
        }
    }

    private static boolean validate(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))){
                continue;
            }
            switch (str.charAt(i)){
                case '-':
                case '.':
                case ',':
                case 'e':
                case 'E':
                    break;
                default:
                    return false;
            }
        }
        return true;

    }
}
