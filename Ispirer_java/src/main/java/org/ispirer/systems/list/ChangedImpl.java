package org.ispirer.systems.list;

public class ChangedImpl implements Changed {
    @Override
    public void changed() {
        System.out.println("Size of list changed");
    }
}
