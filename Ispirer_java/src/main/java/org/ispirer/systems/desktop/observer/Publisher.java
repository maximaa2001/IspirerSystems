package org.ispirer.systems.desktop.observer;

public interface Publisher {
    void addSubscriber(Subscriber subscriber);
    void notifySubscribers();
}
