package xyz.shuttle.filebox.basis.ui;

import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.*;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@PushStateNavigation
public class MainUI extends UI {

    @Autowired
    SpringNavigator navigator;

    @Override
    public void init(VaadinRequest request) {
        getPage().setTitle("FileBox");
        navigator.init(this, this);
    }
}
