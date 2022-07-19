package org.ispirer.systems.desktop.observer;

import java.io.IOException;

public interface Subscriber {
    void update() throws IOException;
}
