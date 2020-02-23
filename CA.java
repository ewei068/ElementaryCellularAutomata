import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.lang.Math;
import java.awt.Rectangle;
import javax.swing.*;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class CA {
    public int _rule;
    public int[] _current;
    public int y = 0;
    public Hashtable<Integer, Integer> _ruleDict = new Hashtable<Integer, Integer>();
    public Random rand = new Random();

    public CA(int rule, int[] start) {
        _rule = rule;
        _current = start;
        makeRule();
    }

    void display(Graphics g) {
        int[] next = new int[_current.length];
        for (int i = 0; i < _current.length; i += 1) {
            int total = 0;

            if (_current[i] == 1) {
                g.fillRect(i*2, y*2, 2, 2);
            }

            if (i == 0) {
                total = _current[_current.length - 1]*4 + _current[i]*2 + _current[i+1];
            } else if (i == _current.length - 1) {
                total = _current[i-1]*4 + _current[i]*2 + _current[0];
            } else {
                total = _current[i-1]*4 + _current[i]*2 + _current[i+1];
            }

            next[i] = _ruleDict.get(total);
        }
        y += 1;
        _current = next;
        // _rule = rand.nextInt(256);
        // makeRule();
    }

    void makeRule() {
        boolean[] bits = new boolean[8];
        for (int i = 7; i >= 0; i--) {
            bits[i] = (_rule & (1 << i)) != 0;
        }

        for (int i = 0; i < 8; i++) {
            _ruleDict.put(i, (bits[i]) ? 1 : 0);
        }

        System.out.println(_rule + " = " + Arrays.toString(bits));
    }
}
