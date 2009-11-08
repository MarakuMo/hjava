package org.huys.gui;

import java.awt.*;

class QuittableFrame extends Frame {
    public QuittableFrame(String title) {
        super(title);
    }

    /** Catch window destroy events. Pass all other
*  events to the original handler.
*/
    public boolean handleEvent(Event event) {
        if (event.id == Event.WINDOW_DESTROY) 
            System.exit(0);
        return (super.handleEvent(event));
    }
}

class ResizeButton extends Button {
    private int width, height;

    public ResizeButton(int width, int height) {
        super("Resize to " + width + "x" + height);
        this.width = width;
        this.height = height;
    }

    public boolean action(Event event, Object object) {
        getParent().resize(width, height);
        getParent().layout();
		System.out.println("Resize to " + width + "x" + height);
        return(true);
    }
}

public class ActionExample extends QuittableFrame {
    public ActionExample() {
        super("JDK: Handling Events in Component");
        setLayout(new FlowLayout());
        setFont(new Font("TimesRoman", Font.BOLD, 18));
        add(new ResizeButton(300, 200));
        add(new ResizeButton(400, 300));
        add(new ResizeButton(500, 400));
        resize(400, 300);
        show();
    }

    public static void main(String[] args) {
        new ActionExample();
    }
}