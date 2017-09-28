package amiltone.bsaugues.td_niveau1;

import amiltone.bsaugues.td_niveau1.presentation.navigator.Navigator;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class TdApplication {

    private Navigator navigator;

    private static TdApplication ourInstance = new TdApplication();


    private TdApplication() {

    }

    public static TdApplication getInstance() {
        return ourInstance;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public Navigator getNavigator() {
        return navigator;
    }

}